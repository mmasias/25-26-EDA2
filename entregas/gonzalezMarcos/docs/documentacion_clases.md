# Documentación de Clases

> Descripción de las tres clases Java que componen la solución.  
> → [Volver al README principal](../README.md)

---

## `MatrizOrdenada.java`

Representa la estructura de datos central del problema: una matriz bidimensional de enteros con la garantía de que sus valores son estrictamente crecientes tanto por filas como por columnas.

### Responsabilidad

Encapsula los datos y expone solo las operaciones necesarias para que el algoritmo de búsqueda pueda trabajar sobre ellos sin acceder directamente al array interno.

### Atributos

| Atributo | Tipo | Descripción |
|---|---|---|
| `datos` | `int[][]` | El array bidimensional con los valores de la matriz |
| `filas` | `int` | Número de filas, calculado una vez en el constructor |
| `columnas` | `int` | Número de columnas, calculado una vez en el constructor |

### Métodos

| Método | Devuelve | Descripción |
|---|---|---|
| `MatrizOrdenada(int[][] datos)` | — | Constructor. Recibe el array 2D y almacena sus dimensiones |
| `getFilas()` | `int` | Número de filas de la matriz |
| `getColumnas()` | `int` | Número de columnas de la matriz |
| `get(int fila, int col)` | `int` | Valor en la celda `[fila][col]` |
| `imprimir()` | `void` | Imprime la matriz por consola con alineación de 4 caracteres por celda |

---

## `BusquedaPorEliminacion.java`

Contiene el algoritmo de búsqueda por eliminación y la clase interna que representa su resultado.

### Responsabilidad

Implementar la búsqueda sobre un objeto `MatrizOrdenada` aprovechando su invariante de orden. Cada llamada a `buscar` produce una traza por consola y devuelve un resultado inmutable.

### Clase interna `Resultado`

Objeto de solo lectura que encapsula la salida del algoritmo. Sus campos son públicos y finales porque el resultado no cambia tras la búsqueda.

| Campo | Tipo | Descripción |
|---|---|---|
| `encontrado` | `boolean` | `true` si el valor `k` existe en la matriz |
| `fila` | `int` | Fila donde se encontró (`-1` si no existe) |
| `columna` | `int` | Columna donde se encontró (`-1` si no existe) |
| `comparaciones` | `int` | Número total de comparaciones realizadas |

Su `toString()` genera un mensaje legible listo para imprimir por consola.

### Métodos estáticos

#### `buscar(MatrizOrdenada matriz, int k)` → `Resultado`

El núcleo del algoritmo. Arranca en la **esquina superior derecha** (`fila = 0`, `col = columnas - 1`) e itera mientras las coordenadas estén dentro de los límites:

- Si `valor == k` → devuelve un `Resultado` con `encontrado = true`.
- Si `valor < k` → incrementa `fila` (descarta la fila actual).
- Si `valor > k` → decrementa `col` (descarta la columna actual).

En cada paso imprime la coordenada visitada, el valor leído y la decisión tomada.

#### `mejorCaso(int n, int m)` → `int`

Devuelve siempre `1`. El mejor caso ocurre cuando `k` coincide con el elemento de la esquina de inicio, resolviendo la búsqueda en una sola comparación.

#### `peorCaso(int n, int m)` → `int`

Devuelve `n + m - 1`. El peor caso ocurre cuando el algoritmo recorre toda la frontera superior-derecha → inferior-izquierda sin encontrar el elemento hasta el último paso, o cuando el elemento no existe.

---

## `Main.java`

Punto de entrada del programa. Junta los dos componentes anteriores para producir la salida completa del reto.

### Responsabilidad

Definir los datos del enunciado, lanzar la búsqueda y mostrar el análisis de complejidad. No contiene lógica de búsqueda propia.

### Flujo de ejecución

```
1. Define el array 2D con los valores del enunciado
2. Crea un objeto MatrizOrdenada con ese array
3. Imprime la cabecera y la matriz
4. Llama a BusquedaPorEliminacion.buscar(matriz, 22)
         └─ imprime la traza paso a paso
         └─ devuelve un objeto Resultado
5. Imprime el Resultado (posición + comparaciones)
6. Imprime el análisis de mejor y peor caso
```



# Reto: Búsqueda en Matriz Ordenada

## 1. Descripción del Algoritmo
Habia pensado en un algortmo, y es q basicamente aprovechando de q esta en orden entonces lo q hacemos es empezar en la esquina superior derecha, y comparamos, si n q seria nuestro numero a buscar es menor que el num en la posicion q estamos, entonces descartamos la columna y los elementos que estan abajo de el ya q todos abajo serian mayor, nos movemos a la izquierda y volvemos a hacer la misma comprobacion, si por el contrario el numero es mayor entonces lo q descartamos es la fila como tal, y bajamos y repetimos este pproceso sin parar
Caso $k = \text{actual}$: El elemento ha sido localizado (éxito)
.Caso $k < \text{actual}$: Debido a que la columna está ordenada de forma creciente hacia abajo, si $k$ es menor que el valor actual, necesariamente será menor que todos los valores inferiores de esa columna. Por tanto, se descarta la columna completa moviendo el puntero a la izquierda ($c - 1$).
Caso $k > \text{actual}$: Dado que la fila está ordenada de forma creciente hacia la derecha, si $k$ es mayor que el valor actual, será mayor que todos los valores previos de esa fila. Por tanto, se descarta la fila completa moviendo el puntero hacia abajo ($f + 1$).

## 2. Trazas de Ejecución
### 2.1. Búsqueda de k = 22
### 2.1. Traza de búsqueda para k = 22
| Paso | Fila ($f$) | Col. ($c$) | Valor $[f][c]$ | Comparación | Acción |
| :--- | :---: | :---: | :---: | :---: | :--- |
| 1 | 0 | 4 | 21 | $22 > 21$ | **Bajar**: Descartamos Fila 0 |
| 2 | 1 | 4 | 25 | $22 < 25$ | **Izquierda**: Descartamos Columna 4 |
| 3 | 1 | 3 | 17 | $22 > 17$ | **Bajar**: Descartamos Fila 1 |
| 4 | 2 | 3 | 20 | $22 > 20$ | **Bajar**: Descartamos Fila 2 |
| 5 | 3 | 3 | 27 | $22 < 27$ | **Izquierda**: Descartamos Columna 3|
| 6 | 3 | 2 | **22** | $22 = 22$ | **ÉXITO**: Valor encontrado |
### 2.2. Búsqueda de k = 21
| Paso | Fila ($f$) | Col. ($c$) | Valor $[f][c]$ | Comparación | Acción |
| :--- | :---: | :---: | :---: | :---: | :--- |
| 1 | 0 | 4 | 21 | $21 = 21$ | **ÉXITO**: Elemento encontrado en el punto de inicio[cite: 2]. |

### 2.3. Búsqueda de k = 16
| Paso | Fila ($f$) | Col. ($c$) | Valor $[f][c]$ | Comparación | Acción |
| :--- | :---: | :---: | :---: | :---: | :--- |
| 1 | 0 | 4 | 21 | $16 < 21$ | **Izquierda**: Descartamos Columna 4[cite: 2]. |
| 2 | 0 | 3 | 14 | $16 > 14$ | **Bajar**: Descartamos Fila 0[cite: 2]. |
| 3 | 1 | 3 | 17 | $16 < 17$ | **Izquierda**: Descartamos Columna 3[cite: 1]. |
| 4 | 1 | 2 | 11 | $16 > 11$ | **Bajar**: Descartamos Fila 1[cite: 2]. |
| 5 | 2 | 2 | 15 | $16 > 15$ | **Bajar**: Descartamos Fila 2[cite: 2]. |
| 6 | 3 | 2 | 22 | $16 < 22$ | **Izquierda**: Descartamos Columna 2[cite: 1]. |
| 7 | 3 | 1 | 18 | $16 < 18$ | **Izquierda**: Descartamos Columna 1[cite: 2]. |
| 8 | 3 | 0 | 13 | $16 > 13$ | **Bajar**: Descartamos Fila 3[cite: 2]. |
| 9 | 4 | 0 | 19 | $16 < 19$ | **Izquierda**: Índice $c$ pasa a -1. |
| 10 | - | - | - | - | **FIN**: Fuera de límites. El valor 16 no existe. |

---

## 3. Análisis de Complejidad

### 3.1. Caso Mejor
*   **Comparaciones:** 1.
*   **Elemento de ejemplo:** $k = 21$.
*   **Justificación:** Ocurre cuando el elemento buscado se encuentra en la esquina superior derecha, que es nuestro punto de partida.

### 3.2. Caso Peor
*   **Comparaciones:** $N + M - 1$ (donde $N$ es filas y $M$ columnas)[cite: 2].
*   **Elemento de ejemplo:** $k = 19$ (esquina inferior izquierda).
*   **Justificación:** El algoritmo debe "serpentear" por toda la matriz, descartando casi todas las filas y columnas hasta llegar al extremo opuesto.
*   **Traza del peor caso (k = 19):**
    `21 (izq) -> 14 (izq) -> 9 (izq) -> 5 (izq) -> 2 (bajar) -> 4 (bajar) -> 8 (bajar) -> 13 (bajar) -> 19 (éxito)`.

---

## 4. Justificación Teórica e Investigación

### 4.1. Optimización del Peor Caso
Para una matriz cuadrada de $N \times N$, este algoritmo tiene una complejidad de $O(N)$[cite: 2]. Aunque existen algoritmos basados en **Búsqueda Binaria** sobre filas y columnas que podrían reducir teóricamente las comparaciones en matrices extremadamente grandes o muy asimétricas (donde una dimensión es mucho mayor que la otra), la **Búsqueda en Escalera** es óptima para el uso general por su simplicidad y porque evita el coste computacional de calcular puntos medios constantemente.

### 4.2. Análisis del Punto de Inicio
**¿Es mejor empezar del centro?** No. Si empezamos en el centro (valor 15) y buscamos un valor $k > 15$, solo podemos descartar el cuadrante superior izquierdo. Esto nos deja con **tres sub-matrices** potenciales donde seguir buscando, lo que complica la lógica y no garantiza un descarte lineal. Al empezar en la esquina superior derecha (o inferior izquierda), cada comparación garantiza el descarte de una **fila completa** o una **columna completa**, manteniendo el avance siempre en una dirección determinista.

---

## 5. Implementación (Pseudocódigo)

El algoritmo se implementa de forma modular para separar la validación de la lógica de navegación.

```java
// Pseudocódigo lógico
METODO buscarElemento(matriz, k)
    f <- 0
    c <- columnas - 1
    hallado <- falso

    MIENTRAS (f < filas Y c >= 0 Y NO hallado) HACER
        valorActual <- matriz[f][c]
        SI valorActual == k ENTONCES
            hallado <- verdadero
        SINO SI k < valorActual ENTONCES
            c <- c - 1  // Descartar columna
        SINO
            f <- f + 1  // Descartar fila
        FIN SI
    FIN MIENTRAS
    RETORNAR hallado
FIN METODO
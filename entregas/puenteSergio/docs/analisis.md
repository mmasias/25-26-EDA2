# Análisis Comparativo de los Algoritmos de Ordenación

## Array de prueba

```java
int[] array = {5, 2, 8, 1, 9, 3};
```

---

## 1. Insertion Sort

### Idea

Recorre el array de izquierda a derecha. Para cada elemento, lo coloca en su posición correcta dentro de la subsecuencia ordenada que va construyendo a su izquierda, desplazando los mayores una posición a la derecha.

### Versión iterativa

Bucle externo desde `i = 1` hasta `length - 1`. Bucle interno (`while`) que desplaza elementos mientras sean mayores que el `actual`.

### Versión recursiva

Ordena los primeros `n - 1` elementos llamándose a sí mismo, y después inserta el elemento en posición `n - 1` en la subsecuencia ordenada. Caso base: `n <= 1`.

### Complejidad

| Caso | Tiempo |
|------|--------|
| Mejor | O(n) |
| Medio | O(n²) |
| Peor | O(n²) |
| Espacio | O(1) iterativo, O(n) recursivo (pila) |

### Cuándo usarlo

Arrays pequeños o casi ordenados. Eficiente como subrutina dentro de algoritmos híbridos (ej. Timsort).

---

## 2. Merge Sort

### Idea

Divide el array por la mitad recursivamente hasta llegar a subarrays de tamaño uno (caso base), y después fusiona pares de subarrays ordenados en uno mayor también ordenado.

### Versión recursiva

Divide en `[izquierda..medio]` y `[medio+1..derecha]`, ordena ambas mitades por recursión y fusiona. Caso base: `izquierda >= derecha`.

### Versión iterativa (bottom-up)

Empieza con bloques de tamaño 1 y los va fusionando en bloques de tamaño 2, 4, 8... hasta cubrir el array completo. Equivalente al recursivo pero sin pila de llamadas.

### Complejidad

| Caso | Tiempo |
|------|--------|
| Mejor | O(n log n) |
| Medio | O(n log n) |
| Peor | O(n log n) |
| Espacio | O(n) |

### Cuándo usarlo

Cuando se necesita rendimiento garantizado en el peor caso. Estable. Buena opción para datos en disco o estructuras enlazadas.

---

## 3. Quick Sort

### Idea

Escoge un pivote (en esta implementación, el último elemento del subarray), particiona el resto en dos grupos —menores o iguales al pivote y mayores—, coloca el pivote entre ambos y aplica recursión a cada grupo.

### Particionado (esquema de Lomuto)

Recorre con `j` desde `izquierda` hasta `derecha - 1`. Si `array[j] <= pivote`, incrementa `i` e intercambia `array[i]` con `array[j]`. Al final, intercambia `array[i+1]` con el pivote.

### Complejidad

| Caso | Tiempo |
|------|--------|
| Mejor | O(n log n) |
| Medio | O(n log n) |
| Peor | O(n²) (pivote pésimo, ej. array ya ordenado con pivote = último) |
| Espacio | O(log n) por la pila |

### Cuándo usarlo

Cuando se prima la velocidad media y el uso de memoria. No estable. Sensible a la elección del pivote.

---

## Tabla resumen

| Algoritmo | Mejor | Medio | Peor | Espacio | Estable |
|-----------|-------|-------|------|---------|---------|
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Sí |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Sí |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |

---

## Decisiones de diseño en la traza

### Indentación proporcional

En los algoritmos recursivos (Insertion recursivo, Merge recursivo, Quick) cada nivel de recursión añade cuatro espacios al inicio de cada línea. Esto permite reconstruir visualmente el árbol de llamadas leyendo solo la consola.

En el Merge iterativo se aplica el mismo criterio pero indentando por **pasada** (`tamano` 1, 2, 4...) ya que no existe pila de llamadas.

### Identificación del caso base

Cada caso base se imprime con la etiqueta `CASO BASE:` seguida de la condición que lo activó. Esto distingue de un vistazo dónde para la recursión.

### Comparaciones explícitas

Toda comparación que decide el flujo (`array[j] > actual`, `array[j] <= pivote`, `mitadIzquierda[i] <= mitadDerecha[j]`) imprime los dos operandos y el resultado (`TRUE` / `FALSE`). El lector puede así validar cada decisión sin volver al código.

### Modificaciones del array

Tras cada desplazamiento, intercambio o inserción se imprime el array completo. Esto sacrifica brevedad por trazabilidad: cualquier estado intermedio queda registrado.

---

## Restricción cumplida

Ningún `if`, `while`, `for`, condición o comparación de los algoritmos originales ha sido modificado. Las únicas adiciones son:

- Llamadas a `System.out.println`.
- Métodos auxiliares de soporte (`formatear`, `indentacion`).
- Sobrecargas privadas con parámetro `nivel` para propagar la indentación a las llamadas recursivas.

Las sobrecargas se consideran métodos auxiliares de soporte: el método público mantiene íntegra su firma original.
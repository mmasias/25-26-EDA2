# Reto de recuperación
 
Implementación de tres algoritmos de ordenación con trazas detalladas por consola.
 
## Estructura del proyecto
 
```
├── InsertionSortIterativo.java
├── InsertionSortRecursivo.java
├── MergeSortIterativo.java
├── MergeSortRecursivo.java
└── QuickSort.java
```
 
- **InsertionSortIterativo.java** — Insertion Sort con un bucle `for` externo y un `while` interno para desplazar elementos. Incluye su propio `main`.
- **InsertionSortRecursivo.java** — Insertion Sort donde cada llamada recursiva ordena los primeros `n-1` elementos y luego inserta el último en su posición correcta. Incluye su propio `main`.
- **MergeSortIterativo.java** — Merge Sort por pasadas de tamaño creciente (1, 2, 4...), fusionando pares de subarrays en cada iteración.
- **MergeSortRecursivo.java** — Merge Sort que divide el array por la mitad recursivamente y fusiona los resultados al volver.
- **QuickSort.java** — Quick Sort que elige como pivote el último elemento, particiona el segmento y ordena cada parte recursivamente.
Cada clase contiene sus propios métodos auxiliares: `arrayATexto`, `rangoATexto` y, en los algoritmos recursivos, `sangria` y `nivelRecursion` para reflejar la profundidad de las llamadas en la traza.
 
## Qué muestra la traza
 
Para cada algoritmo la salida por consola muestra:
 
- El array antes y después de ordenar.
- Cada comparación relevante con su resultado (`TRUE` o `FALSE`).
- El estado del array tras cada modificación.
- En los algoritmos recursivos, sangría proporcional al nivel de recursión para visualizar el árbol de llamadas.
- Identificación explícita de cada caso base.
## Array de prueba
 
```java
int[] array = {5, 2, 8, 1, 9, 3};
```
 
Resultado esperado en todos los casos: `[1, 2, 3, 5, 8, 9]`

```
## Restricciones respetadas
 
La lógica original de cada algoritmo no ha sido modificada. Las únicas adiciones son instrucciones `System.out.println` y métodos auxiliares privados de soporte (`arrayATexto`, `rangoATexto`, `sangria`).
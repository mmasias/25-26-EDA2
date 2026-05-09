# Búsqueda en Matriz Ordenada 

Este documento describe un algoritmo optimizado para encontrar un valor específico en una matriz donde tanto las filas como las columnas están ordenadas de forma ascendente.

## La Matriz de Ejemplo

La matriz proporcionada es una de $5 \times 5$ donde los valores crecen de izquierda a derecha y de arriba abajo:

| | Col 0 | Col 1 | Col 2 | Col 3 | Col 4 |
|---|---|---|---|---|---|
| **Fila 0** | 2 | 5 | 9 | 14 | 21 |
| **Fila 1** | 4 | 7 | 11 | 17 | 25 |
| **Fila 2** | 8 | 12 | 15 | 20 | 30 |
| **Fila 3** | 13 | 18 | 22 | 27 | 35 |
| **Fila 4** | 19 | 24 | 28 | 33 | 40 |

---

## 1. El Algoritmo

Para minimizar las comparaciones, aprovechamos la doble ordenación. En lugar de buscar secuencialmente, comenzamos en un punto donde cada decisión (moverse en una dirección) descarte una fila o una columna completa.

### Lógica del Algoritmo:
1. **Punto de inicio:** Esquina superior derecha (Fila 0, Columna $n-1$).
2. **Comparación:**
   - Si el valor es **igual** al buscado: Terminar (Encontrado).
   - Si el valor es **mayor** al buscado: Moverse a la **izquierda** (toda la columna actual es mayor, se descarta).
   - Si el valor es **menor** al buscado: Moverse hacia **abajo** (toda la fila actual es menor, se descarta).
3. **Repetir** hasta hallar el valor o salir de los límites.

### Traza para $k = 22$:

| Paso | Posición (F, C) | Valor | Comparación | Acción |
| :--- | :--- | :--- | :--- | :--- |
| 1 | (0, 4) | 21 | $21 < 22$ | Bajar a Fila 1 |
| 2 | (1, 4) | 25 | $25 > 22$ | Izquierda a Col 3 |
| 3 | (1, 3) | 17 | $17 < 22$ | Bajar a Fila 2 |
| 4 | (2, 3) | 20 | $20 < 22$ | Bajar a Fila 3 |
| 5 | (3, 3) | 27 | $27 > 22$ | Izquierda a Col 2 |
| 6 | (3, 2) | **22** | $22 = 22$ | **¡Encontrado!** |

---

## 2. Análisis de Complejidad

### Mejor Caso
* **Situación:** El valor buscado está exactamente en la esquina de inicio (superior derecha).
* **Comparaciones:** **1**.
* **Ejemplo:** Buscar $k = 21$.

### Peor Caso
* **Situación:** El algoritmo debe cruzar la matriz hasta la esquina opuesta o realizar un camino en zigzag que recorra el máximo de filas y columnas.
* **Comparaciones:** $N + M - 1$. Para una matriz de $5 \times 5$, el máximo es **9 comparaciones**.
* **Elemento de ejemplo:** El valor **19** (esquina inferior izquierda).

#### Traza del Peor Caso ($k = 19$):
1. (0, 4) = 21 ($> 19$) $\rightarrow$ Izquierda
2. (0, 3) = 14 ($< 19$) $\rightarrow$ Abajo
3. (1, 3) = 17 ($< 19$) $\rightarrow$ Abajo
4. (2, 3) = 20 ($> 19$) $\rightarrow$ Izquierda
5. (2, 2) = 15 ($< 19$) $\rightarrow$ Abajo
6. (3, 2) = 22 ($> 19$) $\rightarrow$ Izquierda
7. (3, 1) = 18 ($< 19$) $\rightarrow$ Abajo
8. (4, 1) = 24 ($> 19$) $\rightarrow$ Izquierda
9. (4, 0) = **19** (**Encontrado en 9 pasos**)

---

## 3. ¿Existen algoritmos más rápidos?

### En el Peor Caso ($O$):
No existe un algoritmo que reduzca el orden de complejidad por debajo de **$O(n)$** para una matriz cuadrada de $n \times n$. Se ha demostrado matemáticamente que cualquier algoritmo requiere al menos $2n - 1$ comparaciones en el peor caso para este tipo de estructura.

### Optimizaciones teóricas:
Existen enfoques de **Divide y Vencerás** (usando búsqueda binaria sobre la fila central y dividiendo en sub-matrices) que pueden ser más eficientes si la matriz es muy rectangular (por ejemplo, muchas más columnas que filas), logrando una complejidad de $O(n \log(m/n))$. Sin embargo:
1. Para matrices cuadradas o pequeñas, la complejidad sigue siendo lineal.
2. La implementación es mucho más compleja y la constante de tiempo suele ser mayor que la del algoritmo propuesto

En conclusión, para el caso general y especialmente para una matriz de $5 \times 5$, el algoritmo propuesto es el **óptimo**.
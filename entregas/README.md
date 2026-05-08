# Búsqueda en matriz ordenada

Resolución del problema de búsqueda en una matriz bidimensional donde las filas crecen de izquierda a derecha y las columnas crecen de arriba hacia abajo.

## 2Think

### 1. Propuesta de algoritmo y traza buscando el valor 22

**Algoritmo:**
Para minimizar el número de comparaciones aprovechando el ordenamiento, el algoritmo inicia en la **esquina superior derecha** de la matriz.
* Si el valor actual es igual a `k`, se ha encontrado.
* Si el valor actual es mayor que `k`, se sabe que todos los valores debajo también serán mayores. Por lo tanto, se descarta toda la columna actual y nos movemos hacia la **izquierda**.
* Si el valor actual es menor que `k`, se sabe que todos los valores a la izquierda también serán menores. Por lo tanto, se descarta la fila actual y nos movemos hacia **abajo**.
* El proceso se repite hasta encontrar `k` o salir de los límites de la matriz (índices fuera de rango).

**Traza buscando el valor 22:**
1. Inicio en `[0][4]` (21). Como 21 < 22 $\rightarrow$ Abajo.
2. En `[1][4]` (25). Como 25 > 22 $\rightarrow$ Izquierda.
3. En `[1][3]` (17). Como 17 < 22 $\rightarrow$ Abajo.
4. En `[2][3]` (20). Como 20 < 22 $\rightarrow$ Abajo.
5. En `[3][3]` (27). Como 27 > 22 $\rightarrow$ Izquierda.
6. En `[3][2]` (22). Como 22 == 22 $\rightarrow$ **Encontrado** (6 comparaciones en total).

### 2. Análisis de comparaciones y peor caso

* **Mejor caso:** Ocurre si el elemento buscado está exactamente en la posición inicial (`[0][4]`). Realiza **1 comparación**.
* **Peor caso:** Ocurre cuando se recorre la matriz desde la esquina superior derecha hasta la esquina inferior izquierda. En una matriz de $N$ filas por $M$ columnas, realizará un máximo de $N + M - 1$ comparaciones. En esta matriz de 5x5, el peor caso realiza **9 comparaciones**.

**Elemento del peor caso (Ejemplo: buscando el 19):**
1. `[0][4]` (21) > 19 $\rightarrow$ Izquierda
2. `[0][3]` (14) < 19 $\rightarrow$ Abajo
3. `[1][3]` (17) < 19 $\rightarrow$ Abajo
4. `[2][3]` (20) > 19 $\rightarrow$ Izquierda
5. `[2][2]` (15) < 19 $\rightarrow$ Abajo
6. `[3][2]` (22) > 19 $\rightarrow$ Izquierda
7. `[3][1]` (18) < 19 $\rightarrow$ Abajo
8. `[4][1]` (24) > 19 $\rightarrow$ Izquierda
9. `[4][0]` (19) == 19 $\rightarrow$ **Encontrado** (9 comparaciones).

### 3. ¿Existe un algoritmo con menos comparaciones en el peor caso?

En el peor de los casos, el valor objetivo puede estar escondido en cualquier lugar a lo largo de la anti-diagonal. Cualquier algoritmo que intente saltarse secciones enteras seguirá requiriendo una cantidad de verificaciones que escala linealmente con la suma de las dimensiones de la matriz. Por lo tanto, este es el enfoque óptimo para el caso general.

---

## 2Think²

### 1. Traza buscando el valor 21
* Inicio en `[0][4]` (21). Como 21 == 21 $\rightarrow$ **Encontrado** (1 comparación).

### 2. Traza buscando el valor 16
1. `[0][4]` (21) > 16 $\rightarrow$ Izquierda
2. `[0][3]` (14) < 16 $\rightarrow$ Abajo
3. `[1][3]` (17) > 16 $\rightarrow$ Izquierda
4. `[1][2]` (11) < 16 $\rightarrow$ Abajo
5. `[2][2]` (15) < 16 $\rightarrow$ Abajo
6. `[3][2]` (22) > 16 $\rightarrow$ Izquierda
7. `[3][1]` (18) > 16 $\rightarrow$ Izquierda
8. `[3][0]` (13) < 16 $\rightarrow$ Abajo
9. `[4][0]` (19) > 16 $\rightarrow$ Izquierda
10. *Límite izquierdo superado* $\rightarrow$ **No encontrado**.

### 3. ¿Arrancar del centro es mejor que arrancar de la esquina?

**Sí, en casos específicos.** El caso más evidente es si el valor buscado es exactamente el que se encuentra en el centro.
* **Demostración:** Si buscamos el valor **15** y empezamos en el centro (`[2][2]`), lo encontramos en **1 sola comparación**. Si buscamos el **15** con el algoritmo de la esquina, requiere **5 comparaciones** (`21 -> 14 -> 17 -> 11 -> 15`).
* *Nota:* Aunque gana en este caso específico, implementar un algoritmo partiendo desde el centro exige dividir la matriz en 4 cuadrantes recursivamente, lo cual es más complejo de programar y no mejora la eficiencia asintótica general respecto a empezar desde la esquina.

---

## 2Think³

### 1. Codificación de la propuesta (Java)

- [Archivo BusquedaMatrizOrdenada.java](./caicedoFernando/src/BusquedaMatrizOrdenada.java)
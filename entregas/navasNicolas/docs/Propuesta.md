## 2Think

### 1. Descripción del Algoritmo
El algoritmo comienza en la esquina superior izquierda `[0,0]` y avanza buscando el valor $k$ siguiendo estas reglas:
*   **Inicio:** Posición `[0, 0]`.
*   **Movimiento:** 
    *   Si el valor actual es **menor** que $k$, intenta avanzar a la **derecha**. 
    *   Si el valor a la derecha es mayor que $k$ o se llega al borde de la fila, se desplaza **hacia abajo**.
    *   Si el valor actual es **mayor** que $k$, se **retrocede** a la izquierda.
*   **Fin:** Se detiene al encontrar $k$ o al salirse de los límites de la matriz.

**Traza buscando el valor 22:**
1.  `[0, 0]` = 2 (< 22) $\rightarrow$ derecha.
2.  `[0, 1]` = 5 (< 22) $\rightarrow$ derecha.
3.  `[0, 2]` = 9 (< 22) $\rightarrow$ derecha.
4.  `[0, 3]` = 14 (< 22) $\rightarrow$ derecha.
5.  `[0, 4]` = 21 (< 22) $\rightarrow$ borde derecho alcanzado, bajar.
6.  `[1, 4]` = 25 (> 22) $\rightarrow$ retroceder izquierda.
7.  `[1, 3]` = 17 (< 22) $\rightarrow$ derecha es 25 (> 22), bajar.
8.  `[2, 3]` = 20 (< 22) $\rightarrow$ derecha es 30 (> 22), bajar.
9.  `[3, 3]` = 27 (> 22) $\rightarrow$ retroceder izquierda.
10. `[3, 2]` = 22 $\rightarrow$ **¡Encontrado!** (10 comparaciones).

### 2. Comparaciones (Mejor y Peor caso)
*   **Mejor caso:** **1 comparación**. Si $k$ es el primer elemento `[0,0]`.
*   **Peor caso:** Aproximadamente **11 comparaciones**. Ocurre cuando el valor está en la esquina inferior izquierda o cerca de ella, obligando a recorrer el ancho de la matriz y luego "zigzaguear" hacia abajo y hacia atrás.

**Traza del peor caso (k = 19):**
*   Camino: `[0,0]` $\rightarrow$ `[0,3]` (bajar) $\rightarrow$ `[1,3]` (bajar) $\rightarrow$ `[2,3]` (retroceder) $\rightarrow$ `[2,2]` (bajar) $\rightarrow$ `[3,2]` (retroceder) $\rightarrow$ `[3,1]` (bajar) $\rightarrow$ `[4,1]` (retroceder) $\rightarrow$ `[4,0]`.
*   Total: **11 comparaciones**.

### 3. Optimización
Existe un algoritmo que requiere menos comparaciones en el peor caso al comenzar desde la esquina superior derecha, evitando la necesidad de "retroceder" por donde ya se pasó.

---

## 2Think²

### 1. Prueba buscando 21
*   Secuencia: `[0,0]` $\rightarrow$ `[0,1]` $\rightarrow$ `[0,2]` $\rightarrow$ `[0,3]` $\rightarrow$ `[0,4]`.
*   **Resultado:** Encontrado en 5 comparaciones.

### 2. Prueba buscando 16
*   Secuencia: Fila 0 hasta `[0,3]` (bajar) $\rightarrow$ `[1,3]` (retroceder) $\rightarrow$ `[1,2]` (bajar) $\rightarrow$ `[2,2]` (bajar) $\rightarrow$ `[3,2]` (retroceder) $\rightarrow$ `[3,1]` (retroceder) $\rightarrow$ `[3,0]` (bajar) $\rightarrow$ `[4,0]` (retroceder) $\rightarrow$ fuera de matriz.
*   **Resultado:** No encontrado (9 comparaciones).

### 3. Caso del centro
Arrancar desde el centro es mejor si el valor buscado es exactamente el elemento central (15). En ese caso se encuentra en **1 comparación**, mientras que con la 2ª propuesta desde la esquina requiere 7 pasos.
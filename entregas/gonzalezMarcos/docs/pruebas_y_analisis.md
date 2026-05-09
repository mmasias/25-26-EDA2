# Segunda Parte del Reto: Pruebas y Análisis de Punto de Arranque

> → [Volver al README principal](../README.md)

---

## 1. Prueba con `k = 21`

El 21 es el valor que ocupa exactamente la **esquina superior derecha**: el punto de inicio del algoritmo.

| Paso | Celda | Valor | Decisión |
|:---:|---|:---:|---|
| 1 | (F0, C4) | 21 | 21 == 21 → ✅ **¡Encontrado!** |

**1 comparación.** Es el **mejor caso** posible para el algoritmo: el elemento buscado es el primer valor evaluado. No hay ningún algoritmo de búsqueda general capaz de hacerlo en menos, ya que al menos una comparación es necesaria para confirmar la existencia del elemento.

---

## 2. Prueba con `k = 16`

El 16 **no existe** en la matriz. El algoritmo debe recorrer toda la frontera antes de poder certificar su ausencia.

| Paso | Celda | Valor | Decisión |
|:---:|---|:---:|---|
| 1 | (F0, C4) | 21 | 21 > 16 → **izquierda** |
| 2 | (F0, C3) | 14 | 14 < 16 → **bajar** |
| 3 | (F1, C3) | 17 | 17 > 16 → **izquierda** |
| 4 | (F1, C2) | 11 | 11 < 16 → **bajar** |
| 5 | (F2, C2) | 15 | 15 < 16 → **bajar** |
| 6 | (F3, C2) | 22 | 22 > 16 → **izquierda** |
| 7 | (F3, C1) | 18 | 18 > 16 → **izquierda** |
| 8 | (F3, C0) | 13 | 13 < 16 → **bajar** |
| 9 | (F4, C0) | 19 | 19 > 16 → izquierda → **col = −1, fuera de límites** |

**9 comparaciones. NO ENCONTRADO.** Es el **peor caso** del algoritmo: N + M − 1 = 5 + 5 − 1 = 9. El algoritmo agota toda la frontera superior-derecha → inferior-izquierda sin encontrar el elemento. Que el elemento no exista es, junto con el caso de estar en la esquina opuesta a la de inicio, la situación más costosa posible.

---

## 3. ¿Empezar del centro puede ser mejor que empezar de la esquina?

### Respuesta directa: sí existe un caso concreto

Para la búsqueda de `k = 15` (el elemento que ocupa el **centro exacto** de la matriz, celda (F2, C2)):

**Arrancando desde la esquina superior derecha:**

| Paso | Celda | Valor | Decisión |
|:---:|---|:---:|---|
| 1 | (F0, C4) | 21 | 21 > 15 → **izquierda** |
| 2 | (F0, C3) | 14 | 14 < 15 → **bajar** |
| 3 | (F1, C3) | 17 | 17 > 15 → **izquierda** |
| 4 | (F1, C2) | 11 | 11 < 15 → **bajar** |
| 5 | (F2, C2) | 15 | 15 == 15 → ✅ **¡Encontrado!** |

**5 comparaciones desde la esquina.**

**Arrancando desde el centro (F2, C2):**

| Paso | Celda | Valor | Decisión |
|:---:|---|:---:|---|
| 1 | (F2, C2) | 15 | 15 == 15 → ✅ **¡Encontrado!** |

**1 comparación desde el centro.**

Para este valor concreto, empezar del centro es **5 veces más rápido**.

---

### Por qué esto no invalida la elección de la esquina

Que exista un caso donde el centro gana no significa que sea una estrategia mejor en general. Hay tres razones que lo demuestran:

**1. Es un caso de medida cero.**
Solo el elemento que ocupa exactamente la celda central se encuentra en 1 comparación empezando desde allí. Para los 24 elementos restantes de la matriz, empezar desde el centro no garantiza ninguna ventaja, y en muchos casos es peor.

**2. El algoritmo de eliminación no puede empezar desde el centro.**
El invariante que hace funcionar la búsqueda por eliminación es empezar desde una **esquina**: en ese punto, cualquier movimiento (bajar o ir a la izquierda) garantiza el descarte completo de una fila o columna. Desde el centro, esa garantía no existe: el elemento buscado puede estar en cualquiera de las cuatro direcciones, y no hay un movimiento único que descarte una fila o columna entera. Empezar del centro con este algoritmo rompería su corrección.

**3. La única alternativa correcta desde el centro tiene peor coste.**
Para buscar correctamente desde el centro, es obligatorio usar **Divide y Vencerás** (lanzar tres llamadas recursivas en cada nivel). Como se estudia en el [análisis comparativo](analisis_comparativo.md), eso tiene un coste de O(N^1.58) en el peor caso, frente al O(N+M) de la búsqueda por eliminación desde la esquina.

### Demostración formal

Sea `c` la celda central. Empezar desde `c` con el algoritmo de eliminación implica:

- Si `k > c`, el elemento puede estar en el cuadrante inferior derecho, en el superior derecho **o** en el inferior izquierdo. No hay un único movimiento válido.
- Si `k < c`, el elemento puede estar en el cuadrante superior izquierdo, en el superior derecho **o** en el inferior izquierdo. Mismo problema.

En cambio, en la esquina superior derecha `(F0, C_max)`:

- Si `k > esquina`, el elemento no puede estar en esa fila (todo lo que queda a su izquierda es menor). Solo hay un movimiento válido: **bajar**.
- Si `k < esquina`, el elemento no puede estar en esa columna (todo lo que queda debajo es mayor). Solo hay un movimiento válido: **ir a la izquierda**.

La esquina es la única posición de la matriz que permite este descarte determinista en todo momento. Es el único punto de empiece que hace posible el algoritmo de eliminación.


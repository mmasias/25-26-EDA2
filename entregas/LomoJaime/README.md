# Búsqueda en matriz ordenada

## 2Think

### 1. Mi propuesta: arrancar desde la esquina

Mi idea es empezar en la esquina superior derecha. Desde ahí, si me muevo a la izquierda el valor baja, y si me muevo hacia abajo el valor sube. Eso me permite tomar siempre una decisión clara sin tener que explorar a ciegas.

**Los pasos que sigo:**

1. Empiezo en la esquina superior derecha: fila `i=0`, columna `j=n-1`
2. Comparo el elemento actual con `k`:
   - Si son iguales → lo encontré, paro
   - Si el elemento es mayor que `k` → me muevo a la izquierda (`j--`)
   - Si el elemento es menor que `k` → me muevo hacia abajo (`i++`)
3. Si me salgo del borde → el valor no está en la matriz

**Traza buscando el valor 22:**

| Paso | Posición | Valor | Decisión |
|------|----------|-------|----------|
| 1 | (0,4) | 21 | 21 < 22 → bajo |
| 2 | (1,4) | 25 | 25 > 22 → izquierda |
| 3 | (1,3) | 17 | 17 < 22 → bajo |
| 4 | (2,3) | 20 | 20 < 22 → bajo |
| 5 | (3,3) | 27 | 27 > 22 → izquierda |
| 6 | (3,2) | 22 | 22 = 22 → **encontrado** ✓ |

En total hago **6 comparaciones** para encontrar el 22.

---

### 2. Cuántas comparaciones hace mi algoritmo

**Mejor caso → 1 comparación**

Si el valor que busco está justo en la esquina de arranque `(0, n-1)`, lo encuentro en la primera comparación. En esta matriz, buscar el **21** es exactamente ese caso.

**Peor caso → m + n - 2 comparaciones**

En cada comparación me muevo una fila hacia abajo o una columna hacia la izquierda, y en el último paso ya tengo el resultado directamente sin necesidad de un movimiento extra. Por eso el máximo real de comparaciones es `m + n - 2`, que en una matriz 5×5 son **8 comparaciones**.

El elemento que provoca ese peor caso es el **40**, que está en la esquina contraria a donde empiezo. Tengo que bajar por toda la columna derecha hasta llegar a él:

| Paso | Posición | Valor | Decisión |
|------|----------|-------|----------|
| 1 | (0,4) | 21 | 21 < 40 → bajo |
| 2 | (1,4) | 25 | 25 < 40 → bajo |
| 3 | (2,4) | 30 | 30 < 40 → bajo |
| 4 | (3,4) | 35 | 35 < 40 → bajo |
| 5 | (4,4) | 40 | 40 = 40 → **encontrado** ✓ |

Otro peor caso igual de claro es buscar un valor que **no existe**, como el **16**: el puntero recorre casi toda la escalera hasta salirse por el borde.

---

### 3. ¿Puedo hacerlo con menos comparaciones en el peor caso?

**No.** La razón es bastante directa: en el peor caso, mi algoritmo tiene que descartar una a una al menos `n` filas o columnas, y cada descarte me cuesta una comparación. No hay forma de saltarse ese trabajo porque la única información que tengo es el resultado de cada comparación.

Cualquier otra forma de atacar el problema, como por ejemplo hacer búsqueda binaria en cada fila por separado, acaba siendo más lenta en el peor caso, no más rápida. Así que arrancar desde la esquina es la mejor opción posible para este tipo de matriz.

---

## 2Think²

### 1. Busco el 21 → mejor caso

El primer elemento que miro es `(0,4) = 21`. Es exactamente el valor que busco, así que termino con **1 sola comparación**.

### 2. Busco el 16 → valor que no existe

| Paso | Posición | Valor | Decisión |
|------|----------|-------|----------|
| 1 | (0,4) | 21 | 21 > 16 → izquierda |
| 2 | (0,3) | 14 | 14 < 16 → bajo |
| 3 | (1,3) | 17 | 17 > 16 → izquierda |
| 4 | (1,2) | 11 | 11 < 16 → bajo |
| 5 | (2,2) | 15 | 15 < 16 → bajo |
| 6 | (3,2) | 22 | 22 > 16 → izquierda |
| 7 | (3,1) | 18 | 18 > 16 → izquierda |
| 8 | (3,0) | 13 | 13 < 16 → bajo |
| — | j < 0 | — | **no existe** ✗ |

Son **8 comparaciones**: el peor caso real en esta matriz, ya que en el último paso me salgo del borde sin necesitar una comparación extra.

### 3. ¿Arrancar del centro podría ser mejor?

**No, en ningún caso.** Desde la esquina, cada comparación siempre me elimina una fila entera o una columna entera, sin ninguna duda. Si arranco del centro, cuando el valor que miro no coincide con `k`, este podría estar en dos zonas distintas de la matriz y no tengo forma de saber en cuál sin seguir mirando. Eso me obliga a explorar más celdas, nunca menos. Arrancar del centro no puede ser mejor que arrancar de la esquina.


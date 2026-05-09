# Reto 004: Búsqueda en matriz ordenada

## 2Think

### 1. Algoritmo propuesto

Como las filas crecen hacia la derecha y las columnas hacia abajo, no tiene sentido recorrer la matriz entera ni hacer una búsqueda binaria por filas, porque desperdiciaríamos la información de las columnas.

La idea es empezar en la **esquina superior derecha** y comparar el valor con `k`:

- Si `M[i][j] == k` → encontrado.
- Si `M[i][j] > k` → me muevo a la izquierda (`j--`), porque toda esa columna por debajo es aún mayor.
- Si `M[i][j] < k` → bajo una fila (`i++`), porque toda esa fila a la izquierda es aún menor.

Así, cada comparación descarta una fila o una columna entera.

### Traza buscando k = 22

Empezamos en `(0, 4)` = 21.

| Paso | Posición | Valor | Acción |
|:-:|:-:|:-:|:--|
| 1 | (0,4) | 21 | 21 < 22 → `i++` |
| 2 | (1,4) | 25 | 25 > 22 → `j--` |
| 3 | (1,3) | 17 | 17 < 22 → `i++` |
| 4 | (2,3) | 20 | 20 < 22 → `i++` |
| 5 | (3,3) | 27 | 27 > 22 → `j--` |
| 6 | (3,2) | 22 | encontrado! |

Total: **6 comparaciones**.

---

### 2. Mejor y peor caso

- **Mejor caso: 1 comparación.** Cuando el valor está en la propia esquina superior derecha. Por ejemplo, buscando `k = 21`.
- **Peor caso: n + m − 1 comparaciones.** En esta matriz 5×5 son **9**, porque cada paso baja una fila o retrocede una columna, y como mucho recorremos casi todas.

Un valor que provoca el peor caso es **k = 19**:

| Paso | Posición | Valor | Acción |
|:-:|:-:|:-:|:--|
| 1 | (0,4) | 21 | `j--` |
| 2 | (0,3) | 14 | `i++` |
| 3 | (1,3) | 17 | `i++` |
| 4 | (2,3) | 20 | `j--` |
| 5 | (2,2) | 15 | `i++` |
| 6 | (3,2) | 22 | `j--` |
| 7 | (3,1) | 18 | `i++` |
| 8 | (4,1) | 24 | `j--` |
| 9 | (4,0) | 19 | encontrado! |

---

### 3. ¿Se puede hacer con menos comparaciones en el peor caso?

No. En el peor caso, cualquier algoritmo necesita al menos **n + m − 1 comparaciones**, y mi algoritmo ya alcanza ese número.

La razón es que, usando solo comparaciones, en cada paso solo podemos descartar como mucho una fila o una columna. Como hay n filas y m columnas, en el peor caso hay que mirar al menos n + m − 1 elementos antes de poder asegurar que el valor está o no está. Por debajo de ese número siempre quedan posiciones sin revisar donde el valor podría estar escondido, así que no se puede garantizar la respuesta con menos comparaciones.

Existen otros algoritmos (por ejemplo, los que dividen la matriz en partes y buscan recursivamente) que pueden ser más rápidos en algunos casos concretos, pero en el peor caso siguen necesitando el mismo número de comparaciones.

---

## 2Think²

### 1. Buscar k = 21

Empezamos en `(0, 4)` = 21. **Encontrado en 1 comparación.** Es el mejor caso posible.

### 2. Buscar k = 16 (no existe)

| Paso | Posición | Valor | Acción |
|:-:|:-:|:-:|:--|
| 1 | (0,4) | 21 | `j--` |
| 2 | (0,3) | 14 | `i++` |
| 3 | (1,3) | 17 | `j--` |
| 4 | (1,2) | 11 | `i++` |
| 5 | (2,2) | 15 | `i++` |
| 6 | (3,2) | 22 | `j--` |
| 7 | (3,1) | 18 | `j--` |
| 8 | (3,0) | 13 | `i++` |
| 9 | (4,0) | 19 | `j--` → fuera |

El algoritmo termina cuando `j < 0` o `i >= n`. Total: **9 comparaciones** y devuelve "no encontrado".

### 3. ¿Es mejor arrancar desde el centro?

No. Desde el centro, una comparación solo permite descartar uno de los cuatro cuadrantes, porque los otros tres pueden contener al elemento. Desde la esquina, en cambio, siempre se descarta una fila o una columna entera sin ambigüedad.

Por tanto, en el peor caso la esquina siempre gana o empata. Si el centro fuera mejor, podríamos bajar del límite teórico Ω(n + m), y eso no es posible.

---

## 2Think³

He implementado el algoritmo en Java empezando por la esquina superior derecha. Incluye un contador de comparaciones para comprobar las trazas anteriores.

[BusquedaMatrizOrdenada.java](./entregas/coboIsmael/src/BusquedaMatrizOrdenada.java)
# Búsqueda en matriz ordenada

## 1. El problema

Dada la siguiente matriz 5×5, donde las filas crecen de izquierda a derecha y las columnas crecen de arriba abajo:

```text
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

Se pide proponer un algoritmo que determine si un valor `k` existe en la matriz, minimizando el número de comparaciones.

La propiedad importante de la matriz es que está ordenada en dos direcciones:

- De izquierda a derecha, cada fila crece.
- De arriba abajo, cada columna crece.

Por tanto, el algoritmo debe aprovechar ese orden. Una búsqueda lineal funcionaría, pero no sería óptima porque revisaría elementos uno por uno sin usar la estructura de la matriz.

---

# 2Think

## 2. Algoritmo propuesto

El algoritmo propuesto es una **búsqueda por eliminación**, también conocida como **búsqueda escalonada** o **Saddleback Search**.

La idea consiste en empezar en la **esquina superior derecha** de la matriz.

En esta matriz, la esquina superior derecha es el valor `21`:

```text
 2   5   9  14 [21]
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

Desde esta posición, cada comparación permite descartar una fila o una columna completa.

La regla es:

```text
Si valor actual == k:
    El elemento ha sido encontrado.

Si valor actual < k:
    Se baja una fila.

Si valor actual > k:
    Se avanza una columna hacia la izquierda.
```

La razón es la siguiente:

| Comparación | Movimiento | Justificación |
|---|---|---|
| `valor == k` | Encontrado | Se ha localizado el valor buscado |
| `valor < k` | Bajar | Todo lo que está a la izquierda es menor que el valor actual, así que tampoco puede ser `k` |
| `valor > k` | Izquierda | Todo lo que está debajo es mayor que el valor actual, así que tampoco puede ser `k` |

De esta forma, el algoritmo no revisa toda la matriz. En cada paso elimina una fila o una columna de la zona de búsqueda.

---

## 3. Traza buscando k = 22

Buscamos el valor:

```text
k = 22
```

Empezamos en la esquina superior derecha.

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(0, 4)` | 21 | `21 < 22` | Bajar |
| 2 | `(1, 4)` | 25 | `25 > 22` | Izquierda |
| 3 | `(1, 3)` | 17 | `17 < 22` | Bajar |
| 4 | `(2, 3)` | 20 | `20 < 22` | Bajar |
| 5 | `(3, 3)` | 27 | `27 > 22` | Izquierda |
| 6 | `(3, 2)` | 22 | `22 == 22` | Encontrado |

Camino recorrido:

```text
 2   5   9  14 [21]
 4   7  11 [17][25]
 8  12  15 [20] 30
13  18 [22][27] 35
19  24  28  33  40
```

Resultado:

```text
El valor 22 existe en la matriz.
Número de comparaciones: 6.
```

---

## 4. Mejor caso

El mejor caso ocurre cuando el valor buscado está justo en la primera posición comparada.

Como el algoritmo empieza en la esquina superior derecha, el mejor caso se produce al buscar:

```text
k = 21
```

Traza:

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(0, 4)` | 21 | `21 == 21` | Encontrado |

Por tanto:

```text
Mejor caso: 1 comparación.
```

Complejidad del mejor caso:

```text
O(1)
```

---

## 5. Peor caso

En cada comparación, el algoritmo descarta una fila o una columna.

Para una matriz de `N` filas y `M` columnas, el número máximo de comparaciones es:

```text
N + M - 1
```

En esta matriz concreta:

```text
N = 5
M = 5
```

Por tanto:

```text
5 + 5 - 1 = 9
```

El peor caso es:

```text
9 comparaciones.
```

Un elemento de la matriz que provoca el peor caso es:

```text
k = 19
```

---

## 6. Traza del peor caso buscando k = 19

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(0, 4)` | 21 | `21 > 19` | Izquierda |
| 2 | `(0, 3)` | 14 | `14 < 19` | Bajar |
| 3 | `(1, 3)` | 17 | `17 < 19` | Bajar |
| 4 | `(2, 3)` | 20 | `20 > 19` | Izquierda |
| 5 | `(2, 2)` | 15 | `15 < 19` | Bajar |
| 6 | `(3, 2)` | 22 | `22 > 19` | Izquierda |
| 7 | `(3, 1)` | 18 | `18 < 19` | Bajar |
| 8 | `(4, 1)` | 24 | `24 > 19` | Izquierda |
| 9 | `(4, 0)` | 19 | `19 == 19` | Encontrado |

Camino recorrido:

```text
 2   5   9 [14][21]
 4   7  11 [17] 25
 8  12 [15][20] 30
13 [18][22] 27  35
[19][24] 28  33  40
```

Resultado:

```text
El valor 19 existe en la matriz.
Número de comparaciones: 9.
```

---

## 7. ¿Existe algún algoritmo que pueda resolver este problema con menos comparaciones en el peor caso?

Sin usar estructuras auxiliares ni preprocesamiento previo, la búsqueda por eliminación es una estrategia óptima en orden de complejidad para una matriz ordenada por filas y columnas.

La búsqueda lineal tendría coste:

```text
O(N · M)
```

En una matriz 5×5, eso podría suponer hasta 25 comparaciones.

La búsqueda por eliminación tiene coste:

```text
O(N + M)
```

En esta matriz 5×5, como máximo hace:

```text
5 + 5 - 1 = 9 comparaciones.
```

La clave está en que cada comparación descarta una fila o una columna completa. Por eso aprovecha mejor la información de orden de la matriz.

Un enfoque alternativo sería empezar por el centro y dividir la matriz en regiones. Sin embargo, desde el centro solo se puede descartar con seguridad uno de los cuadrantes diagonales. Los otros dos cuadrantes siguen siendo ambiguos y tendrían que explorarse igualmente. Por eso este enfoque puede ser correcto, pero no mejora el peor caso de forma clara.

Conclusión:

```text
Para este problema, la búsqueda por eliminación desde la esquina superior derecha es la opción más adecuada, porque garantiza como máximo N + M - 1 comparaciones.
```

---

# 2Think²

## 8. Prueba buscando k = 21

Buscamos:

```text
k = 21
```

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(0, 4)` | 21 | `21 == 21` | Encontrado |

Resultado:

```text
El valor 21 existe en la matriz.
Número de comparaciones: 1.
```

Este caso coincide con el mejor caso del algoritmo.

---

## 9. Prueba buscando k = 16

Buscamos:

```text
k = 16
```

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(0, 4)` | 21 | `21 > 16` | Izquierda |
| 2 | `(0, 3)` | 14 | `14 < 16` | Bajar |
| 3 | `(1, 3)` | 17 | `17 > 16` | Izquierda |
| 4 | `(1, 2)` | 11 | `11 < 16` | Bajar |
| 5 | `(2, 2)` | 15 | `15 < 16` | Bajar |
| 6 | `(3, 2)` | 22 | `22 > 16` | Izquierda |
| 7 | `(3, 1)` | 18 | `18 > 16` | Izquierda |
| 8 | `(3, 0)` | 13 | `13 < 16` | Bajar |
| 9 | `(4, 0)` | 19 | `19 > 16` | Izquierda |

Después del paso 9, la columna pasa a ser `-1`, por lo que el algoritmo sale de la matriz.

Camino recorrido:

```text
 2   5   9 [14][21]
 4   7 [11][17] 25
 8  12 [15] 20  30
[13][18][22] 27  35
[19] 24  28  33  40
```

Resultado:

```text
El valor 16 no existe en la matriz.
Número de comparaciones: 9.
```

Aunque el algoritmo realiza un movimiento final para salir de la matriz, ese movimiento no compara con ningún elemento nuevo. Por eso el número real de comparaciones es 9.

---

## 10. ¿Existe algún caso concreto donde arrancar del centro sea mejor que arrancar de la esquina?

Sí, existe un caso concreto donde arrancar desde el centro es mejor: cuando el valor buscado es precisamente el centro de la matriz.

El centro de esta matriz es:

```text
15
```

Si se busca:

```text
k = 15
```

y se empieza desde el centro, se encuentra en una sola comparación:

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(2, 2)` | 15 | `15 == 15` | Encontrado |

Resultado desde el centro:

```text
1 comparación.
```

En cambio, con la búsqueda por eliminación desde la esquina superior derecha, el recorrido sería:

| Paso | Posición | Valor | Comparación | Decisión |
|---:|---|---:|---|---|
| 1 | `(0, 4)` | 21 | `21 > 15` | Izquierda |
| 2 | `(0, 3)` | 14 | `14 < 15` | Bajar |
| 3 | `(1, 3)` | 17 | `17 > 15` | Izquierda |
| 4 | `(1, 2)` | 11 | `11 < 15` | Bajar |
| 5 | `(2, 2)` | 15 | `15 == 15` | Encontrado |

Resultado desde la esquina:

```text
5 comparaciones.
```

Por tanto, sí existe un caso concreto donde arrancar desde el centro es mejor:

```text
k = 15
```

Sin embargo, arrancar desde el centro no es mejor como algoritmo general.

Si desde el centro se compara con `15`, solo se pueden descartar con seguridad algunas zonas. Por ejemplo, si se busca `19`:

```text
19 > 15
```

Se puede descartar la zona superior izquierda:

```text
 2   5   9
 4   7  11
 8  12  15
```

Pero el valor buscado todavía puede estar en varias regiones restantes. No queda una única dirección clara de avance.

En cambio, desde la esquina superior derecha, cada comparación permite descartar siempre una fila o una columna completa. Por eso la esquina es mejor como estrategia general, aunque el centro pueda ganar en casos concretos.

Conclusión:

```text
Arrancar desde el centro puede ser mejor en casos concretos, como k = 15, pero no mejora el peor caso general del algoritmo.
```

---

# 2Think³

## 11. Codificación de la propuesta

La implementación se encuentra en el archivo:

```text
BusquedaMatriz.java
```

El programa implementa la búsqueda por eliminación desde la esquina superior derecha.

El algoritmo empieza con:

```text
fila = 0
columna = número de columnas - 1
```

Mientras la posición esté dentro de la matriz:

```text
1. Compara matriz[fila][columna] con k.
2. Si son iguales, devuelve encontrado.
3. Si el valor actual es menor que k, baja una fila.
4. Si el valor actual es mayor que k, se mueve una columna a la izquierda.
```

El programa prueba los siguientes valores:

```text
k = 22
k = 21
k = 16
k = 19
k = 15
```

---

## 12. Salida esperada

```text
Buscando k = 22
Resultado: encontrado
Fila: 3
Columna: 2
Comparaciones: 6

Buscando k = 21
Resultado: encontrado
Fila: 0
Columna: 4
Comparaciones: 1

Buscando k = 16
Resultado: no encontrado
Comparaciones: 9

Buscando k = 19
Resultado: encontrado
Fila: 4
Columna: 0
Comparaciones: 9

Buscando k = 15
Resultado: encontrado
Fila: 2
Columna: 2
Comparaciones: 5
```

Las filas y columnas están indicadas como en Java, empezando desde `0`.

---

## 13. Estructura de la entrega

La entrega contiene dos archivos:

```text
BusquedaMatriz.java
README.md
```

`BusquedaMatriz.java` contiene el código del algoritmo.

`README.md` contiene el análisis completo, la justificación, las trazas y la complejidad.

---

# Conclusión

El algoritmo propuesto es la búsqueda por eliminación en matriz ordenada.

Empieza en la esquina superior derecha y en cada comparación descarta una fila o una columna completa.

Su coste temporal es:

```text
O(N + M)
```

donde `N` es el número de filas y `M` el número de columnas.

Para esta matriz de 5×5:

```text
Mejor caso: 1 comparación.
Peor caso: 9 comparaciones.
```

El algoritmo es más eficiente que revisar todos los elementos, porque aprovecha directamente la propiedad de orden de la matriz.
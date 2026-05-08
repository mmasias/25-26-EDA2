## 2Think

### Algoritmo propuesto

Para determinar si un valor `k` existe en una matriz, teniendo en cuenta que debo **minimizar el número de comparaciones**, propongo el siguiente algoritmo.

Empiezo por la esquina superior derecha. Supongamos que `k` es el número que busco y `x` es el número actual que estoy comparando.

Comparo con el número que ocupa la posición de la esquina superior derecha:

- Si `x == k`, el número ha sido encontrado.
- Si `x > k`, me muevo una posición a la izquierda.
- Si `x < k`, bajo una posición.
- Si salgo de la matriz, el número no existe.

Traza `k = 22`:

```text
21 < 22 → bajo 
25 > 22 → izquierda 
17 < 22 → bajo 
20 < 22 → bajo 
27 > 22 → izquierda 
22 == 22 → encontrado
```

Comparaciones realizadas: 6

### Número de comparaciones en el peor y mejor caso

En el mejor caso, el número buscado sería el que ocupa la esquina superior derecha, que es el 21.

Traza mejor caso, `k = 21`:

```text
21 == 21 → encontrado
```

Total comparaciones mejor caso: 1

---

En el peor caso, sería por ejemplo el número que ocupa la esquina inferior izquierda, que es el 19.

Traza peor caso, `k = 19`:

```text
21 > 19 → izquierda
14 < 19 → bajo
17 < 19 → bajo
20 > 19 → izquierda
15 < 19 → bajo
22 > 19 → izquierda
18 < 19 → bajo
24 > 19 → izquierda
19 == 19 → encontrado
```

Total comparaciones peor caso: 9

---

### ¿Existe algún algoritmo que pueda resolver el peor caso con menos comparaciones?

No. Para una matriz de `m` filas y `n` columnas ordenada por filas y columnas, el algoritmo desde la esquina superior derecha tiene peor caso `m + n - 1`. En esta matriz de `5 x 5`, eso son 9 comparaciones.

No se puede garantizar menos en el peor caso, porque cada comparación solo permite descartar una fila o una columna de forma segura. En algunos casos, la búsqueda tiene que recorrer una frontera completa entre valores menores y mayores que `k`, cuya longitud puede ser `m + n - 1`.

Por tanto, en esta matriz no existe un algoritmo basado en comparaciones que mejore las 9 comparaciones en el peor caso.

## 2Think²

### Pruebe el algoritmo buscando 21

Traza `k = 21`:

```text
21 == 21 → encontrado
```

Comparaciones realizadas: 1 

### Pruebe el algoritmo buscando 16

Traza `k = 16`:

```text
21 > 16 → izquierda
14 < 16 → bajo
17 > 16 → izquierda
11 < 16 → bajo
15 < 16 → bajo
22 > 16 → izquierda
18 > 16 → izquierda
13 < 16 → bajo
19 > 16 → izquierda
Salimos de la matriz, luego 16 no está.
```

Comparaciones realizadas: 9

### ¿Hay algún caso donde empezar en el centro sea mejor?

Sí, existe un caso concreto donde empezar por el centro es mejor: por ejemplo, buscar 15.

La matriz es:

```text
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

El centro es 15.

Si empiezo en el centro:

```text
15 == 15 → encontrado
```

Si empiezo por la esquina superior derecha:

```text
21 > 15 → izquierda
14 < 15 → bajo
17 > 15 → izquierda
11 < 15 → bajo
15 == 15 → encontrado
```

Por tanto, sí hay casos concretos donde empezar por el centro es mejor, aunque eso no significa que sea mejor en el peor caso.

## 2Think³

Mi propuesta codificada se encuentra en:

[`BusquedaMatrizOrdenada.java`](src/BusquedaMatrizOrdenada.java)
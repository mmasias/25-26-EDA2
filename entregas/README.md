# Búsqueda en matriz ordenada

## 2Think

### 1. Algoritmo propuesto

Yo usaría un algoritmo que empieza en la esquina superior derecha de la matriz.

Desde esa posición comparo el valor actual con `k`:

- Si el valor es igual a `k`, lo he encontrado.
- Si el valor es mayor que `k`, me muevo a la izquierda.
- Si el valor es menor que `k`, bajo una fila.

Esto funciona porque las filas crecen hacia la derecha y las columnas crecen hacia abajo, así que en cada comparación puedo descartar una fila o una columna completa.

---

### Traza buscando 22

Matriz:

```text
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

Búsqueda:

```text
Empiezo en 21
22 > 21 → bajo
25 > 22 → izquierda
17 < 22 → bajo
20 < 22 → bajo
27 > 22 → izquierda
22 == 22 → encontrado
```

Comparaciones realizadas: 6.

---

### 2. Mejor y peor caso

El mejor caso ocurre cuando `k` está justo en la primera posición que comparo.

Por ejemplo:

```text
k = 21
```

Solo hago 1 comparación.

El peor caso ocurre cuando el algoritmo tiene que recorrer prácticamente todo el camino posible.

Un ejemplo es:

```text
k = 19
```

Traza:

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

Comparaciones realizadas: 9.

En una matriz de 5x5:

```text
filas + columnas - 1 = 5 + 5 - 1 = 9
```

Por tanto:

- Mejor caso: `O(1)`
- Peor caso: `O(filas + columnas)`

---

### 3. ¿Existe un algoritmo con menos comparaciones en el peor caso?

Para este tipo de matriz, este algoritmo ya es bastante eficiente porque en cada comparación elimina una fila o una columna entera.

Puede haber algoritmos más complejos usando divisiones de submatrices, pero para este problema la búsqueda desde la esquina es una solución muy buena y simple de implementar.

---

# 2Think²

## 1. Prueba buscando 21

```text
Empiezo en 21
21 == 21 → encontrado
```

Comparaciones realizadas: 1.

---

## 2. Prueba buscando 16

```text
Empiezo en 21
21 > 16 → izquierda
14 < 16 → bajo
17 > 16 → izquierda
11 < 16 → bajo
15 < 16 → bajo
22 > 16 → izquierda
18 > 16 → izquierda
13 < 16 → bajo
19 > 16 → izquierda

Me salgo de la matriz → no encontrado
```

El número 16 no está en la matriz.

Comparaciones realizadas: 9.

---

## 3. ¿Existe algún caso donde arrancar del centro sea mejor?

Sí.

Por ejemplo, si busco:

```text
k = 15
```

y empiezo desde el centro, lo encuentro directamente:

```text
15 == 15
```

Solo hago 1 comparación.

En cambio, empezando desde la esquina:

```text
21 > 15 → izquierda
14 < 15 → bajo
17 > 15 → izquierda
11 < 15 → bajo
15 == 15
```

Necesito 5 comparaciones.

Por tanto, empezar desde el centro puede ser mejor en algunos casos concretos, pero no en el peor caso general.
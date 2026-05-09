# Búsqueda en una Matriz Ordenada

## Introducción

En este ejercicio trabajamos con una matriz cuyos números están ordenados de una manera especial:

- Las filas aumentan de izquierda a derecha.
- Las columnas aumentan de arriba hacia abajo.

La matriz utilizada es la siguiente:

```text
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

El objetivo es encontrar un número `k` dentro de la matriz utilizando la menor cantidad posible de comparaciones.

---

# Idea principal de la solución

La solución propuesta consiste en comenzar desde el número `21`, ubicado en la esquina superior derecha de la matriz.

A partir de ese punto se realizan comparaciones para decidir hacia dónde movernos.

Las reglas son:

- Si el número actual es igual al número buscado → el elemento fue encontrado.
- Si el número actual es mayor → debemos movernos hacia la izquierda.
- Si el número actual es menor → debemos movernos hacia abajo.

Esta estrategia funciona gracias al orden de la matriz.

---

# ¿Por qué empezar desde la esquina superior derecha?

La esquina superior derecha es una posición ideal porque:

- Todos los números a la izquierda son menores.
- Todos los números debajo son mayores.

Eso permite que cada comparación descarte una parte completa de la matriz.

Por ejemplo:

Si estamos en `25` y buscamos `22`:

```text
25 > 22
```

sabemos que:

- debajo de `25` habrá números todavía mayores,
- por lo tanto no tiene sentido bajar,
- entonces debemos movernos hacia la izquierda.

En cambio, si estamos en `17`:

```text
17 < 22
```

sabemos que:

- los números de la izquierda son menores,
- necesitamos números más grandes,
- entonces debemos bajar.

---

# Explicación paso a paso buscando el número 22

Queremos encontrar:

```text
22
```

Matriz:

```text
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

---

## Paso 1

Comenzamos en:

```text
21
```

Comparación:

```text
21 < 22
```

Como el número actual es menor que el buscado, debemos bajar para encontrar números mayores.

---

## Paso 2

Ahora estamos en:

```text
25
```

Comparación:

```text
25 > 22
```

Como el número actual es mayor que el buscado, debemos movernos hacia la izquierda.

---

## Paso 3

Ahora estamos en:

```text
17
```

Comparación:

```text
17 < 22
```

El número sigue siendo menor, entonces bajamos.

---

## Paso 4

Ahora estamos en:

```text
20
```

Comparación:

```text
20 < 22
```

Seguimos necesitando un número más grande, por lo tanto bajamos nuevamente.

---

## Paso 5

Ahora estamos en:

```text
27
```

Comparación:

```text
27 > 22
```

El número es demasiado grande, así que nos movemos hacia la izquierda.

---

## Paso 6

Ahora estamos en:

```text
22
```

Comparación:

```text
22 == 22
```

El número fue encontrado correctamente.

---

# Recorrido visual

```text
21 ↓
25 ←
17 ↓
20 ↓
27 ←
22 ✓
```

---

# ¿Por qué esta solución funciona?

La solución funciona porque aprovecha completamente el orden de la matriz.

Cada vez que hacemos una comparación:

- eliminamos una fila completa,
- o eliminamos una columna completa.

Eso evita revisar todos los elementos uno por uno.

Por ejemplo:

- si el número actual es demasiado grande, todos los números debajo también serán demasiado grandes,
- si el número actual es demasiado pequeño, todos los números a la izquierda también serán demasiado pequeños.

Gracias a eso reducimos muchísimo el número de comparaciones.

---

# Mejor caso

El mejor caso ocurre cuando el número buscado es el primero que revisamos.

Ejemplo:

Buscar:

```text
21
```

Comparación:

```text
21 == 21
```

Número de comparaciones:

```text
1 comparación
```

---

# Peor caso

El peor caso ocurre cuando debemos movernos muchas veces entre izquierda y abajo antes de encontrar el número o determinar que no existe.

En una matriz `n x n`, el máximo número de comparaciones es:

```text
2n - 1
```

Para esta matriz `5 x 5`:

```text
2(5) - 1 = 9 comparaciones
```

---

# Ejemplo buscando un número que no existe

Busquemos el número:

```text
16
```

Recorrido:

```text
21 > 16 → izquierda
14 < 16 → abajo
17 > 16 → izquierda
11 < 16 → abajo
15 < 16 → abajo
22 > 16 → izquierda
18 > 16 → izquierda
13 < 16 → abajo
24 > 16 → izquierda
```

Finalmente salimos de la matriz y concluimos que el número no existe.

---

# Ventajas de esta solución

- Es fácil de implementar.
- Es mucho más rápida que recorrer toda la matriz.
- Aprovecha el orden de filas y columnas.
- Reduce considerablemente la cantidad de comparaciones.
- Tiene una complejidad eficiente.

---

# Complejidad temporal

La complejidad del algoritmo es:

```text
O(n + m)
```

donde:

- `n` representa las filas,
- `m` representa las columnas.

En una matriz cuadrada:

```text
O(n)
```

---

# Conclusión

La solución propuesta utiliza comparaciones inteligentes para encontrar un número dentro de una matriz ordenada sin necesidad de recorrer todos los elementos.

Comenzar desde la esquina superior derecha permite decidir rápidamente si debemos movernos:

- hacia la izquierda para buscar números menores,
- o hacia abajo para buscar números mayores.

De esta manera el algoritmo reduce el espacio de búsqueda en cada paso y logra encontrar el elemento de forma eficiente.
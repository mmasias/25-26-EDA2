# Búsqueda en Matriz Ordenada (2Think)
1. **Pruebe su algoritmo buscando 21**
2. **Pruebe su algoritmo buscando 16**
3. **¿Existe algún caso concreto donde arrancar del centro sea mejor que arrancar de la esquina? Si no existe, demuéstrelo. Si existe, encuéntrelo.**
## 1. **Traza para k = 21:**

*Paso 1:* **Inicio + Fin**

Comparamos con la esquina superior derecha. Como el valor es exactamente el que buscamos (21 = 21), el algoritmo termina inmediatamente.
```
                            2   5   9   14 [21] ✅ (21 = 21) => ¡Encontrado!
                            4   7   11  17  25  
                            8   12  15  20  30
                            13  18  22  27  35
                            19  24  28  33  40
```
## 2. **Traza para k = 16:**
*Paso 1*: **Inicio**

Comparamos con la esquina superior derecha. Como 21 > 16, descartamos la columna 4 (todos los valores debajo son mayores) y nos movemos a la izquierda.
```
                                2   5   9   14 [21] 👈 (21 > 16) 
                                4   7   11  17  25  
                                8   12  15  20  30
                                13  18  22  27  35
                                19  24  28  33  40
```
```
                                2   5   9   [14] ❌
                                4   7   11  17   ❌
                                8   12  15  20   ❌
                                13  18  22  27   ❌
                                19  24  28  33   ❌ => descartamos columna 4
```

*Paso 2*: **Izquierda**

Llegamos al 14. Como 14 < 16, descartamos la fila 0 (todos a la izquierda son menores) y bajamos.

```
                                ❌ ❌  ❌  ❌  ❌
                                4   7   11  [17] ❌  👈 (17 > 16)
                                8   12  15   20  ❌
                                13  18  22   27  ❌
                                19  24  28   33  ❌
```

```
                                ❌ ❌  ❌   ❌   ❌
                                4   7  [11]  ❌   ❌
                                8   12  15   ❌   ❌
                                13  18  22   ❌   ❌
                                19  24  28   ❌   ❌ => descartamos columna 3
```

*Paso 3*: **Bajar**

Llegamos al 17. Como 17 > 16, descartamos la columna 3 y nos movemos a la izquierda.
```
                                ❌  ❌  ❌ ❌  ❌
                                4   7   11  [17] ❌  👈 (17 > 16)
                                8   12  15   20  ❌
                                13  18  22   27  ❌
                                19  24  28   33  ❌
```
```
                                ❌  ❌  ❌  ❌   ❌
                                4   7  [11]  ❌   ❌
                                8   12  15   ❌   ❌
                                13  18  22   ❌   ❌
                                19  24  28   ❌   ❌ => descartamos columna 3
```
*Paso 4*: **Izquierda**

Llegamos al 11. Como 11 < 16, descartamos la fila 1 y bajamos.
```
                                ❌  ❌  ❌  ❌   ❌
                                4   7  [11]  ❌   ❌  👇 (11 < 16)
                                8   12  15   ❌   ❌
                                13  18  22   ❌   ❌
                                19  24  28   ❌   ❌
```
```
                                ❌  ❌ ❌   ❌   ❌
                                ❌  ❌ ❌   ❌   ❌ => descartamos fila 1
                                8   12  [15] ❌   ❌
                                13  18  22   ❌   ❌
                                19  24  28   ❌   ❌
```
*Paso 5*: **Bajar**

Llegamos al 15. Como 15 < 16, descartamos la fila 2 y bajamos.
```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                8   12 [15]  ❌   ❌  👇 (15 < 16)
                                13  18  22   ❌   ❌
                                19  24  28   ❌   ❌
```
```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌ => descartamos fila 2
                                13  18  [22]  ❌   ❌
                                19  24  28   ❌   ❌
```

*Paso 6*: **Bajar**

Llegamos al 22. Como $22 > 16$, descartamos la columna 2 y nos movemos a la izquierda.
```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                13  18 [22]  ❌   ❌  👈 (22 > 16)
                                19  24  28   ❌   ❌
```
```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                13 [18] ❌   ❌   ❌
                                19  24  ❌   ❌   ❌ => descartamos columna 2
```

*Paso 7*: **Izquierda**

Llegamos al 18. Como 18 > 16, descartamos la columna 1 y nos movemos a la izquierda.

```
❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                13 [18] ❌   ❌   ❌  👈 (18 > 16)
                                19  24  ❌   ❌   ❌
```
```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                               [13] ❌  ❌   ❌   ❌
                                19  ❌  ❌   ❌   ❌ => descartamos columna 1
```
*Paso 8*: **Izquierda**

Llegamos al 13. Como $13 < 16$, descartamos la fila 3 y bajamos.

```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                               [13] ❌  ❌   ❌   ❌  👇 (13 < 16)
                                19  ❌  ❌   ❌   ❌
```

```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌ => descartamos fila 3
                               [19] ❌  ❌   ❌   ❌
```

*Paso 9*: **Bajar (Final)**
Llegamos al 19. Como 19 > 16, intentaríamos movernos a la izquierda, pero salimos de los límites de la matriz (Columna -1).


```
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌
                                ❌  ❌  ❌   ❌   ❌ 
                                ❌  ❌  ❌   ❌   ❌
```
## 3. ¿Arrancar del centro?
Para este tipo de algoritmo, no. Desde el centro no puedes descartar filas o columnas completas. Si centro < k, el valor puede estar en tres cuadrantes distintos, lo que requeriría recursividad y sería menos eficiente en el peor caso.
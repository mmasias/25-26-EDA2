# Búsqueda en Matriz Ordenada (2Think)

1. **Proponga un algoritmo que determine si un valor k existe en la matriz, minimizando el número de comparaciones . Descríbalo con palabras y tracelo sobre la matriz buscando el valor 22**


2. **¿Cuántas comparaciones hace su algoritmo en el mejor caso? ¿Y en el peor caso? Identifique en la matriz un elemento que provoque ese peor caso y rastree la búsqueda**

3. **¿Existe algún algoritmo que pueda resolver este problema con menos comparaciones en el peor caso? Justifique su respuesta**

## 1. Algoritmo de Búsqueda Lineal
Para minimizar el número de comparaciones, se utiliza un algoritmo que aprovecha que tanto filas como columnas están ordenadas de forma ascendente.

### > **Descripción:**
*Inicio:*  Esquina **superior derecha** de la matriz (fila 0, columna 4).

```
                                2   5   9   14 [21] 
                                4   7   11  17  25
                                8   12  15  20  30
                                13  18  22  27  35
                                19  24  28  33  40
```

*Reglas:*

**1**. Si valor_actual = valor_buscado => Termina con éxito.

**2**. Si valor_actual > valor_buscado => Todos los elementos debajo de él en esa columna también serán mayores. Por lo tanto, descartamos la columna completa moviéndonos a la izquierda.

**3**. Si valor_actual > valor_buscado => Todos los elementos a su izquierda en esa fila también serán menores. Descartamos la fila moviéndonos hacia abajo.

### > **Traza para k = 22:**
*Paso 1:* **Inicio**

Comparamos con la esquina superior derecha. Como 21 < 22, descartamos la fila 0 (todos a la izquierda son menores) y bajamos.

```
                                2   5   9   14 [21] 👇 (21 < 22) 
                                4   7   11  17  25  
                                8   12  15  20  30
                                13  18  22  27  35
                                19  24  28  33  40
```
```
                                ❌ ❌  ❌  ❌  ❌ => descartamos fila 0
                                4   7   11  17  [25]  
                                8   12  15  20  30
                                13  18  22  27  35
                                19  24  28  33  40
```
*Paso 2:* **Bajar**

Llegamos al 25. Como 25 > 22, descartamos la columna 4 (todos abajo son mayores) y nos movemos a la izquierda.
```
                                ❌ ❌  ❌  ❌  ❌  
                                4   7   11  17  [25]  👈 (25 > 22)
                                8   12  15  20  30
                                13  18  22  27  35
                                19  24  28  33  40
```

```
                                ❌ ❌  ❌  ❌  ❌
                                4   7   11  17  [25]  
                                8   12  15  20   ❌
                                13  18  22  27   ❌
                                19  24  28  33   ❌ => descartamos columna 4
```
*Paso 3*: **Izquierda**

Llegamos al 17. Como 17 < 22, descartamos la fila 1 (todos a la izquierda son menores) y bajamos.

```
                                ❌ ❌  ❌  ❌  ❌  
                                4   7   11  [17] ❌  👇 (17 < 22)
                                8   12  15  20   ❌
                                13  18  22  27   ❌
                                19  24  28  33   ❌
```

```
                                ❌ ❌  ❌  ❌  ❌
                                ❌ ❌  ❌  ❌  ❌ => descartamos fila 1 
                                8   12  15  [20] ❌
                                13  18  22  27   ❌
                                19  24  28  33   ❌ 
```
*Paso 4*: **Bajar**

Llegamos al 20. Como 20 < 22, descartamos la fila 2 y volvemos a bajar.

```
                                ❌ ❌  ❌  ❌  ❌
                                ❌ ❌  ❌  ❌  ❌ 
                                8   12  15  [20] ❌ 👇 (17 < 22)
                                13  18  22  27   ❌
                                19  24  28  33   ❌ 
```

```
                                ❌ ❌  ❌  ❌  ❌
                                ❌ ❌  ❌  ❌  ❌  
                                ❌ ❌  ❌  ❌  ❌  => descartamos fila 2 
                                13  18  22  [27] ❌
                                19  24  28  33   ❌ 
```

*Paso 5*: **Bajar**

Llegamos al 27. Como 27 > 22, descartamos la columna 3 y nos movemos a la izquierda.

```
                                ❌ ❌  ❌  ❌  ❌
                                ❌ ❌  ❌  ❌  ❌  
                                ❌ ❌  ❌  ❌  ❌  
                                13  18  22  [27] ❌  👈 (27 > 22)
                                19  24  28  33   ❌ 
```

```
                                ❌ ❌  ❌  ❌  ❌
                                ❌ ❌  ❌  ❌  ❌  
                                ❌ ❌  ❌  ❌  ❌  
                                13  18  [22]❌  ❌  => descartamos columna 3
                                19  24  28  ❌  ❌ 
```
*Paso 6*: **Izquierda (Final)**

Llegamos al 22. ¡Objetivo encontrado!
```
                                ❌ ❌  ❌  ❌  ❌
                                ❌ ❌  ❌  ❌  ❌  
                                ❌ ❌  ❌  ❌  ❌  
                                13  18  [22]❌  ❌  ✅ (22 = 22) ¡Encontrado!
                                19  24  28  ❌  ❌ 
```

## 2. Complejidad y Peor/Mejor Caso
> **Mejor caso:** Complejidad 0(1)-> 1 comparación. Ocurre si el valor está en el inicio [21].

> **Peor caso:** Complejidad O(n + m) -> En una matriz de 5x5, el máximo de pasos es 5 + 5 - 1 = 9 comparaciones.Por tanto el elemento de peor caso es el valor **19** (extremo opuesto) o un valor inexistente que obligue a recorrer el borde.


    > Traza para 19:
        1º- 21 > 19 => 👈 (i=0 j=3) +  Descartamos columna 4 
        2º- 14 < 19 => 👇 (i=1 j=3) 
        3º- 17 < 19 => 👇 (i=2 j=3) + Descartamos columna 3
        4º- 20 > 19 => 👈 (i=2 j=2)
        5º- 15 < 19 => 👇 (i=3 j=2)
        6º- 22 > 19 => 👇 (i=3 j=1)
        7º- 18 < 19 => 👇 (i=4 j=1)
        8º- 24 > 19 => 👈 (i=4 j=0)
        9º- 19 = 19. Encontrado en 9 pasos.

## 3. Justificación de existencia de otro algoritmo más óptimo
No existe un algoritmo que garantice menos de **O(n+m)** en el peor caso. Aunque la búsqueda binaria es **O(log n)**, aquí las filas no están conectadas (el fin de una no es menor que el inicio de la siguiente), por lo que no se puede tratar como un array lineal.
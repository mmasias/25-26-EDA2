# Resolución de Algoritmos en Matriz

## 1. Propuesta de Algoritmo
Teniendo en cuenta que la matriz está ordenada, lo primero que hago es revisar el primer y el último número del cuadrante actual. Ahí lo que hacemos es asegurarnos de que el número que buscamos es válido, si el que buscamos es menor que el primero o mayor que el último, entonces sabemos que no está.

Después vas a la diagonal principal del cuadrante y comparas el número que buscas. Cuando encuentres un número mayor en esa diagonal al que buscas, paras. Con eso sabes que todos los números de la matriz que están a la derecha o abajo de ese tope no son, y todos los números a la izquierda o arriba tampoco son.

Para el resto, en vez de usar fuerza bruta, aplico la técnica de **divide y vencerás**. Al detenernos en la diagonal, descartamos esas esquinas y solo nos quedan dos cuadrantes donde el número podría estar: el **inferior-izquierdo** y el **superior-derecho**. Finalmente, vuelvo a aplicar este mismo algoritmo de forma recursiva en esos dos bloques hasta encontrar el número.

### Traza sobre la matriz buscando el valor 22
* **Cuadrante inicial (toda la matriz)**: Extremos 2 y 40. El 22 es válido.
* **Recorrido de la diagonal principal**: 2, 7, 15. El siguiente es 27. Como 27 > 22, me detengo.
* **División en dos cuadrantes**:
    * Inferior-Izquierdo (filas 3-4, columnas 0-2).
    * Superior-Derecho (filas 0-2, columnas 3-4).
* **Análisis del Inferior-Izquierdo**: Extremos 13 y 28. Válido.
* **Diagonal**: 13, 24. Como 24 > 22, me detengo en el 24.
* **Nueva división**: El subcuadrante superior-derecho resultante contiene la fila 3, columnas 1 y 2 (valores 18 y 22).
* **Análisis del subcuadrante [18, 22]**: Su diagonal empieza en 18. Al avanzar, me salgo de los límites, así que divido de nuevo.
* **Resultado**: La división me lleva exactamente a la celda de la fila 3, columna 2. Evalúo esa celda. El valor es 22. **Número encontrado**.

---

## 2. Comparaciones (Mejor y Peor Caso)

* **Mejor caso**: 1 comparación útil (ignorando las verificaciones de los extremos). Ocurre si el número que buscamos es el primer elemento de la matriz (el 2).
* **Peor caso**: Ocurre cuando el número no existe y su valor obliga a realizar múltiples divisiones recursivas comprobando varios subcuadrantes inútilmente.
* **Elemento que provoca el peor caso**: El 16 (o cualquier número intermedio que no exista).

### Traza del peor caso (Buscando 16)
1. Reviso la matriz completa. Válido. Diagonal: 2, 7, 15. Me detengo en 27.
2. Divido en Inferior-Izquierdo y Superior-Derecho.
3. El cuadrante **Inferior-Izquierdo** revisa su diagonal (13, 24). Se detiene y vuelve a dividir. Los subcuadrantes resultantes contienen números como 19 o el bloque [18, 22]. Se evalúan recursivamente y todos devuelven falso porque son mayores que 16.
4. El cuadrante **Superior-Derecho** revisa su diagonal (14, 25). Se detiene y divide. Queda el 21, que también se evalúa y devuelve falso.
5. Al no encontrarlo en ninguna rama recursiva, el algoritmo concluye con falso.

---

## 3. Algoritmo con menos comparaciones en el peor caso
Sí, existe un método conocido como **Saddleback Search** (empezar desde la esquina superior derecha o inferior izquierda).

Se justifica porque ese algoritmo se mueve de forma estrictamente lineal, una celda a la vez (hacia la izquierda si el número es menor, o hacia abajo si es mayor). Esto garantiza matemáticamente que en el peor caso nunca hará más de **N + M** comparaciones (donde N son filas y M columnas), que en esta matriz son 9 comparaciones.

---

## 4. ¿Existe algún caso donde arrancar del centro sea mejor que arrancar de la esquina?
Si cuando el numero que buscas esta en el centro.
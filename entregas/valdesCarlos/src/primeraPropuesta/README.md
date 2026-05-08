# Reto-004: Propuesta de arranque en esquina superior derecha

## 2Think

**1. Proponga un algoritmo que determine si un valor k existe en la matriz, minimizando el número de comparaciones.**

Mi propuesta es empezar siempre la búsqueda desde la **esquina superior derecha** de la matriz. Al hacer esto, uso esa celda como si fuera un semáforo que me dice por dónde ir:
- Todo lo que hay a la **izquierda** de esa celda es más pequeño.
- Todo lo que hay **debajo** de esa celda es más grande.

Así que el algoritmo es bastante sencillo: me pongo en esa esquina y comparo el número con el que busco. Si busco un número más pequeño, me muevo a la izquierda (descartando toda esa columna). Si busco uno más grande, me muevo hacia abajo (descartando la fila).

**Traza buscando el valor 22:**
- (Fila 1, Col 5): Estoy en **21**. Como 22 es mayor, me muevo hacia abajo.
- (Fila 2, Col 5): Estoy en **25**. Como 22 es menor, me muevo a la izquierda.
- (Fila 2, Col 4): Estoy en **17**. Como 22 es mayor, me muevo hacia abajo.
- (Fila 3, Col 4): Estoy en **20**. Como 22 es mayor, me muevo hacia abajo.
- (Fila 4, Col 4): Estoy en **27**. Como 22 es menor, me muevo a la izquierda.
- (Fila 4, Col 3): Estoy en **22**. **¡Encontrado!** (He necesitado 6 comparaciones).

**2. ¿Cuántas comparaciones hace su algoritmo en el mejor caso? ¿Y en el peor caso?**

- **En el mejor caso:** Hace solo **1 comparación**. Esto pasa si tengo mucha suerte y el número que busco está justo en mi casilla de salida (el 21).
- **En el peor caso:** Hará **9 comparaciones** en esta matriz (Filas + Columnas - 1). Esto pasa cuando el número está en la otra punta del tablero (abajo a la izquierda) o cuando el número no existe pero me obliga a cruzar toda la matriz para darme cuenta.

**Traza de un peor caso (buscando el 19, que está abajo a la izquierda):**
1. Comparo con **21**: 19 es menor -> voy a la izquierda.
2. Comparo con **14**: 19 es mayor -> voy hacia abajo.
3. Comparo con **17**: 19 es mayor -> voy hacia abajo.
4. Comparo con **20**: 19 es menor -> voy a la izquierda.
5. Comparo con **15**: 19 es mayor -> voy hacia abajo.
6. Comparo con **22**: 19 es menor -> voy a la izquierda.
7. Comparo con **18**: 19 es mayor -> voy hacia abajo.
8. Comparo con **24**: 19 es menor -> voy a la izquierda.
9. Comparo con **19**: **¡Encontrado!** (Justo en el límite de las 9 comparaciones).

**3. ¿Existe algún algoritmo que pueda resolver este problema con menos comparaciones en el peor caso?**

No, no he encontrado ninguno que mejore esto para el peor de los casos. Como la matriz no es una lista normal totalmente ordenada del 1 al 100, no puedo usar una búsqueda binaria tradicional para ir partiendo todo por la mitad. En el peor caso, siempre voy a tener que recorrer esa "frontera" que separa a los números pequeños de los grandes, y la longitud de ese camino es sí o sí la suma de las filas y las columnas.

---

## 2Think²

**1. Pruebe su algoritmo buscando 21**
- Empiezo en la esquina superior derecha (Fila 1, Col 5), que es el **21**.
- Comparo: ¿21 es igual a 21? Sí.
- **Fin.** ¡Lo encontré en la primera comparación!

**2. Pruebe su algoritmo buscando 16**
- 21 -> 16 es menor -> Izquierda.
- 14 -> 16 es mayor -> Abajo.
- 17 -> 16 es menor -> Izquierda.
- 11 -> 16 es mayor -> Abajo.
- 15 -> 16 es mayor -> Abajo.
- 22 -> 16 es menor -> Izquierda.
- 18 -> 16 es menor -> Izquierda.
- 13 -> 16 es mayor -> Abajo.
- 19 -> 16 es menor -> Izquierda.
- ¡Me salgo de la matriz por la izquierda! **Conclusión: El 16 no existe** (9 comparaciones).

**3. ¿Existe algún caso concreto donde arrancar del centro sea mejor que arrancar de la esquina?**

Sí que existe: cuando el número que buscamos **es exactamente el del centro** (el 15). 
Si arranco mi búsqueda desde el centro buscando el 15, lo encuentro en 1 sola comparación. Sin embargo, con mi algoritmo actual arrancando desde la esquina, tardaría 5 comparaciones en dar con él (haciendo el camino 21 -> 14 -> 17 -> 11 -> 15). 

---


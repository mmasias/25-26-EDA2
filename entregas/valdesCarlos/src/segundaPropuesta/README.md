# Reto-004: Propuesta de arranque en el centro

A continuación presento el análisis de una estrategia alternativa basada en **Divide y Vencerás**, arrancando la búsqueda desde el elemento central de la matriz.

## 2Think

**1. Proponga un algoritmo que determine si un valor k existe en la matriz, minimizando el número de comparaciones.**

El algoritmo consiste en calcular el elemento central de la matriz (o de la sub-matriz actual). 
- Si el elemento buscado es igual al centro, terminamos. 
- Si es menor, sabemos que no puede estar en el cuadrante inferior derecho, así que lo descartamos y hacemos llamadas recursivas para buscar en las zonas restantes (la mitad superior completa y el cuadrante inferior izquierdo). 
- Si es mayor, descartamos el cuadrante superior izquierdo y buscamos recursivamente en el resto.

**Traza buscando el valor 22:**
1. Matriz completa. Centro = **15**. Como 22 > 15, descarto el cuadrante superior izquierdo. Lanzo búsquedas recursivas en la mitad inferior y en el cuadrante superior derecho.
2. Las llamadas recursivas continúan dividiendo sus respectivas zonas. Una de ellas evaluará el centro del cuadrante inferior, por ejemplo el **28**. Como 22 < 28, descarta su parte inferior derecha.
3. El proceso de dividir se repite hasta que una de las llamadas evalúa la celda `[3, 2]` cuyo valor es **22**. ¡Encontrado!

**2. ¿Cuántas comparaciones hace su algoritmo en el mejor caso? ¿Y en el peor caso?**

- **Mejor caso:** Hace solo **1 comparación**. Ocurre si el número que buscamos está exactamente en el centro de la matriz inicial (es decir, el **15**).
- **Peor caso:** Ocurre cuando el número no existe o cuando está en una posición que obliga a abrir muchísimas ramas de llamadas recursivas. En esta matriz 5x5, el peor caso obliga a realizar unas **15 comparaciones** antes de parar.

**3. ¿Existe algún algoritmo que pueda resolver este problema con menos comparaciones en el peor caso?**

**SÍ, existe.** El algoritmo de búsqueda desde la esquina superior derecha es mucho más eficiente en el peor caso. 

---

## 2Think²

**1. Pruebe su algoritmo buscando 21**
En esta aproximación, el **21** ya no es el mejor caso. El programa mirará el centro (**15**), luego se irá ramificando por la derecha y arriba, evaluando varios sub-centros antes de acorralar al 21 en la esquina. Tardará varias comparaciones más que si hubiésemos empezado directamente desde esa misma esquina.

**2. Pruebe su algoritmo buscando 16**
El programa mirará el **15**. Al ser 16 mayor, lanzará búsquedas recursivas. Al ser el 16 un número que "debería" estar rodeado por el 15, 17, 20... abrirá muchísimas ramas del árbol de recursividad buscando en sub-matrices cada vez más pequeñas hasta que todos los límites se crucen y todas las ramas devuelvan `false`. Realizará alrededor de **15 comparaciones** antes de confirmar que no existe.

**3. ¿Existe algún caso concreto donde arrancar del centro sea mejor que arrancar de la esquina?**
**Sí.** Buscando exactamente el **15** (el centro absoluto). Este algoritmo lo encuentra en 1 sola comparación. El algoritmo de la esquina tardaría 5 comparaciones en llegar a él.

---



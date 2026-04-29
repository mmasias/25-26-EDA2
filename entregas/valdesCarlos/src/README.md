# Traza de Algoritmos de Ordenación 

Este documento explica el funcionamiento de cada uno de los algoritmos de ordenación implementados para este reto, detallando exactamente qué hace el código paso a paso sobre el array.

## 1. Insertion Sort (Iterativo)
- **Qué hace:** Recorre el array de izquierda a derecha empezando por el segundo número. 
- **El proceso:** Toma el número en el que está (lo llamamos "actual") y mira los números que tiene a su izquierda. Si los números de la izquierda son mayores que el actual, los desplaza una posición hacia la derecha en el array. Hace esto mediante un bucle hasta que encuentra un número menor o llega al principio del array. En ese hueco que ha quedado libre, inserta el número "actual". Repite esto número por número hasta el final.

## 2. Insertion Sort (Recursivo)
- **Qué hace:** Consigue exactamente el mismo resultado y los mismos desplazamientos que el anterior, pero el control del proceso se gestiona en la pila de llamadas.
- **El proceso:** En lugar de avanzar de izquierda a derecha con un bucle, la función se llama a sí misma para ordenar los primeros `n-1` elementos del array. Esto se repite hasta llegar al caso base (tamaño 1, que ya está ordenado). A partir de ahí, la recursividad "vuelve hacia atrás": en cada nivel, toma el último número de su tramo correspondiente y ejecuta el mismo bucle de desplazamientos hacia la derecha que la versión iterativa para insertarlo en su posición correcta.

## 3. Merge Sort (Recursivo)
- **Qué hace:** Aplica la estrategia de dividir el problema en subproblemas más pequeños hasta que son triviales de resolver, para luego reconstruir el resultado final.
- **El proceso (División):** Calcula el punto medio y divide el array por la mitad. Luego llama a la recursividad para dividir esas dos mitades por la mitad. Sigue haciendo esto hasta que el array queda fragmentado en subarrays de 1 solo elemento. 
- **El proceso (Fusión):** Como un array de 1 elemento está matemáticamente ordenado, el algoritmo empieza a "volver" combinándolos. Toma dos mitades, compara sus elementos uno a uno de izquierda a derecha, y los vuelca ordenados en el array original. Repite este proceso de fusión hacia arriba (juntando bloques de 1 en 2, de 2 en 4, etc.) hasta reconstruir el array completo.

## 4. Merge Sort (Iterativo)
- **Qué hace:** Realiza la misma fusión final que el Merge Sort recursivo, pero elimina la fase de "división recursiva desde arriba".
- **El proceso:** Empieza el trabajo directamente desde abajo utilizando bucles anidados. El bucle externo define un "tamaño de bloque" que empieza en 1. El bucle interno toma elementos adyacentes de 1 en 1 y los fusiona en bloques ordenados de 2. En la siguiente vuelta, el tamaño se multiplica por 2, tomando bloques ordenados de 2 en 2 para fusionarlos en bloques de 4. Este crecimiento multiplicativo continúa hasta que el tamaño del bloque abarca todo el array.

## 5. Quick Sort (Recursivo)
- **Qué hace:** Ordena el array seleccionando un valor de referencia y dividiendo el resto de elementos en dos subgrupos, colocando dicho valor en su posición definitiva en el array.
- **El proceso (Partición):** Selecciona el último elemento del tramo actual como "pivote". Luego, recorre todos los demás números desde la izquierda con un bucle. Si un número es menor o igual al pivote, lo intercambia para moverlo hacia la izquierda. Si es mayor, lo deja en la derecha. 
- **El paso clave:** Al terminar el recorrido, intercambia el pivote colocándolo justo entre el grupo de los menores y el grupo de los mayores. En este punto, ese pivote ya está en su posición final absoluta. Finalmente, realiza llamadas recursivas para aplicar este mismo proceso de partición de forma independiente al subarray izquierdo y al subarray derecho.
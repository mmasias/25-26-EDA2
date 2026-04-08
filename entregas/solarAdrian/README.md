# Resolución de Criptoaritmética mediante Backtracking

## Propuesta del Algoritmo

Para resolver problemas criptoaritméticos (como `SEND + MORE = MONEY`), el enfoque más óptimo es utilizar un algoritmo de **Backtracking** (vuelta atrás). El núcleo del problema consiste en realizar una búsqueda en un espacio de estados donde debemos asignar dígitos únicos (del 0 al 9) a un conjunto de letras distintas.

La lógica recursiva se estructura de la siguiente manera:

### 1. Definición de la Función Recursiva
La función de búsqueda recibe como parámetros:
* **Lista de letras pendientes:** Las letras que aún no tienen un valor numérico asignado.
* **Mapeo actual:** Un diccionario/mapa que relaciona cada letra con su dígito asignado.
* **Dígitos usados:** Un conjunto (Set) que registra los números que ya han sido tomados para evitar duplicados.

### 2. El Proceso de Búsqueda
La recursividad opera como un árbol de decisión con dos fases principales:
* **Caso Base:** Si la lista de letras pendientes está vacía, significa que hemos asignado un valor a cada letra. En este punto, la función traduce las letras de las palabras a sus valores numéricos y verifica si se cumple la ecuación matemática (ej. `SEND + MORE == MONEY`). Si la suma es correcta, la recursión termina con éxito.
* **Paso Recursivo:** Si quedan letras por asignar, la función toma la primera letra de la lista pendiente y prueba, mediante un bucle, todos los dígitos posibles del 0 al 9.

### 3. Restricciones y Poda
Para que la búsqueda sea eficiente y no evalúe millones de combinaciones imposibles, aplicamos reglas *antes* de bajar al siguiente nivel de recursión (esto se conoce como "podar" el árbol):
* **Unicidad:** Solo probamos dígitos que no estén en el conjunto de "dígitos usados".
* **Ceros a la izquierda:** Si la letra actual es la primera letra de alguna de las palabras (ej. la 'S' o la 'M' en `SEND` y `MORE`), descartamos inmediatamente el dígito 0.

### 4. Mecanismo de Backtracking
Si una rama de la recursión llega a un punto donde no se cumple la suma final o no hay más dígitos disponibles que cumplan las restricciones, la función "deshace" la última asignación. Es decir, elimina el dígito del mapeo y del conjunto de usados, y regresa al nivel anterior para probar con el siguiente dígito posible. Esto garantiza la exploración de todas las combinaciones válidas sin desperdiciar memoria.

### 5. Conclusión
Este enfoque es drásticamente más eficiente que la fuerza bruta pura. Al ir construyendo la solución paso a paso y podar ramas enteras del árbol de búsqueda en cuanto se incumple una restricción (como asignar un 0 a una letra inicial), nos aseguramos de encontrar la solución única en milisegundos.


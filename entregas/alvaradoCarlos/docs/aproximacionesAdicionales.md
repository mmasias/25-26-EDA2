# Otras Aproximaciones

El algoritmo propuesto anteriormente (Búsqueda Binaria con Filtro de Rango) tiene una complejidad temporal en el peor caso de **O(N log M)**. Esto sucede cuando el valor `k` encaja en el rango inicial y final de todas las filas.

Por el contrario, existe otro algoritmo llamado *Saddleback Search* que logra una complejidad óptima de **O(N + M)**. 

Este es superior porque explota de manera simultánea la propiedad bidimensional de la matriz (filas ordenadas de izquierda a derecha y columnas de arriba a abajo).

### ¿Cómo garantiza menos comparaciones?

1. El algoritmo no empieza en la posición [0,0] ni por filas, sino en la **esquina superior derecha** (o en la inferior izquierda). En esta posición, tiene dos caminos con comportamientos estrictamente opuestos: hacia la izquierda los valores siempre disminuyen, y hacia abajo siempre aumentan.

2.  En cada paso, compara el valor actual con k:
    *   Si k es **menor**, el algoritmo se mueve a la izquierda. Esto **descarta una columna entera** en una sola comparación.
    *   Si k es **mayor**, el algoritmo se mueve hacia abajo. Esto **descarta una fila entera** en una sola comparación.

3.  Al eliminar invariablemente toda una fila o toda una columna por cada comparación realizada, el camino más largo posible (el peor caso absoluto) es viajar desde una esquina hasta la esquina opuesta. 

### Comparativa numérica del peor caso

*   **En la matriz propuesta de 5x5:** El algoritmo *Saddleback Search* garantiza encontrar el elemento o confirmar su ausencia en un máximo estricto de **5 + 5 = 10 comparaciones**. 

En contraste, la Búsqueda Binaria con Filtro requirió **35 comparaciones** en su peor escenario (buscando el elemento 19).
*   **A gran escala (1000x1000):** El peor caso del *Saddleback Search* consumiría un máximo de **2,000 comparaciones**, frente a las aproximadamente **14,000 comparaciones** de la Búsqueda Binaria con Filtro. 


## ¿Existe un caso donde arrancar en el centro sea mejor?

**Sí, existe un caso concreto.** Aunque el algoritmo de *Saddleback Search* es superior para el peor caso general en matrices cuadradas, el algoritmo de **Divide y Vencerás** (arrancar desde el centro absoluto) lo supera en dos escenarios específicos.

### Caso: Elemento en el centro

*   Pasa cuando buscamos el elemento central de la matriz. En la matriz de ejemplo de 5x5, el centro es el **15** (Fila 3, Columna 3).

*   El algoritmo salta directamente a la coordenada `[N/2][M/2]`. Compara el 15 con el 15 y lo encuentra en **1 sola comparación** (O(1)).

*  En cambio, en *Saddleback Search* eñ algoritmo está obligado a caminar físicamente desde la esquina hasta el centro. Estando en el 21, su ruta sería: `21` -> `14` -> `17` -> `11` -> `15`. Requiere **5 pasos (y aproximadamente 10 comprobaciones lógicas)** para llegar al mismo número. 
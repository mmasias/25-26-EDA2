# Búsqueda en Matriz Ordenada

## 1. Propuesta de Algoritmo: Búsqueda desde la esquina inferior izquierda
Analizando la matriz, para realizar una cantidad mínima de comparaciones en este caso que ya está ordenada tanto en filas como en columnas sería elegir una esquina donde los dos caminos disponibles tengan relación opuesta, es decir un camino para aumentar el valor y otro para disminuirlo.

Como punto de partida iniciamos en la **esquina inferior izquierda** de la matriz. 

* Si el valor actual es igual a **22**, la búsqueda termina con éxito.
* Si el valor actual es **mayor que 22**, sabemos que todos los valores a la derecha en esa fila también serán mayores. Por lo tanto, **subimos una fila**.
* Si el valor actual es **menor que 22**, sabemos que todos los valores arriba en esa columna también serán menores. Por lo tanto, **avanzamos una posición a la derecha**.

Esta acción se repite hasta encontrar el valor o hasta que no se encuentre el valor que estamos buscando:
* `Si valorActual == 22`: termina la búsqueda.
* `Si valorActual > 22`: Sube una fila.
* `Si valorActual < 22`: Me muevo a la derecha.

---

## 2. Trazo del algoritmo
Iniciamos desde la esquina inferior izquierda, el valor **19**.

1.  **Valor actual 19**: Como 19 < 22, me muevo una posición a la derecha.
2.  **Valor actual 24**: Como 24 > 22, me muevo una posición hacia arriba.
3.  **Valor actual 18**: Como 18 < 22, me muevo una posición a la derecha.
4.  **Paso 4: Valor actual 22**: Fin de la búsqueda.

---

## 3. Justificación del algoritmo
Al iniciar en la esquina inferior izquierda (o la superior derecha), cada comparación elimina una fila completa o una columna completa de la búsqueda.

* **Número de comparaciones en este trazo**: 4 comparaciones.
* **Complejidad temporal**: O(n + m), donde n es el número de filas y m el de columnas.

### Esquina superior derecha vs esquina inferior izquierda
Ambos puntos de partida son equivalentes en complejidad. Sin embargo, en esta matriz en específico el camino recorrido a nivel de comparaciones es mucho más corto, haciendo caso al planteamiento inicial.

### Casos de Análisis
1.  **Mejor Caso**: 1 comparación. El valor buscado es el punto de inicio (la misma esquina izquierda).
2.  **Peor Caso**: 9 comparaciones (fórmula: n + m - 1). El valor está en la esquina opuesta (21) o no existe.

---

## 4. Trazo del Peor Caso (Buscando k = 21)
Desde el 19, el camino zigzaguea eliminando filas y columnas:
1.  `19 < 21` -> Derecha (24)
2.  `24 > 21` -> Arriba (18)
3.  `18 < 21` -> Derecha (22)
4.  `22 > 21` -> Arriba (15)
5.  `15 < 21` -> Derecha (20)
6.  `20 < 21` -> Derecha (30)
7.  `30 > 21` -> Arriba (25)
8.  `25 > 21` -> Arriba (21)
9.  `21 == 21` -> Fin de la búsqueda (9 comparaciones).


En una matriz de 5x5 mientras que el método de la esquina requiere hasta 9 comparaciones, una búsqueda basada en particiones binarias podría resolver el peor caso en aproximadamente 7 u 8 comparaciones, ya que aprovecha mejor la propiedad de orden bidimensional.

---

## 5. Prueba del algoritmo (Buscando k = 16)
Partiendo de la esquina inferior izquierda (19):
1.  `19 > 16` -> Arriba (13)
2.  `13 < 16` -> Derecha (18)
3.  `18 > 16` -> Arriba (12)
4.  `12 < 16` -> Derecha (15)
5.  `15 < 16` -> Derecha (20)
6.  `20 > 16` -> Arriba (17)
7.  `17 > 16` -> Arriba (11)
8.  `11 < 16` -> Derecha (17) -> Se sale de la matriz.
* **Resultado**: 16 no existe en la matriz.

---

## 6. ¿Es mejor iniciar desde el centro?
El algoritmo que inicia desde el centro es más conveniente únicamente si el valor buscado se encuentra en esa posición exacta o en sus cercanías inmediatas. Sin embargo, presenta una desventaja lógica: mientras que desde una esquina solo tienes dos direcciones (arriba o abajo), desde el centro hay **cuatro cuadrantes posibles**, lo que dificulta la toma de decisiones lineal.
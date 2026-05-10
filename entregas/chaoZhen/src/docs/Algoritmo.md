### Propuesta de Algoritmo

Propuesta escrita hecha en clase ![Propuesta Escrita](/entregas/chaoZhen/src/image/Propuesta-Algoritmo.jpeg)

* Comenzar en la esquina superior derecha de la matriz en el número **21**.

#### **Reglas**
* **Si $k = 22$:** Termina.
* **Si ($k >$ número actual en matriz):** Podamos los números de la izquierda de esa fila.
* **Si ($k <$ número actual en matriz):** Podamos los números debajo del número en la columna.

---

### Análisis de Casos

* **Mejor caso:** $O(1)$
    * **Escenario:** El elemento que buscamos está exactamente en la posición inicial.
    * **Justificación:** El algoritmo compara el valor buscado con el primer elemento que evalúa, encuentra que son iguales y finaliza inmediatamente tras 1 sola comparación.

* **Peor caso:** $O(N + M)$
    * **Escenario:** El elemento está en la esquina opuesta.
    * **Justificación:** En el peor de los casos, el algoritmo tendrá que recorrer todas las columnas moviéndose hacia la izquierda ($M$ pasos) y todas las filas moviéndose hacia abajo ($N$ pasos) antes de encontrar el elemento o salirse de los límites de la matriz.
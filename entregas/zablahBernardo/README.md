El reto tiene como objetivo hacer visible el proceso interno de cada algoritmo. 

El reto está hecho en cuatro clases para tener un código limpio y separado por responsabilidades:
* `Main.java`: Clase de gestion. Esta clase hace que todas las pruebas se ejecuten y las controla.
* `InsertionSort.java`: Contiene las versiones iterativa y recursiva de la ordenación por inserción.
* `MergeSort.java`: Contiene las versiones iterativa y recursiva, además de su método de fusión respectivo.
* `QuickSort.java`: Contiene la versión recursiva y su método respectivo de partición.


Explicacion de la complejidad:
* Insertion Sort: Desempeño de $O(n^2)$ en el peor de los casos y $O(n)$ en el mejor (array ya ordenado). Eficiente para arrays muy pequeños.

* Merge Sort: Desempeño garantizado de $O(n \log n)$. Requiere espacio adicional para los arrays temporales de fusión.

* Quick Sort: Desempeño promedio de $O(n \log n)$, aunque puede degradarse a $O(n^2)$ si el pivote elegido es consistentemente el peor.

Tambien en los casos que tienen recursividad, se indenta hasta alcanzar un caso base. Asi se puede visualizar con mucha mas facilidad el objetivo del reto.
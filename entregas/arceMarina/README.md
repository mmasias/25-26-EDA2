# Reto de Algoritmos de Ordenación con Traza

## Objetivo del proyecto

Este proyecto implementa tres algoritmos clásicos de ordenación:

- Insertion Sort 
- Merge Sort 
- Quick Sort

El objetivo no es únicamente ordenar un array, sino **reconstruir paso a paso la ejecución interna del algoritmo mediante trazas en consola**, de forma que un evaluador pueda reproducir exactamente el comportamiento del algoritmo.

---

##  Entrada fija del problema

Todos los algoritmos trabajan sobre el mismo array base:

```java
int[] array = {5, 2, 8, 1, 9, 3}; 
```


## Diseño general del sistema

El proyecto se divide en:

- Main: ejecuta todas las pruebas
- SoporteTraza: gestiona indentación y mensajes auxiliares
- Algoritmos: InsertionSort, MergeSort, QuickSort

### 1. Clase Main
 Propósito: La clase Main es el punto de entrada del programa. Su función es:

- Ejecutar todos los algoritmos
- Clonar el array original para evitar contaminación entre ejecuciones
- Mostrar estado inicial y final
- Reiniciar la traza entre ejecuciones

### 2. SoporteTraza
 Propósito: Esta clase no implementa algoritmos, sino que:

- Controla la indentación de llamadas recursivas
- Centraliza mensajes de comparación
- Evita duplicación de código en los algoritmos

 **Decisiones clave**
1. Uso de variable nivel
private static int nivel = 0; (Representa la profundidad de recursión.)

2. Indentación dinámica getInd() (Genera espacios según nivel de recursión.)

Motivo:
Permite visualizar el árbol de llamadas de forma clara.

3. Métodos auxiliares de traza

- ```imprimirComparacion```: muestra comparaciones clave
- ```imprimirCorteBucle```: explica por qué termina un while
- ```imprimirFinFusion```: indica fin de merge por agotamiento de subarrays

| Motivo: Evitar repetir lógica de impresión en cada algoritmo.

### 3. Insertion Sort 
Insertion Sort inserta cada elemento en su posición correcta dentro de una parte ya ordenada del array
1. **Versión iterativa**

- Es la forma natural del algoritmo
- Más eficiente en memoria que la versión recursiva
- Evita coste de llamadas recursivas innecesarias

#### Funcionamiento: 
Se recorre el array desde i = 1, Se guarda actual, Se desplazan elementos mayores a la derecha, Se inserta el elemento
 Elección de trazas

2. **Versión recursiva** : Simula el comportamiento iterativo pero usando recursión:
- Ordena los primeros n-1
- Inserta el último elemento

### 4. Merge Sort
1. **Versión recursiva**: Divide el array en mitades hasta llegar a casos base y luego fusiona.

2. **Versión iterativa** : Se simula el comportamiento recursivo usando tamaños de bloque.


### 5. Quick Sort
- Se elige un pivote
- Se reorganiza el array
- Se separan subproblemas

**¿Por qué recursivo?** : Porque cada partición genera:

Subarray izquierdo || Subarray derecho -> Ambos se ordenan igual → recursión natural

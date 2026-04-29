# Presentación de la trazabilidad por clases

Cada clase ejecuta el array obligatorio:

```java
int[] array = {5, 2, 8, 1, 9, 3};
```

El resultado final esperado en todas las clases es:

```java
[1, 2, 3, 5, 8, 9]
```

## Organización de las clases

La entrega queda dividida en las siguientes clases:

| Clase | Algoritmo implementado |
|---|---|
| `InsertionSortIterativoTraza.java` | Insertion Sort iterativo |
| `InsertionSortRecursivoTraza.java` | Insertion Sort recursivo |
| `MergeSortRecursivoTraza.java` | Merge Sort recursivo |
| `MergeSortIterativoTraza.java` | Merge Sort iterativo |
| `QuickSortTraza.java` | Quick Sort |

Esta separación mejora la claridad porque cada archivo representa una única implementación. Así, la traza generada por cada clase corresponde únicamente a un algoritmo concreto, sin mezclarse con la salida de los demás.


## Trazabilidad implementada en cada clase

Todas las clases mantienen el mismo criterio de trazabilidad. La salida por consola permite reconstruir el proceso completo de ordenación.

En cada implementación se muestra:

- El estado inicial del array.
- Las comparaciones relevantes.
- La decisión tomada después de cada comparación.
- Los cambios realizados sobre el array.
- El estado parcial del array después de cada modificación.
- El estado final del array.

En los algoritmos recursivos también se muestra:

- La llamada recursiva actual.
- El rango o tamaño que se está procesando.
- La indentación según la profundidad de recursión.
- El caso base alcanzado.

## Clase `InsertionSortIterativoTraza`

Esta clase contiene la versión iterativa de Insertion Sort.

El flujo del código empieza recorriendo el array desde la posición `1`. En cada iteración se toma el elemento actual y se compara hacia atrás con los elementos anteriores. Mientras los elementos anteriores sean mayores, se desplazan una posición hacia la derecha.

La traza muestra especialmente:

- El valor de `i`.
- El valor de `actual`.
- Las comparaciones `array[j] > actual`.
- Cada desplazamiento hacia la derecha.
- La posición final donde se inserta `actual`.

Ejemplo del tipo de traza que genera:

```text
Comparo: 5 > 2 -> verdadero
Desplazo 5 de posicion 0 a posicion 1
Array: [5, 5, 8, 1, 9, 3]
Inserto 2 en posicion 0
Array: [2, 5, 8, 1, 9, 3]
```

## Clase `InsertionSortRecursivoTraza`

Esta clase contiene la versión recursiva de Insertion Sort.

Primero se ordenan recursivamente los primeros `n - 1` elementos. Después, al volver de la recursión, se inserta el último elemento en su posición correcta dentro de la parte ya ordenada.

La lógica es la misma que la del Insertion Sort original, pero expresada mediante llamadas recursivas.

La traza muestra:

- Cada llamada `ordenar(array, n)`.
- El caso base `n <= 1`.
- El elemento `ultimo` que se va a insertar.
- Las comparaciones hacia atrás.
- Los desplazamientos realizados.
- La inserción final.

La indentación permite ver claramente en qué nivel de recursión se encuentra cada paso.

## Clase `MergeSortRecursivoTraza`

Esta clase contiene la versión recursiva de Merge Sort.

El algoritmo divide el array en dos mitades hasta llegar a subarrays de un solo elemento. Después fusiona las mitades ordenadas usando el método `fusionar`.

La traza muestra dos partes importantes:

Primero, la fase de división:

```text
Llamada ordenar(array, izquierda = 0, derecha = 5)
Divido en [0, 2] y [3, 5]
```

Después, la fase de fusión:

```text
Comparo: 2 <= 1 -> falso
Copio 1 en posicion 0
Array: [1, 5, 8, 1, 3, 9]
```

En esta clase es especialmente importante trazar el método `fusionar`, porque ahí es donde realmente se modifica el array principal.

## Clase `MergeSortIterativoTraza`

Esta clase contiene la versión iterativa de Merge Sort.

A diferencia de la versión recursiva, aquí no se divide mediante llamadas recursivas. En su lugar, se fusionan bloques de tamaño creciente:

```text
tamano = 1
tamano = 2
tamano = 4
```

En cada pasada, el algoritmo fusiona pares de bloques ya ordenados hasta que todo el array queda ordenado.

La traza muestra:

- El tamaño de bloque actual.
- Los rangos que se van a fusionar.
- Las mitades izquierda y derecha.
- Las comparaciones entre elementos.
- Las copias al array principal.
- El array después de cada fusión.

La lógica de fusión es la misma que en Merge Sort recursivo, pero el recorrido de los bloques se hace con bucles.

## Clase `QuickSortTraza`

Esta clase contiene Quick Sort.

El algoritmo elige como pivote el último elemento del rango actual. Después particiona el array colocando a la izquierda los valores menores o iguales que el pivote y a la derecha los valores mayores.

La traza muestra:

- La llamada actual con sus límites `izquierda` y `derecha`.
- El subarray que se está procesando.
- El pivote elegido.
- Cada comparación `array[j] <= pivote`.
- Si hay intercambio o no.
- El intercambio final que coloca el pivote.
- Las llamadas recursivas a la izquierda y a la derecha.
- Los casos base.

Ejemplo de traza:

```text
Pivote = 3 en posicion 5
Comparo: array[0] = 5 <= pivote 3 -> falso
No se intercambia
Comparo: array[1] = 2 <= pivote 3 -> verdadero
Intercambio posiciones 0 y 1
Array: [2, 5, 8, 1, 9, 3]
```

## Métodos auxiliares usados

Cada clase incluye los métodos auxiliares necesarios para mostrar la traza de forma clara.

Los más comunes son:

```java
private static String mostrar(int[] array)
```

Este método convierte el array en texto usando `Arrays.toString(array)`.

También aparece en las clases recursivas:

```java
private static String tab(int nivel)
```

Este método genera espacios de indentación según la profundidad de recursión.

En Merge Sort recursivo y Quick Sort también se usa:

```java
private static String subarray(int[] array, int izquierda, int derecha)
```

Este método permite mostrar solo la parte del array que se está procesando en una llamada concreta.

## Relación entre lógica y trazabilidad

La lógica del algoritmo y la trazabilidad están separadas conceptualmente.

La lógica se encarga de ordenar:

- Comparar.
- Desplazar.
- Copiar.
- Intercambiar.
- Dividir.
- Fusionar.
- Particionar.

La trazabilidad se encarga de explicar lo que ocurre:

- Qué se compara.
- Qué decisión se toma.
- Qué cambio se realiza.
- Cómo queda el array.
- Cuándo termina una llamada recursiva.

Por tanto, la solución no altera los algoritmos originales. Solo añade salidas por consola para que el proceso sea reconstruible paso a paso.

## Forma de ejecución

Cada clase puede compilarse y ejecutarse por separado.

Por ejemplo:

```bash
javac InsertionSortIterativoTraza.java
java InsertionSortIterativoTraza
```

O para Quick Sort:

```bash
javac QuickSortTraza.java
java QuickSortTraza
```

Cada ejecución mostrará únicamente la traza correspondiente a ese algoritmo.

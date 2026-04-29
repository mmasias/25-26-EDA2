# Presentación de la trazabilidad implementada en el código

La entrega consiste en un programa Java que ejecuta varias implementaciones de algoritmos de ordenación sobre el mismo array de prueba:

```java
int[] base = {5, 2, 8, 1, 9, 3};
```

Para evitar que un algoritmo reciba el array ya ordenado por otro, en el `main` se crea una copia independiente antes de llamar a cada implementación:

```java
int[] a1 = Arrays.copyOf(base, base.length);
```

De esta forma, todas las trazas parten exactamente del mismo estado inicial y permiten comparar correctamente el comportamiento de cada algoritmo.

---

## Flujo general del programa

El método `main` funciona como punto de entrada y organiza la ejecución de los algoritmos. Primero declara el array base y después llama, por separado, a cada versión de ordenación:

- Insertion Sort iterativo.
- Insertion Sort recursivo.
- Merge Sort recursivo.
- Merge Sort iterativo.
- Quick Sort.

Antes de cada ejecución se imprime un encabezado para distinguir claramente qué algoritmo está produciendo la traza. Después, cada algoritmo muestra su estado inicial, sus decisiones internas y el estado final del array.

La estructura general es:

```java
System.out.println("INSERTION SORT ITERATIVO");
int[] a1 = Arrays.copyOf(base, base.length);
insertionIterativo(a1);
```

Este patrón se repite para cada implementación.

---

## Métodos auxiliares usados para la traza

El código incluye algunos métodos auxiliares que no modifican la lógica de ordenación. Su función es únicamente mejorar la salida por consola.

### `mostrar`

Convierte el array completo en texto:

```java
private static String mostrar(int[] array) {
    return Arrays.toString(array);
}
```

Se usa cada vez que se necesita imprimir el estado actual del array.

### `subarray`

Muestra solo una parte del array, indicada por los índices `izquierda` y `derecha`:

```java
private static String subarray(int[] array, int izquierda, int derecha)
```

Este método es útil en Merge Sort y Quick Sort, porque ambos trabajan con rangos concretos del array.

### `tab`

Genera espacios de indentación según la profundidad recursiva:

```java
private static String tab(int nivel)
```

Se usa en los algoritmos recursivos para que la salida refleje visualmente el árbol de llamadas. Cuanto más profunda es la llamada, más indentada aparece su traza.

---

## Trazabilidad en Insertion Sort iterativo

En la versión iterativa de Insertion Sort, la traza sigue el avance del bucle `for`.

Para cada posición `i`, se imprime:

- El valor de `i`.
- El elemento actual que se quiere insertar.
- Las comparaciones realizadas dentro del `while`.
- Los desplazamientos hacia la derecha.
- La posición final donde se inserta el elemento.
- El array después de cada modificación.

El flujo principal es:

```java
for (int i = 1; i < array.length; i++) {
    int actual = array[i];
    int j = i - 1;

    while (j >= 0 && array[j] > actual) {
        array[j + 1] = array[j];
        j--;
    }

    array[j + 1] = actual;
}
```

La traza se coloca alrededor de estas operaciones para mostrar qué ocurre sin cambiar la lógica original.

Ejemplo de información que aparece en consola:

```text
Comparo: 5 > 2 -> verdadero
Desplazo 5 de posicion 0 a posicion 1
Array: [5, 5, 8, 1, 9, 3]
Inserto 2 en posicion 0
Array: [2, 5, 8, 1, 9, 3]
```

Así se puede reconstruir cómo el algoritmo va creando una zona ordenada al principio del array.

---

## Trazabilidad en Insertion Sort recursivo

En la versión recursiva, la traza muestra primero cómo el algoritmo baja hasta el caso base y después cómo va insertando los elementos al volver de la recursión.

Cada llamada imprime:

- El valor de `n`.
- Si se alcanza o no el caso base.
- El elemento `ultimo` que se va a insertar.
- Las comparaciones dentro del `while`.
- Los desplazamientos realizados.
- El array después de cada cambio.

El caso base queda marcado explícitamente:

```text
Caso base: n <= 1
```

La indentación permite ver la profundidad de cada llamada:

```text
Llamada insertionRecursivo(n = 6)
  Llamada insertionRecursivo(n = 5)
    Llamada insertionRecursivo(n = 4)
```

Cuando la recursión empieza a volver, se insertan los últimos elementos de cada subproblema. Por eso la traza permite ver dos fases:

1. Bajada recursiva hasta `n = 1`.
2. Inserción ordenada de los elementos al regresar.

---

## Trazabilidad en Merge Sort recursivo

Merge Sort recursivo divide el array en mitades hasta llegar a subarrays de un solo elemento. Después fusiona esas partes de forma ordenada.

La traza del método `mergeRecursivo` muestra:

- La llamada actual con sus índices `izquierda` y `derecha`.
- El subarray que se está procesando.
- El caso base `izquierda >= derecha`.
- El cálculo del punto medio.
- La división en parte izquierda y derecha.
- La llamada al método `fusionar`.

Ejemplo de traza de división:

```text
Llamada mergeRecursivo(0, 5) [5, 2, 8, 1, 9, 3]
Divido en [0, 2] y [3, 5]
```

Cuando se alcanza un subarray de tamaño 1, aparece:

```text
Caso base: izquierda >= derecha
```

Esto indica que esa parte ya está ordenada por definición.

---

## Trazabilidad en el método `fusionar`

El método `fusionar` es una parte clave de Merge Sort, porque aquí sí se modifica realmente el array principal.

La traza muestra:

- La mitad izquierda creada.
- La mitad derecha creada.
- Cada comparación entre ambas mitades.
- Qué elemento se copia al array principal.
- La posición donde se copia.
- El estado del array tras cada copia.
- Los elementos sobrantes de alguna mitad.

Ejemplo:

```text
Izquierda: [5]
Derecha:   [2]
Comparo: 5 <= 2 -> falso
Copio 2 en posicion 0
Array: [2, 2, 8, 1, 9, 3]
Sobra izquierda: copio 5 en posicion 1
Array: [2, 5, 8, 1, 9, 3]
```

Esta parte es importante porque permite reconstruir exactamente cómo se van mezclando dos subarrays ordenados.

---

## Trazabilidad en Merge Sort iterativo

La versión iterativa de Merge Sort no usa recursión. En su lugar, va fusionando bloques de tamaño creciente.

La traza muestra:

- El tamaño actual del bloque.
- Los rangos que se van a fusionar.
- La llamada al método `fusionar`.
- El array resultante después de cada fusión.

El flujo es:

```java
for (int tamano = 1; tamano < n; tamano *= 2) {
    for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
        int medio = izquierda + tamano - 1;
        int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
        fusionar(array, izquierda, medio, derecha, 1);
    }
}
```

Ejemplo de salida:

```text
Tamano de bloque = 1
Fusiono [0, 0] con [1, 1]
```

Después, cuando el tamaño aumenta:

```text
Tamano de bloque = 2
Fusiono [0, 1] con [2, 3]
```

Así se puede observar cómo el algoritmo pasa de fusionar elementos individuales a fusionar bloques más grandes hasta ordenar todo el array.

---

## Trazabilidad en Quick Sort

Quick Sort trabaja seleccionando un pivote, particionando el array y ordenando recursivamente las partes izquierda y derecha.

La traza del método `quickSort` muestra:

- La llamada actual con `izquierda` y `derecha`.
- El subarray procesado.
- El caso base `izquierda >= derecha`.
- La posición final del pivote después de particionar.
- Las llamadas recursivas a izquierda y derecha.

Ejemplo:

```text
Llamada quickSort(0, 5) [5, 2, 8, 1, 9, 3]
Pivote queda en posicion 2
Array: [2, 1, 3, 5, 9, 8]
```

La indentación permite ver claramente qué llamadas pertenecen a la parte izquierda y cuáles a la derecha.

---

## Trazabilidad en el método `particionar`

El método `particionar` es el núcleo de Quick Sort. En esta implementación, el pivote se toma como el último elemento del rango:

```java
int pivote = array[derecha];
```

La traza muestra:

- Qué valor se elige como pivote.
- Cada comparación `array[j] <= pivote`.
- Si la comparación es verdadera o falsa.
- Cuándo se incrementa `i`.
- Qué posiciones se intercambian.
- El array después de cada intercambio.
- El intercambio final que coloca el pivote en su posición definitiva.

Ejemplo:

```text
Pivote = 3 en posicion 5
Comparo: array[0] = 5 <= pivote 3 -> falso
No se intercambia
Comparo: array[1] = 2 <= pivote 3 -> verdadero
Intercambio posiciones 0 y 1
Array: [2, 5, 8, 1, 9, 3]
```

Al final de la partición se coloca el pivote:

```text
Coloco pivote en su posicion final
Intercambio posiciones 2 y 5
Array: [2, 1, 3, 5, 9, 8]
```

Esto permite saber exactamente qué elementos quedan a la izquierda y a la derecha del pivote.

---

## Artefactos de la entrega

La entrega se compone principalmente de los siguientes archivos:

- `RetoRecuperacionTrazasSimple.java`: código Java con los algoritmos y las trazas integradas.
- `Presentacion_Trazabilidad_Codigo_Ordenacion.md`: documento explicativo sobre el flujo del código y la trazabilidad implementada.

El archivo Java es el artefacto principal, ya que contiene la ejecución completa. El documento Markdown sirve como explicación de apoyo para entender cómo están organizadas las trazas y qué información proporciona cada una.

---

## Resultado esperado

Todas las implementaciones parten del mismo array:

```text
[5, 2, 8, 1, 9, 3]
```

Y todas deben terminar con el array ordenado:

```text
[1, 2, 3, 5, 8, 9]
```

La diferencia entre ellas no está en el resultado final, sino en el camino seguido para llegar a ese resultado. Por eso la traza permite ver cómo cada algoritmo toma decisiones y transforma el array paso a paso.

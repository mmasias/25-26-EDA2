# Reto de recuperación

Se proporcionan implementaciones de referencia de tres algoritmos de ordenación: **Insertion Sort** (versión iterativa y recursiva), **Merge Sort** (versión recursiva e iterativa) y **Quick Sort**.

Para cada algoritmo, se debe **enriquecer el código con instrucciones de traza** que permitan reconstruir, exclusivamente a partir de la salida por consola, la secuencia completa de decisiones y transformaciones que el algoritmo realiza sobre el array hasta alcanzar el resultado ordenado.

## Requisitos de la traza

1. **Estado inicial y final.** Mostrar el array antes de comenzar y después de terminar.
1. **Cada decisión relevante.** Toda comparación que determine un intercambio, un desplazamiento o la elección de un camino de ejecución debe quedar registrada, indicando los valores comparados y el resultado de la comparación.
1. **Cada modificación del array.** Cada vez que un elemento cambia de posición, mostrar el array resultante o al menos la operación realizada.
1. **Profundidad de recursión visible.** En los algoritmos recursivos, la traza de cada llamada debe estar indentada proporcionalmente a su nivel de recursión, de forma que el árbol de llamadas sea legible directamente en la salida.
1. **Identificación de casos base.** Señalar explícitamente cuándo se alcanza un caso base y por qué.

## Array de prueba

Todas las entregas deben ejecutarse sobre el siguiente array:

```java
int[] array = {5, 2, 8, 1, 9, 3};
```

La corrección se realizará comparando la traza producida contra la traza de referencia para ese input. Una implementación que produce salida correcta sobre otro array pero incorrecta sobre este no se considera válida.

## Restricción explícita

No se permite modificar la lógica de ordenación. Las únicas adiciones válidas son instrucciones `System.out.println` y métodos auxiliares de soporte (formateo de arrays, gestión de indentación). Cualquier cambio en las condiciones, comparaciones o estructura de control del algoritmo original invalida la entrega.

## Algoritmos

### Insertion sort

```java
    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
        }
    }

    public static void ordenar(int[] array, int n) {
        if (n <= 1) {
            return;
        }
        ordenar(array, n - 1);
        int ultimo = array[n - 1];
        int j = n - 2;
        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ultimo;
    }
```

### Merge sort

```java
    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        fusionar(array, izquierda, medio, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }


```

### Quick sort

```java
    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }
        int indicePivote = particionar(array, izquierda, derecha);
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
            }
        }
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        return i + 1;
    }
```

package src;

import java.util.Arrays;

public class AlgoritmosOrdenacion {

    private static int nivelRecursion = 0;

    private static String obtenerIndentacion() {
        return "  ".repeat(nivelRecursion);
    }

    private static String arrayAString(int[] array) {
        return Arrays.toString(array);
    }

    private static String arrayAString(int[] array, int izquierda, int derecha) {
        int[] subarray = new int[derecha - izquierda + 1];
        for (int i = 0; i < subarray.length; i++) {
            subarray[i] = array[izquierda + i];
        }
        return Arrays.toString(subarray);
    }

    public static void insertionSortIterativo(int[] array) {
        System.out.println("\n========== INSERTION SORT ITERATIVO ==========");
        System.out.println("Estado inicial: " + arrayAString(array));

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\nIteración i=" + i + ", elemento actual: " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparación: array[" + j + "]=" + array[j] + " > " + actual + "? SÍ");
                System.out.println("  Desplazamiento: array[" + (j + 1) + "] = " + array[j]);
                array[j + 1] = array[j];
                System.out.println("  Array después: " + arrayAString(array));
                j--;
            }

            if (j >= 0) {
                System.out.println("  Comparación: array[" + j + "]=" + array[j] + " > " + actual + "? NO");
            } else {
                System.out.println("  Límite izquierdo alcanzado");
            }

            System.out.println("  Inserción: array[" + (j + 1) + "] = " + actual);
            array[j + 1] = actual;
            System.out.println("  Array después: " + arrayAString(array));
        }

        System.out.println("\nEstado final: " + arrayAString(array));
        System.out.println("==========================================\n");
    }

    public static void insertionSortRecursivo(int[] array) {
        System.out.println("\n========== INSERTION SORT RECURSIVO ==========");
        System.out.println("Estado inicial: " + arrayAString(array));
        nivelRecursion = 0;
        insertionSortRecursivoAux(array, array.length);
        System.out.println("\nEstado final: " + arrayAString(array));
        System.out.println("==========================================\n");
    }

    private static void insertionSortRecursivoAux(int[] array, int n) {
        System.out.println(obtenerIndentacion() + "Llamada insertionSort(n=" + n + ")");

        if (n <= 1) {
            System.out.println(obtenerIndentacion() + "Caso base: n <= 1, retornando");
            return;
        }

        nivelRecursion++;
        insertionSortRecursivoAux(array, n - 1);
        nivelRecursion--;

        int ultimo = array[n - 1];
        System.out.println(obtenerIndentacion() + "Después de recursión: insertando " + ultimo + " en posición [" + (n - 1) + "]");
        System.out.println(obtenerIndentacion() + "Array actual: " + arrayAString(array));

        int j = n - 2;
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(obtenerIndentacion() + "  Comparación: array[" + j + "]=" + array[j] + " > " + ultimo + "? SÍ");
            System.out.println(obtenerIndentacion() + "  Desplazamiento: array[" + (j + 1) + "] = " + array[j]);
            array[j + 1] = array[j];
            j--;
        }

        if (j >= 0) {
            System.out.println(obtenerIndentacion() + "  Comparación: array[" + j + "]=" + array[j] + " > " + ultimo + "? NO");
        } else {
            System.out.println(obtenerIndentacion() + "  Límite izquierdo alcanzado");
        }

        System.out.println(obtenerIndentacion() + "Inserción: array[" + (j + 1) + "] = " + ultimo);
        array[j + 1] = ultimo;
        System.out.println(obtenerIndentacion() + "Array después: " + arrayAString(array));
    }

    public static void mergeSortRecursivo(int[] array) {
        System.out.println("\n========== MERGE SORT RECURSIVO ==========");
        System.out.println("Estado inicial: " + arrayAString(array));
        nivelRecursion = 0;
        mergeSortRecursivoAux(array, 0, array.length - 1);
        System.out.println("\nEstado final: " + arrayAString(array));
        System.out.println("======================================\n");
    }

    private static void mergeSortRecursivoAux(int[] array, int izquierda, int derecha) {
        System.out.println(obtenerIndentacion() + "mergeSortRec([" + izquierda + ", " + derecha + "]): " + arrayAString(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(obtenerIndentacion() + "Caso base: izquierda >= derecha");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(obtenerIndentacion() + "Dividiendo en medio=" + medio);

        nivelRecursion++;
        System.out.println(obtenerIndentacion() + "Ordenando mitad izquierda:");
        mergeSortRecursivoAux(array, izquierda, medio);

        System.out.println(obtenerIndentacion() + "Ordenando mitad derecha:");
        mergeSortRecursivoAux(array, medio + 1, derecha);
        nivelRecursion--;

        System.out.println(obtenerIndentacion() + "Fusionando [" + izquierda + ", " + medio + "] con [" + (medio + 1) + ", " + derecha + "]");
        fusionarConTraza(array, izquierda, medio, derecha);
        System.out.println(obtenerIndentacion() + "Array después de fusión: " + arrayAString(array, izquierda, derecha));
    }

    private static void fusionarConTraza(int[] array, int izquierda, int medio, int derecha) {
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

        System.out.println(obtenerIndentacion() + "  Mitad izquierda: " + Arrays.toString(mitadIzquierda));
        System.out.println(obtenerIndentacion() + "  Mitad derecha: " + Arrays.toString(mitadDerecha));

        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(obtenerIndentacion() + "  Comparación: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + "? SÍ -> tomar izquierda");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(obtenerIndentacion() + "  Comparación: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + "? NO -> tomar derecha");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println(obtenerIndentacion() + "  Copiando residuo izquierda: " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(obtenerIndentacion() + "  Copiando residuo derecha: " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    public static void mergeSortIterativo(int[] array) {
        System.out.println("\n========== MERGE SORT ITERATIVO ==========");
        System.out.println("Estado inicial: " + arrayAString(array));

        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n--- Pasada con tamaño de subarrays: " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("Fusionando: [" + izquierda + ", " + medio + "] con [" + (medio + 1) + ", " + derecha + "]");
                System.out.println("  Subarray izquierdo: " + arrayAString(array, izquierda, medio));
                System.out.println("  Subarray derecho: " + arrayAString(array, Math.min(medio + 1, n - 1), derecha));

                fusionarIterativoConTraza(array, izquierda, medio, derecha);
                System.out.println("  Resultado: " + arrayAString(array, izquierda, derecha));
            }
            System.out.println("Array después de pasada: " + arrayAString(array));
        }

        System.out.println("\nEstado final: " + arrayAString(array));
        System.out.println("======================================\n");
    }

    private static void fusionarIterativoConTraza(int[] array, int izquierda, int medio, int derecha) {
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

        int i = 0, j = 0, k = izquierda;
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

    public static void quickSort(int[] array) {
        System.out.println("\n========== QUICK SORT ==========");
        System.out.println("Estado inicial: " + arrayAString(array));
        nivelRecursion = 0;
        quickSortAux(array, 0, array.length - 1);
        System.out.println("\nEstado final: " + arrayAString(array));
        System.out.println("==============================\n");
    }

    private static void quickSortAux(int[] array, int izquierda, int derecha) {
        System.out.println(obtenerIndentacion() + "quickSort([" + izquierda + ", " + derecha + "]): " + arrayAString(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(obtenerIndentacion() + "Caso base: izquierda >= derecha");
            return;
        }

        System.out.println(obtenerIndentacion() + "Particionando...");
        int indicePivote = particionarConTraza(array, izquierda, derecha);
        System.out.println(obtenerIndentacion() + "Pivote colocado en índice: " + indicePivote);
        System.out.println(obtenerIndentacion() + "Array después: " + arrayAString(array));

        nivelRecursion++;
        System.out.println(obtenerIndentacion() + "Ordenando subarray izquierdo [" + izquierda + ", " + (indicePivote - 1) + "]");
        quickSortAux(array, izquierda, indicePivote - 1);

        System.out.println(obtenerIndentacion() + "Ordenando subarray derecho [" + (indicePivote + 1) + ", " + derecha + "]");
        quickSortAux(array, indicePivote + 1, derecha);
        nivelRecursion--;
    }

    private static int particionarConTraza(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        System.out.println(obtenerIndentacion() + "  Pivote seleccionado: " + pivote + " (posición " + derecha + ")");

        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            System.out.print(obtenerIndentacion() + "  Comparación: array[" + j + "]=" + array[j] + " <= " + pivote + "?");

            if (array[j] <= pivote) {
                System.out.println(" SÍ");
                i++;
                System.out.println(obtenerIndentacion() + "    Intercambio: array[" + i + "] <-> array[" + j + "]");
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(obtenerIndentacion() + "    Array: " + arrayAString(array));
            } else {
                System.out.println(" NO");
            }
        }

        System.out.println(obtenerIndentacion() + "  Colocando pivote en posición: " + (i + 1));
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arrayPrueba = {5, 2, 8, 1, 9, 3};

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║    ALGORITMOS DE ORDENACIÓN CON TRAZA      ║");
        System.out.println("║         Array prueba: {5,2,8,1,9,3}        ║");
        System.out.println("╚════════════════════════════════════════════╝");

        int[] array1 = arrayPrueba.clone();
        insertionSortIterativo(array1);

        int[] array2 = arrayPrueba.clone();
        insertionSortRecursivo(array2);

        int[] array3 = arrayPrueba.clone();
        mergeSortRecursivo(array3);

        int[] array4 = arrayPrueba.clone();
        mergeSortIterativo(array4);

        int[] array5 = arrayPrueba.clone();
        quickSort(array5);
    }
}

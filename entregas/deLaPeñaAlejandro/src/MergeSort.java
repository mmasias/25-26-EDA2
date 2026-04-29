import java.util.Arrays;

public class MergeSort {

    private static void printArray(int[] array, String mensaje) {
        System.out.println(mensaje + " " + Arrays.toString(array));
    }

    private static void printArray(int[] array, String mensaje, int nivel) {
        System.out.print("    ".repeat(nivel));
        System.out.println(mensaje + " " + Arrays.toString(array));
    }

    private static void printIndented(int nivel, String mensaje) {
        System.out.print("    ".repeat(nivel));
        System.out.println(mensaje);
    }

    public static void ordenarRecursivo(int[] array) {
        printArray(array, "=== INICIO Merge Sort Recursivo ===");
        ordenar(array, 0, array.length - 1);
        printArray(array, "=== FIN Merge Sort Recursivo (ORDENADO) ===");
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        printIndented(izquierda, "→ Llamada recursiva: ordenar([" + izquierda + ".." + derecha + "])");

        if (izquierda >= derecha) {
            printIndented(izquierda, "   Caso base alcanzado (subarray de 0 o 1 elemento)");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        printIndented(izquierda, "   Dividiendo en [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");

        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);

        printIndented(izquierda, "   Fusionando subarrays [" + izquierda + ".." + derecha + "]");
        fusionar(array, izquierda, medio, derecha);
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

        printIndented(izquierda, "     Arrays temporales: L=" + Arrays.toString(mitadIzquierda) 
                               + "  R=" + Arrays.toString(mitadDerecha));

        int i = 0, j = 0, k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("Comparando: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " ?");

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                i++;
                System.out.print("    ".repeat(izquierda + 1));
                System.out.println("→ Tomado de izquierda");
            } else {
                array[k] = mitadDerecha[j];
                j++;
                System.out.print("    ".repeat(izquierda + 1));
                System.out.println("→ Tomado de derecha");
            }
            printArray(array, "       Array actual:", izquierda + 1);
            k++;
        }

        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("→ Copiando resto de izquierda en pos " + k);
            printArray(array, "       Array actual:", izquierda + 1);
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("→ Copiando resto de derecha en pos " + k);
            printArray(array, "       Array actual:", izquierda + 1);
            j++;
            k++;
        }

        printIndented(izquierda, "   Fusion completada → [" + izquierda + ".." + derecha + "] ordenado");
    }

    public static void ordenarIterativo(int[] array) {
        printArray(array, "=== INICIO Merge Sort Iterativo (Bottom-Up) ===");

        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n=== Pasada con subarrays de tamaño " + tamano + " ===");

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("   Fusionando [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "]");
                fusionar(array, izquierda, medio, derecha);
            }
        }

        printArray(array, "=== FIN Merge Sort Iterativo (ORDENADO) ===");
    }

    public static void main(String[] args) {
        int[] original = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=".repeat(90));
        System.out.println("          MERGE SORT - AMBAS VERSIONES");
        System.out.println("Array original: " + Arrays.toString(original));
        System.out.println("=".repeat(90) + "\n");

        System.out.println("🔹 EJECUTANDO VERSIÓN RECURSIVA");
        ordenarRecursivo(original.clone());

        System.out.println("\n" + "=".repeat(90) + "\n");

        System.out.println("🔹 EJECUTANDO VERSIÓN ITERATIVA");
        ordenarIterativo(original.clone());

        System.out.println("\n" + "=".repeat(90));
    }
}
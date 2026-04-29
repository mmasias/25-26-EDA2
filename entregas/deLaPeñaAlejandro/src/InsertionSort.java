import java.util.Arrays;

public class InsertionSort {

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

    public static void ordenarIterativo(int[] array) {
        printArray(array, "=== INICIO Insertion Sort Iterativo ===");

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            printArray(array, "Pasada i=" + i + " → Elemento a insertar:", 1);
            System.out.println("    actual = " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("    Comparación: array[" + j + "]=" + array[j] 
                                 + " > " + actual + " → true");
                
                array[j + 1] = array[j];
                j--;
                
                printArray(array, "→ Desplazamiento realizado:", 2);
            }

            if (j == i - 1) {
                System.out.println("    No se necesita mover (ya está en posición correcta)");
            } else {
                System.out.println("    Insertando " + actual + " en posición " + (j + 1));
            }

            array[j + 1] = actual;
            printArray(array, "Array después de la pasada " + i + ":", 1);
        }

        printArray(array, "=== FIN Insertion Sort Iterativo (ORDENADO) ===");
    }

    public static void ordenarRecursivo(int[] array) {
        printArray(array, "=== INICIO Insertion Sort Recursivo ===");
        ordenarRecursivoAux(array, array.length);
        printArray(array, "=== FIN Insertion Sort Recursivo (ORDENADO) ===");
    }

    private static void ordenarRecursivoAux(int[] array, int n) {
        printIndented(n, "→ Llamada recursiva con n = " + n);

        if (n <= 1) {
            printIndented(n, "   ¡¡ CASO BASE !! (n <= 1)");
            return;
        }

        ordenarRecursivoAux(array, n - 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        printIndented(n, "← Volviendo: Insertando " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            printIndented(n, "   Comparación: " + array[j] + " > " + ultimo + " → true");
            array[j + 1] = array[j];
            j--;
        }

        array[j + 1] = ultimo;
        printArray(array, "   Array después de nivel n=" + n + ":", n);
    }

    public static void main(String[] args) {
        int[] original = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=".repeat(80));
        System.out.println("     INSERTION SORT - AMBAS VERSIONES");
        System.out.println("Array original: " + Arrays.toString(original));
        System.out.println("=".repeat(80) + "\n");

        System.out.println("🔹 EJECUTANDO VERSIÓN ITERATIVA");
        ordenarIterativo(original.clone());

        System.out.println("\n" + "=".repeat(80) + "\n");

        System.out.println("🔹 EJECUTANDO VERSIÓN RECURSIVA");
        ordenarRecursivo(original.clone());

        System.out.println("\n" + "=".repeat(80));
    }
}
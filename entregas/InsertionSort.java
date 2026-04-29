import java.util.Arrays;

public class InsertionSort {

    private static String getIndent() {
        int depth = 0;
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            if (e.getMethodName().equals("ordenar")) depth++;
        }
        return "  ".repeat(Math.max(0, depth - 1));
    }

    public static void ordenar(int[] array) {
        System.out.println("Iniciando Insertion Sort Iterativo. Array: " + Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("  [Bucle Externo] i=" + i + " | Evaluando elemento actual=" + actual);
            while (j >= 0 && array[j] > actual) {
                System.out.println("    [Comparación] array[" + j + "]=" + array[j] + " > actual=" + actual + " -> VERDADERO. Desplazando.");
                array[j + 1] = array[j];
                System.out.println("    [Modificación] Array tras desplazamiento: " + Arrays.toString(array));
                j--;
            }
            if (j >= 0) {
                System.out.println("    [Comparación] array[" + j + "]=" + array[j] + " > actual=" + actual + " -> FALSO. Fin de desplazamientos.");
            } else {
                System.out.println("    [Condición] Se alcanzó el inicio del array (j < 0).");
            }
            array[j + 1] = actual;
            System.out.println("  [Modificación] Colocando actual=" + actual + " en índice " + (j + 1) + ": " + Arrays.toString(array));
        }
    }

    public static void ordenar(int[] array, int n) {
        String ind = getIndent();
        System.out.println(ind + "Llamada a ordenar(array, n=" + n + ")");
        if (n <= 1) {
            System.out.println(ind + "  [Caso Base] n (" + n + ") <= 1. Retornando.");
            return;
        }
        ordenar(array, n - 1);
        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(ind + "[Post-Recursión] n=" + n + " | Evaluando elemento ultimo=" + ultimo);
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + "  [Comparación] array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> VERDADERO. Desplazando.");
            array[j + 1] = array[j];
            System.out.println(ind + "  [Modificación] Array tras desplazamiento: " + Arrays.toString(array));
            j--;
        }
        if (j >= 0) {
            System.out.println(ind + "  [Comparación] array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> FALSO. Fin de desplazamientos.");
        } else {
            System.out.println(ind + "  [Condición] Se alcanzó el inicio del array (j < 0).");
        }
        array[j + 1] = ultimo;
        System.out.println(ind + "  [Modificación] Colocando ultimo=" + ultimo + " en índice " + (j + 1) + ": " + Arrays.toString(array));
    }
}

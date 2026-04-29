public class InsertionSort {

    // =========================================================================
    // AUXILIARES
    // =========================================================================

    private static String str(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1)
                sb.append(", ");
        }
        return sb.append("]").toString();
    }

    // Contador de profundidad para la versión recursiva
    private static int depth = 0;

    // =========================================================================
    // ITERATIVO
    // =========================================================================

    public static void ordenar(int[] array) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   INSERTION SORT ~ ITERATIVO         ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Estado inicial: " + str(array));
        System.out.println();

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("┌─ Pasada i=" + i + "  |  actual=" + actual + "  |  " + str(array));

            while (j >= 0 && array[j] > actual) {
                System.out.println("│  Cmp array[" + j + "]=" + array[j]
                        + " > actual=" + actual
                        + "  →  VERDADERO  →  desplazar array[" + j + "] a pos " + (j + 1));
                array[j + 1] = array[j];
                System.out.println("│  Array: " + str(array));
                j--;
            }

            if (j >= 0) {
                System.out.println("│  Cmp array[" + j + "]=" + array[j]
                        + " > actual=" + actual
                        + "  →  FALSO  →  fin de desplazamientos");
            } else {
                System.out.println("│  j=" + j + " < 0  →  inicio del array, fin de desplazamientos");
            }

            array[j + 1] = actual;
            System.out.println("└─ Insertar " + actual + " en pos " + (j + 1) + "  →  " + str(array));
            System.out.println();
        }

        System.out.println("Estado final: " + str(array));
    }

    // =========================================================================
    // RECURSIVO
    // =========================================================================

    public static void ordenar(int[] array, int n) {
        String ind = "  ".repeat(depth);

        System.out.println(ind + "→ ordenar(n=" + n + ")");

        if (n <= 1) {
            System.out.println(ind + "  [CASO BASE] n=" + n
                    + " ≤ 1  →  subarreglo trivialmente ordenado, retornar");
            return;
        }

        depth++;
        ordenar(array, n - 1);
        depth--;

        // A partir de aquí: inserción de array[n-1] en el subarray ya ordenado
        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(ind + "  ← vuelta de ordenar(n-1=" + (n - 1) + ")  |  insertando ultimo=" + ultimo
                + "  |  " + str(array));

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + "  Cmp array[" + j + "]=" + array[j]
                    + " > ultimo=" + ultimo
                    + "  →  VERDADERO  →  desplazar array[" + j + "] a pos " + (j + 1));
            array[j + 1] = array[j];
            System.out.println(ind + "  Array: " + str(array));
            j--;
        }

        if (j >= 0) {
            System.out.println(ind + "  Cmp array[" + j + "]=" + array[j]
                    + " > ultimo=" + ultimo
                    + "  →  FALSO  →  fin de desplazamientos");
        } else {
            System.out.println(ind + "  j=" + j + " < 0  →  inicio del array, fin de desplazamientos");
        }

        array[j + 1] = ultimo;
        System.out.println(ind + "  Insertar " + ultimo + " en pos " + (j + 1) + "  →  " + str(array));
    }

    // =========================================================================
    // MAIN
    // =========================================================================

    public static void main(String[] args) {

        // -- Iterativo --
        int[] a1 = { 5, 2, 8, 1, 9, 3 };
        ordenar(a1);

        System.out.println("\n\n");

        // -- Recursivo --
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   INSERTION SORT — RECURSIVO         ║");
        System.out.println("╚══════════════════════════════════════╝");
        int[] a2 = { 5, 2, 8, 1, 9, 3 };
        System.out.println("Estado inicial: " + str(a2));
        System.out.println();
        depth = 0;
        ordenar(a2, a2.length);
        System.out.println();
        System.out.println("Estado final: " + str(a2));
    }
}

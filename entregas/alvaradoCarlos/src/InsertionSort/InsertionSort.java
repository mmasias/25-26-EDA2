public class InsertionSort {

    public static void ordenar(int[] array) {
        System.out.println("ESTADO INICIAL: " + formatear(array));

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("\n[I=" + i + "] Insertando " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("  " + array[j] + " > " + actual + " ? -> SI. Desplazando " + array[j]);
                array[j + 1] = array[j];
                System.out.println("    " + formatear(array));
                j--;
            }

            if (j >= 0) {
                System.out.println("  " + array[j] + " > " + actual + " ? -> NO. Continua al siguiente.");
            } else {
                System.out.println("  j < 0 ? -> Al inicio.");
            }

            array[j + 1] = actual;
            System.out.println("-> Final paso: " + formatear(array));
        }
    }

    public static void ordenar(int[] array, int n) {
        int profundidad = array.length - n;

        String indentacion = "  ".repeat(profundidad);

        if (n == array.length) {
            System.out.println("ESTADO INICIAL: " + formatear(array));
        }

        if (n <= 1) {
            System.out.println(indentacion + "[CASO BASE n=" + n + "] " + array[0] + " ya ordenado.");
            return;
        }

        System.out.println(indentacion + "-> Bajando a n=" + (n - 1));
        ordenar(array, n - 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println("\n" + indentacion + "[NIVEL n=" + n + "] Insertando " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(indentacion + "  " + array[j] + " > " + ultimo + " ? -> SI");
            array[j + 1] = array[j];
            System.out.println(indentacion + "    " + formatear(array));
            j--;
        }

        if (j >= 0) {
            System.out.println(indentacion + "  " + array[j] + " > " + ultimo + " ? -> NO");
        }

        array[j + 1] = ultimo;
        System.out.println(indentacion + "-> Fin n=" + n + ": " + formatear(array));
    }

    public static void imprimirArray(int[] array) {
        System.out.println(formatear(array));
    }

    private static String formatear(int[] array) {
        String arrayFormateado = " >>> [";
        for (int i = 0; i < array.length; i++) {
            arrayFormateado += array[i] + (i < array.length - 1 ? ", " : "");
        }
        return arrayFormateado + "]";
    }
}
public class InsertionSortTraza {

    private static int nivelRecursion = 0;

    private static String indent(int nivel) {
        String resultado = "";
        for (int i = 0; i < nivel; i++) {
            resultado = resultado + "    "; 
        }
        return resultado;
    }

    private static String arrayToString(int[] array) {
        String resultado = "[";
        for (int i = 0; i < array.length; i++) {
            resultado = resultado + array[i];
            if (i < array.length - 1) {
                resultado = resultado + ", ";
            }
        }
        resultado = resultado + "]";
        return resultado;
    }

    public static void ordenar(int[] array) {
        System.out.println("Estado inicial (Iterativo): " + arrayToString(array));
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\nIteración i=" + i + ". Evaluando insertar elemento: " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparación: array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> TRUE");
                array[j + 1] = array[j];
                System.out.println("  Desplazamiento: movido " + array[j] + " a la posición " + (j + 1) + " -> " + arrayToString(array));
                j--;
            }
            if (j >= 0) {
                System.out.println("  Comparación: array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> FALSE (o inicio alcanzado)");
            }

            array[j + 1] = actual;
            System.out.println("  Inserción: colocado " + actual + " en la posición " + (j + 1) + " -> " + arrayToString(array));
        }
        System.out.println("\nEstado final (Iterativo): " + arrayToString(array));
    }

    public static void ordenar(int[] array, int n) {
        String ind = indent(nivelRecursion);

        if (nivelRecursion == 0) {
            System.out.println("\nEstado inicial (Recursivo): " + arrayToString(array));
        }

        System.out.println(ind + "Llamada recursiva: ordenar(array, n=" + n + ")");

        if (n <= 1) {
            System.out.println(ind + "-> CASO BASE ALCANZADO: n <= 1. El subarray de 1 elemento ya se considera ordenado.");
            return;
        }

        nivelRecursion++;
        ordenar(array, n - 1);
        nivelRecursion--;

        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(ind + "Retorno de recursión (n=" + n + "). Buscando posición para: " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + "  Comparación: array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> TRUE");
            array[j + 1] = array[j];
            System.out.println(ind + "  Desplazamiento: movido " + array[j] + " a pos " + (j + 1) + " -> " + arrayToString(array));
            j--;
        }
        if (j >= 0) {
            System.out.println(ind + "  Comparación: array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> FALSE");
        }

        array[j + 1] = ultimo;
        System.out.println(ind + "  Inserción: colocado " + ultimo + " en pos " + (j + 1) + " -> " + arrayToString(array));

        if (nivelRecursion == 0) {
            System.out.println("Estado final (Recursivo): " + arrayToString(array));
        }
    }
}

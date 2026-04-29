public class InsertionSortRecursivo {

    public static void ordenar(int[] array, int n) {
        ordenar(array, n, 0);
    }

    private static void ordenar(int[] array, int n, int nivel) {
        String indent = indentacion(nivel);
        System.out.println(indent + "Llamada ordenar(n=" + n + ") | array=" + formatear(array));
        if (n <= 1) {
            System.out.println(indent + "CASO BASE: n=" + n + " <= 1, retornar");
            return;
        }
        ordenar(array, n - 1, nivel + 1);
        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(indent + "Insertando ultimo=" + ultimo + " (posicion " + (n - 1) + ")");
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(indent + "  Comparacion array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> TRUE, desplazar");
            array[j + 1] = array[j];
            System.out.println(indent + "  Desplazado array[" + (j + 1) + "]=" + array[j] + " | array=" + formatear(array));
            j--;
        }
        if (j >= 0) {
            System.out.println(indent + "  Comparacion array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> FALSE, parar");
        } else {
            System.out.println(indent + "  j=" + j + " < 0, parar");
        }
        array[j + 1] = ultimo;
        System.out.println(indent + "  Colocado ultimo=" + ultimo + " en posicion " + (j + 1) + " | array=" + formatear(array));
    }

    private static String indentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    private static String formatear(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
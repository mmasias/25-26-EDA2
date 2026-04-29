public class InsertionSortIterativo {

    public static void ordenar(int[] array) {
        System.out.println("=== INSERTION SORT ITERATIVO ===");
        System.out.println("Estado inicial: " + formatear(array));
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("Iteracion i=" + i + ": insertando actual=" + actual + " | array=" + formatear(array));
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparacion array[" + j + "]=" + array[j] + " > actual=" + actual + " -> TRUE, desplazar");
                array[j + 1] = array[j];
                System.out.println("  Desplazado array[" + (j + 1) + "]=" + array[j] + " | array=" + formatear(array));
                j--;
            }
            if (j >= 0) {
                System.out.println("  Comparacion array[" + j + "]=" + array[j] + " > actual=" + actual + " -> FALSE, parar");
            } else {
                System.out.println("  j=" + j + " < 0, parar");
            }
            array[j + 1] = actual;
            System.out.println("  Colocado actual=" + actual + " en posicion " + (j + 1) + " | array=" + formatear(array));
        }
        System.out.println("Estado final: " + formatear(array));
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
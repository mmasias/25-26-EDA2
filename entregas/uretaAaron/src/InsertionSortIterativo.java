public class InsertionSortIterativo {
    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + TrazaUtils.fmt(array));
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("Elemento actual i=" + i + " (valor: " + actual + ")");
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Decisión: array[" + j + "]=" + array[j] + " > " + actual + " (SÍ). Desplazando.");
                array[j + 1] = array[j];
                j--;
                System.out.println("  Array tras desplazamiento: " + TrazaUtils.fmt(array));
            }
            if (j >= 0) System.out.println("  Decisión: array[" + j + "]=" + array[j] + " > " + actual + " (NO).");
            else System.out.println("  Decisión: j < 0. No más comparaciones.");

            array[j + 1] = actual;
            System.out.println("Inserción de " + actual + " en posición " + (j + 1) + ": " + TrazaUtils.fmt(array));
        }
        System.out.println("Estado final: " + TrazaUtils.fmt(array));
    }
}
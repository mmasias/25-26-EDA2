public class Main {

    public static void main(String[] args) {
        ejecutarInsertionIterativo();
        System.out.println();
        ejecutarInsertionRecursivo();
        System.out.println();
        ejecutarMergeRecursivo();
        System.out.println();
        ejecutarMergeIterativo();
        System.out.println();
        ejecutarQuickSort();
    }

    private static void ejecutarInsertionIterativo() {
        int[] array = {5, 2, 8, 1, 9, 3};
        InsertionSortIterativo.ordenar(array);
    }

    private static void ejecutarInsertionRecursivo() {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("=== INSERTION SORT RECURSIVO ===");
        System.out.println("Estado inicial: " + formatear(array));
        InsertionSortRecursivo.ordenar(array, array.length);
        System.out.println("Estado final: " + formatear(array));
    }

    private static void ejecutarMergeRecursivo() {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("=== MERGE SORT RECURSIVO ===");
        System.out.println("Estado inicial: " + formatear(array));
        MergeSortRecursivo.ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + formatear(array));
    }

    private static void ejecutarMergeIterativo() {
        int[] array = {5, 2, 8, 1, 9, 3};
        MergeSortIterativo.ordenarIterativo(array);
    }

    private static void ejecutarQuickSort() {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("=== QUICK SORT ===");
        System.out.println("Estado inicial: " + formatear(array));
        QuickSort.ordenar(array, 0, array.length - 1);
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
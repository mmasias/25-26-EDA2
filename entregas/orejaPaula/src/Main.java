import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] base = {5, 2, 8, 1, 9, 3};

        ejecutarInsertionIterativo(base);
        ejecutarInsertionRecursivo(base);
        ejecutarMergeRecursivo(base);
        ejecutarMergeIterativo(base);
        ejecutarQuickSort(base);
    }

    private static void ejecutarInsertionIterativo(int[] base) {
        int[] array = Arrays.copyOf(base, base.length);
        Trazas.titulo("Insertion Sort iterativo");
        Trazas.estadoInicial(array);
        InsertionSort.ordenar(array);
        Trazas.estadoFinal(array);
    }

    private static void ejecutarInsertionRecursivo(int[] base) {
        int[] array = Arrays.copyOf(base, base.length);
        Trazas.titulo("Insertion Sort recursivo");
        Trazas.estadoInicial(array);
        InsertionSort.ordenar(array, array.length);
        Trazas.estadoFinal(array);
    }

    private static void ejecutarMergeRecursivo(int[] base) {
        int[] array = Arrays.copyOf(base, base.length);
        Trazas.titulo("Merge Sort recursivo");
        Trazas.estadoInicial(array);
        MergeSort.ordenar(array, 0, array.length - 1);
        Trazas.estadoFinal(array);
    }

    private static void ejecutarMergeIterativo(int[] base) {
        int[] array = Arrays.copyOf(base, base.length);
        Trazas.titulo("Merge Sort iterativo");
        Trazas.estadoInicial(array);
        MergeSort.ordenarIterativo(array);
        Trazas.estadoFinal(array);
    }

    private static void ejecutarQuickSort(int[] base) {
        int[] array = Arrays.copyOf(base, base.length);
        Trazas.titulo("Quick Sort");
        Trazas.estadoInicial(array);
        QuickSort.ordenar(array, 0, array.length - 1);
        Trazas.estadoFinal(array);
    }
}
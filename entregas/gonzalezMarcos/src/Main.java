public class Main {

    private static final String SEPARADOR = "\n======================================================================\n";

    public static void main(String[] args) {


        System.out.println(SEPARADOR);
        System.out.println(">>> INSERTION SORT (Iterativo)");
        System.out.println(SEPARADOR);
        int[] arrayInsertionIterativo = {5, 2, 8, 1, 9, 3};
        InsertionSortTraza.ordenar(arrayInsertionIterativo);


        System.out.println(SEPARADOR);
        System.out.println(">>> INSERTION SORT (Recursivo)");
        System.out.println(SEPARADOR);
        int[] arrayInsertionRecursivo = {5, 2, 8, 1, 9, 3};
        InsertionSortTraza.ordenar(arrayInsertionRecursivo, arrayInsertionRecursivo.length);


        System.out.println(SEPARADOR);
        System.out.println(">>> MERGE SORT (Recursivo)");
        System.out.println(SEPARADOR);
        int[] arrayMergeRecursivo = {5, 2, 8, 1, 9, 3};
        MergeSortTraza.ordenar(arrayMergeRecursivo, 0, arrayMergeRecursivo.length - 1);


        System.out.println(SEPARADOR);
        System.out.println(">>> MERGE SORT (Iterativo)");
        System.out.println(SEPARADOR);
        int[] arrayMergeIterativo = {5, 2, 8, 1, 9, 3};
        MergeSortTraza.ordenarIterativo(arrayMergeIterativo);


        System.out.println(SEPARADOR);
        System.out.println(">>> QUICK SORT");
        System.out.println(SEPARADOR);
        int[] arrayQuickSort = {5, 2, 8, 1, 9, 3};
        QuickSortTraza.ordenar(arrayQuickSort, 0, arrayQuickSort.length - 1);
    }
}

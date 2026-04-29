public class Main {
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("       INSERTION SORT (ITERATIVO)        ");
        System.out.println("=========================================");
        int[] array1 = {5, 2, 8, 1, 9, 3};
        InsertionSort.ordenar(array1);

        System.out.println("\n\n=========================================");
        System.out.println("       INSERTION SORT (RECURSIVO)        ");
        System.out.println("=========================================");
        int[] array2 = {5, 2, 8, 1, 9, 3};
        InsertionSort.ordenar(array2, array2.length);

        System.out.println("\n\n=========================================");
        System.out.println("         MERGE SORT (RECURSIVO)          ");
        System.out.println("=========================================");
        int[] array3 = {5, 2, 8, 1, 9, 3};
        MergeSort.ordenar(array3, 0, array3.length - 1);

        System.out.println("\n\n=========================================");
        System.out.println("         MERGE SORT (ITERATIVO)          ");
        System.out.println("=========================================");
        int[] array4 = {5, 2, 8, 1, 9, 3};
        MergeSort.ordenarIterativo(array4);

        System.out.println("\n\n=========================================");
        System.out.println("               QUICK SORT                ");
        System.out.println("=========================================");
        int[] array5 = {5, 2, 8, 1, 9, 3};
        QuickSort.ordenar(array5, 0, array5.length - 1);
        
    }
}
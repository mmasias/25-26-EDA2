public class Main {
    public static void main(String[] args) {
        
        int[] arr1 = {5, 2, 8, 1, 9, 3};
        Soporte.ejecutarPrueba("INSERTION SORT (ITERATIVO)", arr1, () -> insertionSort.ordenar(arr1));

        int[] arr2 = {5, 2, 8, 1, 9, 3};
        Soporte.ejecutarPrueba("INSERTION SORT (RECURSIVO)", arr2, () -> insertionSort.ordenar(arr2, arr2.length));

        int[] arr3 = {5, 2, 8, 1, 9, 3};
        Soporte.ejecutarPrueba("MERGE SORT (RECURSIVO)", arr3, () -> mergeSort.ordenar(arr3, 0, arr3.length - 1));

        int[] arr4 = {5, 2, 8, 1, 9, 3};
        Soporte.ejecutarPrueba("MERGE SORT (ITERATIVO)", arr4, () -> mergeSort.ordenarIterativo(arr4));

        int[] arr5 = {5, 2, 8, 1, 9, 3};
        Soporte.ejecutarPrueba("QUICK SORT", arr5, () -> quickSort.ordenar(arr5, 0, arr5.length - 1));
    }
}
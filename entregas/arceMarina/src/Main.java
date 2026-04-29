import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayOriginal = {5, 2, 8, 1, 9, 3};

        System.out.println("=== INSERTION SORT (ITERATIVO) ===");
        int[] arr1 = arrayOriginal.clone();
        System.out.println("Estado inicial: " + Arrays.toString(arr1));
        SoporteTraza.reiniciar();
        InsertionSort.ordenar(arr1);
        System.out.println("Estado final:    " + Arrays.toString(arr1) + "\n");

        System.out.println("=== INSERTION SORT (RECURSIVO) ===");
        int[] arr2 = arrayOriginal.clone();
        System.out.println("Estado inicial: " + Arrays.toString(arr2));
        SoporteTraza.reiniciar();
        InsertionSort.ordenar(arr2, arr2.length);
        System.out.println("Estado final:    " + Arrays.toString(arr2) + "\n");

        System.out.println("=== MERGE SORT (RECURSIVO) ===");
        int[] arr3 = arrayOriginal.clone();
        System.out.println("Estado inicial: " + Arrays.toString(arr3));
        SoporteTraza.reiniciar();
        MergeSort.ordenar(arr3, 0, arr3.length - 1);
        System.out.println("Estado final:    " + Arrays.toString(arr3) + "\n");

        System.out.println("=== MERGE SORT (ITERATIVO) ===");
        int[] arr4 = arrayOriginal.clone();
        System.out.println("Estado inicial: " + Arrays.toString(arr4));
        SoporteTraza.reiniciar();
        MergeSort.ordenarIterativo(arr4);
        System.out.println("Estado final:    " + Arrays.toString(arr4) + "\n");

        System.out.println("=== QUICK SORT ===");
        int[] arr5 = arrayOriginal.clone();
        System.out.println("Estado inicial: " + Arrays.toString(arr5));
        SoporteTraza.reiniciar();
        QuickSort.ordenar(arr5, 0, arr5.length - 1);
        System.out.println("Estado final:    " + Arrays.toString(arr5) + "\n");
    }
}
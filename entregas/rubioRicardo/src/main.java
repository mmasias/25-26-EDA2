import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        
        int[] arrayOriginal = {5, 2, 8, 1, 9, 3};
        int[] arrayPrueba;

        System.out.println("=========================================");
        System.out.println("1. INSERTION SORT (ITERATIVO)");
        System.out.println("=========================================");
        arrayPrueba = arrayOriginal.clone();
        insertionSort.ordenar(arrayPrueba);

        System.out.println("\n\n=========================================");
        System.out.println("2. INSERTION SORT (RECURSIVO)");
        System.out.println("=========================================");
        arrayPrueba = arrayOriginal.clone();
        insertionSort.ordenar(arrayPrueba, arrayPrueba.length);

        System.out.println("\n\n=========================================");
        System.out.println("3. MERGE SORT (RECURSIVO)");
        System.out.println("=========================================");
        arrayPrueba = arrayOriginal.clone();
        mergeSort.ordenar(arrayPrueba, 0, arrayPrueba.length - 1);

        System.out.println("\n\n=========================================");
        System.out.println("4. MERGE SORT (ITERATIVO)");
        System.out.println("=========================================");
        arrayPrueba = arrayOriginal.clone();
        mergeSort.ordenarIterativo(arrayPrueba);

        System.out.println("\n\n=========================================");
        System.out.println("5. QUICK SORT");
        System.out.println("=========================================");
        arrayPrueba = arrayOriginal.clone();
        quickSort.ordenar(arrayPrueba, 0, arrayPrueba.length - 1);
    }
}

public class AppOrdenamientos {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("RETO DE RECUPERACIÓN - TRAZAS DE ORDENAMIENTO");
        System.out.println("==============================================");
        System.out.println();

        int[] arrayInsercionIterativa = {5, 2, 8, 1, 9, 3};
        System.out.println("---------- INSERTION SORT (ITERATIVE) ----------");
        InsertionSort.ordenar(arrayInsercionIterativa);
        System.out.println();

        int[] arrayInsercionRecursiva = {5, 2, 8, 1, 9, 3};
        System.out.println("---------- INSERTION SORT (RECURSIVE) ----------");
        InsertionSort.ordenar(arrayInsercionRecursiva, arrayInsercionRecursiva.length);
        System.out.println();

        int[] arrayMezclaRecursiva = {5, 2, 8, 1, 9, 3};
        System.out.println("---------- MERGE SORT (RECURSIVE) ----------");
        MergeSort.ordenar(arrayMezclaRecursiva, 0, arrayMezclaRecursiva.length - 1);
        System.out.println();

        int[] arrayMezclaIterativa = {5, 2, 8, 1, 9, 3};
        System.out.println("---------- MERGE SORT (ITERATIVE) ----------");
        MergeSort.ordenarIterativo(arrayMezclaIterativa);
        System.out.println();

        int[] arrayRapido = {5, 2, 8, 1, 9, 3};
        System.out.println("---------- QUICK SORT ----------");
        QuickSort.ordenar(arrayRapido, 0, arrayRapido.length - 1);
    }
}

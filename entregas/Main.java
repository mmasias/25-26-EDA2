import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] original = {5, 2, 8, 1, 9, 3};

        ejecutarPrueba("INSERTION SORT (ITERATIVO)", original.clone(), array -> InsertionSort.ordenar(array));
        ejecutarPrueba("INSERTION SORT (RECURSIVO)", original.clone(), array -> InsertionSort.ordenar(array, array.length));

        ejecutarPrueba("MERGE SORT (RECURSIVO)", original.clone(), array -> MergeSort.ordenar(array, 0, array.length - 1));
        ejecutarPrueba("MERGE SORT (ITERATIVO)", original.clone(), array -> MergeSort.ordenarIterativo(array));

        ejecutarPrueba("QUICK SORT", original.clone(), array -> QuickSort.ordenar(array, 0, array.length - 1));
    }

    private static void ejecutarPrueba(String titulo, int[] array, java.util.function.Consumer<int[]> algoritmo) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" EJECUTANDO: " + titulo);
        System.out.println("=".repeat(50));
        System.out.println("Estado inicial: " + Arrays.toString(array) + "\n");
        
        algoritmo.accept(array);
        
        System.out.println("\nEstado final: " + Arrays.toString(array));
    }
}
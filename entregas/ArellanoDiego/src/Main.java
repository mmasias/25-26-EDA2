import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("Antes del ordenamiento:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Seleccione algoritmo de ordenación:");
        System.out.println("1. Insertion Sort (iterativo)");
        System.out.println("2. Insertion Sort (recursivo)");
        System.out.println("3. Merge Sort (recursivo)");
        System.out.println("4. Merge Sort (iterativo)");
        System.out.println("5. Quick Sort");

        int opcion = sc.nextInt();
        System.out.println();

        if (opcion == 1) {
            InsertionSort.ordenar(array);
        } else if (opcion == 2) {
            InsertionSort.ordenar(array, array.length);
        } else if (opcion == 3) {
            MergeSort.ordenar(array, 0, array.length - 1);
        } else if (opcion == 4) {
            MergeSort.ordenarIterativo(array);
        } else if (opcion == 5) {
            QuickSort.ordenar(array, 0, array.length - 1);
        } else {
            System.out.println("Opción no válida");
        }

        System.out.println();
        
        System.out.println("Array luego del ordenamiento:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
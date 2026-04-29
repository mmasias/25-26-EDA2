import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayOriginal = {5, 2, 8, 1, 9, 3};

        int[] arrayInsIte = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        System.out.println("==================================================");
        System.out.println("            INSERTION SORT ITERATIVO");
        System.out.println("==================================================");
        System.out.println("ESTADO INICIAL: " + Arrays.toString(arrayInsIte) + "\n");
        InsertionSort.ordenarIterativo(arrayInsIte);
        System.out.println("\nESTADO FINAL:   " + Arrays.toString(arrayInsIte));
        System.out.println("==================================================\n");

        int[] arrayInsRec = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        System.out.println("==================================================");
        System.out.println("            INSERTION SORT RECURSIVO");
        System.out.println("==================================================");
        System.out.println("ESTADO INICIAL: " + Arrays.toString(arrayInsRec) + "\n");
        InsertionSort.ordenarRecursivo(arrayInsRec, arrayInsRec.length, 0);
        System.out.println("\nESTADO FINAL:   " + Arrays.toString(arrayInsRec));
        System.out.println("==================================================\n");

        int[] arrayMergeRec = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        System.out.println("==================================================");
        System.out.println("              MERGE SORT RECURSIVO");
        System.out.println("==================================================");
        System.out.println("ESTADO INICIAL: " + Arrays.toString(arrayMergeRec) + "\n");
        MergeSort.ordenar(arrayMergeRec, 0, arrayMergeRec.length - 1, 0);
        System.out.println("\nESTADO FINAL:   " + Arrays.toString(arrayMergeRec));
        System.out.println("==================================================\n");

        int[] arrayMergeIte = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        System.out.println("==================================================");
        System.out.println("              MERGE SORT ITERATIVO");
        System.out.println("==================================================");
        System.out.println("ESTADO INICIAL: " + Arrays.toString(arrayMergeIte) + "\n");
        MergeSort.ordenarIterativo(arrayMergeIte);
        System.out.println("\nESTADO FINAL:   " + Arrays.toString(arrayMergeIte));
        System.out.println("==================================================\n");

        int[] arrayQuick = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        System.out.println("==================================================");
        System.out.println("              QUICK SORT RECURSIVO");
        System.out.println("==================================================");
        System.out.println("ESTADO INICIAL: " + Arrays.toString(arrayQuick) + "\n");
        QuickSort.ordenar(arrayQuick, 0, arrayQuick.length - 1, 0);
        System.out.println("\nESTADO FINAL:   " + Arrays.toString(arrayQuick));
        System.out.println("==================================================");
    }
}
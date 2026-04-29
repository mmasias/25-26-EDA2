import java.util.Arrays;

public class InsertionSortRecursivo {

    static int recursionDepth = 0;

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== INICIO INSERTION SORT RECURSIVO ===");
        System.out.println("Inicial: " + Arrays.toString(array));
        
        ordenar(array, array.length);
        
        System.out.println("Final: " + Arrays.toString(array));
    }

    static void ordenar(int[] array, int n) {
        System.out.println(indent() + "ordenar(n=" + n + ")");
        recursionDepth++;

        if (n <= 1) {
            recursionDepth--;
            return;
        }

        ordenar(array, n - 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ultimo;
        
        System.out.println(indent() + "Insertado " + ultimo + " -> " + Arrays.toString(array));
        recursionDepth--;
    }

    static String indent() {
        return "  ".repeat(Math.max(0, recursionDepth));
    }
}

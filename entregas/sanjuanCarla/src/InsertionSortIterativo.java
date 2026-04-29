import java.util.Arrays;

public class InsertionSortIterativo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== INICIO INSERTION SORT ITERATIVO ===");
        System.out.println("Inicial: " + Arrays.toString(array));
        
        ordenar(array);
        
        System.out.println("Final: " + Arrays.toString(array));
    }

    static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
            
            System.out.println("  Iteración " + i + " (insertado " + actual + "): " + Arrays.toString(array));
        }
    }
}

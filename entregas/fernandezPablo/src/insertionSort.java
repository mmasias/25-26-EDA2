import java.util.Arrays;

public class insertionSort {

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.printf("Iteración i=%d. Evaluando insertar: %d%n", i, actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.printf("  Comparación: %d > %d -> true. Desplazando %d a la derecha.%n", array[j], actual, array[j]);
                array[j + 1] = array[j];
                j--;
            }
            System.out.printf("  Condición falsa/límite. Colocando %d en índice %d.%n", actual, j + 1);
            array[j + 1] = actual;
            System.out.printf("  Array resultante: %s%n", Arrays.toString(array));
        }
    }

    public static void ordenar(int[] array, int n) {
        if (n <= 1) {
            System.out.printf("%sCaso base: n=%d. Array unitario/vacío ya está ordenado.%n", Soporte.ind(), n);
            return;
        }
        
        System.out.printf("%sLlamada recursiva n=%d%n", Soporte.ind(), n);
        Soporte.nivelRecursion++;
        ordenar(array, n - 1);
        Soporte.nivelRecursion--;

        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.printf("%sVuelta recursión (n=%d). Evaluando insertar: %d%n", Soporte.ind(), n, ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            System.out.printf("%s  Comparación: %d > %d -> true. Desplazando %d.%n", Soporte.ind(), array[j], ultimo, array[j]);
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ultimo;
        System.out.printf("%s  Array tras inserción: %s%n", Soporte.ind(), Arrays.toString(array));
    }
}
package insertionsort;
import java.util.Arrays;

public class InsertionSortIterativo {

    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            System.out.println("Iteracion i=" + i + " | actual=" + actual);
            imprimirComparacion(array, j, actual);
            
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                System.out.println("Desplazamiento: " + Arrays.toString(array));
                j--;
                imprimirComparacion(array, j, actual);
            }
            array[j + 1] = actual;
            System.out.println("Insercion: " + Arrays.toString(array));
        }
        
        System.out.println("Estado final: " + Arrays.toString(array));
    }

    private static void imprimirComparacion(int[] array, int j, int actual) {
        if (j < 0) {
            System.out.println("Comparacion: j<0. Fin de la busqueda.");
        } else {
            System.out.println("Comparacion: array[" + j + "]=" + array[j] + " > " + actual + " es " + (array[j] > actual));
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenar(array);
    }
}
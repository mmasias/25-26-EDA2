import java.util.Arrays;

public class InsertionSortIterativo {

    private static String formatear(int[] array) {
        return Arrays.toString(array);
    }

    private static String formatearRango(int[] array, int desde, int hasta) {
        return Arrays.toString(Arrays.copyOfRange(array, desde, hasta + 1));
    }

    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + formatear(array));
        for (int i = 1; i < array.length; i++) {
            System.out.println("Iteracion i=" + i);
            int actual = array[i];
            System.out.println("  actual = array[" + i + "] = " + actual);
            System.out.println("  Prefijo ya ordenado: " + formatearRango(array, 0, i - 1));
            int j = i - 1;
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparacion array[" + j + "]=" + array[j] + " > " + actual + " ? Si, desplazar array[" + j + "] a posicion " + (j + 1));
                array[j + 1] = array[j];
                System.out.println("    Estado del array: " + formatear(array));
                j--;
            }
            if (j >= 0) {
                System.out.println("  Comparacion array[" + j + "]=" + array[j] + " > " + actual + " ? No, fin del bucle de desplazamiento");
            } else {
                System.out.println("  j=" + j + " < 0, fin del bucle de desplazamiento (alcanzado el inicio)");
            }
            array[j + 1] = actual;
            System.out.println("  Insertar " + actual + " en posicion " + (j + 1));
            System.out.println("    Estado del array: " + formatear(array));
        }
        System.out.println("Estado final: " + formatear(array));
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenar(array);
    }
}
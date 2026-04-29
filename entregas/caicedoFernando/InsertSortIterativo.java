package entregas.caicedoFernando;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSortIterativo {

    final private static Scanner scanner = new Scanner(System.in);

    public static void ordenar(int[] array) {
        System.out.println("=== INSERT SORT ITERATIVO ===\nEstado inicial: " + Arrays.toString(array));
        System.out.println("=== PRESIONE ENTER PARA CONTINUAR ===");
        scanner.nextLine();
        System.out.println();

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("--- Iteración i = " + i + " ---");
            System.out.println("  Elemento a insertar: actual=" + actual + " (posición " + i + ")");
            scanner.nextLine();

            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparacion: array[" + j + "] =" + array[j] + " > actual=" + actual + " -> true -> desplazar " + array[j] + " a posicion " + (j + 1));
                array[j + 1] = array[j];
                j--;
                System.out.println("  Array después de desplazamiento: " + Arrays.toString(array));
            }

            if (j >= 0) {
                System.out.println("  Comparación: array[" + j + "] =" + array[j] + " > actual = " + actual + " -> false -> detenemos desplazamiento");
            } else {
                System.out.println("  j =" + j + " < 0 -> llegamos al inicio del array");
            }

            array[j + 1] = actual;
            System.out.println("  Insertar actual = " + actual + " en posición " + (j + 1));
            System.out.println("  Array después de insercion: " + Arrays.toString(array));
            System.out.println();
        }

        System.out.println("Estado final: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenar(array);
    }
}

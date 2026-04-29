package entregas.caicedoEsteban;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortIterativo {

    private static final Scanner scanner = new Scanner(System.in);

    private static void pausar() {
        System.out.print("  [Presiona Enter para avanzar]...");
        scanner.nextLine();
    }

    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array) + "\n");
        pausar();

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("Iteración i=" + i + ", elemento a insertar actual=" + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparación: array[" + j + "] (" + array[j] + ") > actual (" + actual
                        + ") -> Se desplaza a la derecha");
                array[j + 1] = array[j];
                j--;
                System.out.println("  Array parcial: " + Arrays.toString(array));
                pausar();
            }

            if (j >= 0) {
                System.out.println("  Comparación: array[" + j + "] (" + array[j] + ") <= actual (" + actual
                        + ") -> Fin de desplazamientos");
            } else {
                System.out.println("  Se alcanzó el principio del array (j < 0)");
            }

            array[j + 1] = actual;
            System.out.println("  Se inserta " + actual + " en la posición " + (j + 1));
            System.out.println("  Array resultante: " + Arrays.toString(array) + "\n");
            pausar();
        }

        System.out.println("Estado final: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array);
    }
}
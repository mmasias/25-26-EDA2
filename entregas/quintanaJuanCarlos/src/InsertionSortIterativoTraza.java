package src;

import java.util.Arrays;

public class InsertionSortIterativoTraza {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("INSERTION SORT ITERATIVO");
        ordenar(array);
    }

    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + mostrar(array));

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("\nIteracion i = " + i);
            System.out.println("Elemento actual = " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("Comparo: " + array[j] + " > " + actual + " -> verdadero");
                System.out.println("Desplazo " + array[j] + " de posicion " + j + " a posicion " + (j + 1));

                array[j + 1] = array[j];

                System.out.println("Array: " + mostrar(array));
                j--;
            }

            if (j >= 0) {
                System.out.println("Comparo: " + array[j] + " > " + actual + " -> falso");
            } else {
                System.out.println("Fin del while: j < 0");
            }

            array[j + 1] = actual;

            System.out.println("Inserto " + actual + " en posicion " + (j + 1));
            System.out.println("Array: " + mostrar(array));
        }

        System.out.println("\nEstado final: " + mostrar(array));
    }

    private static String mostrar(int[] array) {
        return Arrays.toString(array);
    }
}
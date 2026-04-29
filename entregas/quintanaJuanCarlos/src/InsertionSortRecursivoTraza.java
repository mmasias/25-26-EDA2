package src;

import java.util.Arrays;

public class InsertionSortRecursivoTraza {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("INSERTION SORT RECURSIVO");
        System.out.println("Estado inicial: " + mostrar(array));

        ordenar(array, array.length);

        System.out.println("Estado final: " + mostrar(array));
    }

    public static void ordenar(int[] array, int n) {
        ordenar(array, n, 0);
    }

    private static void ordenar(int[] array, int n, int nivel) {
        String t = tab(nivel);

        System.out.println(t + "Llamada ordenar(array, n = " + n + ")");

        if (n <= 1) {
            System.out.println(t + "Caso base: n <= 1");
            return;
        }

        System.out.println(t + "Se ordenan primero los primeros " + (n - 1) + " elementos");
        ordenar(array, n - 1, nivel + 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(t + "Insertar ultimo = " + ultimo + " dentro de los primeros " + n + " elementos");

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(t + "Comparo: " + array[j] + " > " + ultimo + " -> verdadero");
            System.out.println(t + "Desplazo " + array[j] + " de posicion " + j + " a posicion " + (j + 1));

            array[j + 1] = array[j];

            System.out.println(t + "Array: " + mostrar(array));
            j--;
        }

        if (j >= 0) {
            System.out.println(t + "Comparo: " + array[j] + " > " + ultimo + " -> falso");
        } else {
            System.out.println(t + "Fin del while: j < 0");
        }

        array[j + 1] = ultimo;

        System.out.println(t + "Inserto " + ultimo + " en posicion " + (j + 1));
        System.out.println(t + "Array: " + mostrar(array));
    }

    private static String mostrar(int[] array) {
        return Arrays.toString(array);
    }

    private static String tab(int nivel) {
        String texto = "";

        for (int i = 0; i < nivel; i++) {
            texto += "  ";
        }

        return texto;
    }
}
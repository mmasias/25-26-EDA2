package entregas.tasconRaul;

import java.util.Arrays;

public class insertionSort {

    // Variable para la indentación de la recursividad
    private static int profInsRec = 0;

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) sb.append("    ");
        return sb.toString();
    }

    // Versión Iterativa
    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\nIteración i=" + i + ": Tomamos el elemento " + actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparación: array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> true");
                array[j + 1] = array[j];
                System.out.println("  Desplazamiento: movemos " + array[j] + " a la derecha. Estado: " + Arrays.toString(array));
                j--;
            }
            
            if (j >= 0) {
                System.out.println("  Comparación: array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> false");
            } else {
                System.out.println("  Caso límite: Alcanzado el inicio del array (j < 0).");
            }
            
            array[j + 1] = actual;
            System.out.println("  Inserción: colocamos " + actual + " en la posición " + (j + 1) + ". Estado: " + Arrays.toString(array));
        }
        System.out.println("\nEstado final: " + Arrays.toString(array));
    }

    // Versión Recursiva
    public static void ordenar(int[] array, int n) {
        if (profInsRec == 0 && n == array.length) {
            System.out.println("Estado inicial: " + Arrays.toString(array));
        }
        String ind = getIndent(profInsRec);

        if (n <= 1) {
            System.out.println(ind + "Caso base alcanzado: n = " + n + " (<= 1). Sub-array de 1 o 0 elementos.");
            return;
        }

        System.out.println(ind + "Llamada recursiva para ordenar los primeros " + (n - 1) + " elementos.");
        profInsRec++;
        ordenar(array, n - 1);
        profInsRec--;

        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(ind + "Retorno recursivo (n=" + n + "). Elemento a insertar = " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + "  Comparación: array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> true");
            array[j + 1] = array[j];
            System.out.println(ind + "  Desplazamiento: movemos " + array[j] + " a la derecha. Estado: " + Arrays.toString(array));
            j--;
        }

        if (j >= 0) {
            System.out.println(ind + "  Comparación: array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> false");
        } else {
            System.out.println(ind + "  Caso límite: Alcanzado el inicio del array (j < 0).");
        }

        array[j + 1] = ultimo;
        System.out.println(ind + "  Inserción: colocamos " + ultimo + " en la posición " + (j + 1) + ". Estado: " + Arrays.toString(array));

        if (profInsRec == 0 && n == array.length) {
            System.out.println("\nEstado final: " + Arrays.toString(array));
        }
    }
}
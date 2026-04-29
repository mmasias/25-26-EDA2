package entregas.caicedoFernando;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSortRecursivo {

    final private static Scanner scanner = new Scanner(System.in);

    private static String indentar(int nivel) {
        String string = "";
        for (int i = 0; i < nivel; i++) {
            string += "  ";
        }
        return string;
    }

    public static void ordenar(int[] array, int n) {
        ordenarConTraza(array, n, 0);
    }

    private static void ordenarConTraza(int[] array, int n, int nivel) {
        System.out.println(indentar(nivel) + "-> llamada ordenar(n = " + n + ")");

        if (n <= 1) {
            System.out.println(indentar(nivel) + "   CASO BASE: n = " + n + " <= 1 -> retornar");
            return;
        }

        scanner.nextLine();
        ordenarConTraza(array, n - 1, nivel + 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(indentar(nivel) + "<- retorno a n = " + n + " | Insertar último = " + ultimo + " (posición " + (n - 1) + ")");
        System.out.println(indentar(nivel) + "   Array actual: " + Arrays.toString(array));
        scanner.nextLine();

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(indentar(nivel) + "   Comparación: array[" + j + "] = " + array[j] + " > último = " + ultimo + " -> true -> desplazar " + array[j] + " a posición " + (j + 1));
            array[j + 1] = array[j];
            j--;
            System.out.println(indentar(nivel) + "   Array después de desplazamiento: " + Arrays.toString(array));
            scanner.nextLine();

        }

        if (j >= 0) {
            System.out.println(indentar(nivel) + "   Comparación: array[" + j + "] = " + array[j] + " > último=" + ultimo + " -> false -> detener");
        } else {
            System.out.println(indentar(nivel) + "   j=" + j + " < 0 -> llegamos al inicio");
        }

        array[j + 1] = ultimo;
        System.out.println(indentar(nivel) + "   Insertar último = " + ultimo + " en posición " + (j + 1));
        System.out.println(indentar(nivel) + "   Array después de inserción: " + Arrays.toString(array));
        scanner.nextLine();
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("=== INSERT SORT RECURSIVO ===\nEstado inicial: " + Arrays.toString(array));
        System.out.println("=== PRESIONE ENTER PARA CONTNUAR ===");
        scanner.nextLine();
        System.out.println();
        ordenarConTraza(array, array.length, 0);
        System.out.println("\nEstado final: " + Arrays.toString(array));
    }
}

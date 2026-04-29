package entregas.caicedoEsteban;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRercusivo {
    private static int profundidadRecursividad = 0;
    private static final Scanner scanner = new Scanner(System.in);

    private static String indentar() {
        return "    ".repeat(profundidadRecursividad);
    }

    private static void pausar() {
        System.out.print(indentar() + "  [Presiona Enter para avanzar]...");
        scanner.nextLine();
    }

    public static void ordenar(int[] array, int n) {
        boolean esRaiz = (n == array.length);
        if (esRaiz) {
            System.out.println("Estado inicial: " + Arrays.toString(array) + "\n");
            pausar();
        }
        System.out.println(indentar() + "-> Entrando: ordenar(n=" + n + ")");
        pausar();

        if (n <= 1) {
            System.out.println(indentar() + "[Caso Base] n=" + n + ": El subarray ya está ordenado por definición.");
            pausar();
            return;
        }

        profundidadRecursividad++;
        ordenar(array, n - 1);
        profundidadRecursividad--;

        pausar();

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(indentar() + "Insertando elemento actual: " + ultimo + " (índice " + (n - 1) + ")");

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(indentar() + "  Comparación: " + array[j] + " > " + ultimo
                    + " (Verdadero) -> Desplazando " + array[j]);
            array[j + 1] = array[j];
            j--;
            System.out.println(indentar() + "  Array actual: " + Arrays.toString(array));
            pausar();
        }

        if (j >= 0) {
            System.out.println(
                    indentar() + "  Comparación: " + array[j] + " > " + ultimo + " (Falso) -> Posición encontrada.");
        } else {
            System.out.println(indentar() + "  Llegamos al inicio del array.");
        }

        array[j + 1] = ultimo;
        System.out.println(indentar() + "Resultado tras inserción: " + Arrays.toString(array) + "\n");
        pausar();

        if (esRaiz) {
            System.out.println("Estado final: " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array, array.length);
    }
}
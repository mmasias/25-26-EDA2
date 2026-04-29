package entregas.caicedoEsteban;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    private static int profundidadRecursividad = 0;
    private static final Scanner scanner = new Scanner(System.in);

    private static String indentar() {
        return "    ".repeat(profundidadRecursividad);
    }

    private static void pausar() {
        System.out.print(indentar() + "  [Presiona Enter para avanzar]...");
        scanner.nextLine();
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        boolean esRaiz = (izquierda == 0 && derecha == array.length - 1);
        if (esRaiz) {
            System.out.println("Estado inicial: " + Arrays.toString(array) + "\n");
            pausar();
        }

        System.out.println(indentar() + "-> Llamada: ordenar(izq=" + izquierda + ", der=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(
                    indentar() + "[Caso Base] Rango [" + izquierda + "," + derecha + "] no requiere ordenación.");
            pausar();
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha);

        profundidadRecursividad++;
        System.out.println(indentar() + "Sub-problema Izquierdo:");
        ordenar(array, izquierda, indicePivote - 1);

        System.out.println(indentar() + "Sub-problema Derecho:");
        ordenar(array, indicePivote + 1, derecha);
        profundidadRecursividad--;

        if (esRaiz) {
            System.out.println("\nEstado final: " + Arrays.toString(array));
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        System.out.println(indentar() + "  Particionando con pivote: " + pivote + " (en índice " + derecha + ")");
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            System.out.print(indentar() + "    Comparando " + array[j] + " <= " + pivote + ": ");
            if (array[j] <= pivote) {
                i++;
                System.out
                        .println("SÍ. Intercambio array[" + i + "]=" + array[i] + " por array[" + j + "]=" + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                pausar();
            } else {
                System.out.println("NO.");
            }
        }

        System.out.println(
                indentar() + "  Colocando pivote en su lugar: Intercambio " + array[i + 1] + " por " + array[derecha]);
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(indentar() + "  Estado tras partición: " + Arrays.toString(array));
        pausar();
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array, 0, array.length - 1);
    }
}
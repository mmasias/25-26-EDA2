package entregas.caicedoEsteban;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortRecursivo {

    private static int profundidadRecursividad = 0;
    private static final Scanner scanner = new Scanner(System.in);

    private static void pausar() {
        System.out.print(indentar() + "  [Presiona Enter para avanzar]...");
        scanner.nextLine();
    }

    private static String indentar() {
        return "    ".repeat(profundidadRecursividad);
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial: " + Arrays.toString(array));
            pausar();
        }

        System.out.println(indentar() + "ordenar(izq=" + izquierda + ", der=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(indentar() + "  [Caso Base] Tamaño 1.");
            pausar();
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        profundidadRecursividad++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        profundidadRecursividad--;

        fusionar(array, izquierda, medio, derecha);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        System.out.println(indentar() + "  Fusionando rangos [" + izquierda + "-" + medio + "] y [" + (medio + 1) + "-"
                + derecha + "]");
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++)
            mitadIzquierda[i] = array[izquierda + i];
        for (int j = 0; j < tamanoDerecha; j++)
            mitadDerecha[j] = array[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i++];
            } else {
                array[k] = mitadDerecha[j++];
            }
            k++;
        }
        while (i < tamanoIzquierda)
            array[k++] = mitadIzquierda[i++];
        while (j < tamanoDerecha)
            array[k++] = mitadDerecha[j++];
        System.out.println(indentar() + "  Resultado fusión: " + Arrays.toString(array));
        pausar();
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + Arrays.toString(array));
    }
}
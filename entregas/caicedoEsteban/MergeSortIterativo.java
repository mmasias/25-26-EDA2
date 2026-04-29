package entregas.caicedoEsteban;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortIterativo {

    private static final Scanner scanner = new Scanner(System.in);

    private static void pausar() {
        System.out.print("  [Presiona Enter para avanzar]...");
        scanner.nextLine();
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
        pausar();
        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n--- Tamaño de bloque: " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Fusionando indices: [" + izquierda + "," + medio + "] con [" + (medio + 1) + ","
                        + derecha + "]");
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("\nEstado final: " + Arrays.toString(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int j = 0; j < tamanoDerecha; j++) {
            mitadDerecha[j] = array[medio + 1 + j];
        }

        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print("  Comparando la mitad izquierda[" + mitadIzquierda[i] + "] y la mitad derecha["
                    + mitadDerecha[j] + "] -> ");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("Elegido la mitad izquierda");
                array[k] = mitadIzquierda[i++];
            } else {
                System.out.println("Elegido la mitad derecha");
                array[k] = mitadDerecha[j++];
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k++] = mitadIzquierda[i++];
        }
        while (j < tamanoDerecha) {
            array[k++] = mitadDerecha[j++];
        }
        System.out.println("  Sub-array resultante: " + Arrays.toString(array));
        pausar();
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenarIterativo(array);
    }
}

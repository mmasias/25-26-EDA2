package entregas.caicedoFernando;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortIterativo {

    final private static Scanner scanner = new Scanner(System.in);

    public static void ordenarIterativo(int[] array) {
        System.out.println("=== MERGE SORT ITERATIVO ===\nEstado inicial: " + Arrays.toString(array));
        System.out.println("=== PRESIONE ENTER PARA CONTNUAR ===");
        scanner.nextLine();
        System.out.println();

        int n = array.length;
        for (int tamaño = 1; tamaño < n; tamaño *= 2) {
            System.out.println("--- tamaño de bloque: " + tamaño + " ---");
            for (int izquierda = 0; izquierda < n - tamaño; izquierda += 2 * tamaño) {
                int medio = izquierda + tamaño - 1;
                int derecha = Math.min(izquierda + 2 * tamaño - 1, n - 1);

                System.out.println("  Fusionar [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "] | array antes = " + Arrays.toString(array));
                scanner.nextLine();
                fusionar(array, izquierda, medio, derecha);
                System.out.println("  Array tras fusión: " + Arrays.toString(array));
                scanner.nextLine();
            }
            System.out.println();
        }

        System.out.println("Estado final: " + Arrays.toString(array));
        scanner.nextLine();
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }

        System.out.println("    Copias temporales -> izquierda = " + Arrays.toString(mitadIzquierda));
        scanner.nextLine();
        System.out.println("    Copias temporales -> derecha = " + Arrays.toString(mitadDerecha));
        scanner.nextLine();

        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("    Comparar izquierda[" + i + "] = " + mitadIzquierda[i] + " <= derecha[" + j + "] = " + mitadDerecha[j] + " -> colocar " + mitadIzquierda[i] + " en posición " + k);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println("    Comparar izquierda[" + i + "] = " + mitadIzquierda[i] + " <= derecha[" + j + "] = " + mitadDerecha[j] + " -> colocar " + mitadIzquierda[i] + " en posición " + k);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println("    Copiar resto izquierda[" + i + "] = " + mitadIzquierda[i] + " en posición " + k);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println("    Copiar resto derecha[" + j + "] = " + mitadDerecha[j] + " en posición " + k);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenarIterativo(array);
    }
}

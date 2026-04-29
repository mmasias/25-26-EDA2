package entregas.caicedoFernando;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortRecursivo {

    final private static Scanner scanner = new Scanner(System.in);

    private static String indentar(int nivel) {
        String string = "";
        for (int i = 0; i < nivel; i++) {
            string += "  ";
        }
        return string;
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        ordenarConTraza(array, izquierda, derecha, 0);
    }

    private static void ordenarConTraza(int[] array, int izquierda, int derecha, int nivel) {
        System.out.print(indentar(nivel) + "-> llamada ordenar(izquierda = " + izquierda + ", derecha = " + derecha + ") | array = ");
        System.out.println(Arrays.toString(array));
        scanner.nextLine();

        if (izquierda >= derecha) {
            System.out.println(indentar(nivel) + "   CASO BASE: izquierda = " + izquierda + " >= derecha = " + derecha + " -> retornar");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(indentar(nivel) + "   medio = " + medio + " | Dividir en [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");

        ordenarConTraza(array, izquierda, medio, nivel + 1);
        ordenarConTraza(array, medio + 1, derecha, nivel + 1);

        System.out.print(indentar(nivel) + "   Fusionar [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "] | array antes=");
        System.out.println(Arrays.toString(array));
        scanner.nextLine();

        fusionar(array, izquierda, medio, derecha, indentar(nivel));

        System.out.print(indentar(nivel) + "   Array después de fusión: ");
        System.out.println(Arrays.toString(array));
        scanner.nextLine();
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, String indentar) {
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

        System.out.print(indentar + "   Copias temporales -> izquierda = ");
        System.out.println(Arrays.toString(mitadIzquierda));
        scanner.nextLine();

        System.out.print(indentar + "   Copias temporales -> derecha = ");
        System.out.println(Arrays.toString(mitadDerecha));
        scanner.nextLine();

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(indentar + "     Comparar izquierda[" + i + "] = " + mitadIzquierda[i] + " <= derecha[" + j + "] = " + mitadDerecha[j] + " -> colocar " + mitadIzquierda[i] + " en posición " + k);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(indentar + "     Comparar izquierda[" + i + "] = " + mitadIzquierda[i] + " > derecha[" + j + "] = " + mitadDerecha[j] + " -> colocar " + mitadDerecha[j] + " en posición " + k);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println(indentar + "     Copiar resto izquierda[" + i + "] = " + mitadIzquierda[i] + " en posición " + k);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(indentar + "     Copiar resto derecha[" + j + "] = " + mitadDerecha[j] + " en posición " + k);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.print("=== MERGE SORT RECURSIVO ===\nEstado inicial: ");
        System.out.println(Arrays.toString(array));

        System.out.println("=== PRESIONE ENTER PARA CONTINUAR ===");
        scanner.nextLine();
        System.out.println();

        ordenarConTraza(array, 0, array.length - 1, 0);

        System.out.print("\nEstado final: ");
        System.out.println(Arrays.toString(array));
    }
}

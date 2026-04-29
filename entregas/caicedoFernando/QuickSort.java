package entregas.caicedoFernando;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

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

        System.out.println(indentar(nivel) + "   Pivote elegido: array[" + derecha + "] = " + array[derecha]);
        scanner.nextLine();

        int indicePivote = particionar(array, izquierda, derecha, indentar(nivel));
        System.out.println(indentar(nivel) + "   Pivote " + array[indicePivote] + " colocado en posición definitiva: " + indicePivote);
        System.out.print(indentar(nivel) + "   Array tras partición: ");
        System.out.println(Arrays.toString(array));
        scanner.nextLine();

        System.out.println(indentar(nivel) + "   Recursión izquierda: [" + izquierda + ".." + (indicePivote - 1) + "]");
        scanner.nextLine();
        ordenarConTraza(array, izquierda, indicePivote - 1, nivel + 1);

        System.out.println(indentar(nivel) + "   Recursión derecha: [" + (indicePivote + 1) + ".." + derecha + "]");

        ordenarConTraza(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, String indentacion) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(indentacion + "   Particionando: pivote = " + pivote + " | i inicial = " + i);
        scanner.nextLine();

        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                System.out.println(indentacion + "     j = " + j + ": array[j] = " + array[j] + " <= pivote = " + pivote + " -> intercambiar array[" + i + "] = " + array[i] + " con array[" + j + "] = " + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.print(indentacion + "     Array tras intercambio: ");
                System.out.println(Arrays.toString(array));
                scanner.nextLine();
            } else {
                System.out.println(indentacion + "     j = " + j + ": array[j]=" + array[j] + " > pivote = " + pivote + " -> no intercambiar");
            }
        }

        System.out.println(indentacion + "     Colocar pivote = " + pivote + " en posición " + (i + 1) + ": intercambiar array[" + (i + 1) + "] = " + array[i + 1] + " con array[" + derecha + "] = " + array[derecha]);
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.print("=== QUICK SORT ===\nEstado inicial: ");
        System.out.println(Arrays.toString(array));
        System.out.println("=== PRESIONE ENTER PARA CONTINUAR ===");
        scanner.nextLine();
        System.out.println();
        ordenarConTraza(array, 0, array.length - 1, 0);
        System.out.print("\nEstado final: ");
        System.out.println(Arrays.toString(array));
    }
}

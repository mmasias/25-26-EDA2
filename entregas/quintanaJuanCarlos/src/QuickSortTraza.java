package src;

import java.util.Arrays;

public class QuickSortTraza {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("QUICK SORT");
        System.out.println("Estado inicial: " + mostrar(array));

        ordenar(array, 0, array.length - 1);

        System.out.println("Estado final: " + mostrar(array));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        ordenar(array, izquierda, derecha, 0);
    }

    private static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String t = tab(nivel);

        System.out.println(t + "Llamada ordenar(array, izquierda = " + izquierda + ", derecha = " + derecha + ")");
        System.out.println(t + "Subarray actual: " + subarray(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(t + "Caso base: izquierda >= derecha");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha, nivel);

        System.out.println(t + "Pivote queda en posicion " + indicePivote);
        System.out.println(t + "Array: " + mostrar(array));

        ordenar(array, izquierda, indicePivote - 1, nivel + 1);
        ordenar(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, int nivel) {
        String t = tab(nivel);

        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(t + "Pivote = " + pivote + " en posicion " + derecha);

        for (int j = izquierda; j < derecha; j++) {
            System.out.print(t + "Comparo: array[" + j + "] = " + array[j] + " <= pivote " + pivote);

            if (array[j] <= pivote) {
                System.out.println(" -> verdadero");

                i++;

                System.out.println(t + "Intercambio posiciones " + i + " y " + j);

                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                System.out.println(t + "Array: " + mostrar(array));
            } else {
                System.out.println(" -> falso");
                System.out.println(t + "No se intercambia");
            }
        }

        System.out.println(t + "Coloco pivote en su posicion final");
        System.out.println(t + "Intercambio posiciones " + (i + 1) + " y " + derecha);

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(t + "Array: " + mostrar(array));

        return i + 1;
    }

    private static String mostrar(int[] array) {
        return Arrays.toString(array);
    }

    private static String subarray(int[] array, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return "[]";
        }

        return Arrays.toString(Arrays.copyOfRange(array, izquierda, derecha + 1));
    }

    private static String tab(int nivel) {
        String texto = "";

        for (int i = 0; i < nivel; i++) {
            texto += "  ";
        }

        return texto;
    }
}

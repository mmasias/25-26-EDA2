package src;

import java.util.Arrays;

public class MergeSortRecursivoTraza {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("MERGE SORT RECURSIVO");
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

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(t + "Divido en [" + izquierda + ", " + medio + "] y ["
                + (medio + 1) + ", " + derecha + "]");

        ordenar(array, izquierda, medio, nivel + 1);
        ordenar(array, medio + 1, derecha, nivel + 1);

        System.out.println(t + "Fusiono [" + izquierda + ", " + medio + "] con ["
                + (medio + 1) + ", " + derecha + "]");

        fusionar(array, izquierda, medio, derecha, nivel);

        System.out.println(t + "Resultado fusion: " + subarray(array, izquierda, derecha));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, int nivel) {
        String t = tab(nivel);

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

        System.out.println(t + "Mitad izquierda: " + mostrar(mitadIzquierda));
        System.out.println(t + "Mitad derecha:   " + mostrar(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print(t + "Comparo: " + mitadIzquierda[i] + " <= " + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(" -> verdadero");
                array[k] = mitadIzquierda[i];

                System.out.println(t + "Copio " + mitadIzquierda[i] + " en posicion " + k);
                i++;
            } else {
                System.out.println(" -> falso");
                array[k] = mitadDerecha[j];

                System.out.println(t + "Copio " + mitadDerecha[j] + " en posicion " + k);
                j++;
            }

            System.out.println(t + "Array: " + mostrar(array));
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println(t + "Sobra izquierda: copio " + mitadIzquierda[i] + " en posicion " + k);

            array[k] = mitadIzquierda[i];

            System.out.println(t + "Array: " + mostrar(array));

            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(t + "Sobra derecha: copio " + mitadDerecha[j] + " en posicion " + k);

            array[k] = mitadDerecha[j];

            System.out.println(t + "Array: " + mostrar(array));

            j++;
            k++;
        }
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
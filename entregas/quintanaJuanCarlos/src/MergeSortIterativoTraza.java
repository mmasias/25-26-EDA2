package src;

import java.util.Arrays;

public class MergeSortIterativoTraza {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("MERGE SORT ITERATIVO");
        ordenarIterativo(array);
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;

        System.out.println("Estado inicial: " + mostrar(array));

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\nTamano de bloque = " + tamano);

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Fusiono [" + izquierda + ", " + medio + "] con ["
                        + (medio + 1) + ", " + derecha + "]");

                fusionar(array, izquierda, medio, derecha);

                System.out.println("Array tras fusion: " + mostrar(array));
            }
        }

        System.out.println("\nEstado final: " + mostrar(array));
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

        System.out.println("  Mitad izquierda: " + mostrar(mitadIzquierda));
        System.out.println("  Mitad derecha:   " + mostrar(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print("  Comparo: " + mitadIzquierda[i] + " <= " + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(" -> verdadero");
                array[k] = mitadIzquierda[i];

                System.out.println("  Copio " + mitadIzquierda[i] + " en posicion " + k);
                i++;
            } else {
                System.out.println(" -> falso");
                array[k] = mitadDerecha[j];

                System.out.println("  Copio " + mitadDerecha[j] + " en posicion " + k);
                j++;
            }

            System.out.println("  Array: " + mostrar(array));
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println("  Sobra izquierda: copio " + mitadIzquierda[i] + " en posicion " + k);

            array[k] = mitadIzquierda[i];

            System.out.println("  Array: " + mostrar(array));

            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println("  Sobra derecha: copio " + mitadDerecha[j] + " en posicion " + k);

            array[k] = mitadDerecha[j];

            System.out.println("  Array: " + mostrar(array));

            j++;
            k++;
        }
    }

    private static String mostrar(int[] array) {
        return Arrays.toString(array);
    }
}

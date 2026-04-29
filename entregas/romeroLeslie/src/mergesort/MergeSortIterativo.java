package mergesort;

import java.util.Arrays;

public class MergeSortIterativo {

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("Fusionando: izq=" + izquierda + " medio=" + medio + " der=" + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;
        
        int[] izq = new int[n1];
        int[] der = new int[n2];

        for (int i = 0; i < n1; i++) izq[i] = array[izquierda + i];
        for (int j = 0; j < n2; j++) der[j] = array[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;

        while (i < n1 && j < n2) {
            System.out.println("Comparacion: " + izq[i] + " <= " + der[j] + " es " + (izq[i] <= der[j]));
            if (izq[i] <= der[j]) {
                array[k] = izq[i];
                i++;
            } else {
                array[k] = der[j];
                j++;
            }
            System.out.println("Array actualizado: " + Arrays.toString(array));
            k++;
        }

        while (i < n1) { array[k++] = izq[i++]; }
        while (j < n2) { array[k++] = der[j++]; }
        
        System.out.println("Resultado de la fusion: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("Estado inicial: " + Arrays.toString(array));
        ordenarIterativo(array);
        System.out.println("Estado final: " + Arrays.toString(array));
    }
}
package entregas.tasconRaul;

import java.util.Arrays;

public class mergeSort {

    private static int profMerge = 0;

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) sb.append("    ");
        return sb.toString();
    }

    // Versión Recursiva
    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (profMerge == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial: " + Arrays.toString(array));
        }
        String ind = getIndent(profMerge);

        if (izquierda >= derecha) {
            System.out.println(ind + "Caso base: izquierda (" + izquierda + ") >= derecha (" + derecha + "). Retornando.");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(ind + "Dividiendo: sub-array [" + izquierda + ".." + derecha + "] en medio = " + medio);

        System.out.println(ind + "Llamada recursiva a la mitad izquierda [" + izquierda + ".." + medio + "]");
        profMerge++;
        ordenar(array, izquierda, medio);
        profMerge--;

        System.out.println(ind + "Llamada recursiva a la mitad derecha [" + (medio + 1) + ".." + derecha + "]");
        profMerge++;
        ordenar(array, medio + 1, derecha);
        profMerge--;

        System.out.println(ind + "Iniciando fusión de [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");
        fusionar(array, izquierda, medio, derecha);

        if (profMerge == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("\nEstado final: " + Arrays.toString(array));
        }
    }

    // Versión Iterativa
    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
        int n = array.length;
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\nNueva pasada: tamaño de sub-array = " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("  Llamando a fusionar sub-arrays: [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");
                profMerge = 1; // Asignamos profundidad 1 para la indentación visual del método auxiliar
                fusionar(array, izquierda, medio, derecha);
                profMerge = 0;
            }
        }
        System.out.println("\nEstado final: " + Arrays.toString(array));
    }

    // Método de fusión común
    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String ind = getIndent(profMerge) + "  ";
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
        System.out.println(ind + "Sub-arrays a fusionar -> Izquierda: " + Arrays.toString(mitadIzquierda) + ", Derecha: " + Arrays.toString(mitadDerecha));

        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            boolean condicion = mitadIzquierda[i] <= mitadDerecha[j];
            System.out.println(ind + "Comparación: Izq[" + i + "] (" + mitadIzquierda[i] + ") <= Der[" + j + "] (" + mitadDerecha[j] + ") -> " + condicion);
            
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                System.out.println(ind + "Copiado " + mitadIzquierda[i] + " de la izquierda al índice " + k + " original. Estado: " + Arrays.toString(array));
                i++;
            } else {
                array[k] = mitadDerecha[j];
                System.out.println(ind + "Copiado " + mitadDerecha[j] + " de la derecha al índice " + k + " original. Estado: " + Arrays.toString(array));
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(ind + "Vaciando resto izquierdo: copiado " + mitadIzquierda[i] + " al índice " + k + ". Estado: " + Arrays.toString(array));
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(ind + "Vaciando resto derecho: copiado " + mitadDerecha[j] + " al índice " + k + ". Estado: " + Arrays.toString(array));
            j++;
            k++;
        }
    }
}
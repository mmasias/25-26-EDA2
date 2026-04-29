import java.util.Arrays;

public class MergeSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = SoporteTraza.getInd();
        System.out.println(ind + "Llamada recursiva: izquierda=" + izquierda + ", derecha=" + derecha);

        if (izquierda >= derecha) {
            System.out.println(ind + "Caso base alcanzado (izquierda >= derecha).");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(ind + "División calculada: medio=" + medio);

        System.out.println(ind + "-> Subarray izquierdo (izquierda=" + izquierda + " a medio=" + medio + ")");
        SoporteTraza.entrarNivel();
        ordenar(array, izquierda, medio);
        SoporteTraza.salirNivel();

        System.out.println(ind + "-> Subarray derecho (medio+1=" + (medio + 1) + " a derecha=" + derecha + ")");
        SoporteTraza.entrarNivel();
        ordenar(array, medio + 1, derecha);
        SoporteTraza.salirNivel();

        System.out.println(ind + "Llamando a fusionar: izquierda=" + izquierda + ", medio=" + medio + ", derecha=" + derecha);
        fusionar(array, izquierda, medio, derecha);

        System.out.println(ind + "Resultado tras fusionar este bloque: " + Arrays.toString(array));
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Bucle externo: tamaño de sub-arrays=" + tamano);

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Bucle interno llama a fusionar: izquierda=" + izquierda + ", medio=" + medio + ", derecha=" + derecha);
                fusionar(array, izquierda, medio, derecha);
                System.out.println("Resultado tras fusionar bloque: " + Arrays.toString(array));
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String ind = SoporteTraza.getInd();

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

        int i = 0, j = 0, k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println(ind + "Comparando mitadIzquierda[" + i + "]=" + mitadIzquierda[i] + " <= mitadDerecha[" + j + "]=" + mitadDerecha[j] + " -> " + (mitadIzquierda[i] <= mitadDerecha[j]));

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }

        SoporteTraza.imprimirFinFusion(i, tamanoIzquierda, j, tamanoDerecha, ind);

        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(ind + "Copiando resto izquierda: array[" + k + "] = " + mitadIzquierda[i] + " -> " + Arrays.toString(array));
            i++; k++;
        }

        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(ind + "Copiando resto derecha: array[" + k + "] = " + mitadDerecha[j] + " -> " + Arrays.toString(array));
            j++; k++;
        }
    }
}
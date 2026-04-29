import java.util.Arrays;

public class MergeSortIterativo {

    private static String formatear(int[] array) {
        return Arrays.toString(array);
    }

    private static String formatearRango(int[] array, int desde, int hasta) {
        return Arrays.toString(Arrays.copyOfRange(array, desde, hasta + 1));
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + formatear(array));
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Ronda con tamano de bloque = " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("  Fusionar bloques [" + izquierda + ", " + medio + "] = " + formatearRango(array, izquierda, medio) + " y [" + (medio + 1) + ", " + derecha + "] = " + formatearRango(array, medio + 1, derecha));
                fusionar(array, izquierda, medio, derecha);
                System.out.println("    Resultado de la fusion: " + formatearRango(array, izquierda, derecha));
                System.out.println("    Estado del array completo: " + formatear(array));
            }
            System.out.println("  Fin de la ronda. Array tras la ronda: " + formatear(array));
        }
        System.out.println("Estado final: " + formatear(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String prefijo = "      ";
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
        System.out.println(prefijo + "Copia mitadIzquierda = " + formatear(mitadIzquierda) + ", mitadDerecha = " + formatear(mitadDerecha));
        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(prefijo + "Comparacion " + mitadIzquierda[i] + " ≤ " + mitadDerecha[j] + " ? Si, escribir " + mitadIzquierda[i] + " en array[" + k + "]");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(prefijo + "Comparacion " + mitadIzquierda[i] + " ≤ " + mitadDerecha[j] + " ? No, escribir " + mitadDerecha[j] + " en array[" + k + "]");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println(prefijo + "Residuo de mitadIzquierda: escribir " + mitadIzquierda[i] + " en array[" + k + "]");
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(prefijo + "Residuo de mitadDerecha: escribir " + mitadDerecha[j] + " en array[" + k + "]");
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
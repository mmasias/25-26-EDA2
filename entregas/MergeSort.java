import java.util.Arrays;

public class MergeSort {

    private static String getIndent() {
        int depth = 0;
        boolean isIterativo = false;
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            if (e.getMethodName().equals("ordenar")) depth++;
            if (e.getMethodName().equals("ordenarIterativo")) isIterativo = true;
        }
        if (isIterativo) return "  ";
        return "  ".repeat(Math.max(0, depth - 1));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = getIndent();
        System.out.println(ind + "Llamada a ordenar(array, izq=" + izquierda + ", der=" + derecha + ")");
        if (izquierda >= derecha) {
            System.out.println(ind + "  [Caso Base] izquierda (" + izquierda + ") >= derecha (" + derecha + "). Retornando.");
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(ind + "  [Decisión] Dividiendo en medio=" + medio);
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        fusionar(array, izquierda, medio, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("Iniciando Merge Sort Iterativo. Array: " + Arrays.toString(array));
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("[Bucle Externo] Tamaño de sub-array=" + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("  [Bucle Interno] Rango: izq=" + izquierda + ", med=" + medio + ", der=" + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String ind = getIndent();
        System.out.println(ind + "-> Inicio fusionar(izq=" + izquierda + ", med=" + medio + ", der=" + derecha + ")");
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
        System.out.println(ind + "   Sub-array izquierdo: " + Arrays.toString(mitadIzquierda));
        System.out.println(ind + "   Sub-array derecho: " + Arrays.toString(mitadDerecha));
        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println(ind + "   [Comparación] mitadIzquierda[" + i + "]=" + mitadIzquierda[i] + " <= mitadDerecha[" + j + "]=" + mitadDerecha[j] + " : " + (mitadIzquierda[i] <= mitadDerecha[j]));
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                array[k] = mitadDerecha[j];
                j++;
            }
            System.out.println(ind + "   [Modificación] Array tras inserción en índice " + k + ": " + Arrays.toString(array));
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            i++;
            k++;
            System.out.println(ind + "   [Modificación] Volcando resto izquierdo en índice " + (k-1) + ": " + Arrays.toString(array));
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            j++;
            k++;
            System.out.println(ind + "   [Modificación] Volcando resto derecho en índice " + (k-1) + ": " + Arrays.toString(array));
        }
    }
}

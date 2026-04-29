import java.util.Arrays;

public class QuickSort {

    private static String getIndent() {
        int depth = 0;
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            if (e.getMethodName().equals("ordenar")) depth++;
        }
        return "  ".repeat(Math.max(0, depth - 1));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = getIndent();
        System.out.println(ind + "Llamada a ordenar(array, izq=" + izquierda + ", der=" + derecha + ")");
        if (izquierda >= derecha) {
            System.out.println(ind + "  [Caso Base] izquierda (" + izquierda + ") >= derecha (" + derecha + "). Retornando.");
            return;
        }
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(ind + "  [Decisión] Pivote colocado en índice " + indicePivote + ". Recursión en [" + izquierda + ", " + (indicePivote - 1) + "] y [" + (indicePivote + 1) + ", " + derecha + "]");
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String ind = getIndent() + "  ";
        int pivote = array[derecha];
        System.out.println(ind + "-> particionar(izq=" + izquierda + ", der=" + derecha + ") | Pivote: array[" + derecha + "]=" + pivote);
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            System.out.println(ind + "   [Comparación] array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " : " + (array[j] <= pivote));
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(ind + "   [Modificación] Intercambio array[" + i + "]=" + array[i] + " con array[" + j + "]=" + array[j] + ": " + Arrays.toString(array));
            }
        }
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(ind + "   [Modificación] Pivote a posición final (" + (i + 1) + "): " + Arrays.toString(array));
        return i + 1;
    }
}

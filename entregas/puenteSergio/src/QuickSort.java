public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        ordenar(array, izquierda, derecha, 0);
    }

    private static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String indent = indentacion(nivel);
        System.out.println(indent + "Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ") | array=" + formatear(array));
        if (izquierda >= derecha) {
            System.out.println(indent + "CASO BASE: izquierda=" + izquierda + " >= derecha=" + derecha + ", retornar");
            return;
        }
        int indicePivote = particionar(array, izquierda, derecha, nivel);
        System.out.println(indent + "Pivote colocado en indice " + indicePivote + " | array=" + formatear(array));
        ordenar(array, izquierda, indicePivote - 1, nivel + 1);
        ordenar(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, int nivel) {
        String indent = indentacion(nivel);
        int pivote = array[derecha];
        System.out.println(indent + "Particionar [" + izquierda + ".." + derecha + "] con pivote=" + pivote + " (array[" + derecha + "])");
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                System.out.println(indent + "  Comparacion array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " -> TRUE, intercambiar");
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(indent + "  Swap pos " + i + " y pos " + j + " | array=" + formatear(array));
            } else {
                System.out.println(indent + "  Comparacion array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " -> FALSE, no intercambiar");
            }
        }
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(indent + "  Colocar pivote en pos " + (i + 1) + " (swap con pos " + derecha + ") | array=" + formatear(array));
        return i + 1;
    }

    private static String indentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    private static String formatear(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
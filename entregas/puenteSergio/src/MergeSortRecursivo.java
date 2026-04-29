public class MergeSortRecursivo {

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
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(indent + "Dividir: medio=" + medio + " -> izquierda=[" + izquierda + ".." + medio + "] derecha=[" + (medio + 1) + ".." + derecha + "]");
        ordenar(array, izquierda, medio, nivel + 1);
        ordenar(array, medio + 1, derecha, nivel + 1);
        fusionar(array, izquierda, medio, derecha, nivel);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, int nivel) {
        String indent = indentacion(nivel);
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
        System.out.println(indent + "Fusionar: izq=" + formatear(mitadIzquierda) + " der=" + formatear(mitadDerecha));
        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(indent + "  Comparacion " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " -> TRUE, tomar " + mitadIzquierda[i] + " de izq");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(indent + "  Comparacion " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " -> FALSE, tomar " + mitadDerecha[j] + " de der");
                array[k] = mitadDerecha[j];
                j++;
            }
            System.out.println(indent + "  Array tras colocar en pos " + k + ": " + formatear(array));
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println(indent + "  Resto izq: tomar " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            System.out.println(indent + "  Array tras colocar en pos " + k + ": " + formatear(array));
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(indent + "  Resto der: tomar " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            System.out.println(indent + "  Array tras colocar en pos " + k + ": " + formatear(array));
            j++;
            k++;
        }
        System.out.println(indent + "Fusion completada [" + izquierda + ".." + derecha + "]: " + formatear(array));
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
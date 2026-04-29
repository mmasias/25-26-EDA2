
public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        ConsolaTraza.mostrarEstado("Array al inicio: ", array);
        ordenar(array, izquierda, derecha, 0);
        ConsolaTraza.mostrarEstado("Array al final: ", array);
    }

    private static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Llamada a ordenar con izquierda = " + izquierda + ", derecha = " + derecha);

        if (izquierda >= derecha) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Caso base: izquierda >= derecha, este tramo ya no se divide más");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha, nivel);

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("El pivote queda en la posición " + indicePivote);

        ordenar(array, izquierda, indicePivote - 1, nivel + 1);
        ordenar(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        return particionar(array, izquierda, derecha, 0);
    }

    private static int particionar(int[] array, int izquierda, int derecha, int nivel) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Tomo como pivote el valor " + pivote + " de la posición " + derecha);

        for (int j = izquierda; j < derecha; j++) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo " + array[j] + " <= " + pivote);

            if (array[j] <= pivote) {
                ConsolaTraza.aplicarIndentacion(nivel);
                System.out.println("Se cumple, avanzo i e intercambio las posiciones " + (i + 1) + " y " + j);

                i++;

                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);
            } else {
                ConsolaTraza.aplicarIndentacion(nivel);
                System.out.println("No se cumple, lo dejo donde está");
            }
        }

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Hago el intercambio final para dejar el pivote en su sitio");

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);

        return i + 1;
    }
}

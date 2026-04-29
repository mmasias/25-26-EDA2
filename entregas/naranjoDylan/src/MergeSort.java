
public class MergeSort {

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
            System.out.println("Caso base: izquierda >= derecha, ya no hay nada que dividir");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Divido el tramo en izquierda = " + izquierda + ", medio = " + medio + ", derecha = " + derecha);

        ordenar(array, izquierda, medio, nivel + 1);
        ordenar(array, medio + 1, derecha, nivel + 1);

        fusionar(array, izquierda, medio, derecha, nivel);
    }

    public static void ordenarIterativo(int[] array) {
        ConsolaTraza.mostrarEstado("Array al inicio: ", array);

        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Tamaño de bloque actual: " + tamano);

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Voy a combinar los bloques con izquierda = " + izquierda
                        + ", medio = " + medio
                        + ", derecha = " + derecha);

                fusionar(array, izquierda, medio, derecha, 0);
            }
        }

        ConsolaTraza.mostrarEstado("Array al final: ", array);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        fusionar(array, izquierda, medio, derecha, 0);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, int nivel) {
        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Empiezo a fusionar el tramo " + izquierda + " al " + derecha);

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

        ConsolaTraza.mostrarEstadoIndentado(nivel, "Mitad izquierda: ", mitadIzquierda);
        ConsolaTraza.mostrarEstadoIndentado(nivel, "Mitad derecha: ", mitadDerecha);

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo i < tamanoIzquierda && j < tamanoDerecha: se cumple");
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo " + mitadIzquierda[i] + " <= " + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                ConsolaTraza.aplicarIndentacion(nivel);
                System.out.println("Se cumple, copio " + mitadIzquierda[i] + " en la posición " + k);

                array[k] = mitadIzquierda[i];

                i++;
            } else {
                ConsolaTraza.aplicarIndentacion(nivel);
                System.out.println("No se cumple, copio " + mitadDerecha[j] + " en la posición " + k);

                array[k] = mitadDerecha[j];

                j++;
            }

            ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);

            k++;
        }

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Compruebo i < tamanoIzquierda && j < tamanoDerecha: no se cumple");

        while (i < tamanoIzquierda) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo i < tamanoIzquierda: se cumple");
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Copio lo que queda de la mitad izquierda: " + mitadIzquierda[i] + " en la posición " + k);

            array[k] = mitadIzquierda[i];

            ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);

            i++;
            k++;
        }

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Compruebo i < tamanoIzquierda: no se cumple");

        while (j < tamanoDerecha) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo j < tamanoDerecha: se cumple");
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Copio lo que queda de la mitad derecha: " + mitadDerecha[j] + " en la posición " + k);

            array[k] = mitadDerecha[j];

            ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);

            j++;
            k++;
        }

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Compruebo j < tamanoDerecha: no se cumple");
    }
}

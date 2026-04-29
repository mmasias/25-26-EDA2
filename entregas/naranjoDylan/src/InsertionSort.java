
public class InsertionSort {

    public static void ordenar(int[] array) {
        ConsolaTraza.mostrarEstado("Array al inicio: ", array);

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("Tomo el valor " + actual + " de la posición " + i);

            while (j >= 0 && array[j] > actual) {
                System.out.println("Compruebo " + array[j] + " > " + actual + ": se cumple");
                System.out.println("Muevo " + array[j] + " de la posición " + j + " a la posición " + (j + 1));

                array[j + 1] = array[j];

                ConsolaTraza.mostrarEstado("Array ahora: ", array);

                j--;
            }

            if (j >= 0) {
                System.out.println("Compruebo " + array[j] + " > " + actual + ": no se cumple");
            } else {
                System.out.println("Compruebo j >= 0: no se cumple");
                System.out.println("Ya no quedan elementos a la izquierda (j < 0)");
            }

            System.out.println("Inserto " + actual + " en la posición " + (j + 1));

            array[j + 1] = actual;

            ConsolaTraza.mostrarEstado("Array ahora: ", array);
        }

        ConsolaTraza.mostrarEstado("Array al final: ", array);
    }

    public static void ordenar(int[] array, int n) {
        ConsolaTraza.mostrarEstado("Array al inicio: ", array);
        ordenar(array, n, 0);
        ConsolaTraza.mostrarEstado("Array al final: ", array);
    }

    private static void ordenar(int[] array, int n, int nivel) {
        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Llamada a ordenar con n = " + n);

        if (n <= 1) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Caso base: n <= 1, no hay nada que ordenar");
            return;
        }

        ordenar(array, n - 1, nivel + 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Vuelvo a insertar el valor " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo " + array[j] + " > " + ultimo + ": se cumple");

            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Muevo " + array[j] + " de la posición " + j + " a la posición " + (j + 1));

            array[j + 1] = array[j];

            ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);

            j--;
        }

        if (j >= 0) {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo " + array[j] + " > " + ultimo + ": no se cumple");
        } else {
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Compruebo j >= 0: no se cumple");
            ConsolaTraza.aplicarIndentacion(nivel);
            System.out.println("Ya no quedan elementos a la izquierda (j < 0)");
        }

        ConsolaTraza.aplicarIndentacion(nivel);
        System.out.println("Inserto " + ultimo + " en la posición " + (j + 1));

        array[j + 1] = ultimo;

        ConsolaTraza.mostrarEstadoIndentado(nivel, "Array ahora: ", array);
    }
}

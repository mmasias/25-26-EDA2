public class MergeSortIterativo {

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println();
            System.out.println("Iteracion " + tamano);

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                fusionar(array, izquierda, medio, derecha);

                System.out.print("Estado tras juntarles: ");
                imprimirArray(array);
                System.out.println();
            }
            System.out.println("-".repeat(20));
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
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

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print("Comparando Izquierda[" + i + "] = " + mitadIzquierda[i] + " y Derecha[" + j + "] = "
                    + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println();
                System.out.println("Elige Izquierda: " + mitadIzquierda[i]);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println();
                System.out.println("Elige Derecha: " + mitadDerecha[j]);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println("Copiando ultimo de Izquierda: " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println("Copiando ultimo de Derecha: " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    private static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };

        System.out.print("ESTADO INICIAL: ");
        imprimirArray(array);
        System.out.println();

        ordenarIterativo(array);

        System.out.println();
        System.out.print("ESTADO FINAL: ");
        imprimirArray(array);
    }
}
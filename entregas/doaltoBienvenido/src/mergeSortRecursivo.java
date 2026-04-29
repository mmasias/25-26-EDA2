public class MergeSortRecursivo {

    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String ind = "";
        for (int i = 0; i < nivel; i++)
            ind += "  ";

        System.out.println(ind + "Llamada recursiva (Izquierda = " + izquierda + ", Derecha = " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(ind + "CASO BASE: Izquierda >= Derecha (" + izquierda + " >= " + derecha
                    + "). Un solo elemento o vacio.");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(ind + " Dividiendo: Mitad izquierda [" + izquierda + "..." + medio + "] | Mitad derecha ["
                + (medio + 1) + "..." + derecha + "]");

        ordenar(array, izquierda, medio, nivel + 1);
        ordenar(array, medio + 1, derecha, nivel + 1);

        fusionar(array, izquierda, medio, derecha, ind);

        System.out.print(ind + "Estado tras juntarles: ");
        imprimirArray(array);
        System.out.println();
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, String ind) {
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
            System.out.print(
                    ind + "Comparando Izquierda [" + i + "] = " + mitadIzquierda[i] + " y Derecha [" + j + "] = "
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
            System.out.println(ind + "Copiando ultimo de Izquierda: " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(ind + "Copiando ultimo de Derecha: " + mitadDerecha[j]);
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

        ordenar(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.print("ESTADO FINAL: ");
        imprimirArray(array);
    }
}
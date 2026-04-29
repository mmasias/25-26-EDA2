public class InsertionSortIterativo {

    private static String arrayATexto(int[] array) {
        String textoArray = "[";

        for (int indice = 0; indice < array.length; indice++) {
            textoArray += array[indice];

            if (indice < array.length - 1) {
                textoArray += ", ";
            }
        }

        textoArray += "]";
        return textoArray;
    }

    public static void ordenar(int[] array) {
        System.out.println("========== INSERTION SORT ITERATIVO ==========");
        System.out.println("Estado inicial: " + arrayATexto(array));
        System.out.println();

        for (int indiceActual = 1; indiceActual < array.length; indiceActual++) {
            int valorActual = array[indiceActual];
            int indiceComparacion = indiceActual - 1;

            System.out.println("--- indiceActual=" + indiceActual + ", valorActual=" + valorActual + " ---");

            while (indiceComparacion >= 0 && array[indiceComparacion] > valorActual) {
                System.out.println("Comparo array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + valorActual + " -> TRUE");
                System.out.println("Desplazo " + array[indiceComparacion] + " a posición " + (indiceComparacion + 1));

                array[indiceComparacion + 1] = array[indiceComparacion];

                System.out.println("Array: " + arrayATexto(array));

                indiceComparacion--;
            }

            if (indiceComparacion >= 0) {
                System.out.println("Comparo array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + valorActual + " -> FALSE");
            } else {
                System.out.println("indiceComparacion < 0 -> se llegó al inicio");
            }

            array[indiceComparacion + 1] = valorActual;

            System.out.println("Inserto " + valorActual + " en posición " + (indiceComparacion + 1));
            System.out.println("Array: " + arrayATexto(array));
            System.out.println();
        }

        System.out.println("Estado final: " + arrayATexto(array));
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenar(array);
    }
}
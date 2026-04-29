public class InsertionSort {

    private static int nivelRecursion = 0;

    private static String sangria() {
        String textoSangria = "";

        for (int indice = 0; indice < nivelRecursion; indice++) {
            textoSangria += "  ";
        }

        return textoSangria;
    }

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

    private static String rangoATexto(int[] array, int indiceInicio, int indiceFin) {
        if (indiceInicio > indiceFin) {
            return "[]";
        }

        String textoRango = "[";

        for (int indice = indiceInicio; indice <= indiceFin; indice++) {
            textoRango += array[indice];

            if (indice < indiceFin) {
                textoRango += ", ";
            }
        }

        textoRango += "]";
        return textoRango;
    }

    public static void insertionSortIterativo(int[] array) {
        System.out.println("Estado inicial: " + arrayATexto(array));
        System.out.println();

        for (int indiceActual = 1; indiceActual < array.length; indiceActual++) {
            int valorActual = array[indiceActual];
            int indiceComparacion = indiceActual - 1;

            System.out.println("--- i=" + indiceActual + ", elemento a insertar: " + valorActual + " ---");

            while (indiceComparacion >= 0 && array[indiceComparacion] > valorActual) {
                System.out.println("  array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + valorActual + " → TRUE, desplazando " + array[indiceComparacion] + " a posición " + (indiceComparacion + 1));

                array[indiceComparacion + 1] = array[indiceComparacion];

                System.out.println("  Array: " + arrayATexto(array));

                indiceComparacion--;
            }

            if (indiceComparacion >= 0) {
                System.out.println("  array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + valorActual + " → FALSE, se detiene");
            } else {
                System.out.println("  indiceComparacion < 0, se llegó al inicio");
            }

            array[indiceComparacion + 1] = valorActual;

            System.out.println("  Insertando " + valorActual + " en posición " + (indiceComparacion + 1));
            System.out.println("  Array: " + arrayATexto(array));
            System.out.println();
        }

        System.out.println("Estado final: " + arrayATexto(array));
    }

    public static void insertionSortRecursivo(int[] array, int numeroElementos) {
        System.out.println(sangria() + "→ ordenar(numeroElementos=" + numeroElementos + ")  array[0.." + (numeroElementos - 1) + "]: " + rangoATexto(array, 0, numeroElementos - 1));

        if (numeroElementos <= 1) {
            System.out.println(sangria() + "  CASO BASE: numeroElementos=" + numeroElementos + " <= 1 → retorno");
            return;
        }

        nivelRecursion++;
        insertionSortRecursivo(array, numeroElementos - 1);
        nivelRecursion--;

        int ultimoElemento = array[numeroElementos - 1];
        int indiceComparacion = numeroElementos - 2;

        System.out.println(sangria() + "← vuelvo a numeroElementos=" + numeroElementos + ", inserto " + ultimoElemento + " en [0.." + (numeroElementos - 1) + "]");

        while (indiceComparacion >= 0 && array[indiceComparacion] > ultimoElemento) {
            System.out.println(sangria() + "  array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + ultimoElemento + " → TRUE, desplazando " + array[indiceComparacion]);

            array[indiceComparacion + 1] = array[indiceComparacion];

            System.out.println(sangria() + "  Array: " + rangoATexto(array, 0, numeroElementos - 1));

            indiceComparacion--;
        }

        if (indiceComparacion >= 0) {
            System.out.println(sangria() + "  array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + ultimoElemento + " → FALSE, se detiene");
        } else {
            System.out.println(sangria() + "  indiceComparacion < 0, se llegó al inicio");
        }

        array[indiceComparacion + 1] = ultimoElemento;

        System.out.println(sangria() + "  Insertando " + ultimoElemento + " en posición " + (indiceComparacion + 1));
        System.out.println(sangria() + "  Array: " + rangoATexto(array, 0, numeroElementos - 1));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrayBase = {5, 2, 8, 1, 9, 3};

        System.out.println("========== INSERTION SORT ITERATIVO ==========");
        int[] array = arrayBase.clone();
        insertionSortIterativo(array);

        System.out.println("\n========== INSERTION SORT RECURSIVO ==========");
        array = arrayBase.clone();
        nivelRecursion = 0;
        System.out.println("Estado inicial: " + arrayATexto(array));
        System.out.println();
        insertionSortRecursivo(array, array.length);
        System.out.println("Estado final: " + arrayATexto(array));
    }
}
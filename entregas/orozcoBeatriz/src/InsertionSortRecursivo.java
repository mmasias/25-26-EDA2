public class InsertionSortRecursivo {

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

    public static void ordenar(int[] array, int numeroElementos) {
        System.out.println(sangria() + "→ ordenar(numeroElementos=" + numeroElementos + ")");
        System.out.println(sangria() + "  Segmento actual: " + rangoATexto(array, 0, numeroElementos - 1));

        if (numeroElementos <= 1) {
            System.out.println(sangria() + "  CASO BASE: numeroElementos <= 1 -> retorno");
            return;
        }

        nivelRecursion++;
        ordenar(array, numeroElementos - 1);
        nivelRecursion--;

        int ultimoElemento = array[numeroElementos - 1];
        int indiceComparacion = numeroElementos - 2;

        System.out.println(sangria() + "← vuelvo a numeroElementos=" + numeroElementos);
        System.out.println(sangria() + "  Inserto ultimoElemento=" + ultimoElemento);

        while (indiceComparacion >= 0 && array[indiceComparacion] > ultimoElemento) {
            System.out.println(sangria() + "  Comparo array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + ultimoElemento + " -> TRUE");
            System.out.println(sangria() + "  Desplazo " + array[indiceComparacion] + " a posición " + (indiceComparacion + 1));

            array[indiceComparacion + 1] = array[indiceComparacion];

            System.out.println(sangria() + "  Array: " + rangoATexto(array, 0, numeroElementos - 1));

            indiceComparacion--;
        }

        if (indiceComparacion >= 0) {
            System.out.println(sangria() + "  Comparo array[" + indiceComparacion + "]=" + array[indiceComparacion] + " > " + ultimoElemento + " -> FALSE");
        } else {
            System.out.println(sangria() + "  indiceComparacion < 0 -> se llegó al inicio");
        }

        array[indiceComparacion + 1] = ultimoElemento;

        System.out.println(sangria() + "  Inserto " + ultimoElemento + " en posición " + (indiceComparacion + 1));
        System.out.println(sangria() + "  Array: " + rangoATexto(array, 0, numeroElementos - 1));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("========== INSERTION SORT RECURSIVO ==========");
        System.out.println("Estado inicial: " + arrayATexto(array));
        System.out.println();

        nivelRecursion = 0;
        ordenar(array, array.length);

        System.out.println("Estado final: " + arrayATexto(array));
    }
}
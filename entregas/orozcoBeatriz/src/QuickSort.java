public class QuickSort {

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

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(sangria() + "→ ordenar(izquierda=" + izquierda + ", derecha=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(sangria() + "  CASO BASE: izquierda >= derecha -> retorno");
            return;
        }

        System.out.println(sangria() + "  Segmento actual: " + rangoATexto(array, izquierda, derecha));
        System.out.println(sangria() + "  Pivote: array[" + derecha + "]=" + array[derecha]);

        int indicePivote = particionar(array, izquierda, derecha);

        System.out.println(sangria() + "  Pivote " + array[indicePivote] + " fijado en posición " + indicePivote);
        System.out.println(sangria() + "  Array: " + rangoATexto(array, izquierda, derecha));
        System.out.println();

        nivelRecursion++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        nivelRecursion--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int indiceMenores = izquierda - 1;

        System.out.println(sangria() + "  Particionando, pivote=" + pivote);

        for (int indiceExploracion = izquierda; indiceExploracion < derecha; indiceExploracion++) {
            if (array[indiceExploracion] <= pivote) {
                indiceMenores++;

                System.out.println(sangria() + "    Comparo array[" + indiceExploracion + "]=" + array[indiceExploracion] + " <= " + pivote + " -> TRUE");
                System.out.println(sangria() + "    Intercambio array[" + indiceMenores + "] y array[" + indiceExploracion + "]");

                int valorTemporal = array[indiceMenores];
                array[indiceMenores] = array[indiceExploracion];
                array[indiceExploracion] = valorTemporal;

                System.out.println(sangria() + "    Array: " + arrayATexto(array));
            } else {
                System.out.println(sangria() + "    Comparo array[" + indiceExploracion + "]=" + array[indiceExploracion] + " <= " + pivote + " -> FALSE, sin cambio");
            }
        }

        System.out.println(sangria() + "  Colocando pivote " + pivote + ": intercambio array[" + (indiceMenores + 1) + "] y array[" + derecha + "]");

        int valorTemporal = array[indiceMenores + 1];
        array[indiceMenores + 1] = array[derecha];
        array[derecha] = valorTemporal;

        System.out.println(sangria() + "  Array tras colocar pivote: " + arrayATexto(array));

        return indiceMenores + 1;
    }
}
public class MergeSortRecursivo {

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

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(sangria() + "  medio=" + medio);
        System.out.println(sangria() + "  Divido en [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");

        nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivelRecursion--;

        System.out.println(sangria() + "  Fusiono [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "]");
        System.out.println(sangria() + "  Antes de fusionar: " + rangoATexto(array, izquierda, derecha));

        fusionar(array, izquierda, medio, derecha);

        System.out.println(sangria() + "  Después de fusionar: " + rangoATexto(array, izquierda, derecha));
        System.out.println();
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;

        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int indiceIzquierda = 0; indiceIzquierda < tamanoIzquierda; indiceIzquierda++) {
            mitadIzquierda[indiceIzquierda] = array[izquierda + indiceIzquierda];
        }

        for (int indiceDerecha = 0; indiceDerecha < tamanoDerecha; indiceDerecha++) {
            mitadDerecha[indiceDerecha] = array[medio + 1 + indiceDerecha];
        }

        System.out.println(sangria() + "    Copia izquierda: " + arrayATexto(mitadIzquierda));
        System.out.println(sangria() + "    Copia derecha: " + arrayATexto(mitadDerecha));

        int indiceMitadIzquierda = 0;
        int indiceMitadDerecha = 0;
        int indiceArrayOriginal = izquierda;

        while (indiceMitadIzquierda < tamanoIzquierda && indiceMitadDerecha < tamanoDerecha) {
            if (mitadIzquierda[indiceMitadIzquierda] <= mitadDerecha[indiceMitadDerecha]) {
                System.out.println(sangria() + "    Comparo " + mitadIzquierda[indiceMitadIzquierda] + " <= " + mitadDerecha[indiceMitadDerecha] + " -> TRUE");
                System.out.println(sangria() + "    Coloco " + mitadIzquierda[indiceMitadIzquierda] + " en posición " + indiceArrayOriginal);

                array[indiceArrayOriginal] = mitadIzquierda[indiceMitadIzquierda];

                System.out.println(sangria() + "    Array: " + arrayATexto(array));

                indiceMitadIzquierda++;
            } else {
                System.out.println(sangria() + "    Comparo " + mitadIzquierda[indiceMitadIzquierda] + " <= " + mitadDerecha[indiceMitadDerecha] + " -> FALSE");
                System.out.println(sangria() + "    Coloco " + mitadDerecha[indiceMitadDerecha] + " en posición " + indiceArrayOriginal);

                array[indiceArrayOriginal] = mitadDerecha[indiceMitadDerecha];

                System.out.println(sangria() + "    Array: " + arrayATexto(array));

                indiceMitadDerecha++;
            }

            indiceArrayOriginal++;
        }

        while (indiceMitadIzquierda < tamanoIzquierda) {
            System.out.println(sangria() + "    Resto izquierda: coloco " + mitadIzquierda[indiceMitadIzquierda] + " en posición " + indiceArrayOriginal);

            array[indiceArrayOriginal] = mitadIzquierda[indiceMitadIzquierda];

            System.out.println(sangria() + "    Array: " + arrayATexto(array));

            indiceMitadIzquierda++;
            indiceArrayOriginal++;
        }

        while (indiceMitadDerecha < tamanoDerecha) {
            System.out.println(sangria() + "    Resto derecha: coloco " + mitadDerecha[indiceMitadDerecha] + " en posición " + indiceArrayOriginal);

            array[indiceArrayOriginal] = mitadDerecha[indiceMitadDerecha];

            System.out.println(sangria() + "    Array: " + arrayATexto(array));

            indiceMitadDerecha++;
            indiceArrayOriginal++;
        }
    }
}
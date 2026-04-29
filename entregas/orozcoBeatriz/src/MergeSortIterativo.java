public class MergeSortIterativo {

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

    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + arrayATexto(array));
        System.out.println();

        int numeroElementos = array.length;

        for (int tamanoBloque = 1; tamanoBloque < numeroElementos; tamanoBloque *= 2) {
            System.out.println("--- Tamaño de bloque: " + tamanoBloque + " ---");

            for (int izquierda = 0; izquierda < numeroElementos - tamanoBloque; izquierda += 2 * tamanoBloque) {
                int medio = izquierda + tamanoBloque - 1;
                int derecha = Math.min(izquierda + 2 * tamanoBloque - 1, numeroElementos - 1);

                System.out.println("Fusiono [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "]");
                System.out.println("Antes de fusionar: " + rangoATexto(array, izquierda, derecha));

                fusionar(array, izquierda, medio, derecha);

                System.out.println("Después de fusionar: " + rangoATexto(array, izquierda, derecha));
                System.out.println("Array completo: " + arrayATexto(array));
                System.out.println();
            }
        }

        System.out.println("Estado final: " + arrayATexto(array));
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

        System.out.println("  Copia izquierda: " + arrayATexto(mitadIzquierda));
        System.out.println("  Copia derecha: " + arrayATexto(mitadDerecha));

        int indiceMitadIzquierda = 0;
        int indiceMitadDerecha = 0;
        int indiceArrayOriginal = izquierda;

        while (indiceMitadIzquierda < tamanoIzquierda && indiceMitadDerecha < tamanoDerecha) {
            if (mitadIzquierda[indiceMitadIzquierda] <= mitadDerecha[indiceMitadDerecha]) {
                System.out.println("  Comparo " + mitadIzquierda[indiceMitadIzquierda] + " <= " + mitadDerecha[indiceMitadDerecha] + " -> TRUE");
                System.out.println("  Coloco " + mitadIzquierda[indiceMitadIzquierda] + " en posición " + indiceArrayOriginal);

                array[indiceArrayOriginal] = mitadIzquierda[indiceMitadIzquierda];

                System.out.println("  Array: " + arrayATexto(array));

                indiceMitadIzquierda++;
            } else {
                System.out.println("  Comparo " + mitadIzquierda[indiceMitadIzquierda] + " <= " + mitadDerecha[indiceMitadDerecha] + " -> FALSE");
                System.out.println("  Coloco " + mitadDerecha[indiceMitadDerecha] + " en posición " + indiceArrayOriginal);

                array[indiceArrayOriginal] = mitadDerecha[indiceMitadDerecha];

                System.out.println("  Array: " + arrayATexto(array));

                indiceMitadDerecha++;
            }

            indiceArrayOriginal++;
        }

        while (indiceMitadIzquierda < tamanoIzquierda) {
            System.out.println("  Resto izquierda: coloco " + mitadIzquierda[indiceMitadIzquierda] + " en posición " + indiceArrayOriginal);

            array[indiceArrayOriginal] = mitadIzquierda[indiceMitadIzquierda];

            System.out.println("  Array: " + arrayATexto(array));

            indiceMitadIzquierda++;
            indiceArrayOriginal++;
        }

        while (indiceMitadDerecha < tamanoDerecha) {
            System.out.println("  Resto derecha: coloco " + mitadDerecha[indiceMitadDerecha] + " en posición " + indiceArrayOriginal);

            array[indiceArrayOriginal] = mitadDerecha[indiceMitadDerecha];

            System.out.println("  Array: " + arrayATexto(array));

            indiceMitadDerecha++;
            indiceArrayOriginal++;
        }
    }
}
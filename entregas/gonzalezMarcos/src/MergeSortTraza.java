public class MergeSortTraza {

    private static int nivelRecursion = 0;

    private static String indent(int nivel) {
        String resultado = "";
        for (int i = 0; i < nivel; i++) {
            resultado = resultado + "    ";
        }
        return resultado;
    }

    private static String arrayToString(int[] array) {
        String resultado = "[";
        for (int i = 0; i < array.length; i++) {
            resultado = resultado + array[i];
            if (i < array.length - 1) {
                resultado = resultado + ", ";
            }
        }
        resultado = resultado + "]";
        return resultado;
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = indent(nivelRecursion);

        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial (Merge Recursivo): " + arrayToString(array));
        }

        System.out.println(ind + "Llamada recursiva: ordenar(izq=" + izquierda + ", der=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(ind + "-> CASO BASE ALCANZADO: izq (" + izquierda + ") >= der (" + derecha + "). Subarray no divisible.");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(ind + "División calculada: medio=" + medio);

        nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivelRecursion--;

        fusionar(array, izquierda, medio, derecha);

        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado final (Merge Recursivo): " + arrayToString(array));
        }
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("\nEstado inicial (Merge Iterativo): " + arrayToString(array));
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n--- Pasada con tamaño de sub-arrays: " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("Fusionando bloque iterativo: izq=" + izquierda + ", medio=" + medio + ", der=" + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
            System.out.println("Array tras pasada (tamaño " + tamano + "): " + arrayToString(array));
        }
        System.out.println("Estado final (Merge Iterativo): " + arrayToString(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String ind = indent(nivelRecursion);
        System.out.println(ind + "[Fusión] Uniendo mitades: [" + izquierda + " a " + medio + "] y [" + (medio + 1) + " a " + derecha + "]");

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

        System.out.println(ind + "  Mitad Izq extraída: " + arrayToString(mitadIzquierda));
        System.out.println(ind + "  Mitad Der extraída: " + arrayToString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print(ind + "  Comparando: MitadIzq[" + i + "]=" + mitadIzquierda[i] + " <= MitadDer[" + j + "]=" + mitadDerecha[j] + " -> ");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("TRUE. Tomamos de MitadIzq (" + mitadIzquierda[i] + ")");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println("FALSE. Tomamos de MitadDer (" + mitadDerecha[j] + ")");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }

        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(ind + "  Volcando resto MitadIzq: " + mitadIzquierda[i] + " en pos " + k);
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(ind + "  Volcando resto MitadDer: " + mitadDerecha[j] + " en pos " + k);
            j++;
            k++;
        }
        System.out.println(ind + "  Resultado tras fusión: " + arrayToString(array));
    }
}

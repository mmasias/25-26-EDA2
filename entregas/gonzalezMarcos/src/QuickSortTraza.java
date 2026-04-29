public class QuickSortTraza {

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
            System.out.println("Estado inicial (Quick Sort): " + arrayToString(array));
        }

        System.out.println(ind + "Llamada recursiva: ordenar(izq=" + izquierda + ", der=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(ind + "-> CASO BASE ALCANZADO: izq (" + izquierda + ") >= der (" + derecha + "). No requiere ordenación.");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(ind + "Partición completada. Elemento pivote colocado en índice definitivo: " + indicePivote);

        nivelRecursion++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        nivelRecursion--;

        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado final (Quick Sort): " + arrayToString(array));
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String ind = indent(nivelRecursion);
        int pivote = array[derecha];
        System.out.println(ind + "[Partición] Segmento [" + izquierda + " a " + derecha + "]. Pivote elegido: " + pivote + " (en índice " + derecha + ")");

        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            System.out.print(ind + "  Comparando array[" + j + "] (" + array[j] + ") <= pivote (" + pivote + ") -> ");
            if (array[j] <= pivote) {
                System.out.println("TRUE");
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                if (i != j) {
                    System.out.println(ind + "    Intercambio: valores " + array[j] + " y " + array[i] + " en índices " + i + " y " + j + " -> " + arrayToString(array));
                } else {
                    System.out.println(ind + "    Sin intercambio visible (i == j, ambos son " + i + ").");
                }
            } else {
                System.out.println("FALSE (se queda en la zona de mayores)");
            }
        }

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        if ((i + 1) != derecha) {
            System.out.println(ind + "  [Fin Partición] Intercambio final del pivote " + pivote + " a su índice final " + (i + 1) + " -> " + arrayToString(array));
        } else {
            System.out.println(ind + "  [Fin Partición] El pivote " + pivote + " ya está en su posición final (" + derecha + ").");
        }

        return i + 1;
    }
}

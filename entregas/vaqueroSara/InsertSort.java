
public class InsertionSort {

    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + arrayAString(array));
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            System.out.println("[i=" + i + "] Tomamos array[" + i + "]=" + actual
                    + " como 'actual'; j parte de " + (i - 1));
            int j = i - 1;
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Compara array[" + j + "]=" + array[j]
                        + " > " + actual + " -> TRUE: desplazamos a la derecha");
                array[j + 1] = array[j];
                System.out.println("    array[" + (j + 1) + "] <- array[" + j + "]: "
                        + arrayAString(array));
                j--;
            }
            trazaSalidaWhile("  ", j, actual, array);
            array[j + 1] = actual;
            System.out.println("  Insertamos actual=" + actual + " en posición "
                    + (j + 1) + ": " + arrayAString(array));
        }
        System.out.println("Estado final:   " + arrayAString(array));
    }

    public static void ordenarRecursivo(int[] array, int n) {
        int profundidad = array.length - n;
        String ind = "  ".repeat(profundidad);
        System.out.println(ind + "ordenar(n=" + n + "): array=" + arrayAString(array));
        if (n <= 1) {
            System.out.println(ind + "  CASO BASE: n=" + n
                    + " <= 1 -> return (un único elemento ya está ordenado)");
            return;
        }
        System.out.println(ind + "  Llamada recursiva: ordenar(n=" + (n - 1) + ")");
        ordenarRecursivo(array, n - 1);
        int ultimo = array[n - 1];
        System.out.println(ind + "  Tras recursión array=" + arrayAString(array)
                + "; insertamos array[" + (n - 1) + "]=" + ultimo
                + " en su posición correcta entre los " + (n - 1) + " primeros");
        int j = n - 2;
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + "    Compara array[" + j + "]=" + array[j]
                    + " > " + ultimo + " -> TRUE: desplazamos a la derecha");
            array[j + 1] = array[j];
            System.out.println(ind + "      array[" + (j + 1) + "] <- array["
                    + j + "]: " + arrayAString(array));
            j--;
        }
        trazaSalidaWhile(ind + "    ", j, ultimo, array);
        array[j + 1] = ultimo;
        System.out.println(ind + "  Insertamos " + ultimo + " en posición "
                + (j + 1) + ": " + arrayAString(array));
    }

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println(" INSERTION SORT - VERSIÓN ITERATIVA");
        System.out.println("======================================================");
        int[] a1 = {5, 2, 8, 1, 9, 3};
        ordenarIterativo(a1);

        System.out.println();
        System.out.println("======================================================");
        System.out.println(" INSERTION SORT - VERSIÓN RECURSIVA");
        System.out.println("======================================================");
        int[] a2 = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + arrayAString(a2));
        ordenarRecursivo(a2, a2.length);
        System.out.println("Estado final:   " + arrayAString(a2));
    }

    
    private static String arrayAString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    
    private static void trazaSalidaWhile(String ind, int j, int valor, int[] array) {
        if (j < 0) {
            System.out.println(ind + "Fin del while: j=-1, hemos alcanzado el inicio del array");
        } else {
            System.out.println(ind + "Compara array[" + j + "]=" + array[j]
                    + " > " + valor + " -> FALSE: paramos");
        }
    }
}

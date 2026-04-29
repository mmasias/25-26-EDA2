public class QuickSort {

    private static String arrToString(int[] arr) {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if (i < arr.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private static String subArrToString(int[] arr, int ini, int fin) {
        if (ini > fin)
            return "[]";
        StringBuilder res = new StringBuilder("[");
        for (int i = ini; i <= fin; i++) {
            res.append(arr[i]);
            if (i < fin) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private static void printIndent() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    private static int depth = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        printIndent();
        System.out.println("Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ") en "
                + subArrToString(array, izquierda, derecha));

        if (izquierda >= derecha) {
            printIndent();
            System.out.println("Caso base alcanzado: izquierda >= derecha.");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha);

        printIndent();
        System.out.println("Pivote colocado en indice " + indicePivote + ". Array actual: " + arrToString(array));

        depth++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        depth--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        printIndent();
        System.out.println("Particionando con pivote=" + pivote);

        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                printIndent();
                System.out.print(
                        "  " + array[j] + " <= " + pivote + " -> Si. Intercambiamos posiciones " + i + " y " + j);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(" -> Array actual: " + arrToString(array));
            } else {
                printIndent();
                System.out.println("  " + array[j] + " <= " + pivote + " -> No.");
            }
        }

        printIndent();
        System.out.print("  Movemos el pivote " + pivote + " a la posicion " + (i + 1));

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(" -> Array resultante: " + arrToString(array));

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        System.out.println("Inicio Quick Sort");
        System.out.println("Estado inicial: " + arrToString(array) + "\n");
        depth = 0;
        ordenar(array, 0, array.length - 1);
        System.out.println("\nEstado final: " + arrToString(array));
    }
}

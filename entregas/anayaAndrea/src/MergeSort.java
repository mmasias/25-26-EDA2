public class MergeSort {

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

    public static void ordenar(int[] array, int[] aux, int izquierda, int derecha) {
        printIndent();
        System.out.println("Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ") -> "
                + subArrToString(array, izquierda, derecha));

        if (izquierda >= derecha) {
            printIndent();
            System.out.println("Caso base alcanzado: izquierda >= derecha. Array de 1 o 0 elementos.");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        depth++;
        ordenar(array, aux, izquierda, medio);
        ordenar(array, aux, medio + 1, derecha);
        depth--;

        printIndent();
        System.out.println("Vamos a fusionar las mitades [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".."
                + derecha + "]");

        fusionar(array, aux, izquierda, medio, derecha);

        printIndent();
        System.out.println("Resultado de fusion: " + subArrToString(array, izquierda, derecha));
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("Inicio Merge Sort (Iterativo)");
        System.out.println("Estado inicial: " + arrToString(array));

        int n = array.length;
        int[] aux = new int[n];
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\nTamano de sub-arrays a fusionar: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println(
                        "Fusionando [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "]");
                fusionar(array, aux, izquierda, medio, derecha);
            }
            System.out.println("Array actual tras ronda de tamano " + tamano + ": " + arrToString(array));
        }
        System.out.println("\nEstado final: " + arrToString(array));
    }

    private static void fusionar(int[] array, int[] aux, int izquierda, int medio, int derecha) {
        for (int i = izquierda; i <= derecha; i++) {
            aux[i] = array[i];
        }

        printIndent();
        System.out.println("  Mitad Izq: " + subArrToString(aux, izquierda, medio) + ", Mitad Der: " + subArrToString(aux, medio + 1, derecha));

        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;

        while (i <= medio && j <= derecha) {
            if (aux[i] <= aux[j]) {
                printIndent();
                System.out.println("  " + aux[i] + " <= " + aux[j] + " -> Se toma de la izquierda");
                array[k] = aux[i];
                i++;
            } else {
                printIndent();
                System.out.println("  " + aux[i] + " > " + aux[j] + " -> Se toma de la derecha");
                array[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= medio) {
            array[k] = aux[i];
            i++;
            k++;
        }
        while (j <= derecha) {
            array[k] = aux[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a1 = { 5, 2, 8, 1, 9, 3 };
        System.out.println("Inicio Merge Sort (Recursivo)");
        System.out.println("Estado inicial: " + arrToString(a1) + "\n");
        depth = 0;
        int[] aux1 = new int[a1.length];
        ordenar(a1, aux1, 0, a1.length - 1);
        System.out.println("\nEstado final: " + arrToString(a1));

        System.out.println("\n-------------------------------------------------\n");

        int[] a2 = { 5, 2, 8, 1, 9, 3 };
        ordenarIterativo(a2);
    }
}

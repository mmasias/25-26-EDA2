public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String ind = "";
        for (int i = 0; i < nivel; i++) {
            ind += "  ";
        }

        System.out.println(ind + "Llamada Recursiva (Izquierda) = " + izquierda + ", Derecha = " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(
                    ind + "CASO BASE: Rango invalido o un solo elemento (" + izquierda + " >= " + derecha + ")");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha, ind);

        System.out.print(ind + "Estado tras particion (Indice del Pivote " + indicePivote + "): ");
        imprimirArray(array);
        System.out.println();

        System.out.println(ind + "Parte Izquierda:");
        ordenar(array, izquierda, indicePivote - 1, nivel + 1);

        System.out.println(ind + "Parte Derecha:");
        ordenar(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, String ind) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(ind + "Pivote: " + pivote + " (en indice " + derecha + ")");

        for (int j = izquierda; j < derecha; j++) {
            System.out.print(ind + "Comparando array[" + j + "] (" + array[j] + ") <= pivote (" + pivote + "): ");

            if (array[j] <= pivote) {
                System.out.println("SI.");
                i++;
                System.out.println(
                        ind + "Swap: array[" + i + "](" + array[i] + ") <-> array[" + j + "](" + array[j] + ")");
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
            } else {
                System.out.println("NO.");
            }
        }

        System.out.println(ind + "Pivote en posicion final:");
        System.out.println(ind + "Swap final: array[" + (i + 1) + "](" + array[i + 1] + ") <-> array[" + derecha + "]("
                + array[derecha] + ")");

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        return i + 1;
    }

    private static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };

        System.out.print("ESTADO INICIAL: ");
        imprimirArray(array);
        System.out.println();

        ordenar(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.print("ESTADO FINAL: ");
        imprimirArray(array);
    }
}
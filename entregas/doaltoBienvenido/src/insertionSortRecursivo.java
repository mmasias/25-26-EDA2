public class InsertionSortRecursivo {

    public static void ordenar(int[] array, int n, int nivel) {
        String ind = "";
        for (int i = 0; i < nivel; i++) {
            ind += "  ";
        }

        System.out.println(ind + "LLamada Recursiva (n = " + n + ")");

        if (n <= 1) {
            System.out.println(ind + "Hemos llegado al caso base (n = " + n + "): El subarray ya esta ordenado.");
            return;
        }

        System.out.println(ind + "Bajando al nivel (n = " + (n - 1) + ")");
        ordenar(array, n - 1, nivel + 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println();
        System.out.println(ind + "Iteracion n = " + n + ":");
        System.out.println(ind + "Numero Seleccionado: " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + " Array[" + j + "] = " + array[j] + " > " + ultimo + "? SI.");
            System.out.println(ind + " Swaping " + array[j] + " hacia la derecha.");

            array[j + 1] = array[j];
            j--;

            System.out.print(ind + "Estado tras el swap: ");
            imprimirArray(array);
            System.out.println();
        }

        if (j >= 0) {
            System.out
                    .println(ind + " Array[" + j + "] = " + array[j] + " > " + ultimo + "? NO. (Posicion encontrada)");
        } else {
            System.out.println(ind + "Se alcanzo el limite izquierdo del array");
        }

        array[j + 1] = ultimo;
        System.out.print(ind + "Resultado de iteracion: ");
        imprimirArray(array);
        System.out.println();
        System.out.println(ind + "-".repeat(20));
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

        ordenar(array, array.length, 0);

        System.out.println();
        System.out.print("ESTADO FINAL: ");
        imprimirArray(array);
    }
}
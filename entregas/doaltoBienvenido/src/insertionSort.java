public class InsertionSort {

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println();
            System.out.println("Iteracion " + i + ":");
            System.out.println("Numero Seleccionado: " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println(" Array[" + j + "] = " + array[j] + " > " + actual + "? Si.");
                System.out.println(" Swaping " + array[j] + " hacia la derecha.");

                array[j + 1] = array[j];
                j--;

                System.out.print("Estado tras el swap: ");
                imprimirArray(array);
                System.out.println();
            }

            if (j >= 0) {
                System.out.println(" Array[" + j + "] = " + array[j] + " > " + actual + "? NO. (Posición encontrada)");
            } else {
                System.out.println("Se alcanzo el limite izquierdo del array");
            }

            array[j + 1] = actual;
            System.out.print("Resultado de iteracion : ");
            imprimirArray(array);
            System.out.println();
            System.out.println("-".repeat(20));
        }

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

        ordenar(array);

        System.out.println();
        System.out.print("ESTADO FINAL: ");
        imprimirArray(array);
    }
}
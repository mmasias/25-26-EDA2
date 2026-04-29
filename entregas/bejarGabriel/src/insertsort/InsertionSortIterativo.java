public class InsertionSortIterativo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial del array (Insertion Sort Iterativo):");
        imprimirArray(array);
        System.out.println("Iniciando proceso de ordenación...");
        ordenar(array);
        System.out.println("Proceso finalizado. Estado final del array:");
        imprimirArray(array);
    }

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("--- Evaluando elemento en índice i=" + i + ", valor a insertar=" + actual + " ---");
            while (j >= 0 && array[j] > actual) {
                System.out.println("Comparación: índice j=" + j + " es >= 0 y array[" + j + "] (" + array[j] + ") es > que el valor a insertar (" + actual + "). Intercambio necesario.");
                array[j + 1] = array[j];
                System.out.println("Desplazamiento: El valor " + array[j + 1] + " se mueve a la posición " + (j + 1));
                imprimirArray(array);
                j--;
            }
            if (j < 0) {
                System.out.println("Comparación: índice j=" + j + " es menor que 0. Se alcanzo el inicio del array.");
            } else {
                System.out.println("Comparación: array[" + j + "] (" + array[j] + ") NO es > que el valor a insertar (" + actual + "). Posición correcta encontrada.");
            }
            array[j + 1] = actual;
            System.out.println("Inserción: El valor " + actual + " se coloca en la posición " + (j + 1));
            imprimirArray(array);
        }
    }

    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
import java.util.Arrays;

public class InsertionSort {

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            String ind = SoporteTraza.getInd();
            System.out.println(ind + "Tomando actual = array[" + i + "] = " + array[i]);

            int actual = array[i];
            int j = i - 1;

            SoporteTraza.imprimirComparacion(array, j, actual, ind);

            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                System.out.println(ind + "Desplazamiento: array[" + (j + 1) + "] = " + array[j] + " -> " + Arrays.toString(array));
                j--;
                SoporteTraza.imprimirComparacion(array, j, actual, ind);
            }

            SoporteTraza.imprimirCorteBucle(array, j, actual, ind);

            array[j + 1] = actual;
            System.out.println(ind + "Inserción final: array[" + (j + 1) + "] = " + actual + " -> " + Arrays.toString(array));
        }
    }

    public static void ordenar(int[] array, int n) {
        String ind = SoporteTraza.getInd();
        System.out.println(ind + "Llamada recursiva con n=" + n);

        if (n <= 1) {
            System.out.println(ind + "Caso base alcanzado (n <= 1).");
            return;
        }

        System.out.println(ind + "-> Subarray con n=" + (n - 1));

        SoporteTraza.entrarNivel();
        ordenar(array, n - 1);
        SoporteTraza.salirNivel();

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(ind + "Retorno recursivo, ubicando ultimo=" + ultimo);

        SoporteTraza.imprimirComparacion(array, j, ultimo, ind);

        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            System.out.println(ind + "Desplazamiento: array[" + (j + 1) + "] = " + array[j] + " -> " + Arrays.toString(array));
            j--;
            SoporteTraza.imprimirComparacion(array, j, ultimo, ind);
        }

        SoporteTraza.imprimirCorteBucle(array, j, ultimo, ind);

        array[j + 1] = ultimo;
        System.out.println(ind + "Inserción final: array[" + (j + 1) + "] = " + ultimo + " -> " + Arrays.toString(array));
    }
}
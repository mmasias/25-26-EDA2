public class InsertionSort {

    public static void ordenar(int[] array) {

        System.out.println("=== INSERTION SORT ITERATIVO ===");
        System.out.println("Inicial: " + Utils.a(array));

        for (int i = 1; i < array.length; i++) {

            int actual = array[i];
            int j = i - 1;

            System.out.println("\n[i=" + i + "] actual=" + actual);

            while (j >= 0 && array[j] > actual) {

                System.out.println("Comparar " + array[j] + " > " + actual + " -> true");

                array[j + 1] = array[j];

                System.out.println("Desplazar -> " + Utils.a(array));

                j--;
            }

            if (j >= 0) {
                System.out.println("Comparar " + array[j] + " > " + actual + " -> false");
            }

            array[j + 1] = actual;

            System.out.println("Insertar -> " + Utils.a(array));
        }

        System.out.println("Final: " + Utils.a(array));
    }
}
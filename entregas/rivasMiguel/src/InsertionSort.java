public class InsertionSort{
    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            
            System.out.print("En el array ");
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println(" comparando elementos " + array[i] + " y " + array[i-1]);

            int actual = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
        }
    }

    public static void ordenar(int[] array, int n) {
        if (n <= 1) {
            return;
        }
        ordenar(array, n - 1);

        System.out.print("En el array ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" comparando elementos " + array[n - 1] + " y " + array[n - 2]);

        int ultimo = array[n - 1];
        int j = n - 2;
        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ultimo;
    }
}

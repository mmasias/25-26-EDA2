import java.util.Arrays;

public class InsertionSortIterativoTraza {

    public static void main(String[] args) {

        int[] array = {5, 2, 8, 1, 9, 3};

        ordenar(array);
    }

    public static void ordenar(int[] array) {

        System.out.println("==================================");
        System.out.println("INSERTION SORT - VERSION ITERATIVA");
        System.out.println("==================================");

        System.out.println("ARRAY INICIAL: " + Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {

            int actual = array[i];
            int j = i - 1;

            System.out.println("----------------------------------");
            System.out.println("> ITERACIÓN " + i + ":");
            System.out.println("----------------------------------");
            System.out.println("Array Actual: " + Arrays.toString(array)+ "\n");
            System.out.println("Indice del array a ordenar: [" + (i - 1) + "] -> " + actual + "\n" );


            while (j >= 0 && array[j] > actual) {

                System.out.println("Comparo array [" + j + "] = " + array[j] + " > " + actual + " => true");
                array[j + 1] = array[j];
                System.out.println("Desplazo " + array[j]+ " desde índice " + j + " a índice " + (j + 1) + ": " + Arrays.toString(array)+"\n" );
                j--;
            }

            if (j >= 0) {
                System.out.println("Comparo array[" + j + "] = "+ array[j] + " > " + actual + " -> false");
            } else {
                System.out.println("Fin Iteraión (Sale de las dimendisones del array)");
            }

            array[j + 1] = actual;

            System.out.println("Inserto " + actual+ " en índice " + (j + 1) + ": " + Arrays.toString(array)+"\n");

            System.out.println("Estado tras inserción: "+ Arrays.toString(array));
        }
        System.out.println("==================================");
        System.out.println("ARRAY FINAL : " + Arrays.toString(array));
        System.out.println("==================================");
    }
}


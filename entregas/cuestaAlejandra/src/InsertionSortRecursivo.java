public class InsertionSortRecursivo {

    public static void ordenar(int[] array, int n, int depth) {

        System.out.println(Utils.tab(depth) + "insertion(n=" + n + ")");

        if (n <= 1) {
            System.out.println(Utils.tab(depth) + "Caso base");
            return;
        }

        ordenar(array, n - 1, depth + 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(Utils.tab(depth) + "Insertar " + ultimo);

        while (j >= 0 && array[j] > ultimo) {

            System.out.println(Utils.tab(depth) +
                    "Comparar " + array[j] + " > " + ultimo + " -> true");

            array[j + 1] = array[j];

            System.out.println(Utils.tab(depth) +
                    "Mover -> " + Utils.a(array));

            j--;
        }

        if (j >= 0) {
            System.out.println(Utils.tab(depth) +
                    "Comparar " + array[j] + " > " + ultimo + " -> false");
        }

        array[j + 1] = ultimo;

        System.out.println(Utils.tab(depth) +
                "Insertado -> " + Utils.a(array));
    }
}
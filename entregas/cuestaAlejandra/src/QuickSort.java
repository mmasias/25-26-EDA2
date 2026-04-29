public class QuickSort {

    public static void ordenar(int[] array, int izq, int der, int depth) {

        System.out.println(Utils.tab(depth) + "quick(" + izq + "," + der + ")");

        if (izq >= der) {
            System.out.println(Utils.tab(depth) + "Caso base");
            return;
        }

        int piv = particionar(array, izq, der, depth);

        ordenar(array, izq, piv - 1, depth + 1);
        ordenar(array, piv + 1, der, depth + 1);
    }

    private static int particionar(int[] array, int izq, int der, int depth) {

        int pivote = array[der];

        System.out.println(Utils.tab(depth) + "Pivote = " + pivote);

        int i = izq - 1;

        for (int j = izq; j < der; j++) {

            System.out.println(Utils.tab(depth) +
                    "Comparar " + array[j] + " <= " + pivote);

            if (array[j] <= pivote) {

                i++;

                System.out.println(Utils.tab(depth) +
                        "Swap " + array[i] + " <-> " + array[j]);

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                System.out.println(Utils.tab(depth) +
                        "Array: " + Utils.a(array));
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[der];
        array[der] = temp;

        System.out.println(Utils.tab(depth) +
                "Colocar pivote -> " + Utils.a(array));

        return i + 1;
    }
}
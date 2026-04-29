public class MergeSortRecursivo {

    public static void ordenar(int[] array, int izq, int der, int depth) {

        System.out.println(Utils.tab(depth) + "merge(" + izq + "," + der + ")");

        if (izq >= der) {
            System.out.println(Utils.tab(depth) + "Caso base");
            return;
        }

        int medio = (izq + der) / 2;

        ordenar(array, izq, medio, depth + 1);
        ordenar(array, medio + 1, der, depth + 1);

        System.out.println(Utils.tab(depth) +
                "Fusionar (" + izq + "," + medio + "," + der + ")");

        fusionar(array, izq, medio, der, depth);
    }

    private static void fusionar(int[] array, int izq, int medio, int der, int depth) {

        int n1 = medio - izq + 1;
        int n2 = der - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[izq + i];

        for (int j = 0; j < n2; j++)
            R[j] = array[medio + 1 + j];

        int i = 0, j = 0, k = izq;

        while (i < n1 && j < n2) {

            System.out.println(Utils.tab(depth) +
                    "Comparar " + L[i] + " <= " + R[j]);

            if (L[i] <= R[j]) {

                System.out.println(Utils.tab(depth) +
                        "Tomar izquierda " + L[i]);

                array[k++] = L[i++];
            } else {

                System.out.println(Utils.tab(depth) +
                        "Tomar derecha " + R[j]);

                array[k++] = R[j++];
            }

            System.out.println(Utils.tab(depth) +
                    "Array: " + Utils.a(array));
        }

        while (i < n1) {
            System.out.println(Utils.tab(depth) +
                    "Restante izquierda " + L[i]);
            array[k++] = L[i++];
        }

        while (j < n2) {
            System.out.println(Utils.tab(depth) +
                    "Restante derecha " + R[j]);
            array[k++] = R[j++];
        }
    }
}
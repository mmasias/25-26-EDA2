public class MergeSort {

    public static void ordenarIterativo(int[] array) {

        System.out.println("=== MERGE SORT ITERATIVO ===");
        System.out.println("Inicial: " + Utils.a(array));

        int n = array.length;

        for (int tam = 1; tam < n; tam *= 2) {

            System.out.println("\nTamaño bloque: " + tam);

            for (int izq = 0; izq < n - tam; izq += 2 * tam) {

                int medio = izq + tam - 1;
                int der = Math.min(izq + 2 * tam - 1, n - 1);

                System.out.println("Fusionar (" + izq + "," + medio + "," + der + ")");

                fusionar(array, izq, medio, der);

                System.out.println("Array: " + Utils.a(array));
            }
        }

        System.out.println("Final: " + Utils.a(array));
    }

    private static void fusionar(int[] array, int izq, int medio, int der) {

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

            System.out.println("Comparar " + L[i] + " <= " + R[j]);

            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];
    }
}
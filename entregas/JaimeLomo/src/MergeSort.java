import java.util.Arrays;

public class MergeSort {

    public static void ordenarRecursivo(int[] array, int izq, int der) {
        if (izq == 0 && der == array.length - 1) {
            System.out.println("\n>>> INICIO: Merge Sort Recursivo");
            Soporte.trazarEstado("Estado inicial: ", array);
        }

        if (izq >= der) {
            Soporte.trazar("Caso Base: Segmento [" + izq + "," + der + "] es unitario.");
            return;
        }

        int med = izq + (der - izq) / 2;
        Soporte.trazar("Dividiendo: [" + izq + " - " + med + "] y [" + (med + 1) + " - " + der + "]");
        
        Soporte.indentar();
        ordenarRecursivo(array, izq, med);
        ordenarRecursivo(array, med + 1, der);
        Soporte.desindentar();

        fusionar(array, izq, med, der);
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("\n>>> INICIO: Merge Sort Iterativo");
        Soporte.trazarEstado("Estado inicial: ", array);
        int n = array.length;

        for (int curr_size = 1; curr_size <= n - 1; curr_size = 2 * curr_size) {
            Soporte.trazar("\n[Tamano de bloques a fusionar: " + curr_size + "]");
            
            for (int left_start = 0; left_start < n - 1; left_start += 2 * curr_size) {
                int mid = Math.min(left_start + curr_size - 1, n - 1);
                int right_end = Math.min(left_start + 2 * curr_size - 1, n - 1);

                Soporte.trazar("Agrupando tramos: izq=" + left_start + ", med=" + mid + ", der=" + right_end);
                fusionar(array, left_start, mid, right_end);
            }
        }
        System.out.println("<<< FIN: Array ordenado.");
    }

    private static void fusionar(int[] array, int izq, int med, int der) {
        int n1 = med - izq + 1;
        int n2 = der - med;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = array[izq + i];
        for (int j = 0; j < n2; j++) R[j] = array[med + 1 + j];

        Soporte.trazar("Fusion: L" + Arrays.toString(L) + " con R" + Arrays.toString(R));

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            Soporte.trazar("  Comparacion: L[" + i + "]=" + L[i] + " vs R[" + j + "]=" + R[j]);
            if (L[i] <= R[j]) {
                Soporte.trazar("    -> Toma L[" + i + "]");
                array[k] = L[i];
                i++;
            } else {
                Soporte.trazar("    -> Toma R[" + j + "]");
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) { array[k++] = L[i++]; }
        while (j < n2) { array[k++] = R[j++]; }
        Soporte.trazarEstado("  Estado tras fusion: ", array);
    }
}
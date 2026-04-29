public class InsertionSort {

    public static void ordenarIterativo(int[] array) {
        System.out.println("\n>>> INICIO: Insertion Sort Iterativo");
        Soporte.trazarEstado("Estado inicial: ", array);

        for (int i = 1; i < array.length; i++) {
            Soporte.trazar("\nIteracion i=" + i + " (Valor actual: " + array[i] + ")");
            int actual = array[i];
            int j = i - 1;

            Soporte.evaluarWhileInsertion(j, array, actual);
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                Soporte.trazar("  Accion: Desplaza " + array[j] + " al indice " + (j + 1));
                j--;
                Soporte.evaluarWhileInsertion(j, array, actual);
            }
            array[j + 1] = actual;
            Soporte.trazar("  Accion: Inserta " + actual + " en indice " + (j + 1));
            Soporte.trazarEstado("  Array parcial: ", array);
        }
        System.out.println("<<< FIN: Array ordenado.");
    }

    public static void ordenarRecursivo(int[] array, int n) {
        if (n == array.length) {
            System.out.println("\n>>> INICIO: Insertion Sort Recursivo");
            Soporte.trazarEstado("Estado inicial: ", array);
        }

        if (n <= 1) {
            Soporte.trazar("Caso Base: n=" + n + " (Elemento unico ya ordenado)");
            return;
        }

        Soporte.trazar("Llamada Recursiva: n=" + n);
        Soporte.indentar();
        ordenarRecursivo(array, n - 1);
        Soporte.desindentar();

        int ultimo = array[n - 1];
        int j = n - 2;

        Soporte.trazar("Retorno: Insertando " + ultimo + " en el segmento anterior");
        Soporte.evaluarWhileInsertion(j, array, ultimo);
        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            j--;
            Soporte.evaluarWhileInsertion(j, array, ultimo);
        }
        array[j + 1] = ultimo;
        Soporte.trazarEstado("  Estado tras retorno: ", array);
    }
}
public class QuickSort {

    public static void ordenar(int[] array, int izq, int der) {
        if (izq == 0 && der == array.length - 1) {
            System.out.println("\n>>> INICIO: Quick Sort");
            Soporte.trazarEstado("Estado inicial: ", array);
        }

        if (izq < der) {
            int pi = particionar(array, izq, der);
            Soporte.trazar("Pivote colocado en indice " + pi);
            
            Soporte.indentar();
            ordenar(array, izq, pi - 1);
            ordenar(array, pi + 1, der);
            Soporte.desindentar();
        } else {
            Soporte.trazar("Caso Base: Segmento [" + izq + "," + der + "] no requiere particion.");
        }
    }

    private static int particionar(int[] array, int izq, int der) {
        int pivote = array[der];
        Soporte.trazar("Particion: usando pivote=" + pivote + " en indice " + der);
        int i = (izq - 1);

        for (int j = izq; j < der; j++) {
            Soporte.trazar("  Comparando array[" + j + "]=" + array[j] + " <= " + pivote);
            if (array[j] <= pivote) {
                i++;
                Soporte.trazar("    -> TRUE. Intercambio indice " + i + " con " + j);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[der];
        array[der] = temp;
        Soporte.trazarEstado("  Estado tras particion: ", array);
        return i + 1;
    }
}
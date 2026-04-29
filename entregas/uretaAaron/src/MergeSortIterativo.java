public class MergeSortIterativo {
    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + TrazaUtils.fmt(array));
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Tamaño de bloque: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("Estado final: " + TrazaUtils.fmt(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        System.out.println("  Fusionando [" + izquierda + "," + medio + "] con [" + (medio+1) + "," + derecha + "]");
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        for (int i = 0; i < tamanoIzquierda; i++) mitadIzquierda[i] = array[izquierda + i];
        for (int i = 0; i < tamanoDerecha; i++) mitadDerecha[i] = array[medio + 1 + i];

        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i]; i++;
            } else {
                array[k] = mitadDerecha[j]; j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) { array[k] = mitadIzquierda[i]; i++; k++; }
        while (j < tamanoDerecha) { array[k] = mitadDerecha[j]; j++; k++; }
        System.out.println("  Estado parcial: " + TrazaUtils.fmt(array));
    }
}
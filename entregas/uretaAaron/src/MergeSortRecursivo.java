public class MergeSortRecursivo {
    public static void ordenar(int[] array, int izquierda, int derecha) {
        TrazaUtils.imprimir("-> ordenar(izq=" + izquierda + ", der=" + derecha + ") sub:" + TrazaUtils.fmt(array, izquierda, derecha));
        if (izquierda >= derecha) {
            TrazaUtils.imprimir("CASO BASE: izq >= der (" + izquierda + " >= " + derecha + ").");
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        
        TrazaUtils.nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        TrazaUtils.nivelRecursion--;

        fusionar(array, izquierda, medio, derecha);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        TrazaUtils.imprimir("Fusionando: " + TrazaUtils.fmt(array, izquierda, medio) + " y " + TrazaUtils.fmt(array, medio + 1, derecha));
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++) mitadIzquierda[i] = array[izquierda + i];
        for (int i = 0; i < tamanoDerecha; i++) mitadDerecha[i] = array[medio + 1 + i];

        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            TrazaUtils.imprimir("  Comparando " + mitadIzquierda[i] + " <= " + mitadDerecha[j]);
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                TrazaUtils.imprimir("  (SÍ) -> " + mitadIzquierda[i]);
                array[k] = mitadIzquierda[i]; i++;
            } else {
                TrazaUtils.imprimir("  (NO) -> " + mitadDerecha[j]);
                array[k] = mitadDerecha[j]; j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) { array[k] = mitadIzquierda[i]; i++; k++; }
        while (j < tamanoDerecha) { array[k] = mitadDerecha[j]; j++; k++; }
        TrazaUtils.imprimir("Resultado fusión: " + TrazaUtils.fmt(array, izquierda, derecha));
    }
}
public class InsertionSortRecursivo {
    public static void ordenar(int[] array, int n) {
        TrazaUtils.imprimir("-> Llamada ordenar(n=" + n + ") sobre " + TrazaUtils.fmt(array, 0, n - 1));
        if (n <= 1) {
            TrazaUtils.imprimir("CASO BASE alcanzado: n=" + n + ". Retornando.");
            return;
        }
        
        TrazaUtils.nivelRecursion++;
        ordenar(array, n - 1);
        TrazaUtils.nivelRecursion--;

        int ultimo = array[n - 1];
        int j = n - 2;
        TrazaUtils.imprimir("Insertando último=" + ultimo + " en sub-array ordenado.");

        while (j >= 0 && array[j] > ultimo) {
            TrazaUtils.imprimir("  Decisión: array[" + j + "]=" + array[j] + " > " + ultimo + " (SÍ). Desplazando.");
            array[j + 1] = array[j];
            j--;
            TrazaUtils.imprimir("  Array: " + TrazaUtils.fmt(array));
        }
        if (j >= 0) TrazaUtils.imprimir("  Decisión: array[" + j + "]=" + array[j] + " > " + ultimo + " (NO).");
        
        array[j + 1] = ultimo;
        TrazaUtils.imprimir("Resultado inserción: " + TrazaUtils.fmt(array));
    }
}
public class QuickSort {
    public static void ordenar(int[] array, int izquierda, int derecha) {
        TrazaUtils.imprimir("-> ordenar(izq=" + izquierda + ", der=" + derecha + ") sub:" + TrazaUtils.fmt(array, izquierda, derecha));
        if (izquierda >= derecha) {
            TrazaUtils.imprimir("CASO BASE: izq >= der (" + izquierda + " >= " + derecha + ").");
            return;
        }
        
        int indicePivote = particionar(array, izquierda, derecha);
        
        TrazaUtils.nivelRecursion++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        TrazaUtils.nivelRecursion--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        TrazaUtils.imprimir("Particionando con pivote=" + pivote);
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            TrazaUtils.imprimir("  ¿array[" + j + "]=" + array[j] + " <= " + pivote + "?");
            if (array[j] <= pivote) {
                i++;
                TrazaUtils.imprimir("    SÍ. Swap array[" + i + "]=" + array[i] + " con array[" + j + "]=" + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                TrazaUtils.imprimir("    Array: " + TrazaUtils.fmt(array));
            }
        }
        TrazaUtils.imprimir("  Colocando pivote en posición final: Swap array[" + (i+1) + "]=" + array[i+1] + " con array[" + derecha + "]=" + array[derecha]);
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        TrazaUtils.imprimir("Pivote fijado en índice " + (i+1) + ". Array: " + TrazaUtils.fmt(array));
        return i + 1;
    }
}
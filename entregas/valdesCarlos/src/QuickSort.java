public class QuickSort {

    private static int profundidadRecursion = 0;

    private static String getIndent() {
        String indentacion = "";
        for (int i = 0; i < profundidadRecursion; i++) {
            indentacion += "  ";
        }
        return indentacion;
    }

    private static String arrayToString(int[] array) {
        if (array.length == 0) return "[]";
        String resultado = "[";
        for (int i = 0; i < array.length; i++) {
            resultado += array[i];
            if (i < array.length - 1) resultado += ", ";
        }
        resultado += "]";
        return resultado;
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (profundidadRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial: " + arrayToString(array));
        }

        System.out.println(getIndent() + "Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(getIndent() + "-> Caso base alcanzado (izq >= der). El subarray está vacío o tiene 1 elemento.");
            return;
        }

        System.out.println(getIndent() + "Particionando array entre índices " + izquierda + " y " + derecha);
        int indicePivote = particionar(array, izquierda, derecha);
        
        profundidadRecursion++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        profundidadRecursion--;

        if (profundidadRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado final: " + arrayToString(array));
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        System.out.println(getIndent() + "  [Partición] Pivote elegido: array[" + derecha + "] = " + pivote);
        
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            boolean condicion = (array[j] <= pivote);
            System.out.println(getIndent() + "  Comparando array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " -> " + condicion);
            
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(getIndent() + "  Intercambio realizado (<= pivote): array[" + i + "]=" + array[i] + " con array[" + j + "]=" + array[j] + " -> " + arrayToString(array));
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(getIndent() + "  Colocando el pivote en su posición definitiva: intercambio array[" + (i + 1) + "]=" + array[i + 1] + " con array[" + derecha + "]=" + array[derecha] + " -> " + arrayToString(array));
        
        return i + 1;
    }
}
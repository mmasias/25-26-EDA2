import java.util.Arrays;

public class QuickSort {

    private static int quickDepth = 0;

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String indent = getIndent(quickDepth);
        System.out.println(indent + "Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(indent + "[i] Caso base alcanzado: izquierda (" + izquierda + ") >= derecha (" + derecha + "). Retornando.");
            return;
        }
        
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(indent + "[i] Posición definitiva del pivote fijada en índice: " + indicePivote);
        
        quickDepth++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        quickDepth--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String indent = getIndent(quickDepth) + "  ";
        int pivote = array[derecha];
        System.out.println(indent + "Seleccionando pivote: " + pivote + " (en índice " + derecha + ")");
        
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            boolean comparacion = array[j] <= pivote;
            System.out.println(indent + "[?] Comparando array[" + j + "] (" + array[j] + ") <= pivote (" + pivote + ") -> " + comparacion);
            
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                
                if (i != j) {
                    System.out.println(indent + "[!] Intercambio realizado: índices " + i + " y " + j + " -> " + Arrays.toString(array));
                } else {
                    System.out.println(indent + "[i] No hay intercambio visible (el elemento es menor y ya está en su zona de partición).");
                }
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println(indent + "[!] Colocando pivote en su posición final: intercambio de índices " + (i + 1) + " y " + derecha + " -> " + Arrays.toString(array));
        return i + 1;
    }
}
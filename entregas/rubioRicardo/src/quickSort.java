import java.util.Arrays;

public class quickSort {

    private static int nivelRecursion = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        imprimirInicio(array, izquierda, derecha);
        
        String tab = obtenerIndentacion(nivelRecursion);
        System.out.println(tab + "Llamada: ordenar(array, izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(tab + "  [Caso Base Alcanzado] izq (" + izquierda + ") >= der (" + derecha + ").");
            return;
        }
        
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(tab + "  Pivote final establecido en el índice: " + indicePivote);
        
        nivelRecursion++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        nivelRecursion--;
        
        imprimirFin(array, izquierda, derecha);
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String tab = obtenerIndentacion(nivelRecursion) + "    ";
        
        int pivote = array[derecha];
        System.out.println(tab + "Pivote seleccionado: array[" + derecha + "] = " + pivote);
        
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.println(tab + "[Comparación] array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " -> " + (array[j] <= pivote));
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(tab + "  Intercambio realizado. Array resultante: " + Arrays.toString(array));
            }
        }
        
        System.out.println(tab + "Fin de partición. Intercambio final de pivote (array[" + derecha + "]) con array[" + (i + 1) + "]=" + array[i + 1]);
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(tab + "Array tras posicionar pivote: " + Arrays.toString(array));
        
        return i + 1;
    }

    
    private static void imprimirInicio(int[] array, int izquierda, int derecha) {
        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial: " + Arrays.toString(array));
        }
    }

    private static void imprimirFin(int[] array, int izquierda, int derecha) {
        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("\nEstado final: " + Arrays.toString(array));
        }
    }

    private static String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) sb.append("    ");
        return sb.toString();
    }
}
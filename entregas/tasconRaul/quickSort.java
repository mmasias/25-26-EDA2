package entregas.tasconRaul;

import java.util.Arrays;

public class quickSort {

    private static int profQuick = 0;

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) sb.append("    ");
        return sb.toString();
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (profQuick == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial: " + Arrays.toString(array));
        }
        String ind = getIndent(profQuick);

        if (izquierda >= derecha) {
            System.out.println(ind + "Caso base: izquierda (" + izquierda + ") >= derecha (" + derecha + "). El sub-array está ordenado o vacío.");
            return;
        }

        System.out.println(ind + "Iniciando particionado de sub-array [" + izquierda + ".." + derecha + "]");
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(ind + "Particionado completado. El pivote definitivo está en el índice " + indicePivote + " con el valor " + array[indicePivote]);

        System.out.println(ind + "Llamada recursiva a la mitad menor (izquierda) [" + izquierda + ".." + (indicePivote - 1) + "]");
        profQuick++;
        ordenar(array, izquierda, indicePivote - 1);
        profQuick--;

        System.out.println(ind + "Llamada recursiva a la mitad mayor (derecha) [" + (indicePivote + 1) + ".." + derecha + "]");
        profQuick++;
        ordenar(array, indicePivote + 1, derecha);
        profQuick--;

        if (profQuick == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("\nEstado final: " + Arrays.toString(array));
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String ind = getIndent(profQuick) + "  ";
        int pivote = array[derecha];
        System.out.println(ind + "Pivote seleccionado: " + pivote + " (en el índice " + derecha + ")");
        
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            boolean condicion = array[j] <= pivote;
            System.out.println(ind + "Comparación: array[" + j + "] (" + array[j] + ") <= pivote (" + pivote + ") -> " + condicion);
            
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                
                if (i != j) {
                    System.out.println(ind + "Intercambio: array[" + i + "] con array[" + j + "]. Estado: " + Arrays.toString(array));
                } else {
                    System.out.println(ind + "Auto-intercambio (i == j): el elemento se queda en su lugar.");
                }
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(ind + "Posicionando el pivote: intercambio de array[" + (i + 1) + "] con array[" + derecha + "]. Estado: " + Arrays.toString(array));
        
        return i + 1;
    }
}
import java.util.Arrays;

public class InsertionSort {

    private static int nivelRecursion = 0;

    private static String getInd() {
        return "  ".repeat(Math.max(0, nivelRecursion));
    }

    public static void ordenar(int[] array) {
        System.out.println("=== INSERTION SORT ITERATIVO ===");
        System.out.println("Estado Inicial: " + Arrays.toString(array));
        
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\nIteracion " + i + " | Elemento a insertar: " + actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparando array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> SI");
                System.out.println("  Desplazando " + array[j] + " a la derecha.");
                array[j + 1] = array[j];
                j--;
                System.out.println("  Estado temporal: " + Arrays.toString(array));
            }
            
            if (j >= 0) {
                System.out.println("  Comparando array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> NO (Posicion encontrada)");
            } else {
                System.out.println("  Se alcanzo el limite izquierdo del array.");
            }
            
            array[j + 1] = actual;
            System.out.println("Resultado de la iteracion: " + Arrays.toString(array));
        }
        System.out.println("\nEstado Final: " + Arrays.toString(array) + "\n");
    }
    public static void ordenar(int[] array, int n) {
        if (nivelRecursion == 0) {
            System.out.println("=== INSERTION SORT RECURSIVO ===");
            System.out.println("Estado Inicial: " + Arrays.toString(array));
        }
        
        System.out.println(getInd() + "Llamada recursiva (n = " + n + ")");
        
        if (n <= 1) {
            System.out.println(getInd() + "CASO BASE: n <= 1. Subarray considerado ordenado.");
            return;
        }
        
        nivelRecursion++;
        ordenar(array, n - 1);
        nivelRecursion--;
        
        int ultimo = array[n - 1];
        int j = n - 2;
        
        System.out.println("\n" + getInd() + "Retorno a n = " + n + " | Elemento a insertar: " + ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(getInd() + "  Comparando array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> SI");
            System.out.println(getInd() + "  Desplazando " + array[j] + " a la derecha.");
            array[j + 1] = array[j];
            j--;
            System.out.println(getInd() + "  Estado temporal: " + Arrays.toString(array));
        }
        
        if (j >= 0) {
            System.out.println(getInd() + "  Comparando array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> NO (Posicion encontrada)");
        } else {
            System.out.println(getInd() + "  Se alcanzo el limite izquierdo del array.");
        }
        
        array[j + 1] = ultimo;
        System.out.println(getInd() + "Resultado en este nivel: " + Arrays.toString(array));
        
        if (nivelRecursion == 0) {
            System.out.println("\nEstado Final: " + Arrays.toString(array) + "\n");
        }
    }
}
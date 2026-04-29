public class InsertionSort {

    private static String arrToString(int[] arr) {
        String res = "[";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + (i < arr.length - 1 ? ", " : "");
        }
        return res + "]";
    }

    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    public static void ordenar(int[] array) {
        System.out.println("Inicio Insertion Sort (Iterativo)");
        System.out.println("Estado inicial: " + arrToString(array));
        
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\nIteracion i=" + i + ", elemento a insertar=" + actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("  array[" + j + "]=" + array[j] + " > " + actual + " -> Si. Desplazamos a la derecha.");
                array[j + 1] = array[j];
                j--;
                System.out.println("  Array: " + arrToString(array));
            }
            if (j >= 0) {
                System.out.println("  array[" + j + "]=" + array[j] + " > " + actual + " -> No. Paramos de desplazar.");
            }
            array[j + 1] = actual;
            System.out.println("  Insertamos " + actual + " en la posicion " + (j + 1));
            System.out.println("  Array tras iteracion: " + arrToString(array));
        }
        System.out.println("\nEstado final: " + arrToString(array));
    }

    private static int depth = 0;

    public static void ordenar(int[] array, int n) {
        printIndent(depth);
        System.out.println("Llamada ordenar(n=" + n + ")");
        
        if (n <= 1) {
            printIndent(depth);
            System.out.println("Caso base alcanzado: n <= 1. El array ya esta ordenado.");
            return;
        }
        
        depth++;
        ordenar(array, n - 1);
        depth--;
        
        int ultimo = array[n - 1];
        int j = n - 2;
        
        printIndent(depth);
        System.out.println("Volviendo de recursion, vamos a insertar el elemento " + ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            printIndent(depth);
            System.out.println("  array[" + j + "]=" + array[j] + " > " + ultimo + " -> Si. Desplazamos.");
            array[j + 1] = array[j];
            j--;
        }
        if (j >= 0) {
            printIndent(depth);
            System.out.println("  array[" + j + "]=" + array[j] + " > " + ultimo + " -> No.");
        }
        array[j + 1] = ultimo;
        
        printIndent(depth);
        System.out.println("  Elemento " + ultimo + " insertado. Array actual: " + arrToString(array));
    }

    public static void main(String[] args) {
        int[] array1 = {5, 2, 8, 1, 9, 3};
        ordenar(array1);
        
        System.out.println("\n-------------------------------------------------\n");
        
        int[] array2 = {5, 2, 8, 1, 9, 3};
        System.out.println("Inicio Insertion Sort (Recursivo)");
        System.out.println("Estado inicial: " + arrToString(array2));
        depth = 0;
        ordenar(array2, array2.length);
        System.out.println("\nEstado final: " + arrToString(array2));
    }
}

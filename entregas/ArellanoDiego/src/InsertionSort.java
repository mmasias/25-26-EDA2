import java.util.Arrays;

public class InsertionSort {

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
        
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("Iteración i=" + i + " | Elemento a insertar (actual): " + actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("  [?] Comparando array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> true");
                array[j + 1] = array[j];
                System.out.println("  [!] Desplazando " + array[j] + " a la derecha: " + Arrays.toString(array));
                j--;
            }
            
            if (j >= 0) {
                System.out.println("  [?] Comparando array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> false. Fin desplazamiento.");
            } else {
                System.out.println("  [i] Se alcanzó el inicio del array. Fin desplazamiento.");
            }
            
            array[j + 1] = actual;
            System.out.println("  [!] Insertando actual (" + actual + ") en índice " + (j + 1) + ": " + Arrays.toString(array));
        }
        
        System.out.println("Estado final: " + Arrays.toString(array));
    }

    public static void ordenar(int[] array, int n) {
        int depth = array.length - n;
        String indent = getIndent(depth);
        
        System.out.println(indent + "Llamada ordenar(n=" + n + ")");
        
        if (n <= 1) {
            System.out.println(indent + "[i] Caso base alcanzado (n <= 1). Retornando.");
            return;
        }
        
        ordenar(array, n - 1);
        
        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(indent + "Retorno a n=" + n + " | Elemento a insertar (ultimo): " + ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(indent + "  [?] Comparando array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> true");
            array[j + 1] = array[j];
            System.out.println(indent + "  [!] Desplazando " + array[j] + " a la derecha: " + Arrays.toString(array));
            j--;
        }
        
        if (j >= 0) {
            System.out.println(indent + "  [?] Comparando array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> false.");
        } else {
            System.out.println(indent + "  [i] Se alcanzó el inicio del array.");
        }
        
        array[j + 1] = ultimo;
        System.out.println(indent + "  [!] Insertando ultimo (" + ultimo + ") en índice " + (j + 1) + ": " + Arrays.toString(array));
    }
}
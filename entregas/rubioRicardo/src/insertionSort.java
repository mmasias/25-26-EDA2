import java.util.Arrays;

public class insertionSort {

    private static int nivelRecursion = 0;

    
    public static void ordenar(int[] array) {
        System.out.println("Estado inicial (Iterativo): " + Arrays.toString(array));
        
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            System.out.println("\n-> Iniciando paso " + i + " | Evaluando elemento a insertar: " + actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("  [Comparación/Bucle] j=" + j + " >= 0 y array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> VERDADERO. Desplazando.");
                array[j + 1] = array[j];
                System.out.println("    Array resultante: " + Arrays.toString(array));
                j--;
            }
            
            System.out.println("  [Fin de Bucle] Condición incumplida. Terminando desplazamientos.");
            array[j + 1] = actual;
            System.out.println("  [Inserción] Colocando " + actual + " en el índice " + (j + 1) + ". Array actual: " + Arrays.toString(array));
        }
        
        System.out.println("\nEstado final (Iterativo): " + Arrays.toString(array));
    }

  
    public static void ordenar(int[] array, int n) {
        imprimirInicioRecursivo(array, n);
        
        String tab = obtenerIndentacion(nivelRecursion);
        System.out.println(tab + "Llamada: ordenar(array, n=" + n + ")");
        
        if (n <= 1) {
            System.out.println(tab + "  [Caso Base Alcanzado] n <= 1.");
            return;
        }
        
        nivelRecursion++;
        ordenar(array, n - 1);
        nivelRecursion--;
        
        int ultimo = array[n - 1];
        int j = n - 2;
        
        System.out.println(tab + "-> Evaluando insertar elemento: " + ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(tab + "  [Comparación/Bucle] j=" + j + " >= 0 y array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> VERDADERO. Desplazando.");
            array[j + 1] = array[j];
            System.out.println(tab + "    Array resultante: " + Arrays.toString(array));
            j--;
        }
        
        System.out.println(tab + "  [Fin de Bucle] Condición incumplida. Terminando desplazamientos.");
        array[j + 1] = ultimo;
        System.out.println(tab + "  [Inserción] Colocando " + ultimo + " en el índice " + (j + 1) + ". Array actual: " + Arrays.toString(array));
        
        imprimirFinRecursivo(array);
    }

   
    private static void imprimirInicioRecursivo(int[] array, int n) {
        if (nivelRecursion == 0 && n == array.length) {
            System.out.println("Estado inicial (Recursivo): " + Arrays.toString(array));
        }
    }

    private static void imprimirFinRecursivo(int[] array) {
        if (nivelRecursion == 0) {
            System.out.println("\nEstado final (Recursivo): " + Arrays.toString(array));
        }
    }

    private static String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) sb.append("    ");
        return sb.toString();
    }
}
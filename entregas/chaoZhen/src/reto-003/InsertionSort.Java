public class InsertionSort {   
    
    public static void main(String[] args) {
        int[] arrayIterativo = {5, 2, 8, 1, 9, 3};
        System.out.println("--- METODO ITERATIVO ---");
        System.out.println("Estado inicial: " + imprimirArray(arrayIterativo));
        ordenar(arrayIterativo);
        System.out.println("Estado final: " + imprimirArray(arrayIterativo));

        System.out.println("\n--- METODO RECURSIVO ---");
        int[] arrayRecursivo = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + imprimirArray(arrayRecursivo));
        ordenar(arrayRecursivo, arrayRecursivo.length);
        System.out.println("Estado final: " + imprimirArray(arrayRecursivo));
    }

    
    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            System.out.println("\nIteracion i=" + i + " | numero actual=" + actual);
            System.out.println("  Compara j>=0 (" + (j >= 0) + ")" + (j >= 0 ? " y array[" + j + "]=" + array[j] + " > actual=" + actual + " -> " + (array[j] > actual) : " -> Falso"));

            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                j--;
                
                System.out.println("  Desplaza: " + imprimirArray(array));
                System.out.println("  Compara j>=0 (" + (j >= 0) + ")" + (j >= 0 ? " y array[" + j + "]=" + array[j] + " > actual=" + actual + " -> " + (array[j] > actual) : " -> Falso"));
            }
            array[j + 1] = actual;
            System.out.println("  Inserta: " + imprimirArray(array));
        }
    }

    
    public static void ordenar(int[] array, int n) {
        String indent = obtenerIndentacion(array.length - n);
        System.out.println(indent + "Llamada recursiva n=" + n);

        if (n <= 1) {
            System.out.println(indent + "-> CASO BASE: n <= 1. El subarray tiene 1 elemento (ya esta ordenado).");
            return;
        }
        ordenar(array, n - 1);
        int ultimo = array[n - 1];
        int j = n - 2;
        
        System.out.println("\n" + indent + "Retorno de recursion n=" + n + " | ultimo numero=" + ultimo);
        System.out.println(indent + "  Compara j>=0 (" + (j >= 0) + ")" + (j >= 0 ? " y array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> " + (array[j] > ultimo) : " -> Falso"));

        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            j--;
            
            System.out.println(indent + "  Desplaza: " + imprimirArray(array));
            System.out.println(indent + "  Compara j>=0 (" + (j >= 0) + ")" + (j >= 0 ? " y array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> " + (array[j] > ultimo) : " -> Falso"));
        }
        array[j + 1] = ultimo;
        System.out.println(indent + "  Inserta: " + imprimirArray(array));
    }

    
   public static String imprimirArray(int[] array) {
        String resultadoArray = "[";
        for (int i = 0; i < array.length; i++) {
            resultadoArray += array[i] + (i < array.length - 1 ? ", " : "");
        }
        return resultadoArray + "]";
    }

    public static String obtenerIndentacion(int nivel) {
        String espaciosIndentacion = "";
        for (int i = 0; i < nivel; i++) {
            espaciosIndentacion += "    "; 
        }
        return espaciosIndentacion;
    }
}
public class InsertionSortTraza {

    private static int profundidad = 0;
    private static boolean esPrimeraLlamada = true;

    private static String formatearArray(int[] arr) {
        String resultado = "[";
        for (int i = 0; i < arr.length; i++) {
            resultado += arr[i];
            if (i < arr.length - 1) {
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }

    private static String ind() {
        String espacios = "";
        for (int i = 0; i < profundidad; i++) {
            espacios += "  ";
        }
        return espacios;
    }

    private static void trazaInicioIterativo(int[] array) {
        System.out.println("Estado inicial: " + formatearArray(array));
    }

    private static void trazaFin(int[] array) {
        System.out.println("Estado final: " + formatearArray(array));
    }

    private static void trazaFalloWhile(int[] array, int j, int valorComparado) {
        if (j >= 0) {
            System.out.println(ind() + "  Comparando array[" + j + "] (" + array[j] + ") > actual/ultimo (" + valorComparado + ") -> false. Fin desplazamiento.");
        } else {
            System.out.println(ind() + "  Evaluando (j >= 0) -> false (j = " + j + "). Fin desplazamiento.");
        }
    }

    private static void trazaInicioRecursivo(int[] array, int n) {
        if (esPrimeraLlamada) {
            System.out.println("Estado inicial: " + formatearArray(array));
            esPrimeraLlamada = false;
        }
        System.out.println(ind() + "ordenar(array, n=" + n + ")");
    }

    private static void trazaFinRecursivo(int[] array, int n) {
        if (n == array.length) {
            trazaFin(array);
            esPrimeraLlamada = true; 
        }
    }

    public static void ordenar(int[] array) {
        trazaInicioIterativo(array);
        
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            System.out.println("-> Iteración i=" + i + ", evaluando valor: " + actual);
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("  Comparando array[" + j + "] (" + array[j] + ") > actual (" + actual + ") -> true. Desplazando.");
                array[j + 1] = array[j];
                System.out.println("  " + formatearArray(array));
                j--;
            }
            trazaFalloWhile(array, j, actual);
            
            array[j + 1] = actual;
            System.out.println("  Insertando " + actual + " en el índice " + (j + 1) + ": " + formatearArray(array));
        }
        
        trazaFin(array);
    }

    public static void ordenar(int[] array, int n) {
        trazaInicioRecursivo(array, n);
        
        if (n <= 1) {
            System.out.println(ind() + "  Caso base alcanzado: n (" + n + ") <= 1. Subarray ordenado por definición.");
            return;
        }
        
        profundidad++;
        ordenar(array, n - 1);
        profundidad--;
        
        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(ind() + "-> Insertando elemento array[" + (n - 1) + "] = " + ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind() + "  Comparando array[" + j + "] (" + array[j] + ") > ultimo (" + ultimo + ") -> true. Desplazando.");
            array[j + 1] = array[j];
            System.out.println(ind() + "  " + formatearArray(array));
            j--;
        }
        trazaFalloWhile(array, j, ultimo);
        
        array[j + 1] = ultimo;
        System.out.println(ind() + "  Insertando " + ultimo + " en el índice " + (j + 1) + ": " + formatearArray(array));
        
        trazaFinRecursivo(array, n);
    }

    public static void main(String[] args) {
        int[] arrayDePrueba1 = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== PROBANDO VERSIÓN ITERATIVA ===");
        ordenar(arrayDePrueba1);
        
        System.out.println("\n"); 
        
        int[] arrayDePrueba2 = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== PROBANDO VERSIÓN RECURSIVA ===");
        ordenar(arrayDePrueba2, arrayDePrueba2.length);
    }
}
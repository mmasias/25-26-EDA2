public class QuickSortTraza {

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

    private static void trazaLlamada(int[] arr, int izq, int der) {
        if (esPrimeraLlamada) {
            System.out.println("Estado inicial: " + formatearArray(arr));
            esPrimeraLlamada = false;
        }
        System.out.println(ind() + "ordenar(izq=" + izq + ", der=" + der + ")");
    }

    private static void trazaCasoBase(int izq, int der) { 
        System.out.println(ind() + "  Caso base: izq (" + izq + ") >= der (" + der + "). Retorno."); 
    }
    
    private static void trazaPivote(int pivote, int der) { 
        System.out.println(ind() + "  Pivote elegido: " + pivote + " (en índice " + der + ")"); 
    }
    
    // Este método evalúa la condición para mostrarla por pantalla, sin alterar el IF original
    private static void trazaComparacionQS(int val, int pivote) {
        System.out.println(ind() + "  Comparando array[j] (" + val + ") <= pivote (" + pivote + ") -> " + (val <= pivote));
    }
    
    private static void trazaIntercambioQS(int[] arr) { 
        System.out.println(ind() + "    Se cumple. Intercambio realizado: " + formatearArray(arr)); 
    }
    
    private static void trazaColocarPivote(int[] arr, int pivote, int pos) { 
        System.out.println(ind() + "  Colocando pivote " + pivote + " en posición definitiva " + pos + ": " + formatearArray(arr)); 
    }
    
    private static void trazaLlamadaIzq(int izq, int der) { 
        System.out.println(ind() + "Llamada zona izquierda (izq=" + izq + ", der=" + der + ")"); 
    }
    
    private static void trazaLlamadaDer(int izq, int der) { 
        System.out.println(ind() + "Llamada zona derecha (izq=" + izq + ", der=" + der + ")"); 
    }
    
    private static void trazaFin(int[] arr, int izq, int der) {
        if (izq == 0 && der == arr.length - 1) {
            System.out.println("Estado final: " + formatearArray(arr));
            esPrimeraLlamada = true;
        }
    }

    // =================================================================
    // ALGORITMO ORIGINAL (Estructura de control 100% intacta)
    // =================================================================

    public static void ordenar(int[] array, int izquierda, int derecha) {
        trazaLlamada(array, izquierda, derecha);
        
        if (izquierda >= derecha) {
            trazaCasoBase(izquierda, derecha);
            return;
        }
        
        int indicePivote = particionar(array, izquierda, derecha);
        
        profundidad++;
        trazaLlamadaIzq(izquierda, indicePivote - 1);
        ordenar(array, izquierda, indicePivote - 1);
        
        trazaLlamadaDer(indicePivote + 1, derecha);
        ordenar(array, indicePivote + 1, derecha);
        profundidad--;
        
        trazaFin(array, izquierda, derecha);
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        trazaPivote(pivote, derecha);
        
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            trazaComparacionQS(array[j], pivote);
            
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                trazaIntercambioQS(array);
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        trazaColocarPivote(array, pivote, i + 1);
        
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};
        System.out.println("=== PROBANDO QUICK SORT ===");
        ordenar(arr, 0, arr.length - 1);
    }
}
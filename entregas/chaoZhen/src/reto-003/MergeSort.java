public class MergeSort {

    public static void main(String[] args) {
        int[] arrayIterativo = {5, 2, 8, 1, 9, 3};
        System.out.println("--- METODO ITERATIVO ---");
        System.out.println("Estado inicial: " + imprimirArray(arrayIterativo));
        ordenarIterativo(arrayIterativo);
        System.out.println("Estado final: " + imprimirArray(arrayIterativo));

        int[] arrayRecursivo = {5, 2, 8, 1, 9, 3};
        System.out.println("--- METODO RECURSIVO ---");
        System.out.println("Estado inicial: " + imprimirArray(arrayRecursivo));
        ordenar(arrayRecursivo, 0, arrayRecursivo.length - 1);
        System.out.println("Estado final: " + imprimirArray(arrayRecursivo));
    }

    
    public static void ordenar(int[] array, int izquierda, int derecha) {
        String indentacion = obtenerIndentacion();
        System.out.println(indentacion + "Llamada recursiva: ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        System.out.println(indentacion + "  Compara izq >= der (" + izquierda + " >= " + derecha + ") -> " + (izquierda >= derecha));
        
        if (izquierda >= derecha) {
            System.out.println(indentacion + "  -> CASO BASE: izquierda >= derecha. El subarray tiene 0 o 1 elemento (ya esta ordenado).");
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        
        System.out.println(indentacion + "  Se divide en medio=" + medio + ". Llamando a la mitad izquierda:");
        ordenar(array, izquierda, medio);
        
        System.out.println(indentacion + "  Volviendo de la izquierda. Llamando a la mitad derecha (izq=" + (medio + 1) + ", der=" + derecha + "):");
        ordenar(array, medio + 1, derecha);
        
        System.out.println(indentacion + "  Ambas mitades completadas. Llamando a fusionar(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + "):");
        fusionar(array, izquierda, medio, derecha);
    }

   
    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n[Iterativo] Bucle externo: tamano de sub-arrays a fusionar = " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("  Llamada a fusionar(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + ")");
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

   
    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String indentacion = obtenerIndentacion(); 
        System.out.println(indentacion + "[fusionar] Inicio fusionar: izq=" + izquierda + ", medio=" + medio + ", der=" + derecha);
        System.out.println("==========================================================================================");
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }
        
        System.out.println(indentacion + "  Arrays a fusionar -> Izquierda: " + imprimirArray(mitadIzquierda) + " | Derecha: " + imprimirArray(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;
        
        System.out.println(indentacion + "  [While principal] Evalua i<tamIzquierda ("+(i < tamanoIzquierda)+") && j<tamDerecha ("+(j < tamanoDerecha)+") -> " + (i < tamanoIzquierda && j < tamanoDerecha));
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println(indentacion + "    Compara mitadIzquierda["+i+"]=" + mitadIzquierda[i] + " <= mitadDerecha["+j+"]=" + mitadDerecha[j] + " -> " + (mitadIzquierda[i] <= mitadDerecha[j]));
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                System.out.println(indentacion + "    Toma de mitadIzquierda. array["+k+"] = " + mitadIzquierda[i] + " -> " + imprimirArray(array));
                i++;
            } else {
                array[k] = mitadDerecha[j];
                System.out.println(indentacion + "    Toma de mitadDerecha. array["+k+"] = " + mitadDerecha[j] + " -> " + imprimirArray(array));
                j++;
            }
            k++;
            System.out.println(indentacion + "  [While principal] Evalua i<tamIzquierda ("+(i < tamanoIzquierda)+") && j<tamDerecha ("+(j < tamanoDerecha)+") -> " + (i < tamanoIzquierda && j < tamanoDerecha));
        }
        
        System.out.println(indentacion + "  [While sobrante izq] Evalua i<tamIzquierda ("+(i < tamanoIzquierda)+") -> " + (i < tamanoIzquierda));
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(indentacion + "    Copia sobrante de mitadIzquierda. array["+k+"] = " + mitadIzquierda[i] + " -> " + imprimirArray(array));
            i++;
            k++;
            System.out.println(indentacion + "  [While sobrante izq] Evalua i<tamIzquierda ("+(i < tamanoIzquierda)+") -> " + (i < tamanoIzquierda));
        }
        
        System.out.println(indentacion + "  [While sobrante der] Evalua j<tamDerecha ("+(j < tamanoDerecha)+") -> " + (j < tamanoDerecha));
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(indentacion + "    Copia sobrante de mitadDerecha. array["+k+"] = " + mitadDerecha[j] + " -> " + imprimirArray(array));
            j++;
            k++;
            System.out.println(indentacion + "  [While sobrante der] Evalua j<tamDerecha ("+(j < tamanoDerecha)+") -> " + (j < tamanoDerecha));
        }
    }

    
    public static String imprimirArray(int[] a) {
        String resultadoArray = "[";
        for (int i = 0; i < a.length; i++) {
            resultadoArray += a[i] + (i < a.length - 1 ? ", " : "");
        }
        return resultadoArray + "]";
    }

    public static String obtenerIndentacion() {
        StackTraceElement[] pilaLlamadas = Thread.currentThread().getStackTrace();
        int nivelProfundidad = 0;
        
        for (StackTraceElement elementoLlamada : pilaLlamadas) {
            if (elementoLlamada.getMethodName().equals("ordenar")) {
                nivelProfundidad++;
            }
        }
        
        String espaciosIndentacion = "";
        for (int i = 1; i < nivelProfundidad; i++) {
            espaciosIndentacion += "    "; 
        }
        
       
        if (pilaLlamadas[2].getMethodName().equals("fusionar") && nivelProfundidad > 0) {
            espaciosIndentacion += "  ";
        }
        
        return espaciosIndentacion;
    }
}
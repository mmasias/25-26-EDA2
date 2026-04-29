public class MergeSortTraza {

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
        System.out.println(ind() + "  Caso base: izquierda (" + izq + ") >= derecha (" + der + "). Retorno.");
    }

    private static void trazaDivIzq() { System.out.println(ind() + "Dividiendo mitad izquierda:"); }
    private static void trazaDivDer() { System.out.println(ind() + "Dividiendo mitad derecha:"); }

    private static void trazaFin(int[] arr, int izq, int der) {
        if (izq == 0 && der == arr.length - 1) {
            System.out.println("Estado final: " + formatearArray(arr));
            esPrimeraLlamada = true;
        }
    }

    private static void trazaInicioIterativo(int[] arr) {
        System.out.println("Estado inicial: " + formatearArray(arr));
    }

    private static void trazaRondaIterativa(int t) {
        System.out.println("\n-> Ronda de fusiones con tamaño de bloque: " + t);
    }

    private static void trazaFinIterativo(int[] arr) {
        System.out.println("Estado final: " + formatearArray(arr));
    }

    private static void trazaInicioFusion(int izq, int med, int der) {
        System.out.println(ind() + "Fusionando subarrays [" + izq + ".." + med + "] y [" + (med + 1) + ".." + der + "]");
    }

    private static void trazaCompMerge(int valIzq, int valDer) {
        System.out.println(ind() + "  Comparando " + valIzq + " <= " + valDer + " -> " + (valIzq <= valDer));
    }

    private static void trazaTomaIzq(int val) { System.out.println(ind() + "    Se toma " + val + " de la mitad izquierda."); }
    private static void trazaTomaDer(int val) { System.out.println(ind() + "    Se toma " + val + " de la mitad derecha."); }
    private static void trazaResiduoIzq(int val) { System.out.println(ind() + "  Copiando residuo izquierdo: " + val); }
    private static void trazaResiduoDer(int val) { System.out.println(ind() + "  Copiando residuo derecho: " + val); }
    private static void trazaFinFusion(int[] arr) { System.out.println(ind() + "  Array resultante tras fusión: " + formatearArray(arr)); }

    // =================================================================
    // ALGORITMOS ORIGINALES (Estructura de control 100% intacta)
    // =================================================================

    public static void ordenar(int[] array, int izquierda, int derecha) {
        trazaLlamada(array, izquierda, derecha);
        
        if (izquierda >= derecha) {
            trazaCasoBase(izquierda, derecha);
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        
        profundidad++;
        trazaDivIzq();
        ordenar(array, izquierda, medio);
        trazaDivDer();
        ordenar(array, medio + 1, derecha);
        profundidad--;
        
        fusionar(array, izquierda, medio, derecha);
        
        trazaFin(array, izquierda, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        trazaInicioIterativo(array);
        
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            trazaRondaIterativa(tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
        
        trazaFinIterativo(array);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        trazaInicioFusion(izquierda, medio, derecha);
        
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
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            trazaCompMerge(mitadIzquierda[i], mitadDerecha[j]);
            
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                trazaTomaIzq(mitadIzquierda[i]);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                trazaTomaDer(mitadDerecha[j]);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        
        while (i < tamanoIzquierda) {
            trazaResiduoIzq(mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        
        while (j < tamanoDerecha) {
            trazaResiduoDer(mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
        
        trazaFinFusion(array);
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 8, 1, 9, 3};
        System.out.println("=== PROBANDO VERSIÓN ITERATIVA ===");
        ordenarIterativo(arr1);
        
        System.out.println("\n=== PROBANDO VERSIÓN RECURSIVA ===");
        int[] arr2 = {5, 2, 8, 1, 9, 3};
        ordenar(arr2, 0, arr2.length - 1);
    }
}

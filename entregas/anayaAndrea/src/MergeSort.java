public class MergeSort {

    private static String arrToString(int[] arr) {
        String res = "[";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + (i < arr.length - 1 ? ", " : "");
        }
        return res + "]";
    }

    private static String subArrToString(int[] arr, int ini, int fin) {
        if (ini > fin) return "[]";
        String res = "[";
        for (int i = ini; i <= fin; i++) {
            res += arr[i] + (i < fin ? ", " : "");
        }
        return res + "]";
    }

    private static void printIndent() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    private static int depth = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        printIndent();
        System.out.println("Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ") -> " + subArrToString(array, izquierda, derecha));
        
        if (izquierda >= derecha) {
            printIndent();
            System.out.println("Caso base alcanzado: izquierda >= derecha. Array de 1 o 0 elementos.");
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        
        depth++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        depth--;
        
        printIndent();
        System.out.println("Vamos a fusionar las mitades [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");
        
        fusionar(array, izquierda, medio, derecha);
        
        printIndent();
        System.out.println("Resultado de fusion: " + subArrToString(array, izquierda, derecha));
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("Inicio Merge Sort (Iterativo)");
        System.out.println("Estado inicial: " + arrToString(array));
        
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\nTamano de sub-arrays a fusionar: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("Fusionando [" + izquierda + ".." + medio + "] con [" + (medio + 1) + ".." + derecha + "]");
                fusionar(array, izquierda, medio, derecha);
            }
            System.out.println("Array actual tras ronda de tamano " + tamano + ": " + arrToString(array));
        }
        System.out.println("\nEstado final: " + arrToString(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
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
        
        printIndent();
        System.out.println("  Mitad Izq: " + arrToString(mitadIzquierda) + ", Mitad Der: " + arrToString(mitadDerecha));
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                printIndent();
                System.out.println("  " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " -> Se toma de la izquierda");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                printIndent();
                System.out.println("  " + mitadIzquierda[i] + " > " + mitadDerecha[j] + " -> Se toma de la derecha");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {5, 2, 8, 1, 9, 3};
        System.out.println("Inicio Merge Sort (Recursivo)");
        System.out.println("Estado inicial: " + arrToString(a1) + "\n");
        depth = 0;
        ordenar(a1, 0, a1.length - 1);
        System.out.println("\nEstado final: " + arrToString(a1));

        System.out.println("\n-------------------------------------------------\n");

        int[] a2 = {5, 2, 8, 1, 9, 3};
        ordenarIterativo(a2);
    }
}

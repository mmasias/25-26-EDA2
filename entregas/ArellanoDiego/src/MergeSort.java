import java.util.Arrays;

public class MergeSort {

    private static int mergeDepth = 0;

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String indent = getIndent(mergeDepth);
        System.out.println(indent + "Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(indent + "[i] Caso base alcanzado: izquierda (" + izquierda + ") >= derecha (" + derecha + "). Retornando.");
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(indent + "[i] Dividiendo array en medio=" + medio);
        
        mergeDepth++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        mergeDepth--;
        
        System.out.println(indent + "[!] Ejecutando fusionar(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + ")");
        fusionar(array, izquierda, medio, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
        int n = array.length;
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n--- Pasada con tamaño de sub-arrays: " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("  [!] Fusionando bloque: izq=" + izquierda + ", medio=" + medio + ", der=" + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("Estado final: " + Arrays.toString(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String indent = getIndent(mergeDepth) + "  ";
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
        
        System.out.println(indent + "Sub-arrays copiados. Izq: " + Arrays.toString(mitadIzquierda) + 
                           " | Der: " + Arrays.toString(mitadDerecha));
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            boolean comparacion = mitadIzquierda[i] <= mitadDerecha[j];
            System.out.println(indent + "[?] Comparando Izq[" + i + "] (" + mitadIzquierda[i] + ") <= Der[" + j + "] (" + mitadDerecha[j] + ") -> " + comparacion);
            
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                System.out.println(indent + "[+] Insertando " + mitadIzquierda[i] + " de lado Izquierdo en índice k=" + k);
                i++;
            } else {
                array[k] = mitadDerecha[j];
                System.out.println(indent + "[+] Insertando " + mitadDerecha[j] + " de lado Derecho en índice k=" + k);
                j++;
            }
            k++;
            System.out.println(indent + "Array actual: " + Arrays.toString(array));
        }
        
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(indent + "[+] Volcando resto de lado Izquierdo: " + mitadIzquierda[i] + " en índice k=" + k + " -> " + Arrays.toString(array));
            i++;
            k++;
        }
        
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(indent + "[+] Volcando resto de lado Derecho: " + mitadDerecha[j] + " en índice k=" + k + " -> " + Arrays.toString(array));
            j++;
            k++;
        }
    }
}
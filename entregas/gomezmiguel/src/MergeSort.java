import java.util.Arrays;

public class MergeSort {

    private static int nivelRecursion = 0;

    private static String getInd() {
        return "  ".repeat(Math.max(0, nivelRecursion));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (nivelRecursion == 0) {
            System.out.println("=== MERGE SORT RECURSIVO ===");
            System.out.println("Estado Inicial: " + Arrays.toString(array));
        }
        
        System.out.println(getInd() + "Llamada recursiva: rango [" + izquierda + " a " + derecha + "]");
        
        if (izquierda >= derecha) {
            System.out.println(getInd() + "CASO BASE: izquierda (" + izquierda + ") >= derecha (" + derecha + "). Rango vacio o de 1 elemento.");
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(getInd() + "Dividiendo en: [" + izquierda + " a " + medio + "] y [" + (medio + 1) + " a " + derecha + "]");
        
        nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivelRecursion--;
        
        fusionar(array, izquierda, medio, derecha);
        
        if (nivelRecursion == 0) {
            System.out.println("Estado Final: " + Arrays.toString(array) + "\n");
        }
    }
    public static void ordenarIterativo(int[] array) {
        System.out.println("=== MERGE SORT ITERATIVO ===");
        System.out.println("Estado Inicial: " + Arrays.toString(array));
        int n = array.length;
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\nBloque de tamano: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("\nEstado Final: " + Arrays.toString(array) + "\n");
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        System.out.println(getInd() + "--> Fusionando rangos [" + izquierda + "-" + medio + "] con [" + (medio + 1) + "-" + derecha + "]");
        
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        
        for (int i = 0; i < tamanoIzquierda; i++) mitadIzquierda[i] = array[izquierda + i];
        for (int i = 0; i < tamanoDerecha; i++) mitadDerecha[i] = array[medio + 1 + i];
        
        int i = 0, j = 0, k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print(getInd() + "  Comparando izq[" + i + "]=" + mitadIzquierda[i] + " y der[" + j + "]=" + mitadDerecha[j] + " -> ");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("Elige Izquierda (" + mitadIzquierda[i] + ")");
                array[k++] = mitadIzquierda[i++];
            } else {
                System.out.println("Elige Derecha (" + mitadDerecha[j] + ")");
                array[k++] = mitadDerecha[j++];
            }
        }
        
        while (i < tamanoIzquierda) {
            System.out.println(getInd() + "  Vaciando resto Izquierda: " + mitadIzquierda[i]);
            array[k++] = mitadIzquierda[i++];
        }
        while (j < tamanoDerecha) {
            System.out.println(getInd() + "  Vaciando resto Derecha: " + mitadDerecha[j]);
            array[k++] = mitadDerecha[j++];
        }
        System.out.println(getInd() + "Estado tras la fusion: " + Arrays.toString(array));
    }
}
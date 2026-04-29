import java.util.Arrays;

public class mergeSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            System.out.printf("%sCaso base: Rango [%d, %d] indivisible (1 o 0 elementos).%n", Soporte.ind(), izquierda, derecha);
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.printf("%sDividiendo rango [%d..%d] en [%d..%d] y [%d..%d]%n", Soporte.ind(), izquierda, derecha, izquierda, medio, medio + 1, derecha);
        
        Soporte.nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        Soporte.nivelRecursion--;
        
        fusionar(array, izquierda, medio, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.printf("%nFase iterativa: Tamaño de sub-arrays = %d%n", tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        System.out.printf("%sFusionando [%d..%d] y [%d..%d]%n", Soporte.ind(), izquierda, medio, medio + 1, derecha);
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        
        for (int i = 0; i < tamanoIzquierda; i++) mitadIzquierda[i] = array[izquierda + i];
        for (int i = 0; i < tamanoDerecha; i++) mitadDerecha[i] = array[medio + 1 + i];
        
        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.printf("%s  Compara L[%d]=%d <= R[%d]=%d -> %b%n", Soporte.ind(), i, mitadIzquierda[i], j, mitadDerecha[j], (mitadIzquierda[i] <= mitadDerecha[j]));
            
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.printf("%s    Toma %d (izq)%n", Soporte.ind(), mitadIzquierda[i]);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.printf("%s    Toma %d (der)%n", Soporte.ind(), mitadDerecha[j]);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) { array[k] = mitadIzquierda[i]; i++; k++; }
        while (j < tamanoDerecha) { array[k] = mitadDerecha[j]; j++; k++; }
        System.out.printf("%s  Array tras fusión: %s%n", Soporte.ind(), Arrays.toString(array));
    }
}
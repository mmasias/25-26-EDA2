import java.util.Arrays;

public class MergeSortIterativo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== INICIO MERGE SORT ITERATIVO ===");
        System.out.println("Inicial: " + Arrays.toString(array));
        
        ordenar(array);
        
        System.out.println("Final: " + Arrays.toString(array));
    }

    static void ordenar(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Pasadas para tamaño: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        
        for (int i = 0; i < tamanoIzquierda; i++) mitadIzquierda[i] = array[izquierda + i];
        for (int i = 0; i < tamanoDerecha; i++) mitadDerecha[i] = array[medio + 1 + i];
        
        int i = 0, j = 0, k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k++] = mitadIzquierda[i++];
            } else {
                array[k++] = mitadDerecha[j++];
            }
        }
        
        while (i < tamanoIzquierda) array[k++] = mitadIzquierda[i++];
        while (j < tamanoDerecha) array[k++] = mitadDerecha[j++];
        
        System.out.println("  Fusionados izq=" + izquierda + " a der=" + derecha + " -> " + Arrays.toString(array));
    }
}

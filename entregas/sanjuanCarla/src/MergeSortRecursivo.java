import java.util.Arrays;

public class MergeSortRecursivo {

    static int recursionDepth = 0;

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== INICIO MERGE SORT RECURSIVO ===");
        System.out.println("Inicial: " + Arrays.toString(array));
        
        ordenar(array, 0, array.length - 1);
        
        System.out.println("Final: " + Arrays.toString(array));
    }

    static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) return;

        System.out.println(indent() + "Dividiendo: izq=" + izquierda + ", der=" + derecha);
        recursionDepth++;

        int medio = izquierda + (derecha - izquierda) / 2;
        
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        fusionar(array, izquierda, medio, derecha);

        recursionDepth--;
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
        
        System.out.println(indent() + "Fusionados izq=" + izquierda + " a der=" + derecha + " -> " + Arrays.toString(array));
    }

    static String indent() {
        return "  ".repeat(Math.max(0, recursionDepth));
    }
}

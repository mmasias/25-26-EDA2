public class MergeSortIterativo {

    public static void ordenarIterativo(int[] array) {
        System.out.println("Merge Sort Iterativo");
        System.out.println("Estado inicial: " + mostrar(array));
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("Estado final: " + mostrar(array));
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
        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("Comparacion: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " = true");
                array[k] = mitadIzquierda[i];
                System.out.println("Array: " + mostrar(array));
                i++;
            } else {
                System.out.println("Comparacion: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " = false");
                array[k] = mitadDerecha[j];
                System.out.println("Array: " + mostrar(array));
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println("Array: " + mostrar(array));
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println("Array: " + mostrar(array));
            j++;
            k++;
        }
    }

    private static String mostrar(int[] array) {
        String texto = "[";
        for (int i = 0; i < array.length; i++) {
            texto += array[i];
            if (i < array.length - 1) texto += ", ";
        }
        return texto + "]";
    }
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenarIterativo(array);
    }
}
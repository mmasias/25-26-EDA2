
public class MergeSortIterativo {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void ordenar(int[] array) {
        System.out.println("Ordenando el array utilizando Merge Sort Iterativo...");
        int n = array.length;
        System.out.println("A iterar sobre los " + n + " elementos del array con tamaños de subarrays crecientes");
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Iterando con tamaño de subarrays: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                System.out.println("Fusionando subarrays desde el indice " + izquierda);
                int medio = izquierda + tamano - 1;
                System.out.println("    Subarray izquierdo: " + izquierda + " a " + medio);
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("    Subarray derecho: " + (medio + 1) + " a " + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];
        System.out.println("    Creando subarrays para la fusión...");
        for (int i = 0; i < tamanoIzquierda; i++) {
            System.out.println("    Iteracion numero " + (i + 1) + " del subarray izquierdo:");
            System.out.println("        Copiando elemento " + array[izquierda + i] + " al subarray izquierdo");
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            System.out.println("    Iteracion numero " + (i + 1) + " del subarray derecho:");
            System.out.println("            Copiando elemento " + array[medio + 1 + i] + " al subarray derecho");
            mitadDerecha[i] = array[medio + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = izquierda;
        System.out.println("    Fusionando los subarrays de tamaño " + tamanoIzquierda + " y " + tamanoDerecha);
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("    Comparando " + mitadIzquierda[i] + " con " + mitadDerecha[j]);
                array[k] = mitadIzquierda[i];
                System.out.println("    Insertando " + mitadIzquierda[i] + " en la posición " + k);
                i++;
                System.out.println("    El elemento " + mitadIzquierda[i - 1] + " se ha insertado en la posición " + k);
            } else {
                array[k] = mitadDerecha[j];
                System.out.println("    Insertando " + mitadDerecha[j] + " en la posición " + k);
                j++;
                System.out.println("    El elemento " + mitadDerecha[j - 1] + " se ha insertado en la posición " + k);
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println("    Insertando el elemento restante " + mitadIzquierda[i]
                    + " del subarray izquierdo en la posición " + k);
            array[k] = mitadIzquierda[i];
            System.out.println("    El elemento " + mitadIzquierda[i] + " se ha insertado en la posición " + k);
            i++;
            System.out.println("Incrementando el indice del subarray izquierdo a " + i);
            k++;
            System.out.println("Incrementando el indice de la posición del array a " + k);
        }
        while (j < tamanoDerecha) {
            System.out.println("    Insertando el elemento restante " + mitadDerecha[j]
                    + " del subarray derecho en la posición " + k);
            array[k] = mitadDerecha[j];
            System.out.println("    El elemento " + mitadDerecha[j] + " se ha insertado en la posición " + k);
            j++;
            System.out.println("Incrementando el indice del subarray derecho a " + j);
            k++;
            System.out.println("Incrementando el indice de la posición del array a " + k);
        }
    }
}

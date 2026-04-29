public class MergeSortRecursivo {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println("Ordenando el array utilizando Merge Sort Recursivo...");
        System.out.println(
                "Evaluando el caso base para el subarray desde el indice " + izquierda + " hasta el indice " + derecha);
        if (izquierda >= derecha) {
            return;
        }
        System.out.println(
                "Dividiendo el subarray desde el indice " + izquierda + " hasta el indice " + derecha
                        + " en dos mitades");
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(
                "La mitad se encuentra en el indice " + medio + ", dividiendo el subarray en: [" + izquierda + ", "
                        + medio + "] y [" + (medio + 1) + ", " + derecha + "]");
        ordenar(array, izquierda, medio);
        System.out.println(
                "Entrando a la llamada recursiva para ordenar el subarray derecho desde el indice " + (medio + 1)
                        + " hasta el indice " + derecha);
        ordenar(array, medio + 1, derecha);
        System.out.println(
                "Fusionando los subarrays ordenados desde el indice " + izquierda + " hasta el indice " + medio
                        + " y desde el indice " + (medio + 1) + " hasta el indice " + derecha);
        fusionar(array, izquierda, medio, derecha);
        System.out.println(
                "El subarray desde el indice " + izquierda + " hasta el indice " + derecha + " ha sido ordenado");
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

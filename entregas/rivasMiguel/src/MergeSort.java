public class MergeSort{
    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.print("Array ");
        for (int i = izquierda; i <= derecha; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print(" particionado en los grupos: ");
        for (int i = izquierda; i <= medio; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print(" Y ");
        for (int i = medio+1; i <= derecha; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        fusionar(array, izquierda, medio, derecha);

        System.out.print("Arrays ");
        for (int i = izquierda; i <= medio; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print(" Y ");
        for (int i = medio+1; i <= derecha; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print(" fusionados en ");
        for (int i = izquierda; i <= derecha; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        for (int tamano = 1; tamano < n; tamano *= 2) {
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.print("Array ");
                for (int i = izquierda; i <= derecha; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.print(" particionado en los grupos: ");
                for (int i = izquierda; i <= medio; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.print(" Y ");
                for (int i = medio + 1; i <= derecha; i++) {
                    System.out.print(array[i] + " ");
                }

                System.out.println();

                System.out.print("Arrays ");
                for (int i = izquierda; i <= medio; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.print(" Y ");
                for (int i = medio + 1; i <= derecha; i++) {
                    System.out.print(array[i] + " ");
                }

                fusionar(array, izquierda, medio, derecha);

                System.out.print(" fusionados en ");
                for (int i = izquierda; i <= derecha; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            }
        }
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
                array[k] = mitadIzquierda[i];
                i++;
            } else {
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
}

public class MergeSort {

    private static int nivelRecursion = 0;

    private static String getTabs() {
        return "    ".repeat(Math.max(0, nivelRecursion));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String tabs = getTabs();
        System.out.println(tabs + "┌── ordenar(izq: " + izquierda + ", der: " + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(tabs + "│   -> CASO BASE ALCANZADO: izq (" + izquierda + ") >= der (" + derecha + "). El fragmento es de 1 o 0 elementos.");
            System.out.println(tabs + "└── Retornando...");
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(tabs + "│   Calculado medio: " + medio + ". Dividiendo en dos mitades...");
        
        nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivelRecursion--;
        
        System.out.println(tabs + "│   Fusionando mitades: [" + izquierda + " a " + medio + "] y [" + (medio + 1) + " a " + derecha + "]");
        fusionar(array, izquierda, medio, derecha);
        mostrar(array, tabs + "└── RESULTADO PARCIAL: ");
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        System.out.println("┌── INICIO MERGE SORT ITERATIVO");
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("│\n│   [NUEVO TAMAÑO DE BLOQUE: " + tamano + "]");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("│   -> Fusionando bloques iterativos: izq=" + izquierda + ", med=" + medio + ", der=" + derecha);
                fusionar(array, izquierda, medio, derecha);
            }
            mostrar(array, "│   ESTADO DEL ARRAY: ");
        }
        System.out.println("└── FIN ITERATIVO");
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String tabs = getTabs() + "    ";
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
            System.out.println(tabs + "| Comparando izq[" + i + "]=" + mitadIzquierda[i] + " <= der[" + j + "]=" + mitadDerecha[j] + " ? " + (mitadIzquierda[i] <= mitadDerecha[j]));
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(tabs + "| -> Copiando " + mitadIzquierda[i] + " al array original (índice " + k + ")");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(tabs + "| -> Copiando " + mitadDerecha[j] + " al array original (índice " + k + ")");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        
        while (i < tamanoIzquierda) {
            System.out.println(tabs + "| Volcando sobrante izq: copiando " + mitadIzquierda[i] + " al índice " + k);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(tabs + "| Volcando sobrante der: copiando " + mitadDerecha[j] + " al índice " + k);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    public static void mostrar(int[] array, String prefijo) {
        System.out.print(prefijo + "[ ");
        for (int j : array) System.out.print(j + " ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.print("ARRAY INICIAL (Recursivo): [ 5 2 8 1 9 3 ]\n\n");
        ordenar(array, 0, array.length - 1);
        System.out.print("\nARRAY FINAL: ");
        mostrar(array, "");

        System.out.println("\n--------------------   ITERATIVO   -----------------------------\n");

        System.out.print("ARRAY INICIAL (Iterativo): [ 5 2 8 1 9 3 ]\n\n");
        ordenarIterativo(array);
        System.out.print("\nARRAY FINAL: ");
        mostrar(array, "");
    }
}
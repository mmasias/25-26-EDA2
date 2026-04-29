public class QuickSort {

    private static int nivelRecursion = 0;

    private static String getTabs() {
        return "    ".repeat(Math.max(0, nivelRecursion));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String tabs = getTabs();
        System.out.println(tabs + "┌── ordenar(izq: " + izquierda + ", der: " + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(tabs + "│   -> CASO BASE ALCANZADO: izq (" + izquierda + ") >= der (" + derecha + "). Sub-array inválido o de 1 elemento.");
            System.out.println(tabs + "└── Retornando...");
            return;
        }
        
        System.out.println(tabs + "│   Iniciando partición...");
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(tabs + "│   Partición terminada. Pivote ubicado en índice " + indicePivote);
        mostrar(array, tabs + "│   Estado post-partición: ");
        
        nivelRecursion++;
        System.out.println(tabs + "│   -> Ordenando sub-array izquierdo:");
        ordenar(array, izquierda, indicePivote - 1);
        System.out.println(tabs + "│   -> Ordenando sub-array derecho:");
        ordenar(array, indicePivote + 1, derecha);
        nivelRecursion--;
        
        System.out.println(tabs + "└── Fin de ordenar(izq: " + izquierda + ", der: " + derecha + ")");
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String tabs = getTabs() + "    ";
        int pivote = array[derecha];
        System.out.println(tabs + "| Pivote seleccionado: " + pivote + " (en índice " + derecha + ")");
        
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.print(tabs + "| Comparando array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " ? ");
            if (array[j] <= pivote) {
                i++;
                System.out.println("VERDADERO. -> Intercambiando array[" + i + "]=" + array[i] + " con array[" + j + "]=" + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
            } else {
                System.out.println("FALSO.");
            }
        }
        
        System.out.println(tabs + "| Fin de bucle. Ubicando pivote en su posición final...");
        System.out.println(tabs + "| Intercambiando array[" + (i + 1) + "]=" + array[i + 1] + " con pivote (" + array[derecha] + ")");
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        return i + 1;
    }

    public static void mostrar(int[] array, String prefijo) {
        System.out.print(prefijo + "[ ");
        for (int j : array) System.out.print(j + " ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.print("ARRAY INICIAL: [ 5 2 8 1 9 3 ]\n\n");
        ordenar(array, 0, array.length - 1);
        
        System.out.print("\nARRAY FINAL: ");
        mostrar(array, "");
    }
}
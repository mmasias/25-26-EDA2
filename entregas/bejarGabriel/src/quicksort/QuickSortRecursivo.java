public class QuickSortRecursivo {

    private static int nivelRecursion = 0;

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial del array (Quick Sort Recursivo):");
        imprimirArray(array, "");
        System.out.println("Iniciando proceso de ordenacion...");
        ordenar(array, 0, array.length - 1);
        System.out.println("Proceso finalizado. Estado final del array:");
        imprimirArray(array, "");
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = obtenerIndentacion(nivelRecursion);
        System.out.println(ind + "Llamada a ordenar: rango [" + izquierda + " a " + derecha + "]");

        if (izquierda >= derecha) {
            if (izquierda == derecha) {
                System.out.println(ind + "CASO BASE ALCANZADO: izquierda == derecha (" + izquierda + "). El elemento individual ya esta en su posicion.");
            } else {
                System.out.println(ind + "CASO BASE ALCANZADO: izquierda > derecha (" + izquierda + " > " + derecha + "). El sub-array esta vacio.");
            }
            return;
        }

        nivelRecursion++;
        int indicePivote = particionar(array, izquierda, derecha);
        
        System.out.println(ind + "Pivote final establecido en el indice " + indicePivote + ". Dividiendo tareas.");
        
        System.out.println(ind + "Procesando particion izquierda: [" + izquierda + " a " + (indicePivote - 1) + "]");
        ordenar(array, izquierda, indicePivote - 1);
        
        System.out.println(ind + "Procesando particion derecha: [" + (indicePivote + 1) + " a " + derecha + "]");
        ordenar(array, indicePivote + 1, derecha);
        
        nivelRecursion--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String ind = obtenerIndentacion(nivelRecursion);
        int pivote = array[derecha];
        System.out.println(ind + "Iniciando particion. Pivote elegido (valor en indice " + derecha + "): " + pivote);
        
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            System.out.println(ind + "Comparando array[" + j + "] (" + array[j] + ") con el pivote (" + pivote + ")");
            if (array[j] <= pivote) {
                i++;
                System.out.println(ind + "Resultado: " + array[j] + " es menor o igual al pivote. Incrementando puntero i a " + i + " e intercambiando.");
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(ind + "Array tras intercambio interno:");
                imprimirArray(array, ind);
            } else {
                System.out.println(ind + "Resultado: " + array[j] + " es mayor al pivote. No hay intercambio.");
            }
        }
        
        System.out.println(ind + "Intercambio final: colocando el pivote (" + pivote + ") en su posicion definitiva (indice " + (i + 1) + ")");
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        imprimirArray(array, ind);
        
        return i + 1;
    }

    public static String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void imprimirArray(int[] array, String ind) {
        System.out.print(ind + "[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
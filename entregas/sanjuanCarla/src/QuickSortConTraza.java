import java.util.Arrays;

public class QuickSortConTraza {

    static int recursionDepth = 0;

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== INICIO QUICK SORT ===");
        System.out.println("Inicial: " + Arrays.toString(array));
        
        ordenar(array, 0, array.length - 1);
        
        System.out.println("Final: " + Arrays.toString(array));
    }

    static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) return;

        System.out.println(indent() + "ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        recursionDepth++;

        int indicePivote = particionar(array, izquierda, derecha);
        
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);

        recursionDepth--;
    }

    static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println(indent() + "Pivote " + pivote + " ubicado -> " + Arrays.toString(array));
        return i + 1;
    }

    static String indent() {
        return "  ".repeat(Math.max(0, recursionDepth));
    }
}

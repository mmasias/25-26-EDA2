import java.util.Arrays;

public class QuickSort {

    private static int nivelRecursion = 0;

    private static String getInd() {
        return "  ".repeat(Math.max(0, nivelRecursion));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (nivelRecursion == 0) {
            System.out.println("=== QUICK SORT ===");
            System.out.println("Estado Inicial: " + Arrays.toString(array));
        }
        
        System.out.println(getInd() + "Llamada recursiva: rango [" + izquierda + " a " + derecha + "]");
        
        if (izquierda >= derecha) {
            System.out.println(getInd() + "CASO BASE: izquierda (" + izquierda + ") >= derecha (" + derecha + "). Subarray de tamano <= 1.");
            return;
        }
        
        int indicePivote = particionar(array, izquierda, derecha);
        
        System.out.println(getInd() + "Rama Izquierda (menores al pivote):");
        nivelRecursion++;
        ordenar(array, izquierda, indicePivote - 1);
        nivelRecursion--;
        
        System.out.println(getInd() + "Rama Derecha (mayores al pivote):");
        nivelRecursion++;
        ordenar(array, indicePivote + 1, derecha);
        nivelRecursion--;
        
        if (nivelRecursion == 0) {
            System.out.println("\nEstado Final: " + Arrays.toString(array) + "\n");
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        
        System.out.println(getInd() + "--> Particionando | Pivote seleccionado: " + pivote + " (en indice " + derecha + ")");
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.print(getInd() + "  Comparando array[" + j + "] (" + array[j] + ") <= pivote (" + pivote + ") -> ");
            if (array[j] <= pivote) {
                System.out.println("SI");
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(getInd() + "    Swap de " + array[j] + " con " + array[i] + ". Array: " + Arrays.toString(array));
            } else {
                System.out.println("NO");
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(getInd() + "--> Ubicando pivote en su posicion final (" + (i + 1) + "): " + Arrays.toString(array));
        
        return i + 1;
    }
}
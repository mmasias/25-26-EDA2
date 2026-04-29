import java.util.Arrays;

public class QuickSort {

    private static int nivel = 0;
    
    private static String ind() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < nivel; k++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(ind() + "Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(ind() + "Caso base alcanzado: izq (" + izquierda + ") >= der (" + derecha + ")");
            return;
        }
        
        int indicePivote = particionar(array, izquierda, derecha);
        
        nivel++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        nivel--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        
        System.out.println(ind() + "Particionando , pivote=" + pivote);
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.println(ind() + "Comparacion: array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " es " + (array[j] <= pivote));
            
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                
                System.out.println(ind() + "Intercambio interno: " + Arrays.toString(array));
            }
        }
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println(ind() + "Intercambio de pivote a pos " + (i + 1) + ": " + Arrays.toString(array));
        
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("Estado inicial: " + Arrays.toString(array));
        
        ordenar(array, 0, array.length - 1);
        
        System.out.println("Estado final: " + Arrays.toString(array));
    }
}
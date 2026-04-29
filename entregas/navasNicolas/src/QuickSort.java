import java.util.Arrays;

public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String indent = "  ".repeat(nivel);
        
        if (izquierda >= derecha) {
            System.out.println(indent + "-> Caso base alcanzado: Rango [" + izquierda + "," + derecha + "] " + 
                              (izquierda == derecha ? "(Elemento único: " + array[izquierda] + ")" : "(Rango vacío)"));
            return;
        }

        System.out.println(indent + "Particion del rango [" + izquierda + "," + derecha + "]: " + Arrays.toString(Arrays.copyOfRange(array, izquierda, derecha + 1)));

        int indicePivote = particionar(array, izquierda, derecha, nivel);

        System.out.println(indent + "  Llamando sub-array IZQUIERDO de " + indicePivote);
        ordenar(array, izquierda, indicePivote - 1, nivel + 1);
        
        System.out.println(indent + "  Llamando sub-array DERECHO de " + indicePivote);
        ordenar(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, int nivel) {
        String indent = "  ".repeat(nivel);
        int pivote = array[derecha];
        System.out.println(indent + "│   Pivote: " + pivote);
        
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            // Registro de decisión relevante (Comparación)
            System.out.print(indent + "│   ¿" + array[j] + " <= " + pivote + "? ");
            
            if (array[j] <= pivote) {
                i++;
                System.out.println("Si. Intercambiando " + array[i] + " por " + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(indent + "│   Estado: " + Arrays.toString(array));
            } else {
                System.out.println("No. Se queda donde está.");
            }
        }

        System.out.println(indent + "└── Colocando pivote " + pivote + " en su posición final (índice " + (i + 1) + ")");
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println(indent + "    Resultado partición: " + Arrays.toString(array));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("-------------QUICK SORT------------");
        System.out.println("Array desordenado: " + Arrays.toString(array));

        ordenar(array, 0, array.length - 1, 1);

        System.out.println("Array ordenado: " + Arrays.toString(array));
    }
}
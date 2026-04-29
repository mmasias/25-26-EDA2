import java.util.Arrays;

public class InsertionSort {

    public static void ordenarIterativo(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            
            System.out.println("-> Inicio de iteración i=" + i + " | Valor a insertar: [" + actual + "]");
            
            while (j >= 0) {
                System.out.print("   Comparando array[" + j + "]=" + array[j] + " con valor actual=[" + actual + "] -> ");
                
                if (array[j] > actual) {
                    System.out.println("Es MAYOR. Desplazando " + array[j] + " a la posición " + (j + 1));
                    array[j + 1] = array[j];
                    j--;
                    System.out.println("   Array tras desplazamiento: " + Arrays.toString(array));
                } else {
                    System.out.println("Es MENOR o IGUAL. Fin de la búsqueda de posición.");
                    break;
                }
            }
            
            array[j + 1] = actual;
            System.out.println("   Insertando valor [" + actual + "] en la posición " + (j + 1));
            System.out.println("   Estado del array al final de la iteración i=" + i + ": " + Arrays.toString(array) + "\n");
        }
    }

    public static void ordenarRecursivo(int[] array, int n, int nivel) {
        String prefijo = "   ".repeat(nivel);
        System.out.println(prefijo + "Llamada recursiva n=" + n);

        if (n <= 1) {
            System.out.println(prefijo + "--> CASO BASE ALCANZADO: n=" + n + " (Un sub-array de tamaño 1 o 0 ya está ordenado)");
            return;
        }

        ordenarRecursivo(array, n - 1, nivel + 1);

        int ultimo = array[n - 1];
        int j = n - 2;
        
        System.out.println(prefijo + "Retorno a llamada n=" + n + " | Valor a insertar: [" + ultimo + "]");

        while (j >= 0) {
            System.out.print(prefijo + "  Comparando array[" + j + "]=" + array[j] + " con valor actual=[" + ultimo + "] -> ");
            
            if (array[j] > ultimo) {
                System.out.println("Es MAYOR. Desplazando " + array[j] + " a la posición " + (j + 1));
                array[j + 1] = array[j];
                j--;
                System.out.println(prefijo + "  Array tras desplazamiento: " + Arrays.toString(array));
            } else {
                System.out.println("Es MENOR o IGUAL. Fin de la búsqueda.");
                break;
            }
        }
        
        array[j + 1] = ultimo;
        System.out.println(prefijo + "  Insertando valor [" + ultimo + "] en la posición " + (j + 1));
        System.out.println(prefijo + "  Estado del array al completar n=" + n + ": " + Arrays.toString(array));
    }
}
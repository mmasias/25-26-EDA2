import java.util.Arrays;

public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String prefijo = "   ".repeat(nivel);
        System.out.println(prefijo + "Llamada recursiva QuickSort (izq=" + izquierda + ", der=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(prefijo + "--> CASO BASE ALCANZADO: izq >= der. Sub-array demasiado pequeño para dividir.");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha, nivel);
        System.out.println(prefijo + "Pivote definitivo ubicado en el índice " + indicePivote + ". Dividiendo sub-arrays...");
        
        ordenar(array, izquierda, indicePivote - 1, nivel + 1);
        ordenar(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, int nivel) {
        String prefijo = "   ".repeat(nivel);
        int pivote = array[derecha];
        System.out.println(prefijo + "Pivote elegido: [" + pivote + "] (elemento más a la derecha, índice " + derecha + ")");
        
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.print(prefijo + "  Comparando array[" + j + "]=" + array[j] + " con pivote=[" + pivote + "] -> ");
            
            if (array[j] <= pivote) {
                i++;
                System.out.println("Es MENOR o IGUAL. Intercambiando array[" + i + "] con array[" + j + "].");
                
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                
                System.out.println(prefijo + "    Array tras intercambio: " + Arrays.toString(array));
            } else {
                System.out.println("Es MAYOR. No se hace nada.");
            }
        }
        
        System.out.println(prefijo + "  Bucle finalizado. Intercambiando pivote a su posición final (índice " + (i + 1) + ").");
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println(prefijo + "  Estado del array tras partición: " + Arrays.toString(array) + "\n");
        return i + 1;
    }
}
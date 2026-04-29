public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        int diferenciaRango = (array.length - 1) - (derecha - izquierda);
        String indentacion = "  ".repeat(Math.max(0, diferenciaRango));

        if (izquierda == 0 && derecha == array.length - 1) {
            System.out.println("ESTADO INICIAL: " + formatearArray(array));
        }

        if (izquierda >= derecha) {
            System.out.println(indentacion + "[CASO BASE] Izquierda:" + izquierda + " >= Derecha:" + derecha + " ? -> SI.");
            return;
        }

        System.out.println("\n" + indentacion + "-> Particionando rango [" + izquierda + ", " + derecha + "]");
        int indicePivote = particionar(array, izquierda, derecha, indentacion);
        
        System.out.println(indentacion + "Pivote fijado en indice: " + indicePivote);
        System.out.println(indentacion + "Estado: " + formatearArray(array));

        System.out.println(indentacion + "-> Rama Izquierda:");
        ordenar(array, izquierda, indicePivote - 1);
        
        System.out.println(indentacion + "-> Rama Derecha:");
        ordenar(array, indicePivote + 1, derecha);

        if (izquierda == 0 && derecha == array.length - 1) {
            System.out.println("\nESTADO FINAL: " + formatearArray(array));
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha, String indentacion) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        System.out.println(indentacion + "  Pivote elegido: " + pivote);

        for (int j = izquierda; j < derecha; j++) {
            System.out.print(indentacion + "  " + array[j] + " <= " + pivote + " ? ");
            
            if (array[j] <= pivote) {
                System.out.println("-> SI");
                i++;
                
                System.out.println(indentacion + "    Intercambio: " + array[i] + " <-> " + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(indentacion + "    Array: " + formatearArray(array));
            } else {
                System.out.println("-> NO");
            }
        }

        System.out.println(indentacion + "  Colocando pivote en su lugar final:");
        System.out.println(indentacion + "    Intercambio final: " + array[i + 1] + " <-> " + array[derecha]);
        
        int temporalPivote = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporalPivote;

        return i + 1;
    }

    public static void imprimirArray(int[] array) {
        System.out.println(formatearArray(array));
    }

    private static String formatearArray(int[] array) {
        String resultado = "[";
        for (int i = 0; i < array.length; i++) {
            resultado += array[i];
            if (i < array.length - 1) {
                resultado += ", ";
            }
        }
        return resultado + "]";
    }
}
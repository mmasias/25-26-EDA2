public class MergeSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        int profundidad = (array.length - 1) - (derecha - izquierda);
        String indentacion = "  ".repeat(Math.max(0, profundidad));

        if (izquierda == 0 && derecha == array.length - 1) {
            System.out.println("ESTADO INICIAL: " + formatear(array));
        }

        if (izquierda >= derecha) {
            System.out.println(indentacion + "[CASO BASE] Izq:" + izquierda + " >= Der:" + derecha + " ? -> SI. [" + array[izquierda] + "]");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(indentacion + "-> Dividir: " + formatearRango(array, izquierda, derecha));
        
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);

        System.out.println("\n" + indentacion + "[FUSIÓN] Uniendo mitades de rango " + izquierda + "-" + derecha);
        fusionar(array, izquierda, medio, derecha, indentacion);
        
        if (izquierda == 0 && derecha == array.length - 1) {
            System.out.println("\nESTADO FINAL: " + formatear(array));
        }
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        System.out.println("ESTADO INICIAL: " + formatear(array));

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n--- Tamaño de bloque: " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                fusionar(array, izquierda, medio, derecha, "  ");
                System.out.println("  Array actual: " + formatear(array));
            }
        }
        System.out.println("\nESTADO FINAL: " + formatear(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, String indentacion) {
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

        int i = 0, j = 0, k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {

            System.out.print(indentacion + "  " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " ? ");

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("-> SI. Copio " + mitadIzquierda[i] + " en pos " + k);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println("-> NO. Copio " + mitadDerecha[j] + " en pos " + k);
                array[k] = mitadDerecha[j];
                j++;
            }
            
            System.out.println(indentacion + "    Intermedio: " + formatear(array));
            k++;
        }

        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            i++; k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            j++; k++;
        }
    }

    private static String formatear(int[] array) {
        String arrayFormateado = "[";
        for (int i = 0; i < array.length; i++) {
            arrayFormateado += array[i] + (i < array.length - 1 ? ", " : "");
        }
        return arrayFormateado + "]";
    }

    public static void imprimirArray(int[] array) {
        System.out.println(formatear(array));
    }

    private static String formatearRango(int[] array, int izq, int der) {
        String arrayFormateado = "[";
        for (int i = izq; i <= der; i++) {
            arrayFormateado += array[i] + (i < der ? ", " : "");
        }
        return arrayFormateado + "]";
    }
}
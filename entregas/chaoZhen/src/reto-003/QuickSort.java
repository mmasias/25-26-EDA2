public class QuickSort {

     public static void main(String[] args) {
        int[] arrayRecursivo = {5, 2, 8, 1, 9, 3};
        System.out.println("--- METODO RECURSIVO ---");
        System.out.println("Estado inicial: " + imprimirArray(arrayRecursivo));
        ordenar(arrayRecursivo, 0, arrayRecursivo.length - 1);
        System.out.println("Estado final: " + imprimirArray(arrayRecursivo));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String indentacion = obtenerIndentacion();
        System.out.println(indentacion + "Llamada recursiva: ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        System.out.println(indentacion + "  Compara izq >= der (" + izquierda + " >= " + derecha + ") -> " + (izquierda >= derecha));
        
        if (izquierda >= derecha) {
            System.out.println(indentacion + "  -> CASO BASE [Detiene la llamada resursiva]: izquierda >= derecha.");
            return;
        }
        
        System.out.println(indentacion + "  Llamando a particionar(izq=" + izquierda + ", der=" + derecha + ")");
        int indicePivote = particionar(array, izquierda, derecha);
        
        System.out.println(indentacion + "  Pivote colocado en el indice final: " + indicePivote + " (Valor: " + array[indicePivote] + ")");
        
        System.out.println(indentacion + "  Llamando a ordenar mitad izquierda (izq=" + izquierda + ", der=" + (indicePivote - 1) + "):");
        ordenar(array, izquierda, indicePivote - 1);
        
        System.out.println(indentacion + "  Llamando a ordenar mitad derecha (izq=" + (indicePivote + 1) + ", der=" + derecha + "):");
        ordenar(array, indicePivote + 1, derecha);
    }

    
    private static int particionar(int[] array, int izquierda, int derecha) {
        String indentacion = obtenerIndentacion();
        System.out.println(indentacion + "[particionar] Inicio particionar: izq=" + izquierda + ", der=" + derecha);
        
        int pivote = array[derecha];
        System.out.println(indentacion + "  Pivote seleccionado: " + pivote + " (en el indice " + derecha + ")");
        
        int i = izquierda - 1;
        System.out.println(indentacion + "  Indice 'i' (registro de menores que el pivote) inicia en: " + i);
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.println(indentacion + "  [Bucle for] j=" + j + ". Evalua array["+j+"]=" + array[j] + " <= pivote=" + pivote + " -> " + (array[j] <= pivote));
            if (array[j] <= pivote) {
                i++;
                System.out.println(indentacion + "    -> Verdadero. Incrementa 'i' a " + i + " e intercambia array["+i+"]=" + array[i] + " con array["+j+"]=" + array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(indentacion + "    -> " + imprimirArray(array));
            }
        }
        
        System.out.println(indentacion + "  [Fin bucle] Colocando el pivote en su posicion correcta.");
        System.out.println(indentacion + "  Intercambia array["+(i + 1)+"]=" + array[i + 1] + " con el pivote en array["+derecha+"]=" + array[derecha]);
        
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        System.out.println(indentacion + "  Estado final de la particion: " + imprimirArray(array));
        
        return i + 1;
    }

    
    public static String imprimirArray(int[] array) {
        System.out.println("===========================================================================");
        String resultadoArray = "[";
        for (int i = 0; i < array.length; i++) {
            resultadoArray += array[i] + (i < array.length - 1 ? ", " : "");
        }
        return resultadoArray + "]";
    }

    public static String obtenerIndentacion() {
        StackTraceElement[] pilaLlamadas = Thread.currentThread().getStackTrace();
        int nivelProfundidad = 0;
        
        for (StackTraceElement elementoLlamada : pilaLlamadas) {
            if (elementoLlamada.getMethodName().equals("ordenar")) {
                nivelProfundidad++;
            }
        }
        
        String espaciosIndentacion = "";
        for (int i = 1; i < nivelProfundidad; i++) {
            espaciosIndentacion += "    "; 
        }
        
        
        if (pilaLlamadas[2].getMethodName().equals("particionar") && nivelProfundidad > 0) {
            espaciosIndentacion += "  ";
        }
        
        return espaciosIndentacion;
    }
}


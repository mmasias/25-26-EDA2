public class InsertionSort {
    
    private static int profundidadRecursion = 0;

    
    private static String getIndent() {
        String indentacion = "";
        for (int i = 0; i < profundidadRecursion; i++) {
            indentacion += "  ";
        }
        return indentacion;
    }

    
    private static String arrayToString(int[] array) {
        if (array.length == 0) return "[]";
        String resultado = "[";
        for (int i = 0; i < array.length; i++) {
            resultado += array[i];
            if (i < array.length - 1) resultado += ", ";
        }
        resultado += "]";
        return resultado;
    }


    public static void ordenar(int[] array) {
        System.out.println("Estado inicial: " + arrayToString(array));
        
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\n[Iteración i=" + i + "] Analizando elemento a insertar: " + actual);
            
            if (j >= 0) {
                System.out.println("  Comparando array[" + j + "]=" + array[j] + " > actual=" + actual + " -> " + (array[j] > actual));
            }
            
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                System.out.println("  Desplazamiento a la derecha: array[" + (j + 1) + "] = " + array[j] + " -> " + arrayToString(array));
                j--;
                
                if (j >= 0) {
                    System.out.println("  Comparando array[" + j + "]=" + array[j] + " > actual=" + actual + " -> " + (array[j] > actual));
                }
            }
            array[j + 1] = actual;
            System.out.println("  Insertando elemento: array[" + (j + 1) + "] = " + actual + " -> " + arrayToString(array));
        }
        System.out.println("\nEstado final: " + arrayToString(array));
    }


    public static void ordenar(int[] array, int n) {
        if (profundidadRecursion == 0) {
            System.out.println("Estado inicial: " + arrayToString(array));
        }

        System.out.println(getIndent() + "Llamada ordenar(n=" + n + ")");
        
        if (n <= 1) {
            System.out.println(getIndent() + "-> Caso base alcanzado (n=" + n + " <= 1). Un array de 0 o 1 elemento ya está ordenado.");
            return;
        }

        profundidadRecursion++;
        ordenar(array, n - 1);
        profundidadRecursion--;

        int ultimo = array[n - 1];
        int j = n - 2;
        
        System.out.println(getIndent() + "Vuelta de recursión (n=" + n + "). Tratando de insertar el último elemento: " + ultimo);
        
        if (j >= 0) {
            System.out.println(getIndent() + "  Comparando array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> " + (array[j] > ultimo));
        }

        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            System.out.println(getIndent() + "  Desplazamiento a la derecha: array[" + (j + 1) + "] = " + array[j] + " -> " + arrayToString(array));
            j--;
            
            if (j >= 0) {
                System.out.println(getIndent() + "  Comparando array[" + j + "]=" + array[j] + " > ultimo=" + ultimo + " -> " + (array[j] > ultimo));
            }
        }
        array[j + 1] = ultimo;
        System.out.println(getIndent() + "  Insertando elemento: array[" + (j + 1) + "] = " + ultimo + " -> " + arrayToString(array));

        if (profundidadRecursion == 0) {
            System.out.println("Estado final: " + arrayToString(array));
        }
    }
}
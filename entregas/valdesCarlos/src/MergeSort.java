public class MergeSort {

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


    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (profundidadRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial: " + arrayToString(array));
        }

        System.out.println(getIndent() + "Llamada ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(getIndent() + "-> Caso base alcanzado (izq >= der). El subarray de 1 elemento está ordenado por definición.");
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(getIndent() + "Dividiendo el array en el medio: " + medio);

        profundidadRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        profundidadRecursion--;

        System.out.println(getIndent() + "Llamando a fusionar(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + ")");
        fusionar(array, izquierda, medio, derecha);

        if (profundidadRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado final: " + arrayToString(array));
        }
    }


    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial: " + arrayToString(array));
        int n = array.length;
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n[Iteración] fusionando subarrays de tamaño: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("  Llamando a fusionar(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + ")");
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("\nEstado final: " + arrayToString(array));
    }


    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
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
        
        System.out.println(getIndent() + "  [Fusión] Mitad Izquierda: " + arrayToString(mitadIzquierda) + " | Mitad Derecha: " + arrayToString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            boolean condicion = (mitadIzquierda[i] <= mitadDerecha[j]);
            System.out.println(getIndent() + "  Comparando izq[" + i + "]=" + mitadIzquierda[i] + " <= der[" + j + "]=" + mitadDerecha[j] + " -> " + condicion);
            
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                System.out.println(getIndent() + "  Tomando de izquierda: array[" + k + "] = " + mitadIzquierda[i] + " -> " + arrayToString(array));
                i++;
            } else {
                array[k] = mitadDerecha[j];
                System.out.println(getIndent() + "  Tomando de derecha: array[" + k + "] = " + mitadDerecha[j] + " -> " + arrayToString(array));
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(getIndent() + "  Copiando resto de izquierda: array[" + k + "] = " + mitadIzquierda[i] + " -> " + arrayToString(array));
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(getIndent() + "  Copiando resto de derecha: array[" + k + "] = " + mitadDerecha[j] + " -> " + arrayToString(array));
            j++;
            k++;
        }
        System.out.println(getIndent() + "  Resultado tras fusión del tramo: " + arrayToString(array));
    }
}
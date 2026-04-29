public class MergeSortRecursivo {

    private static int nivelRecursion = 0;

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial del array (Merge Sort Recursivo):");
        imprimirArray(array, "");
        System.out.println("Iniciando proceso de ordenacion...");
        ordenar(array, 0, array.length - 1);
        System.out.println("Proceso finalizado. Estado final del array:");
        imprimirArray(array, "");
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = obtenerIndentacion(nivelRecursion);
        System.out.println(ind + "Llamada a ordenar: izquierda=" + izquierda + ", derecha=" + derecha);
        
        if (izquierda >= derecha) {
            System.out.println(ind + "CASO BASE ALCANZADO: izquierda (" + izquierda + ") >= derecha (" + derecha + "). El sub-array tiene 1 o 0 elementos y esta ordenado.");
            return;
        }
        
        nivelRecursion++;
        String indHijo = obtenerIndentacion(nivelRecursion);
        
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(indHijo + "Punto medio calculado: " + medio);
        
        System.out.println(indHijo + "Desglosando mitad izquierda [" + izquierda + " a " + medio + "]");
        ordenar(array, izquierda, medio);
        
        System.out.println(indHijo + "Desglosando mitad derecha [" + (medio + 1) + " a " + derecha + "]");
        ordenar(array, medio + 1, derecha);
        
        System.out.println(indHijo + "Fusionando sub-arrays: izquierda=" + izquierda + ", medio=" + medio + ", derecha=" + derecha);
        fusionar(array, izquierda, medio, derecha);
        
        nivelRecursion--;
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String ind = obtenerIndentacion(nivelRecursion);
        int tamañoIzquierda = medio - izquierda + 1;
        int tamañoDerecha = derecha - medio;
        
        int[] mitadIzquierda = new int[tamañoIzquierda];
        int[] mitadDerecha = new int[tamañoDerecha];
        
        System.out.println(ind + "Copiando datos a arreglos temporales de tamanos " + tamañoIzquierda + " y " + tamañoDerecha);
        for (int i = 0; i < tamañoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamañoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamañoIzquierda && j < tamañoDerecha) {
            System.out.println(ind + "Comparando mitadIzquierda[" + i + "] (" + mitadIzquierda[i] + ") <= mitadDerecha[" + j + "] (" + mitadDerecha[j] + ")");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(ind + "Resultado verdadero: insertando " + mitadIzquierda[i] + " en array[" + k + "]");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(ind + "Resultado falso: insertando " + mitadDerecha[j] + " en array[" + k + "]");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        
        if (i < tamañoIzquierda) {
            System.out.println(ind + "Vaciando elementos restantes de la mitad izquierda:");
        }
        while (i < tamañoIzquierda) {
            System.out.println(ind + "Insertando " + mitadIzquierda[i] + " en array[" + k + "]");
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        
        if (j < tamañoDerecha) {
            System.out.println(ind + "Vaciando elementos restantes de la mitad derecha:");
        }
        while (j < tamañoDerecha) {
            System.out.println(ind + "Insertando " + mitadDerecha[j] + " en array[" + k + "]");
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
        System.out.println(ind + "Estado del array tras la fusion:");
        imprimirArray(array, ind);
    }

    public static String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void imprimirArray(int[] array, String ind) {
        System.out.print(ind + "[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
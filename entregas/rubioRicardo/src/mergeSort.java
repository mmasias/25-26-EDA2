import java.util.Arrays;

public class mergeSort {

    private static int nivelRecursion = 0;

   
    public static void ordenar(int[] array, int izquierda, int derecha) {
        imprimirInicioRecursivo(array, izquierda, derecha);
        
        String tab = obtenerIndentacion(nivelRecursion);
        System.out.println(tab + "Llamada: ordenar(array, izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(tab + "  [Caso Base Alcanzado] izq (" + izquierda + ") >= der (" + derecha + ").");
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(tab + "  Punto medio calculado: " + medio);
        
        nivelRecursion++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivelRecursion--;
        
        System.out.println(tab + "  -> Fusionando(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + ")");
        fusionar(array, izquierda, medio, derecha);
        
        imprimirFinRecursivo(array, izquierda, derecha);
    }

  
    public static void ordenarIterativo(int[] array) {
        System.out.println("Estado inicial (Iterativo): " + Arrays.toString(array));
        int n = array.length;
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n--- Bloques de tamaño: " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("  -> Fusionando(izq=" + izquierda + ", medio=" + medio + ", der=" + derecha + ")");
                fusionar(array, izquierda, medio, derecha);
            }
        }
        System.out.println("\nEstado final (Iterativo): " + Arrays.toString(array));
    }

    
    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String tab = obtenerIndentacion(nivelRecursion) + "    ";
        
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
        
        System.out.println(tab + "Sub-array izquierdo: " + Arrays.toString(mitadIzquierda));
        System.out.println(tab + "Sub-array derecho:   " + Arrays.toString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println(tab + "[Comparación] mitadIzq[" + i + "]=" + mitadIzquierda[i] + " <= mitadDer[" + j + "]=" + mitadDerecha[j] + " -> " + (mitadIzquierda[i] <= mitadDerecha[j]));
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                i++;
                System.out.println(tab + "  Tomado de izquierda. Array parcial: " + Arrays.toString(array));
            } else {
                array[k] = mitadDerecha[j];
                j++;
                System.out.println(tab + "  Tomado de derecha. Array parcial: " + Arrays.toString(array));
            }
            k++;
        }
        
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            i++;
            k++;
            System.out.println(tab + "Vaciando resto izquierdo. Array parcial: " + Arrays.toString(array));
        }
        
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            j++;
            k++;
            System.out.println(tab + "Vaciando resto derecho. Array parcial: " + Arrays.toString(array));
        }
    }

    
    private static void imprimirInicioRecursivo(int[] array, int izquierda, int derecha) {
        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("Estado inicial (Recursivo): " + Arrays.toString(array));
        }
    }

    private static void imprimirFinRecursivo(int[] array, int izquierda, int derecha) {
        if (nivelRecursion == 0 && izquierda == 0 && derecha == array.length - 1) {
            System.out.println("\nEstado final (Recursivo): " + Arrays.toString(array));
        }
    }

    private static String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) sb.append("    ");
        return sb.toString();
    }
}
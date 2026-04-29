import java.util.Arrays;

public class MergeSort {


    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String prefijo = "   ".repeat(nivel);
        System.out.println(prefijo + "Llamada recursiva MergeSort (izq=" + izquierda + ", der=" + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(prefijo + "--> CASO BASE ALCANZADO: izq >= der. Un sub-array de 1 o 0 elementos ya está ordenado.");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(prefijo + "Dividiendo por la mitad (medio=" + medio + ")");
        
        ordenar(array, izquierda, medio, nivel + 1);
        ordenar(array, medio + 1, derecha, nivel + 1);
        
        System.out.println(prefijo + "Iniciando fusión de mitades (izq=" + izquierda + " a medio=" + medio + ", y medio+1=" + (medio + 1) + " a der=" + derecha + ")");
        fusionar(array, izquierda, medio, derecha, nivel);
    }


    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("-> Iteración: Procesando sub-arrays de tamaño = " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                
                System.out.println("   Fusionando bloques: izq=" + izquierda + ", medio=" + medio + ", der=" + derecha);
                fusionar(array, izquierda, medio, derecha, 1);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, int nivel) {
        String prefijo = "   ".repeat(nivel);
        
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

        System.out.println(prefijo + "  Sub-array Izquierdo: " + Arrays.toString(mitadIzquierda));
        System.out.println(prefijo + "  Sub-array Derecho:   " + Arrays.toString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print(prefijo + "  Comparando izq["+i+"]=" + mitadIzquierda[i] + " con der["+j+"]=" + mitadDerecha[j] + " -> ");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(mitadIzquierda[i] + " es MENOR o IGUAL. Se coloca en el array principal.");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(mitadDerecha[j] + " es MENOR. Se coloca en el array principal.");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
            System.out.println(prefijo + "    Estado actual: " + Arrays.toString(array));
        }

        while (i < tamanoIzquierda) {
            System.out.println(prefijo + "  Volcando resto izquierdo: " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++; k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(prefijo + "  Volcando resto derecho: " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++; k++;
        }
        System.out.println(prefijo + "  Array resultante tras fusión: " + Arrays.toString(array) + "\n");
    }
}
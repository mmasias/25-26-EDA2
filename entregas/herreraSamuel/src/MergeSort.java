public class MergeSort {

    private static int profundidad = 0;

    public static void main(String[] args) {
        int[] arrayPrueba = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== MERGE SORT RECURSIVO ===");
        System.out.print("Estado inicial: ");
        mostrarEstado(arrayPrueba);
        
        ordenar(arrayPrueba, 0, arrayPrueba.length - 1);
        
        System.out.print("\nEstado final: ");
        mostrarEstado(arrayPrueba);
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String sangria = generarSangria(profundidad);
        
        if (izquierda >= derecha) {
            System.out.println(sangria + "[CASO BASE]: Rango [" + izquierda + "," + derecha + "] es un solo elemento: " + array[izquierda]);
        } else {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            System.out.println(sangria + "--> Dividiendo rango [" + izquierda + "," + derecha + "] en punto " + medio);
            
            profundidad++;
            System.out.println(sangria + "  Llamada Izquierda:");
            ordenar(array, izquierda, medio);
            
            System.out.println(sangria + "  Llamada Derecha:");
            ordenar(array, medio + 1, derecha);
            profundidad--;
            
            fusionar(array, izquierda, medio, derecha, sangria);
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, String sangria) {
        System.out.println(sangria + "  == FUSIONANDO rumbos [" + izquierda + "-" + medio + "] y [" + (medio + 1) + "-" + derecha + "] ==");
        
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
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print(sangria + "    Comparando: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + "? ");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("SÍ. Elegido: " + mitadIzquierda[i]);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println("NO. Elegido: " + mitadDerecha[j]);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
            System.out.print(sangria + "    Estado actual: ");
            mostrarEstado(array);
        }
        
        while (i < tamanoIzquierda) {
            System.out.println(sangria + "    Restante Izquierda: " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(sangria + "    Restante Derecha: " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
        System.out.print(sangria + "  Resultado fusión: ");
        mostrarEstado(array);
    }

    private static void mostrarEstado(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    private static String generarSangria(int nivel) {
        String resultado = "";
        for (int i = 0; i < nivel; i++) {
            resultado += "│   "; 
        }
        return resultado;
    }
}
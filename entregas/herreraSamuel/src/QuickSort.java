public class QuickSort {

    private static int profundidad = 0;
    public static void main(String[] args) {
        int[] arrayPrueba = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== QUICK SORT RECURSIVO ===");
        System.out.print("Estado inicial: ");
        mostrarEstado(arrayPrueba);
        
        ordenar(arrayPrueba, 0, arrayPrueba.length - 1);
        
        System.out.print("\nEstado final: ");
        mostrarEstado(arrayPrueba);
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String sangria = generarSangria(profundidad);
        
        if (izquierda < derecha) {
            System.out.println(sangria + "--> Ordenando rango [" + izquierda + "," + derecha + "]");
            
            int indicePivote = particionar(array, izquierda, derecha, sangria);
            
            profundidad++;
            System.out.println(sangria + "  Llamada Izquierda (menores que " + array[indicePivote] + "):");
            ordenar(array, izquierda, indicePivote - 1);
            
            System.out.println(sangria + "  Llamada Derecha (mayores que " + array[indicePivote] + "):");
            ordenar(array, indicePivote + 1, derecha);
            profundidad--;
            
        } else {
            System.out.println(sangria + "[CASO BASE]: Rango [" + izquierda + "," + derecha + "] ya es indivisible.");
        }
    }

    private static int particionar(int[] array, int izquierda, int derecha, String sangria) {
        int pivote = array[derecha];
        System.out.println(sangria + "  [PARTICIÓN] Pivote elegido: " + pivote + " (en índice " + derecha + ")");
        
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.print(sangria + "    ¿Es " + array[j] + " <= " + pivote + "? ");
            if (array[j] <= pivote) {
                System.out.println("SÍ.");
                i++;
                if (i != j) {
                    intercambiar(array, i, j, sangria + "    ");
                }
            } else {
                System.out.println("NO.");
            }
        }
        
        System.out.println(sangria + "  Colocando pivote " + pivote + " en su posición final:");
        intercambiar(array, i + 1, derecha, sangria + "  ");
        
        return i + 1;
    }

    private static void intercambiar(int[] array, int idx1, int idx2, String sangria) {
        int temporal = array[idx1];
        System.out.print(sangria + "Intercambiando " + array[idx1] + " por " + array[idx2] + " -> ");
        array[idx1] = array[idx2];
        array[idx2] = temporal;
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
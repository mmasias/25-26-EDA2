public class InsertionSort {

    private static int profundidad = 0;

    public static void main(String[] args) {
        int[] arrayPrueba = {5, 2, 8, 1, 9, 3};

        System.out.println("--- PROBANDO INSERTION SORT ITERATIVO ---");
        ordenarIterativo(arrayPrueba.clone()); 

        System.out.println("\n--- PROBANDO INSERTION SORT RECURSIVO ---");
        ordenarRecursivo(arrayPrueba, arrayPrueba.length);
    }

    public static void ordenarIterativo(int[] array) {
        System.out.print("Estado inicial: ");
        mostrarEstado(array);

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\nIteración i=" + i + ". Elemento a insertar: " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("  ¿Es " + array[j] + " > " + actual + "? SÍ. Desplazando.");
                array[j + 1] = array[j];
                j--;
                mostrarEstado(array);
            }
            
            if (j >= 0) {
                System.out.println("  ¿Es " + array[j] + " > " + actual + "? NO. Posición hallada.");
            }

            array[j + 1] = actual;
            System.out.print("  Inserción final: ");
            mostrarEstado(array);
        }
        System.out.print("\nEstado final: ");
        mostrarEstado(array);
    }

    public static void ordenarRecursivo(int[] array, int n) {
        String sangria = generarSangria(profundidad);
        
        if (n > 1) {
            System.out.println(sangria + "--> Llamada ordenar(n=" + n + ")");
            
            profundidad++;
            ordenarRecursivo(array, n - 1);
            profundidad--;

            int ultimo = array[n - 1];
            int j = n - 2;

            System.out.println(sangria + "  Insertando: " + ultimo);
            while (j >= 0 && array[j] > ultimo) {
                System.out.println(sangria + "    ¿" + array[j] + " > " + ultimo + "? SÍ. Desplazando.");
                array[j + 1] = array[j];
                j--;
                mostrarEstado(array);
            }
            array[j + 1] = ultimo;
            System.out.print(sangria + "  Resultado: ");
            mostrarEstado(array);
        } else {
            System.out.println(sangria + "[CASO BASE] n=" + n + ": El primer elemento ya está ordenado.");
        }
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
            resultado += "  ";
        }
        return resultado;
    }
}
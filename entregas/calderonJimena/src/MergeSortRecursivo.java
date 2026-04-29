public class MergeSortRecursivo {

    private static int nivel = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(identar() + "ordenar(array, " + izquierda + ", " + derecha + ")");
        if (izquierda >= derecha) {
            System.out.println(identar() + "Caso base: izquierda >= derecha");
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        nivel++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivel--;
        fusionar(array, izquierda, medio, derecha);
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
        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(identar() + "Comparacion: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " = true");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(identar() + "Comparacion: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " = false");
                array[k] = mitadDerecha[j];
                j++;
            }
            System.out.println(identar() + "Array: " + mostrar(array));
            k++;
        }
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.println(identar() + "Array: " + mostrar(array));
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.println(identar() + "Array: " + mostrar(array));
            j++;
            k++;
        }
    }

    private static String identar() {
        String texto = "";
        for (int i = 0; i < nivel; i++) texto += "  ";
        return texto;
    }

    private static String mostrar(int[] array) {
        String texto = "[";
        for (int i = 0; i < array.length; i++) {
            texto += array[i];
            if (i < array.length - 1) texto += ", ";
        }
        return texto + "]";
    }
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
    
        System.out.println("Merge Sort Recursivo");
        System.out.println("Estado inicial: " + mostrar(array));
    
        ordenar(array, 0, array.length - 1);
    
        System.out.println("Estado final: " + mostrar(array));
    }
}
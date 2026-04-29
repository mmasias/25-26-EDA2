public class InsertionSort {

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("\n┌── [ITERACIÓN i=" + i + "] Analizando elemento: " + actual);
            mostrar(array, i, "│   ");
            
            while (j >= 0 && array[j] > actual) {
                System.out.println("│   | Comparando array[" + j + "]=" + array[j] + " > actual=" + actual + " -> VERDADERO");
                System.out.println("│   | Desplazando " + array[j] + " a la derecha.");
                array[j + 1] = array[j];
                j--;
            }
            if (j >= 0) {
                System.out.println("│   | Comparando array[" + j + "]=" + array[j] + " > actual=" + actual + " -> FALSO (Fin de desplazamientos)");
            }
            
            System.out.println("│   | Insertando " + actual + " en el índice " + (j + 1));
            array[j + 1] = actual;
            mostrar(array, j + 1, "└── ");
        }
    }

    public static void ordenar(int[] array, int n) {
        String tabs = "    ".repeat(array.length - n);

        if (n <= 1) {
            System.out.println(tabs + "-> CASO BASE ALCANZADO: Sub-array de tamaño " + n + ". Un solo elemento ya está ordenado.");
            return;
        }
        System.out.println(tabs + "-> AVANZANDO: Llamada recursiva para n=" + (n - 1));
        ordenar(array, n - 1);
        
        int ultimo = array[n - 1];
        int j = n - 2;
        System.out.println(tabs + "┌── Retorno de recursión (n=" + n + "). Elemento a insertar: " + ultimo);
        mostrar(array, n - 1, tabs + "│   ");

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(tabs + "│   | Comparación: " + array[j] + " > " + ultimo + " -> VERDADERO. Desplazando " + array[j] + " a la derecha.");
            array[j + 1] = array[j];
            j--;
        }
        if (j >= 0) {
            System.out.println(tabs + "│   | Comparación: " + array[j] + " > " + ultimo + " -> FALSO.");
        }
        
        System.out.println(tabs + "│   | Insertando " + ultimo + " en la posición " + (j + 1));
        array[j + 1] = ultimo;
        mostrar(array, j + 1, tabs + "└── ");
    }

    public static void mostrar(int[] array, int indiceDestacado, String prefijo) {
        System.out.print(prefijo + "ARRAY: [ ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.print("ARRAY INICIAL (Iterativo): [ 5 2 8 1 9 3 ]\n");
        ordenar(array);
        System.out.println("ARRAY FINAL: [ 1 2 3 5 8 9 ]\n");

        System.out.println("\n--------------------   RECURSIVO   -----------------------------\n");

        System.out.print("ARRAY INICIAL (Recursivo): [ 5 2 8 1 9 3 ]\n");
        ordenar(array, array.length);
        System.out.print("ARRAY FINAL: [ ");
        for (int i : array) System.out.print(i + " ");
        System.out.println("]");
    }
}
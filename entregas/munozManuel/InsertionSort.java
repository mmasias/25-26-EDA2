package munozManuel;

class InsertionSort{
    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            System.out.println("El elemento actual(pivote) es: " + actual + "\n");
            int j = i - 1;
            while (j >= 0 && array[j] > actual) {
                array[j + 1] = array[j];
                printArray(array);
                System.out.println("Se cambio el elemento en el indice " + (j+1) + " por el elemento del indice " + j + "\n");
                j--;
                System.out.println("El indice se reduce en uno");
            }
            array[j + 1] = actual;
            System.out.println("El elemento actual se inserta en el indice " + (j+1) + "\n");
            System.out.println("El array actual tiene este orden ");
            printArray(array);
        }
        System.out.println("Al terminar asi es el array resultante: ");
        printArray(array);

    }

    public static void ordenar(int[] array, int n, int[] profundidad) {
        if (n <= 1) {
            System.out.println("---LLegada a caso base, el valor de n es: " + n + "---");
            return;
        }
        System.out.println("---".repeat(profundidad[0]) + "Empezando llamadas recursivas, el valor de n es: " + n);
        profundidad[0]++;
        ordenar(array, n - 1, profundidad);
        profundidad[0]--;
        System.out.println("---".repeat(profundidad[0]) + "Parada de la llamada recursiva, valor de n: " + n);
        int ultimo = array[n - 1];
        System.out.println("---".repeat(profundidad[0]) + "El valor de ultimo es: " + ultimo);
        int j = n - 2;
        System.out.println( "---".repeat(profundidad[0]) + "El valor de j es: " + j);
        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            System.out.println( "---".repeat(profundidad[0]) + "Se cambio el elemento en el indice " + (j+1) + " por el elemento del indice " + j + "\n");
            j--;
            System.out.println("---".repeat(profundidad[0]) + "El indice se reduce en uno");
        }
        array[j + 1] = ultimo;
        System.out.println("---".repeat(profundidad[0]) + "El elemento actual se inserta en el indice " + (j+1) + "\n");
        System.out.println("---".repeat(profundidad[0]) + "El array actual tiene este orden ");
        printArray(array);
    }

    private static void printArray(int[] array){
        for (int numero : array){
            System.out.print(numero + " ");
        }
        System.out.println("");
    }
}
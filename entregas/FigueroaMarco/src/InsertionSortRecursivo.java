public class InsertionSortRecursivo {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array, array.length);
        for (int num : array) {
            System.out.print(num + " ");
        }

    }

    public static void ordenar(int[] array, int n) {
        System.out.println("Ordenando el array utilizando Insertion Sort Recursivo...");
        System.out.println("Evaluando el caso base para n = " + n);
        if (n <= 1) {
            return;
        }
        System.out.println(
                "Entrando a la llamada recursiva para ordenar los primeros " + (n - 1) + " elementos del array");
        ordenar(array, n - 1);
        int ultimo = array[n - 1];
        System.out.println("Valor actual a insertar: " + ultimo);
        int j = n - 2;
        System.out.println("    A recorrer desde el indice " + j + " del array");
        System.out.println("Comparando el valor actual con los elementos anteriores del array");
        while (j >= 0 && array[j] > ultimo) {
            System.out.println("    Comparando " + array[j] + " con " + ultimo);
            System.out.println("    El elemento " + array[j] + " es mayor que " + ultimo + ", moviendo " + array[j]
                    + " a la posición " + (j + 1));
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = ultimo;
    }
}

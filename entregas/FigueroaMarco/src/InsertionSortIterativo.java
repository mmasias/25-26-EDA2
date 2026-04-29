
public class InsertionSortIterativo {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void ordenar(int[] array) {
        System.out.println("Ordenando el array utilizando Insertion Sort Iterativo...");
        System.out.println("A iterar sobre los " + array.length + " elementos del array");
        for (int i = 1; i < array.length; i++) {
            System.out.println("Iteración " + i + ":");
            int actual = array[i];
            System.out.println("    Valor actual: " + actual);
            int j = i - 1;
            System.out.println("    A recorrer desde el indice " + j + " del array");
            while (j >= 0 && array[j] > actual) {
                System.out.println("    Comparando " + array[j] + " con " + actual);
                System.out.println("    El elemento " + array[j] + " es mayor que " + actual + ", moviendo " + array[j]
                        + " a la posición " + (j + 1));
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
        }
    }
}

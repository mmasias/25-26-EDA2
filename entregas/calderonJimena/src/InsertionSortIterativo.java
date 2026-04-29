public class InsertionSortIterativo {

    public static void ordenar(int[] array) {
        System.out.println("Insertion Sort Iterativo");
        System.out.println("Estado inicial: " + mostrar(array));

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            System.out.println("Actual: " + actual);
            while (j >= 0 && array[j] > actual) {
                System.out.println("Comparacion: " + array[j] + " > " + actual + " = true");
                array[j + 1] = array[j];
                System.out.println("Desplazamiento: " + mostrar(array));
                j--;
            }
            if (j >= 0) {
                System.out.println("Comparacion: " + array[j] + " > " + actual + " = false");
            } else {
                System.out.println("Comparacion: j >= 0 = false");
            }

            array[j + 1] = actual;
            System.out.println("Insercion: " + mostrar(array));
        }

        System.out.println("Estado final: " + mostrar(array));
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
        ordenar(array);
    }
}
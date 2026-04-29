public class InsertionSort {

    private static int nivelRecursivo = 0;

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("i = " + i + ", actual = " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("Comparación: " + array[j] + " > " + actual + " -> verdadero");
                System.out.println("Desplazamiento: " + array[j] + " de posición " + j + " a posición " + (j + 1));
                array[j + 1] = array[j];
                Trazas.array(array, 0);
                j--;
            }

            if (j >= 0) {
                System.out.println("Comparación: " + array[j] + " > " + actual + " -> falso");
            } else {
                System.out.println("Caso límite: j < 0, no quedan elementos anteriores");
            }

            array[j + 1] = actual;
            System.out.println("Inserción: " + actual + " en posición " + (j + 1));
            Trazas.array(array, 0);
        }
    }

    public static void ordenar(int[] array, int n) {
        System.out.println(Trazas.indentar(nivelRecursivo) + "Llamada ordenar(array, n = " + n + ")");

        if (n <= 1) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Caso base: n <= 1");
            return;
        }

        nivelRecursivo++;
        ordenar(array, n - 1);
        nivelRecursivo--;

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(Trazas.indentar(nivelRecursivo) + "Insertar último = " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(
                    Trazas.indentar(nivelRecursivo) + "Comparación: " + array[j] + " > " + ultimo + " -> verdadero");
            System.out.println(Trazas.indentar(nivelRecursivo) + "Desplazamiento: " + array[j] + " de posición " + j
                    + " a posición " + (j + 1));
            array[j + 1] = array[j];
            Trazas.array(array, nivelRecursivo);
            j--;
        }

        if (j >= 0) {
            System.out.println(
                    Trazas.indentar(nivelRecursivo) + "Comparación: " + array[j] + " > " + ultimo + " -> falso");
        } else {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Caso límite: j < 0, no quedan elementos anteriores");
        }

        array[j + 1] = ultimo;
        System.out.println(Trazas.indentar(nivelRecursivo) + "Inserción: " + ultimo + " en posición " + (j + 1));
        Trazas.array(array, nivelRecursivo);
    }
}
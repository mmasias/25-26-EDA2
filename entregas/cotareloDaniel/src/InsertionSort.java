public class InsertionSort {

    private static int nivel;

    public static void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            System.out.println("Se toma actual = array[" + i + "] = " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("Comparacion: array[" + j + "] = " + array[j] + " > actual = " + actual + " -> verdadero");

                array[j + 1] = array[j];

                System.out.println("Modificacion: array[" + (j + 1) + "] recibe array[" + j + "] = " + array[j]);
                System.out.println("Array: " + Formato.formatear(array));

                j--;
            }

            if (j >= 0) {
                System.out.println("Comparacion: array[" + j + "] = " + array[j] + " > actual = " + actual + " -> falso");
            } else {
                System.out.println("Decision: j < 0 -> no quedan elementos a la izquierda");
            }

            array[j + 1] = actual;

            System.out.println("Modificacion: array[" + (j + 1) + "] recibe actual = " + actual);
            System.out.println("Array: " + Formato.formatear(array));
        }
    }

    public static void ordenar(int[] array, int n) {
        if (n == array.length) {
            nivel = 0;
        }

        System.out.println(Formato.sangria(nivel) + "Llamada ordenar(array, n = " + n + ")");

        if (n <= 1) {
            System.out.println(Formato.sangria(nivel) + "Caso base alcanzado: n <= 1, porque un tramo con un solo elemento o ninguno ya esta ordenado");
            return;
        }

        nivel++;
        ordenar(array, n - 1);
        nivel--;

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(Formato.sangria(nivel) + "Se toma ultimo = array[" + (n - 1) + "] = " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(Formato.sangria(nivel) + "Comparacion: array[" + j + "] = " + array[j] + " > ultimo = " + ultimo + " -> verdadero");

            array[j + 1] = array[j];

            System.out.println(Formato.sangria(nivel) + "Modificacion: array[" + (j + 1) + "] recibe array[" + j + "] = " + array[j]);
            System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));

            j--;
        }

        if (j >= 0) {
            System.out.println(Formato.sangria(nivel) + "Comparacion: array[" + j + "] = " + array[j] + " > ultimo = " + ultimo + " -> falso");
        } else {
            System.out.println(Formato.sangria(nivel) + "Decision: j < 0 -> no quedan elementos a la izquierda");
        }

        array[j + 1] = ultimo;

        System.out.println(Formato.sangria(nivel) + "Modificacion: array[" + (j + 1) + "] recibe ultimo = " + ultimo);
        System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));
    }
}
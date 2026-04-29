public class QuickSort {

    private static int nivel;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda == 0 && derecha == array.length - 1) {
            nivel = 0;
        }

        System.out.println(Formato.sangria(nivel) + "Llamada ordenar(array, izquierda = " + izquierda + ", derecha = " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(Formato.sangria(nivel) + "Caso base alcanzado: izquierda >= derecha, porque el tramo tiene un solo elemento o ninguno");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha);

        nivel++;
        ordenar(array, izquierda, indicePivote - 1);
        nivel--;

        nivel++;
        ordenar(array, indicePivote + 1, derecha);
        nivel--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(Formato.sangria(nivel) + "Decision: pivote = array[" + derecha + "] = " + pivote);

        for (int j = izquierda; j < derecha; j++) {
            System.out.println(Formato.sangria(nivel) + "Comparacion: array[" + j + "] = " + array[j] + " <= pivote = " + pivote);

            if (array[j] <= pivote) {
                System.out.println(Formato.sangria(nivel) + "Resultado: verdadero");

                i++;

                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                System.out.println(Formato.sangria(nivel) + "Modificacion: intercambio array[" + i + "] y array[" + j + "]");
                System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));
            } else {
                System.out.println(Formato.sangria(nivel) + "Resultado: falso");
            }
        }

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(Formato.sangria(nivel) + "Modificacion: intercambio final del pivote entre array[" + (i + 1) + "] y array[" + derecha + "]");
        System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));

        return i + 1;
    }
}
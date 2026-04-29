import java.util.Arrays;

public class QuickSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = SoporteTraza.getInd();
        System.out.println(ind + "Llamada recursiva: izquierda=" + izquierda + ", derecha=" + derecha);

        if (izquierda >= derecha) {
            System.out.println(ind + "Caso base alcanzado (izquierda >= derecha).");
            return;
        }

        System.out.println(ind + "Llamando a particionar: izquierda=" + izquierda + ", derecha=" + derecha);
        int indicePivote = particionar(array, izquierda, derecha);

        System.out.println(ind + "Partición terminada. Pivote ubicado en índice " + indicePivote + " -> " + Arrays.toString(array));

        System.out.println(ind + "-> Subarray izquierdo (izquierda=" + izquierda + " a derecha=" + (indicePivote - 1) + ")");
        SoporteTraza.entrarNivel();
        ordenar(array, izquierda, indicePivote - 1);
        SoporteTraza.salirNivel();

        System.out.println(ind + "-> Subarray derecho (izquierda=" + (indicePivote + 1) + " a derecha=" + derecha + ")");
        SoporteTraza.entrarNivel();
        ordenar(array, indicePivote + 1, derecha);
        SoporteTraza.salirNivel();
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String ind = SoporteTraza.getInd();

        int pivote = array[derecha];
        System.out.println(ind + "Pivote seleccionado: array[" + derecha + "] = " + pivote);

        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            System.out.println(ind + "Comparando array[" + j + "]=" + array[j] + " <= pivote=" + pivote + " -> " + (array[j] <= pivote));

            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                System.out.println(ind + "Intercambio en partición: array[" + i + "]=" + array[i] + " con array[" + j + "]=" + temporal + " -> " + Arrays.toString(array));
            }
        }

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(ind + "Ubicación final del pivote: intercambio array[" + (i + 1) + "]=" + array[i + 1] + " con array[" + derecha + "]=" + temporal + " -> " + Arrays.toString(array));

        return i + 1;
    }
}
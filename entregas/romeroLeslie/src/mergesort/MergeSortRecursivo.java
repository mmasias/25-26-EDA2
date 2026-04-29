package mergesort;
import java.util.Arrays;

public class MergeSortRecursivo {

    private static int nivel = 0;

    private static String ind() {
        String s = "";
        for (int k = 0; k < nivel; k++) s += "    ";
        return s;
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(ind() + "ordenar(izq=" + izquierda + ", der=" + derecha + ")");
        
        if (izquierda >= derecha) {
            System.out.println(ind() + "Caso base: " + izquierda + ">=" + derecha);
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
        int tI = medio - izquierda + 1;
        int tD = derecha - medio;
        int[] mI = new int[tI];
        int[] mD = new int[tD];

        for (int i = 0; i < tI; i++) mI[i] = array[izquierda + i];
        for (int i = 0; i < tD; i++) mD[i] = array[medio + 1 + i];

        int i = 0, j = 0, k = izquierda;

        System.out.println(ind() + "Fusionando: " + Arrays.toString(mI) + " y " + Arrays.toString(mD));

        while (i < tI && j < tD) {
            System.out.println(ind() + "Comparar: " + mI[i] + " <= " + mD[j] + " es " + (mI[i] <= mD[j]));
            if (mI[i] <= mD[j]) {
                array[k] = mI[i++];
            } else {
                array[k] = mD[j++];
            }
            System.out.println(ind() + "Array: " + Arrays.toString(array));
            k++;
        }

        while (i < tI) {
            array[k++] = mI[i++];
            System.out.println(ind() + "Resto Izq: " + Arrays.toString(array));
        }
        while (j < tD) {
            array[k++] = mD[j++];
            System.out.println(ind() + "Resto Der: " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + Arrays.toString(array));
        ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + Arrays.toString(array));
    }
}
import java.util.Arrays;

public class MergeSortRecursivoTraza {

    public static void main(String[] args) {

        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("==================================");
        System.out.println("MERGE SORT - RECURSIVO");
        System.out.println("==================================");
        System.out.println("ARRAY INICIAL: " + Arrays.toString(array));

        ordenar(array, 0, array.length - 1);

        System.out.println("==================================");
        System.out.println("ARRAY FINAL : " + Arrays.toString(array));
        System.out.println("==================================");
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {

        System.out.println("----------------------------------");
        System.out.println("> SUBARRAY [" + izquierda + "," + derecha + "]");
        System.out.println("----------------------------------");

        if (izquierda >= derecha) {
            System.out.println("CB: [" + izquierda + "," + derecha + "] -> tamaño 1\n");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println("Divido en:");
        System.out.println("  IZQ [" + izquierda + "," + medio + "]");
        System.out.println("  DER [" + (medio + 1) + "," + derecha + "]\n");

        System.out.println("Paso recursivo IZQ");
        ordenar(array, izquierda, medio);

        System.out.println("Paso recursivo DER");
        ordenar(array, medio + 1, derecha);

        System.out.println("-> Fusiono [" + izquierda + "," + medio + "] con [" + (medio + 1) + "," + derecha + "]");
        System.out.println("Antes: " + Arrays.toString(array));

        fusionar(array, izquierda, medio, derecha);

        System.out.println("Array actual: " + Arrays.toString(array) + "\n");
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {

        int tamamañoIzq = medio - izquierda + 1;
        int tamañoDer = derecha - medio;

        int[] izq = new int[tamamañoIzq];
        int[] der = new int[tamañoDer];

        for (int i = 0; i < tamamañoIzq; i++) izq[i] = array[izquierda + i];
        for (int j = 0; j < tamañoDer; j++) der[j] = array[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;

        System.out.println("  IZQ: " + Arrays.toString(izq));
        System.out.println("  DER: " + Arrays.toString(der) + "\n");

        while (i < tamamañoIzq && j < tamañoDer) {

            System.out.print("  Comparo " + izq[i] + " y " + der[j] + " => ");

            if (izq[i] <= der[j]) {
                System.out.println("Tomo IZQ: " + izq[i] + "\n");
                array[k++] = izq[i++];
            } else {
                System.out.println("Tomo DER: " + der[j] + "\n");
                array[k++] = der[j++];
            }
        }

        while (i < tamamañoIzq) {
            System.out.println("  Copio restante IZQ: " + izq[i] + "\n");
            array[k++] = izq[i++];
        }

        while (j < tamañoDer) {
            System.out.println("  Copio restante DER: " + der[j] + "\n");
            array[k++] = der[j++];
        }
    }
}

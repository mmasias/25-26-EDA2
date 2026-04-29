import java.util.Arrays;

public class MergeSortIterativoTraza {

    public static void main(String[] args) {

        int[] array = {5, 2, 8, 1, 9, 3};

        ordenarIterativo(array);

        System.out.println("==================================");
        System.out.println("ARRAY FINAL : " + Arrays.toString(array));
        System.out.println("==================================");
    }

    public static void ordenarIterativo(int[] array) {

        System.out.println("==================================");
        System.out.println("MERGE SORT - ITERATIVO");
        System.out.println("==================================");
        System.out.println("ARRAY INICIAL: " + Arrays.toString(array));

        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {

            System.out.println("----------------------------------");
            System.out.println("> TAMAÑO: " + tamano);
            System.out.println("----------------------------------");

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {

                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Fusiono [" + izquierda + "," + medio + "] con [" + (medio + 1) + "," + derecha + "] \n");
                System.out.println("Antes: " + Arrays.toString(array));

                fusionar(array, izquierda, medio, derecha);

                System.out.println("Array actual: " + Arrays.toString(array) + "\n");
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {

        int tamIzq = medio - izquierda + 1;
        int tamDer = derecha - medio;

        int[] izq = new int[tamIzq];
        int[] der = new int[tamDer];

        for (int i = 0; i < tamIzq; i++) izq[i] = array[izquierda + i];
        for (int j = 0; j < tamDer; j++) der[j] = array[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;

        System.out.println("  IZQ: " + Arrays.toString(izq));
        System.out.println("  DER: " + Arrays.toString(der)+ "\n");

        while (i < tamIzq && j < tamDer) {

            System.out.print("  Comparo " + izq[i] + " y " + der[j] +" =>");

            if (izq[i] <= der[j]) {
                System.out.println("  Tomo IZQ: " + izq[i]+ "\n");
                array[k++] = izq[i++];
            } else {
                System.out.println("  Tomo DER: " + der[j]+ "\n");
                array[k++] = der[j++];
            }
        }

        while (i < tamIzq) {
            System.out.println("  Copio restante IZQ: " + izq[i]+ "\n");
            array[k++] = izq[i++];
        }

        while (j < tamDer) {
            System.out.println("  Copio restante DER: " + der[j]+ "\n");
            array[k++] = der[j++];
        }
    }
}

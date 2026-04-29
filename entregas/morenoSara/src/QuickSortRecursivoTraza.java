import java.util.Arrays;

public class QuickSortRecursivoTraza {

    public static void main(String[] args) {

        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("==================================");
        System.out.println("QUICKSORT - RECURSIVO");
        System.out.println("==================================");

        System.out.println("ARRAY INICIAL: " + Arrays.toString(array));

        ordenar(array, 0, array.length - 1, 0);

        System.out.println("==================================");
        System.out.println("ARRAY FINAL : " + Arrays.toString(array));
        System.out.println("==================================");
    }

    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {

        String indentacion = "  ".repeat(nivel);

        System.out.println(indentacion + "----------------------------------");
        System.out.println(indentacion + "> SUBARRAY [" + izquierda + "," + derecha + "]");
        System.out.println(indentacion + "----------------------------------");

        if (izquierda >= derecha) {
            System.out.println(indentacion + "CB: [" + izquierda + "," + derecha + "] ");
            System.out.println(indentacion + "<< RETORNA A LA LLAMADA ANTERIOR\n");
            return;
        }

        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(indentacion + "PIVOTE: " + pivote);
        System.out.println(indentacion + "Array actual: " + Arrays.toString(array) + "\n");

        for (int j = izquierda; j < derecha; j++) {

            System.out.print(indentacion + "Comparo " + array[j] + " <= " + pivote + " => ");

            if (array[j] <= pivote) {
                System.out.println("true");

                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                System.out.println(indentacion + "Intercambio -> " + Arrays.toString(array) + "\n");
            } else {
                System.out.println("false");
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temp;

        int indicePivote = i + 1;

        System.out.println(indentacion + "Pivote: " + indicePivote);
        System.out.println(indentacion + "Estado: " + Arrays.toString(array) + "\n");

        System.out.println(indentacion + "Recursivo IZQ");
        ordenar(array, izquierda, indicePivote - 1, nivel + 1);

        System.out.println(indentacion + "Vuelvo de IZQ");

        System.out.println(indentacion + "Recursivo DER");
        ordenar(array, indicePivote + 1, derecha, nivel + 1);

        System.out.println(indentacion + "Vuelvo de DER");
        System.out.println(indentacion + "<< RETORNA A LA LLAMADA ANTERIOR\n");
    }
}

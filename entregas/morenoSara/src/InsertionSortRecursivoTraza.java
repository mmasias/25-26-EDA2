import java.util.Arrays;

public class InsertionSortRecursivoTraza {

    public static void main(String[] args) {

        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("==================================");
        System.out.println("INSERTION SORT - VERSION RECURSIVA");
        System.out.println("==================================");

        System.out.println("ARRAY INICIAL: " + Arrays.toString(array));

        ordenar(array, array.length, 0);

        System.out.println("==================================");
        System.out.println("ARRAY FINAL : " + Arrays.toString(array));
        System.out.println("==================================");
    }

    public static void ordenar(int[] array, int cantidadElementos, int nivelRecursion) {

        String indentacion = "  ".repeat(nivelRecursion);

        System.out.println(indentacion + "------------------------------------------------------------------");
        System.out.println(indentacion + "> LLAMADA RECURSIVA ordenar(cantidadElementos = " + cantidadElementos + ")");
        System.out.println(indentacion + "------------------------------------------------------------------");

        if (cantidadElementos <= 1) {
            System.out.println(indentacion + "CB: cantidadElementos <= 1");
            System.out.println(indentacion + "No se necesita ordenar.\n");
            System.out.println(indentacion + "<< RETORNA A LA LLAMADA ANTERIOR");
            return;
        }

        System.out.println(indentacion + "Paso recursivo: ordenar primeros " + (cantidadElementos - 1) + " elementos.\n");

        ordenar(array, cantidadElementos - 1, nivelRecursion + 1);
        System.out.println(indentacion + "------------------------------------------------------------------");
        System.out.println(indentacion + "> LLAMADA RECURSIVA ordenar(cantidadElementos = " + cantidadElementos + ")");
        System.out.println(indentacion + "------------------------------------------------------------------");
        int ultimoElemento = array[cantidadElementos - 1];
        int j = cantidadElementos - 2;

        System.out.println(indentacion + "Array actual: " + Arrays.toString(array));
        System.out.println(indentacion + "Elemento a insertar: índice [" + (cantidadElementos - 1) + "] -> " + ultimoElemento + "\n");

        while (j >= 0 && array[j] > ultimoElemento) {

            System.out.println(indentacion + "Comparo array[" + j + "] = " + array[j] + " > " + ultimoElemento + " => true");

            array[j + 1] = array[j];

            System.out.println(indentacion + "Desplazo " + array[j] + " desde índice " + j + " a índice " + (j + 1) + ": " + Arrays.toString(array) + "\n");

            j--;
        }

        if (j >= 0) {
            System.out.println(indentacion + "Comparo array[" + j + "] = " + array[j] + " > " + ultimoElemento + " => false");
        } else {
            System.out.println(indentacion + "Fin iteración: se salió por el inicio del array.");
        }

        array[j + 1] = ultimoElemento;

        System.out.println(indentacion + "Inserto " + ultimoElemento + " en índice " + (j + 1) + ": " + Arrays.toString(array) + "\n");
        System.out.println(indentacion + "<< RETORNA A LA LLAMADA ANTERIOR\n");

    }
}
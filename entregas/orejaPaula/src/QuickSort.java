public class QuickSort {

    private static int nivelRecursivo = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(Trazas.indentar(nivelRecursivo) + "Llamada ordenar(array, izquierda = " + izquierda + ", derecha = " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Caso base: izquierda >= derecha");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha);

        System.out.println(Trazas.indentar(nivelRecursivo) + "Pivote colocado en índice " + indicePivote);
        Trazas.array(array, nivelRecursivo);

        nivelRecursivo++;
        ordenar(array, izquierda, indicePivote - 1);
        nivelRecursivo--;

        nivelRecursivo++;
        ordenar(array, indicePivote + 1, derecha);
        nivelRecursivo--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(Trazas.indentar(nivelRecursivo) + "Partición desde " + izquierda + " hasta " + derecha);
        System.out.println(Trazas.indentar(nivelRecursivo) + "Pivote = " + pivote);

        for (int j = izquierda; j < derecha; j++) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Comparación: array[" + j + "] = " + array[j] + " <= " + pivote);

            if (array[j] <= pivote) {
                System.out.println(Trazas.indentar(nivelRecursivo) + "Resultado: verdadero");

                i++;

                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                System.out.println(Trazas.indentar(nivelRecursivo) + "Intercambio posiciones " + i + " y " + j);
                Trazas.array(array, nivelRecursivo);
            } else {
                System.out.println(Trazas.indentar(nivelRecursivo) + "Resultado: falso. No hay intercambio");
            }
        }

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(Trazas.indentar(nivelRecursivo) + "Intercambio final del pivote con posición " + (i + 1));
        Trazas.array(array, nivelRecursivo);

        return i + 1;
    }
}
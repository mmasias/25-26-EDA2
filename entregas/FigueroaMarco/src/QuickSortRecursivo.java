
public class QuickSortRecursivo {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 9, 3 };
        ordenar(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println("Ordenando el array utilizando Quick Sort Recursivo...");
        System.out.println(
                "Evaluando el caso base para el subarray desde el indice " + izquierda + " hasta el indice " + derecha);
        if (izquierda >= derecha) {
            return;
        }
        System.out.println(
                "Particionando el subarray desde el indice " + izquierda + " hasta el indice " + derecha
                        + " utilizando el último elemento como pivote");
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(
                "El pivote se encuentra en el indice " + indicePivote + ", dividiendo el subarray en: [" + izquierda
                        + ", "
                        + (indicePivote - 1) + "] y [" + (indicePivote + 1) + ", " + derecha + "]");
        ordenar(array, izquierda, indicePivote - 1);
        System.out.println(
                "Entrando a la llamada recursiva para ordenar el subarray derecho desde el indice " + (indicePivote + 1)
                        + " hasta el indice " + derecha);
        ordenar(array, indicePivote + 1, derecha);
        System.out.println(
                "El subarray desde el indice " + izquierda + " hasta el indice " + derecha + " ha sido ordenado");
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        System.out.println("Particionando el subarray desde el indice " + izquierda + " hasta el indice " + derecha
                + " utilizando el último elemento como pivote");
        int pivote = array[derecha];
        System.out.println("El pivote seleccionado es " + pivote);
        int i = izquierda - 1;
        System.out.println("Inicializando el índice del pivote a " + i);
        for (int j = izquierda; j < derecha; j++) {
            System.out.println("Comparando el elemento " + array[j] + " con el pivote " + pivote);
            if (array[j] <= pivote) {
                System.out.println("El elemento " + array[j]
                        + " es menor o igual que el pivote, incrementando el índice del pivote a " + (i + 1));
                i++;
                int temporal = array[i];
                System.out.println("Intercambiando " + array[i] + " con " + array[j]);
                array[i] = array[j];
                System.out.println("El elemento " + array[i] + " se ha movido a la posición " + i);
                array[j] = temporal;
                System.out.println("    Intercambiando " + array[j] + " con " + array[i]);
            }
        }
        int temporal = array[i + 1];
        System.out.println("Intercambiando el pivote " + array[derecha] + " con el elemento en la posición " + (i + 1));
        array[i + 1] = array[derecha];
        System.out.println("El pivote " + array[i + 1] + " se ha movido a la posición " + (i + 1));
        array[derecha] = temporal;
        System.out.println("Intercambiando " + array[derecha] + " con " + array[i + 1]);
        return i + 1;
    }
}

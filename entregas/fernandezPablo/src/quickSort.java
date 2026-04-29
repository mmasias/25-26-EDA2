import java.util.Arrays;

public class quickSort {

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            System.out.printf("%sCaso base: Rango [%d, %d] ordenado/unitario.%n", Soporte.ind(), izquierda, derecha);
            return;
        }
        
        System.out.printf("%sParticionando rango [%d..%d]%n", Soporte.ind(), izquierda, derecha);
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.printf("%sPivote definitivo en índice %d. Array: %s%n", Soporte.ind(), indicePivote, Arrays.toString(array));

        Soporte.nivelRecursion++;
        System.out.printf("%sLlamada izquierda [%d..%d]:%n", Soporte.ind(), izquierda, indicePivote - 1);
        ordenar(array, izquierda, indicePivote - 1);
        
        System.out.printf("%sLlamada derecha [%d..%d]:%n", Soporte.ind(), indicePivote + 1, derecha);
        ordenar(array, indicePivote + 1, derecha);
        Soporte.nivelRecursion--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        System.out.printf("%s  Pivote elegido: %d%n", Soporte.ind(), pivote);
        int i = izquierda - 1;
        
        for (int j = izquierda; j < derecha; j++) {
            System.out.printf("%s  ¿%d <= %d? -> %b%n", Soporte.ind(), array[j], pivote, (array[j] <= pivote));
            
            if (array[j] <= pivote) {
                i++;
                System.out.printf("%s    Intercambiando índice %d (%d) con %d (%d)%n", Soporte.ind(), i, array[i], j, array[j]);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
            }
        }
        System.out.printf("%s  Intercambio final pivote: índice %d (%d) con %d (%d)%n", Soporte.ind(), i + 1, array[i + 1], derecha, array[derecha]);
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        
        return i + 1;
    }
}

import java.util.Arrays;

public class MergeSort {

    private static int nivelRecursivo = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(Trazas.indentar(nivelRecursivo) + "Llamada ordenar(array, izquierda = " + izquierda + ", derecha = " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Caso base: izquierda >= derecha");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(Trazas.indentar(nivelRecursivo) + "División: medio = " + medio);

        nivelRecursivo++;
        ordenar(array, izquierda, medio);
        nivelRecursivo--;

        nivelRecursivo++;
        ordenar(array, medio + 1, derecha);
        nivelRecursivo--;

        fusionar(array, izquierda, medio, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Tamaño de bloque = " + tamano);

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Fusión iterativa: [" + izquierda + ", " + medio + "] con [" + (medio + 1) + ", " + derecha + "]");
                fusionar(array, izquierda, medio, derecha);
            }
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        System.out.println(Trazas.indentar(nivelRecursivo) + "Fusionar [" + izquierda + ", " + medio + "] y [" + (medio + 1) + ", " + derecha + "]");

        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;

        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }

        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }

        System.out.println(Trazas.indentar(nivelRecursivo) + "Mitad izquierda: " + Arrays.toString(mitadIzquierda));
        System.out.println(Trazas.indentar(nivelRecursivo) + "Mitad derecha: " + Arrays.toString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Comparación: " + mitadIzquierda[i] + " <= " + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(Trazas.indentar(nivelRecursivo) + "Resultado: verdadero. Coloco " + mitadIzquierda[i] + " en posición " + k);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(Trazas.indentar(nivelRecursivo) + "Resultado: falso. Coloco " + mitadDerecha[j] + " en posición " + k);
                array[k] = mitadDerecha[j];
                j++;
            }

            Trazas.array(array, nivelRecursivo);
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Copia restante izquierda: " + mitadIzquierda[i] + " en posición " + k);
            array[k] = mitadIzquierda[i];
            Trazas.array(array, nivelRecursivo);
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(Trazas.indentar(nivelRecursivo) + "Copia restante derecha: " + mitadDerecha[j] + " en posición " + k);
            array[k] = mitadDerecha[j];
            Trazas.array(array, nivelRecursivo);
            j++;
            k++;
        }
    }
}

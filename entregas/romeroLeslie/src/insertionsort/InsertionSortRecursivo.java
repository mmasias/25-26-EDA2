package insertionsort;

import java.util.Arrays;

public class InsertionSortRecursivo {

    public static void ordenar(int[] array, int n) {
        imprimirInicio(array, n);

        if (n <= 1) {
            imprimirCasoBase(array, n); 
            return;
        }

        imprimirLlamada(array, n);

        ordenar(array, n - 1);
        int ultimo = array[n - 1];
        int j = n - 2;

        imprimirRetorno(array, n, ultimo);
        imprimirComparacion(array, j, ultimo, n);

        while (j >= 0 && array[j] > ultimo) {
            array[j + 1] = array[j];
            imprimirDesplazamiento(array, n);
            
            j--;
            imprimirComparacion(array, j, ultimo, n);
        }
        
        
        array[j + 1] = ultimo;

        imprimirInsercion(array, n);
        imprimirFinal(array, n);
    }

    private static String getIndent(int n, int totalLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalLength - n; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    private static void imprimirInicio(int[] array, int n) {
        if (n == array.length) {
            System.out.println("Estado inicial: " + Arrays.toString(array));
        }
    }

    private static void imprimirCasoBase(int[] array, int n) {
        System.out.println(getIndent(n, array.length) + "Caso base alcanzado (n<=1).");
    }

    private static void imprimirLlamada(int[] array, int n) {
        System.out.println(getIndent(n, array.length) + "Llamada recursiva para n=" + (n - 1));
    }

    private static void imprimirRetorno(int[] array, int n, int ultimo) {
        System.out.println(getIndent(n, array.length) + "Retorno n=" + n + "  ultimo=" + ultimo);
    }

    private static void imprimirComparacion(int[] array, int j, int ultimo, int n) {
        String ind = getIndent(n, array.length);
        if (j < 0) {
            System.out.println(ind + "Comparacion: j<0. Fin de busqueda.");
        } else {
            System.out.println(ind + "Comparacion: array[" + j + "]=" + array[j] + " > " + ultimo + " es " + (array[j] > ultimo));
        }
    }

    private static void imprimirDesplazamiento(int[] array, int n) {
        System.out.println(getIndent(n, array.length) + "Desplazamiento: " + Arrays.toString(array));
    }

    private static void imprimirInsercion(int[] array, int n) {
        System.out.println(getIndent(n, array.length) + "Insercion: " + Arrays.toString(array));
    }

    private static void imprimirFinal(int[] array, int n) {
        if (n == array.length) {
            System.out.println("Estado final: " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        ordenar(array, array.length);
    }
}
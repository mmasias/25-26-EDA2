import java.util.Arrays;

public class InsertionSortRecursivo {

    private static int profundidad = 0;

    private static String indentar() {
        String espacios = "";
        for (int contador = 0; contador < profundidad; contador++) {
            espacios = espacios + "    ";
        }
        return espacios;
    }

    private static String formatear(int[] array) {
        return Arrays.toString(array);
    }

    private static String formatearRango(int[] array, int desde, int hasta) {
        if (desde > hasta) {
            return "[]";
        }
        return Arrays.toString(Arrays.copyOfRange(array, desde, hasta + 1));
    }

    public static void ordenar(int[] array, int n) {
        String prefijo = indentar();
        System.out.println(prefijo + "Llamada ordenar(array, n=" + n + ") sobre array " + formatear(array));
        if (n <= 1) {
            System.out.println(prefijo + "  Caso base: n=" + n + " ≤ 1, subarray de tamano ≤ 1, ya ordenado por definicion");
            System.out.println(prefijo + "Retorno de ordenar(n=" + n + ")");
            return;
        }
        System.out.println(prefijo + "  Caso recursivo: ordenar primero los " + (n - 1) + " primeros elementos");
        profundidad++;
        ordenar(array, n - 1);
        profundidad--;
        System.out.println(prefijo + "  Vuelta a ordenar(n=" + n + "), prefijo ya ordenado: " + formatearRango(array, 0, n - 2));
        int ultimo = array[n - 1];
        System.out.println(prefijo + "  ultimo = array[" + (n - 1) + "] = " + ultimo + ", insertar en el prefijo");
        int j = n - 2;
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(prefijo + "  Comparacion array[" + j + "]=" + array[j] + " > " + ultimo + " ? Si, desplazar array[" + j + "] a posicion " + (j + 1));
            array[j + 1] = array[j];
            System.out.println(prefijo + "    Estado del array: " + formatear(array));
            j--;
        }
        if (j >= 0) {
            System.out.println(prefijo + "  Comparacion array[" + j + "]=" + array[j] + " > " + ultimo + " ? No, fin del bucle de desplazamiento");
        } else {
            System.out.println(prefijo + "  j=" + j + " < 0, fin del bucle de desplazamiento (alcanzado el inicio)");
        }
        array[j + 1] = ultimo;
        System.out.println(prefijo + "  Insertar " + ultimo + " en posicion " + (j + 1));
        System.out.println(prefijo + "    Estado del array: " + formatear(array));
        System.out.println(prefijo + "Retorno de ordenar(n=" + n + ")");
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + formatear(array));
        ordenar(array, array.length);
        System.out.println("Estado final: " + formatear(array));
    }
}
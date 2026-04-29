import java.util.Arrays;

public class QuickSort {

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

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String prefijo = indentar();
        System.out.println(prefijo + "Llamada ordenar(izquierda=" + izquierda + ", derecha=" + derecha + ") sobre subarray " + formatearRango(array, izquierda, derecha));
        if (izquierda >= derecha) {
            System.out.println(prefijo + "  Caso base: izquierda=" + izquierda + " ≥ derecha=" + derecha + ", subarray de tamano ≤ 1, ya ordenado");
            System.out.println(prefijo + "Retorno de ordenar(" + izquierda + ", " + derecha + ")");
            return;
        }
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(prefijo + "  Pivote colocado en posicion definitiva " + indicePivote + " con valor " + array[indicePivote]);
        System.out.println(prefijo + "  Estado del array tras particionar: " + formatear(array));
        System.out.println(prefijo + "  Llamada recursiva sobre la parte izquierda [" + izquierda + ", " + (indicePivote - 1) + "]");
        profundidad++;
        ordenar(array, izquierda, indicePivote - 1);
        profundidad--;
        System.out.println(prefijo + "  Llamada recursiva sobre la parte derecha [" + (indicePivote + 1) + ", " + derecha + "]");
        profundidad++;
        ordenar(array, indicePivote + 1, derecha);
        profundidad--;
        System.out.println(prefijo + "Retorno de ordenar(" + izquierda + ", " + derecha + ")");
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String prefijo = indentar() + "    ";
        int pivote = array[derecha];
        System.out.println(prefijo + "pivote = array[" + derecha + "] = " + pivote);
        int i = izquierda - 1;
        System.out.println(prefijo + "i = " + i + " (frontera de la zona ≤ pivote, fuera del subarray)");
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                System.out.println(prefijo + "j=" + j + ", array[" + j + "]=" + array[j] + " ≤ " + pivote + " ? Si, i pasa a " + (i + 1) + ", intercambiar array[" + (i + 1) + "]=" + array[i + 1] + " con array[" + j + "]=" + array[j]);
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(prefijo + "  Estado del array: " + formatear(array));
            } else {
                System.out.println(prefijo + "j=" + j + ", array[" + j + "]=" + array[j] + " ≤ " + pivote + " ? No, no se modifica nada");
            }
        }
        System.out.println(prefijo + "Fin del recorrido. Colocar el pivote en la frontera: intercambiar array[" + (i + 1) + "]=" + array[i + 1] + " con array[" + derecha + "]=" + array[derecha]);
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(prefijo + "  Estado del array: " + formatear(array));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + formatear(array));
        ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + formatear(array));
    }
}
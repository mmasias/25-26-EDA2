import java.util.Arrays;

public class MergeSortRecursivo {

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
        return Arrays.toString(Arrays.copyOfRange(array, desde, hasta + 1));
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String prefijo = indentar();
        System.out.println(prefijo + "Llamada ordenar(izquierda=" + izquierda + ", derecha=" + derecha + ") sobre subarray " + (izquierda <= derecha ? formatearRango(array, izquierda, derecha) : "[]"));
        if (izquierda >= derecha) {
            System.out.println(prefijo + "  Caso base: izquierda=" + izquierda + " ≥ derecha=" + derecha + ", subarray de tamano ≤ 1, ya ordenado");
            System.out.println(prefijo + "Retorno de ordenar(" + izquierda + ", " + derecha + ")");
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(prefijo + "  medio = " + izquierda + " + (" + derecha + " - " + izquierda + ") / 2 = " + medio);
        System.out.println(prefijo + "  Mitad izquierda [" + izquierda + ", " + medio + "] = " + formatearRango(array, izquierda, medio));
        System.out.println(prefijo + "  Mitad derecha [" + (medio + 1) + ", " + derecha + "] = " + formatearRango(array, medio + 1, derecha));
        System.out.println(prefijo + "  Llamada recursiva sobre la mitad izquierda");
        profundidad++;
        ordenar(array, izquierda, medio);
        profundidad--;
        System.out.println(prefijo + "  Llamada recursiva sobre la mitad derecha");
        profundidad++;
        ordenar(array, medio + 1, derecha);
        profundidad--;
        System.out.println(prefijo + "  Fusionar [" + izquierda + ", " + medio + "] con [" + (medio + 1) + ", " + derecha + "]");
        fusionar(array, izquierda, medio, derecha);
        System.out.println(prefijo + "  Resultado de la fusion: " + formatearRango(array, izquierda, derecha));
        System.out.println(prefijo + "  Estado del array completo: " + formatear(array));
        System.out.println(prefijo + "Retorno de ordenar(" + izquierda + ", " + derecha + ")");
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String prefijo = indentar() + "    ";
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
        System.out.println(prefijo + "Copia mitadIzquierda = " + formatear(mitadIzquierda) + ", mitadDerecha = " + formatear(mitadDerecha));
        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(prefijo + "Comparacion " + mitadIzquierda[i] + " ≤ " + mitadDerecha[j] + " ? Si, escribir " + mitadIzquierda[i] + " en array[" + k + "]");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(prefijo + "Comparacion " + mitadIzquierda[i] + " ≤ " + mitadDerecha[j] + " ? No, escribir " + mitadDerecha[j] + " en array[" + k + "]");
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println(prefijo + "Residuo de mitadIzquierda: escribir " + mitadIzquierda[i] + " en array[" + k + "]");
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(prefijo + "Residuo de mitadDerecha: escribir " + mitadDerecha[j] + " en array[" + k + "]");
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + formatear(array));
        ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + formatear(array));
    }
}
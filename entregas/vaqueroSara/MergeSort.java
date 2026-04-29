public class MergeSort {

    private static int profundidad = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = "  ".repeat(profundidad);
        System.out.println(ind + "ordenar(" + izquierda + ", " + derecha + "): segmento "
                + segmentoAString(array, izquierda, derecha));
        if (izquierda >= derecha) {
            System.out.println(ind + "  CASO BASE: izquierda(" + izquierda
                    + ") >= derecha(" + derecha + ") -> return (segmento de longitud <=1)");
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(ind + "  Punto medio = " + medio + ". Dividimos en ["
                + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");

        System.out.println(ind + "  Recursión IZQUIERDA: ordenar(" + izquierda + ", " + medio + ")");
        profundidad++;
        ordenar(array, izquierda, medio);
        profundidad--;

        System.out.println(ind + "  Recursión DERECHA:   ordenar(" + (medio + 1) + ", " + derecha + ")");
        profundidad++;
        ordenar(array, medio + 1, derecha);
        profundidad--;

        System.out.println(ind + "  Fusionamos [" + izquierda + ".." + medio + "] con ["
                + (medio + 1) + ".." + derecha + "]");
        fusionar(array, izquierda, medio, derecha);
        System.out.println(ind + "  Resultado tras fusionar: " + arrayAString(array));
    }

    
    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        System.out.println("Estado inicial: " + arrayAString(array));
        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("--- Pasada con tamaño de bloque = " + tamano + " ---");
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("  Fusionar [" + izquierda + ".." + medio + "] con ["
                        + (medio + 1) + ".." + derecha + "]");
                fusionar(array, izquierda, medio, derecha);
            }
            System.out.println("  Estado tras la pasada: " + arrayAString(array));
        }
        System.out.println("Estado final:   " + arrayAString(array));
    }


    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        String ind = "  ".repeat(profundidad + 1);
        System.out.println(ind + "fusionar(" + izquierda + ", " + medio + ", " + derecha + ")");
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
        System.out.println(ind + "  mitadIzquierda = " + arrayAString(mitadIzquierda));
        System.out.println(ind + "  mitadDerecha   = " + arrayAString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(ind + "  Compara izq[" + i + "]=" + mitadIzquierda[i]
                        + " <= der[" + j + "]=" + mitadDerecha[j] + " -> TRUE: tomamos de IZQ");
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(ind + "  Compara izq[" + i + "]=" + mitadIzquierda[i]
                        + " <= der[" + j + "]=" + mitadDerecha[j] + " -> FALSE: tomamos de DER");
                array[k] = mitadDerecha[j];
                j++;
            }
            System.out.println(ind + "    array[" + k + "]=" + array[k] + " -> " + arrayAString(array));
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println(ind + "  Vuelco resto IZQ: array[" + k + "] <- "
                    + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
            System.out.println(ind + "    array=" + arrayAString(array));
        }
        while (j < tamanoDerecha) {
            System.out.println(ind + "  Vuelco resto DER: array[" + k + "] <- "
                    + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
            System.out.println(ind + "    array=" + arrayAString(array));
        }
        System.out.println(ind + "  Fusión completada: " + arrayAString(array));
    }

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println(" MERGE SORT - VERSIÓN RECURSIVA");
        System.out.println("======================================================");
        int[] a1 = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + arrayAString(a1));
        profundidad = 0;
        ordenar(a1, 0, a1.length - 1);
        System.out.println("Estado final:   " + arrayAString(a1));

        System.out.println();
        System.out.println("======================================================");
        System.out.println(" MERGE SORT - VERSIÓN ITERATIVA");
        System.out.println("======================================================");
        int[] a2 = {5, 2, 8, 1, 9, 3};
        profundidad = 0;
        ordenarIterativo(a2);
    }

    
    private static String arrayAString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static String segmentoAString(int[] array, int izquierda, int derecha) {
        StringBuilder sb = new StringBuilder("[");
        for (int idx = izquierda; idx <= derecha; idx++) {
            if (idx > izquierda) sb.append(", ");
            sb.append(array[idx]);
        }
        sb.append("]");
        return sb.toString();
    }
}
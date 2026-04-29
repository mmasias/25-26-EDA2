public class QuickSort {
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
        int indicePivote = particionar(array, izquierda, derecha);
        System.out.println(ind + "  particionar devuelve indicePivote=" + indicePivote
                + ". Estado actual: " + arrayAString(array));

        System.out.println(ind + "  Recursión IZQUIERDA: ordenar("
                + izquierda + ", " + (indicePivote - 1) + ")");
        profundidad++;
        ordenar(array, izquierda, indicePivote - 1);
        profundidad--;

        System.out.println(ind + "  Recursión DERECHA:   ordenar("
                + (indicePivote + 1) + ", " + derecha + ")");
        profundidad++;
        ordenar(array, indicePivote + 1, derecha);
        profundidad--;
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        String ind = "  ".repeat(profundidad + 1);
        int pivote = array[derecha];
        System.out.println(ind + "particionar(" + izquierda + ", " + derecha + "): pivote = array["
                + derecha + "] = " + pivote);
        int i = izquierda - 1;
        System.out.println(ind + "  i = " + i + " (frontera de la zona <= pivote)");
        for (int j = izquierda; j < derecha; j++) {
            boolean cumple = array[j] <= pivote;
            System.out.println(ind + "  j=" + j + ": ¿array[" + j + "]=" + array[j]
                    + " <= " + pivote + "? " + (cumple ? "SÍ" : "NO"));
            if (array[j] <= pivote) {
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                if (i == j) {
                    System.out.println(ind + "    i avanza a " + i + "; swap(array[" + i
                            + "], array[" + j + "]) (i==j, sin efecto): " + arrayAString(array));
                } else {
                    System.out.println(ind + "    i avanza a " + i + "; swap(array[" + i
                            + "], array[" + j + "]): " + arrayAString(array));
                }
            }
        }
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(ind + "  Colocamos el pivote en su sitio: swap(array["
                + (i + 1) + "], array[" + derecha + "]): " + arrayAString(array));
        System.out.println(ind + "  Devuelve i+1 = " + (i + 1));
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println(" QUICK SORT");
        System.out.println("======================================================");
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + arrayAString(array));
        profundidad = 0;
        ordenar(array, 0, array.length - 1);
        System.out.println("Estado final:   " + arrayAString(array));
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
        if (izquierda > derecha) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int idx = izquierda; idx <= derecha; idx++) {
            if (idx > izquierda) sb.append(", ");
            sb.append(array[idx]);
        }
        sb.append("]");
        return sb.toString();
    }
}
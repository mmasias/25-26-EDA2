public class QuickSort {

    // =========================================================================
    // AUXILIARES
    // =========================================================================

    private static String str(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    private static String subStr(int[] a, int lo, int hi) {
        if (lo > hi) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = lo; i <= hi; i++) {
            sb.append(a[i]);
            if (i < hi) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    // Contador de profundidad de recursión
    private static int depth = 0;

    // =========================================================================
    // QUICK SORT
    // =========================================================================

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = "  ".repeat(depth);

        System.out.println(ind + "→ ordenar(izq=" + izquierda + ", der=" + derecha + ")  "
                + subStr(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(ind + "  [CASO BASE] izquierda(" + izquierda
                    + ") >= derecha(" + derecha + ")  →  subarreglo trivial, retornar");
            return;
        }

        System.out.println(ind + "  Pivote elegido: array[der=" + derecha + "]=" + array[derecha]);
        int indicePivote = particionar(array, izquierda, derecha, ind + "  ");
        System.out.println(ind + "  Pivote " + array[indicePivote]
                + " colocado en pos definitiva " + indicePivote
                + "  →  " + str(array));
        System.out.println();

        System.out.println(ind + "  ── Subarreglo izquierdo [" + izquierda + ".." + (indicePivote - 1) + "] ──");
        depth++;
        ordenar(array, izquierda, indicePivote - 1);
        depth--;

        System.out.println(ind + "  ── Subarreglo derecho [" + (indicePivote + 1) + ".." + derecha + "] ──");
        depth++;
        ordenar(array, indicePivote + 1, derecha);
        depth--;
    }

    // =========================================================================
    // PARTICIONAR
    // =========================================================================

    private static int particionar(int[] array, int izquierda, int derecha, String ind) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(ind + "Inicio partición  pivote=" + pivote
                + "  i=" + i + "  array=" + str(array));

        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                System.out.println(ind + "j=" + j + ": array[j]=" + array[j]
                        + " ≤ pivote=" + pivote
                        + "  →  VERDADERO  →  intercambiar pos " + i + " y " + j);
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(ind + "Array: " + str(array));
            } else {
                System.out.println(ind + "j=" + j + ": array[j]=" + array[j]
                        + " ≤ pivote=" + pivote
                        + "  →  FALSO  →  no intercambiar");
            }
        }

        System.out.println(ind + "Colocar pivote " + pivote
                + ": intercambiar pos " + (i + 1) + " (frontera) y " + derecha + " (pivote)");
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(ind + "Array: " + str(array));

        return i + 1;
    }

    // =========================================================================
    // MAIN
    // =========================================================================

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   QUICK SORT                         ║");
        System.out.println("╚══════════════════════════════════════╝");
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + str(array));
        System.out.println();
        depth = 0;
        ordenar(array, 0, array.length - 1);
        System.out.println();
        System.out.println("Estado final: " + str(array));
    }
}

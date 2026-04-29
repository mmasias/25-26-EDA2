public class MergeSort {

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

    // Contador de profundidad para la versión recursiva
    private static int depth = 0;

    // =========================================================================
    // RECURSIVO
    // =========================================================================

    public static void ordenar(int[] array, int izquierda, int derecha) {
        String ind = "  ".repeat(depth);

        System.out.println(ind + "→ ordenar(izq=" + izquierda + ", der=" + derecha + ")  "
                + subStr(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(ind + "  [CASO BASE] izquierda(" + izquierda
                    + ") >= derecha(" + derecha + ")  →  un solo elemento, retornar");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(ind + "  medio=" + medio);

        System.out.println(ind + "  ── Mitad izquierda [" + izquierda + ".." + medio + "] ──");
        depth++;
        ordenar(array, izquierda, medio);
        depth--;

        System.out.println(ind + "  ── Mitad derecha [" + (medio + 1) + ".." + derecha + "] ──");
        depth++;
        ordenar(array, medio + 1, derecha);
        depth--;

        System.out.println(ind + "  ── Fusionar [" + izquierda + ".." + medio + "] con ["
                + (medio + 1) + ".." + derecha + "] ──");
        fusionar(array, izquierda, medio, derecha, ind + "  ");
        System.out.println(ind + "  Array tras fusión: " + str(array));
    }

    // =========================================================================
    // ITERATIVO
    // =========================================================================

    public static void ordenarIterativo(int[] array) {
        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("┌─ Tamaño de bloque = " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                System.out.println("│  Fusionar [" + izquierda + ".." + medio + "] con ["
                        + (medio + 1) + ".." + derecha + "]");
                System.out.println("│  Antes:   " + str(array));
                fusionar(array, izquierda, medio, derecha, "│    ");
                System.out.println("│  Después: " + str(array));
            }
            System.out.println("└─ Array con bloques de tamaño " + tamano + " ordenados: " + str(array));
            System.out.println();
        }

        System.out.println("Estado final: " + str(array));
    }

    // =========================================================================
    // FUSIONAR (privado, compartido por ambas versiones)
    // =========================================================================

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, String ind) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha   = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha   = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }

        System.out.println(ind + "Copias  L=" + str(mitadIzquierda) + "  R=" + str(mitadDerecha));

        int i = 0, j = 0, k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(ind + "Cmp L[" + i + "]=" + mitadIzquierda[i]
                        + " ≤ R[" + j + "]=" + mitadDerecha[j]
                        + "  →  VERDADERO  →  colocar " + mitadIzquierda[i] + " en pos " + k);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println(ind + "Cmp L[" + i + "]=" + mitadIzquierda[i]
                        + " ≤ R[" + j + "]=" + mitadDerecha[j]
                        + "  →  FALSO  →  colocar " + mitadDerecha[j] + " en pos " + k);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println(ind + "Resto L: colocar L[" + i + "]=" + mitadIzquierda[i] + " en pos " + k);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(ind + "Resto R: colocar R[" + j + "]=" + mitadDerecha[j] + " en pos " + k);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
    }

    // =========================================================================
    // MAIN
    // =========================================================================

    public static void main(String[] args) {

        // -- Recursivo --
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   MERGE SORT — RECURSIVO             ║");
        System.out.println("╚══════════════════════════════════════╝");
        int[] a1 = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + str(a1));
        System.out.println();
        depth = 0;
        ordenar(a1, 0, a1.length - 1);
        System.out.println();
        System.out.println("Estado final: " + str(a1));

        System.out.println("\n\n");

        // -- Iterativo --
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   MERGE SORT — ITERATIVO             ║");
        System.out.println("╚══════════════════════════════════════╝");
        int[] a2 = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial: " + str(a2));
        System.out.println();
        ordenarIterativo(a2);
    }
}

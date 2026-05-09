public class BeMo {

    private static int[][] matriz;
    private static int[][] estado;

    private static final int[][] MOVIMIENTOS = {
        {1, 1},
        {-1, 0},
        {-1, 1},
        {1, 0},
        {0, -1},
        {0, 1},
        {1, -1},
        {-1, -1}
    };

    public static void buscarElemento(int[][] m, int objetivo) {

        matriz = m;
        estado = crearEstado(matriz);

        Elemento inicio = centro();

        boolean encontrado = buscar(inicio, objetivo);

        if (!encontrado) {
            System.out.println("No encontrado");
        }
    }

private static boolean buscar(Elemento actual, int objetivo) {

    return buscar(actual, objetivo, 0);
}

    private static boolean buscar(Elemento actual, int objetivo, int nivel) {

        if (!esValido(actual)) return false;

        indent(nivel);
        System.out.println("→ [" + actual.fila + "," + actual.columna + "] = " + actual.valor);

        if (actual.valor == objetivo) {

            indent(nivel);
            System.out.println("✔ encontrado");

            return true;
        }

        marcarDescartes(actual, objetivo);

        for (int[] mov : MOVIMIENTOS) {

            int nf = actual.fila + mov[0];
            int nc = actual.columna + mov[1];

            if (enRango(nf, nc) && estado[nf][nc] == 1) {

                Elemento siguiente =
                    new Elemento(nf, nc, matriz[nf][nc]);

                indent(nivel);
                System.out.println("  ↳ probando [" + nf + "," + nc + "]");

                if (buscar(siguiente, objetivo, nivel + 1)) {
                    return true;
                }
            }
        }

        indent(nivel);
        System.out.println("↩ backtrack");

        return false;
    }

    private static void indent(int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }
    }

    private static Elemento mover(Elemento actual, int[] mov) {

        int nuevaFila = actual.fila + mov[0];
        int nuevaColumna = actual.columna + mov[1];

        if (!enRango(nuevaFila, nuevaColumna)) return null;

        return new Elemento(nuevaFila, nuevaColumna, matriz[nuevaFila][nuevaColumna]);
    }

    private static void marcarDescartes(Elemento actual, int objetivo) {

        if (objetivo > actual.valor) {

            for (int i = 0; i <= actual.fila; i++) {
                for (int j = 0; j <= actual.columna; j++) {
                    estado[i][j] = 0;
                }
            }

        } else {

            for (int i = actual.fila; i < matriz.length; i++) {
                for (int j = actual.columna; j < matriz[0].length; j++) {
                    estado[i][j] = 0;
                }
            }
        }
    }

    private static boolean esValido(Elemento e) {
        return e != null &&
               enRango(e.fila, e.columna) &&
               estado[e.fila][e.columna] == 1;
    }

    private static boolean enRango(int fila, int columna) {
        return fila >= 0 &&
            fila < matriz.length &&
            columna >= 0 &&
            columna < matriz[0].length;
    }

    private static boolean esObjetivo(Elemento e, int objetivo) {
        return e.valor == objetivo;
    }

    private static void imprimir(Elemento e) {
        System.out.println("Comparando: " + e.valor);
    }

    private static int[][] crearEstado(int[][] matrizOriginal) {

        int[][] estado = new int[matrizOriginal.length][matrizOriginal[0].length];

        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[0].length; j++) {
                estado[i][j] = 1;
            }
        }

        return estado;
    }

    private static Elemento centro() {
        return new Elemento(
            (matriz.length - 1) / 2,
            (matriz[0].length - 1) / 2,
            matriz[(matriz.length - 1) / 2][(matriz[0].length - 1) / 2]
        );
    }
}

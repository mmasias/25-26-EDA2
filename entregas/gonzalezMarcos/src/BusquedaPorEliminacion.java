public class BusquedaPorEliminacion {

    public static class Resultado {
        public final boolean encontrado;
        public final int fila;
        public final int columna;
        public final int comparaciones;

        private Resultado(boolean encontrado, int fila, int columna, int comparaciones) {
            this.encontrado = encontrado;
            this.fila = fila;
            this.columna = columna;
            this.comparaciones = comparaciones;
        }

        @Override
        public String toString() {
            if (encontrado) {
                return String.format("ENCONTRADO en posición [%d][%d] — %d comparación(es)",
                        fila, columna, comparaciones);
            }
            return String.format("NO ENCONTRADO — %d comparación(es)", comparaciones);
        }
    }

    public static Resultado buscar(MatrizOrdenada matriz, int k) {
        int fila = 0;
        int col  = matriz.getColumnas() - 1;
        int comparaciones = 0;

        System.out.printf("%nBuscando k = %d...%n", k);

        while (fila < matriz.getFilas() && col >= 0) {
            int valor = matriz.get(fila, col);
            comparaciones++;

            if (valor == k) {
                System.out.printf("  Paso %-2d → (F%d, C%d) = %2d | ¡Encontrado en (%d,%d)!%n",
                        comparaciones, fila, col, valor, fila, col);
                return new Resultado(true, fila, col, comparaciones);

            } else if (valor < k) {
                System.out.printf("  Paso %-2d → (F%d, C%d) = %2d | %d < %d → bajar%n",
                        comparaciones, fila, col, valor, valor, k);
                fila++;

            } else {
                System.out.printf("  Paso %-2d → (F%d, C%d) = %2d | %d > %d → izquierda%n",
                        comparaciones, fila, col, valor, valor, k);
                col--;
            }
        }

        System.out.printf("  [Espacio de búsqueda agotado]%n");
        return new Resultado(false, -1, -1, comparaciones);
    }

    public static int mejorCaso(int n, int m) {
        return 1;
    }

    public static int peorCaso(int n, int m) {
        return n + m - 1;
    }
}

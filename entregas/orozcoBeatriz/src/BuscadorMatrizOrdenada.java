public class BuscadorMatrizOrdenada {

    public ResultadoBusqueda buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return new ResultadoBusqueda(false, -1, -1, 0);
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int fila = 0;
        int columna = columnas - 1;
        int comparaciones = 0;

        while (fila < filas && columna >= 0) {
            int actual = matriz[fila][columna];
            comparaciones++;

            if (actual == k) {
                return new ResultadoBusqueda(true, fila, columna, comparaciones);
            } else if (actual > k) {
                columna--;
            } else {
                fila++;
            }
        }

        return new ResultadoBusqueda(false, -1, -1, comparaciones);
    }
}
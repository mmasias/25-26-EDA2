public class BusquedaMatrizOrdenada {

    public static boolean buscar(int[][] matriz, int k) {
        int fila = 0;
        int columna = matriz[0].length - 1;

        while (fila < matriz.length && columna >= 0) {
            int actual = matriz[fila][columna];

            if (actual == k) {
                return true;
            } else if (actual < k) {
                fila++;
            } else {
                columna--;
            }
        }

        return false;
    }
}
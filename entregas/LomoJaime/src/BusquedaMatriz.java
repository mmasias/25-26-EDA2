public class BusquedaMatriz {

    public static int[] buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0) {
            return new int[]{-1, -1};
        }

        int filas = matriz.length;
        int cols  = matriz[0].length;

        int i = 0;
        int j = cols - 1;

        while (i < filas && j >= 0) {
            int actual = matriz[i][j];

            if (actual == k) {
                return new int[]{i, j};
            } else if (actual > k) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}
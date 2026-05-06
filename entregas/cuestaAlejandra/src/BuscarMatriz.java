public static int[] buscarMatriz(int[][] matriz, int k) {
    int filas = matriz.length;
    int columnas = matriz[0].length;

    int i = filas - 1;
    int j = 0;

    while (i >= 0 && j < columnas) {
        int valor = matriz[i][j];

        if (valor == k) {
            return new int[]{i, j};
        } else if (valor < k) {
            j++;
        } else {
            i--;
        }
    }

    return null;
}
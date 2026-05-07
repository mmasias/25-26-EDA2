public class BusquedaMatrizOrdenada {

    public static boolean buscar(int[][] matriz, int k) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int i = 0;
        int j = columnas - 1;

        while (i < filas && j >= 0) {
            if (matriz[i][j] == k) {
                return true;
            } else if (matriz[i][j] > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        int k = 22;

        if (buscar(matriz, k)) {
            System.out.println("El número está en la matriz");
        } else {
            System.out.println("El número no está en la matriz");
        }
    }
}
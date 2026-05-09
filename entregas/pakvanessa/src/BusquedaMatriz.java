public class BusquedaMatriz {

    public static boolean buscarNumero(int[][] matriz, int k) {

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int fila = 0;
        int columna = columnas - 1;

        while (fila < filas && columna >= 0) {

            System.out.println("Comparando con: " + matriz[fila][columna]);

            if (matriz[fila][columna] == k) {
                System.out.println("Número encontrado.");
                return true;
            }

            else if (matriz[fila][columna] > k) {
                columna--;
            }

            else {
                fila++;
            }
        }

        System.out.println("Número no encontrado.");
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

        int numeroBuscado = 22;

        buscarNumero(matriz, numeroBuscado);
    }
}
public class BusquedaMatriz {

    public static boolean buscar(int[][] matriz, int k) {

        int fila = 0;
        int columna = matriz[0].length - 1;

        while (fila < matriz.length && columna >= 0) {

            System.out.println("Comparando con: " + matriz[fila][columna]);

            if (matriz[fila][columna] == k) {
                return true;
            }

            if (k < matriz[fila][columna]) {
                columna--;
            } else {
                fila++;
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
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
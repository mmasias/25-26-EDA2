public class BusquedaMatrizOrdenada {

    public static boolean buscarEnMatriz(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int fila = 0;
        int columna = columnas - 1;

        while (fila < filas && columna >= 0) {
            int actual = matriz[fila][columna];

            if (actual == k) {
                return true;
            } else if (actual > k) {
                columna--;
            } else {
                fila++;
            }
        }

        return false;
    }

    public static void buscarConTraza(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.out.println("Matriz vacia");
            return;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int fila = 0;
        int columna = columnas - 1;
        int comparaciones = 0;

        while (fila < filas && columna >= 0) {
            int actual = matriz[fila][columna];
            comparaciones++;

            System.out.println("Comparo " + k + " con " + actual
                    + " en posicion (" + fila + ", " + columna + ")");

            if (actual == k) {
                System.out.println("Encontrado en posicion (" + fila + ", " + columna + ")");
                System.out.println("Comparaciones: " + comparaciones);
                return;
            } else if (actual > k) {
                columna--;
            } else {
                fila++;
            }
        }

        System.out.println(k + " no esta en la matriz");
        System.out.println("Comparaciones: " + comparaciones);
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        buscarConTraza(matriz, 22);
        System.out.println();

        buscarConTraza(matriz, 21);
        System.out.println();

        buscarConTraza(matriz, 16);
        System.out.println();

        buscarConTraza(matriz, 19);
    }
}
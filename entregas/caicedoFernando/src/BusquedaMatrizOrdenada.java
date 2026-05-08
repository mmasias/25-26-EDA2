package src;

public class BusquedaMatrizOrdenada {

    public static boolean buscarEnMatriz(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        for (int[] fila : matriz) {
            if (fila[0] <= objetivo && fila[fila.length - 1] >= objetivo) {
                int inicio = 0;
                int fin = fila.length - 1;

                while (inicio <= fin) {
                    int medio = inicio + (fin - inicio) / 2;

                    if (fila[medio] == objetivo) {
                        return true;
                    } else if (fila[medio] < objetivo) {
                        inicio = medio + 1;
                    } else {
                        fin = medio - 1;
                    }
                }
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

        System.out.println(buscarEnMatriz(matriz, 22));
        System.out.println(buscarEnMatriz(matriz, 21));
        System.out.println(buscarEnMatriz(matriz, 16));
        System.out.println(buscarEnMatriz(matriz, 19));
    }
}

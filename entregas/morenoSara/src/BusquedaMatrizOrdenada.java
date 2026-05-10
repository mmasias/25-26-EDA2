public class BusquedaMatrizOrdenada {

    public static boolean contieneValor(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0) return false;

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int i = 0;
        int j = columnas - 1;

        int paso = 1;

        System.out.println("BÚSQUEDA: " + k );

        while (i < filas && j >= 0) {
            System.out.println("\n--- PASO " + paso + " ---");
            imprimirEstado(matriz, i, j, k);
            
            int valorActual = matriz[i][j];
            paso++;

            if (valorActual == k) {
                System.out.println(">> ¡ENCONTRADO en  [" + i + "][" + j + "]!");
                return true;
            }

            if (valorActual > k) {
                System.out.println(">> " + valorActual + " > " + k + ": Descartamos columna " + j + " (Mover IZQUIERDA)");
                j--;
            } else {
                System.out.println(">> " + valorActual + " < " + k + ": Descartamos fila " + i + " (Mover ABAJO)");
                i++;
            }
        }

        System.out.println("\n--- FINAL ---");
        System.out.println("El valor " + k + " no existe en la matriz.");
        return false;
    }

    private static void imprimirEstado(int[][] matriz, int filaActual, int colActual, int k) {
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                if (f == filaActual && c == colActual) {
                    System.out.printf("[%2d] ", matriz[f][c]);
                } else if (f < filaActual || c > colActual) {
                    System.out.print(" XX  ");
                } else {
                    System.out.printf(" %2d  ", matriz[f][c]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {2,  5,  9,  14, 21},
            {4,  7,  11, 17, 25},
            {8,  12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };


        contieneValor(matriz, 22);
        System.out.println();
        contieneValor(matriz, 21);
        System.out.println();
        contieneValor(matriz, 16);
        System.out.println();

    }
}
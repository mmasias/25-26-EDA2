public class busquedaMatriz {

    public static boolean buscar(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        int fila = 0;
        int col = columnas - 1;
        
        int comparaciones = 0;

        while (fila < filas && col >= 0) {
            comparaciones++;
            int valorActual = matriz[fila][col];

            if (valorActual == objetivo) {
                System.out.println("Encontrado: " + objetivo + " en la posición (" + fila + ", " + col + "). Comparaciones: " + comparaciones);
                return true;
            } else if (valorActual > objetivo) {
    
            } else {

            }
        }

        System.out.println("No encontrado: " + objetivo + ". El valor no existe en la matriz. Comparaciones: " + comparaciones);
        return false;
    }

    public static void main(String[] args) {
        int[][] matriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        System.out.println("--- INICIANDO PRUEBAS ---\n");

        buscar(matriz, 22);

        buscar(matriz, 21);

        buscar(matriz, 19);

        buscar(matriz, 16);
    }
}
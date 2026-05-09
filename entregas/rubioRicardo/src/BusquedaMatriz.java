public class BusquedaMatriz {

    static boolean buscarDivideYVenceras(int[][] matriz, int objetivo, int filaInicio, int filaFin, int colInicio, int colFin) {
        
        if (filaInicio > filaFin || colInicio > colFin) {
            return false;
        }

        if (objetivo < matriz[filaInicio][colInicio] || objetivo > matriz[filaFin][colFin]) {
            return false;
        }

        int filaDiagonal = filaInicio;
        int columnaDiagonal = colInicio;

        while (filaDiagonal <= filaFin && columnaDiagonal <= colFin && matriz[filaDiagonal][columnaDiagonal] <= objetivo) {
            if (matriz[filaDiagonal][columnaDiagonal] == objetivo) {
                return true; 
            }
            filaDiagonal = filaDiagonal + 1;
            columnaDiagonal = columnaDiagonal + 1;
        }

        boolean buscarAbajoIzq = buscarDivideYVenceras(matriz, objetivo, filaDiagonal, filaFin, colInicio, columnaDiagonal - 1);
        boolean buscarArribaDer = buscarDivideYVenceras(matriz, objetivo, filaInicio, filaDiagonal - 1, columnaDiagonal, colFin);

        return buscarAbajoIzq || buscarArribaDer;
    }

    static boolean buscar(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }
        
        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        return buscarDivideYVenceras(matriz, objetivo, 0, filas - 1, 0, columnas - 1);
    }

    public static void main(String[] args) {
        final int[][] matriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        final int OBJETIVO_DIAGONAL_INFERIOR = 22;
        final int OBJETIVO_ESQUINA_SUPERIOR = 21;
        final int OBJETIVO_INEXISTENTE = 16;
        final int OBJETIVO_CENTRO = 15;

        System.out.println("Buscando " + OBJETIVO_DIAGONAL_INFERIOR + ": " + buscar(matriz, OBJETIVO_DIAGONAL_INFERIOR)); 
        System.out.println("Buscando " + OBJETIVO_ESQUINA_SUPERIOR + ": " + buscar(matriz, OBJETIVO_ESQUINA_SUPERIOR)); 
        System.out.println("Buscando " + OBJETIVO_INEXISTENTE + ": " + buscar(matriz, OBJETIVO_INEXISTENTE)); 
        System.out.println("Buscando " + OBJETIVO_CENTRO + ": " + buscar(matriz, OBJETIVO_CENTRO)); 
    }
}
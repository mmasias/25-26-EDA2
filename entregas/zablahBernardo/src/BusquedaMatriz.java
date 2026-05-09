public class BusquedaMatriz {

    public static boolean buscarMatriz(int[][] matriz, int k) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        int filaActual = 0;
        int columnaActual = columnas - 1;

        while (filaActual < filas && columnaActual >= 0) {
            int valorActual = matriz[filaActual][columnaActual];

            if (valorActual == k) {
                System.out.println(" El valor " + k + " encontrado en la posición (" + filaActual + ", " + columnaActual + ")!");
                return true;
            } else if (valorActual > k) {
                columnaActual--;
            } else {
                filaActual++;
            }
        }

        System.out.println("El valor " + k + " no existe en la matriz.");
        return false;
    }

    public static void main(String[] args) {
        int[][] miMatriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        buscarMatriz(miMatriz, 22);
        
        System.out.println("---");
        buscarMatriz(miMatriz, 16);
    }
}
package src;
public class BusquedaMatriz {

    public static boolean buscarEnMatriz(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int filaActual = 0;
        int colActual = columnas - 1;

        while (filaActual < filas && colActual >= 0) {
            int valorActual = matriz[filaActual][colActual];

            if (valorActual == objetivo) {
                return true;
            } else if (valorActual > objetivo) {
                colActual--;
            } else {
                filaActual++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                { 2, 5, 9, 14, 21 },
                { 4, 7, 11, 17, 25 },
                { 8, 12, 15, 20, 30 },
                { 13, 18, 22, 27, 35 },
                { 19, 24, 28, 33, 40 }
        };

        System.out.println("¿Existe 22?: " + buscarEnMatriz(matriz, 22));
        System.out.println("¿Existe 21?: " + buscarEnMatriz(matriz, 21));
        System.out.println("¿Existe 19?: " + buscarEnMatriz(matriz, 19));
        System.out.println("¿Existe 16?: " + buscarEnMatriz(matriz, 16));
    }
}
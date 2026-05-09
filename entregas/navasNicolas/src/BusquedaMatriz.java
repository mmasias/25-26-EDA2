public class BusquedaMatriz {

    public static boolean buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0) return false;

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int x = 0;
        int y = 0;
        int comparaciones = 0;

        while (x < filas && y >= 0 && y < columnas) {
            comparaciones++;
            int actual = matriz[x][y];

            if (actual == k) {
                System.out.println("Valor " + k + " encontrado en la posición [" + x + "][" + y + "] con " + comparaciones + " comparaciones.");
                return true;
            }

            if (actual > k) {
                y--;
            } else {
                if (y + 1 < columnas && matriz[x][y + 1] <= k) {
                    y++;
                } else {
                    x++;
                }
            }
        }

        System.out.println("Valor " + k + " NO encontrado tras " + comparaciones + " comparaciones.");
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

        System.out.println("Buscando 22:");
        buscar(matriz, 22);
        
        System.out.println("\nBuscando 21:");
        buscar(matriz, 21);
        
        System.out.println("\nBuscando 16:");
        buscar(matriz, 16);
        
        System.out.println("\nBuscando 19 (Peor caso):");
        buscar(matriz, 19);
    }
}
public class BusquedaMatriz {
    
    public static boolean buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }
        
        int m = matriz.length;
        int n = matriz[0].length;
        int fila = 0;
        int columna = n - 1;
        int comparaciones = 0;
        
        while (fila < m && columna >= 0) {
            comparaciones++;
            if (matriz[fila][columna] == k) {
                System.out.println("Encontrado en posición [" + fila + "][" + columna + "] - " + comparaciones + " comparaciones");
                return true;
            } else if (matriz[fila][columna] > k) {
                columna--;  // izquierda
            } else {
                fila++;     // abajo
            }
        }
        
        System.out.println("No encontrado - " + comparaciones + " comparaciones");
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
        
        buscar(matriz, 22);
        buscar(matriz, 21);
        buscar(matriz, 16);
        buscar(matriz, 19);
        buscar(matriz, 40);
        buscar(matriz, 100);
    }
}
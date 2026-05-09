public class BusquedaMatrizOrdenada {

    public static int[] buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return new int[]{-1, -1};
        }

        int n = matriz.length;
        int m = matriz[0].length;

        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            if (matriz[i][j] == k) {
                return new int[]{i, j};
            } else if (matriz[i][j] > k) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] buscarConTraza(int[][] matriz, int k) {
        int n = matriz.length;
        int m = matriz[0].length;
        int i = 0, j = m - 1;
        int comparaciones = 0;

        System.out.println("Buscando k = " + k);

        while (i < n && j >= 0) {
            comparaciones++;
            int actual = matriz[i][j];
            System.out.printf("  Paso %d: M[%d][%d] = %2d  ", comparaciones, i, j, actual);

            if (actual == k) {
                System.out.println("-> encontrado");
                System.out.println("Total comparaciones: " + comparaciones);
                return new int[]{i, j};
            } else if (actual > k) {
                System.out.println("> " + k + " -> j--");
                j--;
            } else {
                System.out.println("< " + k + " -> i++");
                i++;
            }
        }

        System.out.println("-> no encontrado");
        System.out.println("Total comparaciones: " + comparaciones);
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        int[] valoresAProbar = {22, 21, 19, 16};

        for (int k : valoresAProbar) {
            buscarConTraza(matriz, k);
            System.out.println("------------------------------------");
        }
    }
}
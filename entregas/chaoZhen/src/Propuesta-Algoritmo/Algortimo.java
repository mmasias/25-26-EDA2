public class Algoritmo {

    public static int[] findInSortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int row = 0;
        int col = cols - 1;
        int iteracion = 1;

        System.out.println("Iniciando traza para buscar k = " + target + "\n");
        System.out.println("Iteracion | Fila | Col | Valor Actual | Evaluacion | Accion");
        System.out.println("-----------------------------------------------------------------");

        while (row < rows && col >= 0) {
            int currentValue = matrix[row][col];
            String textoBase = iteracion + " | " + row + " | " + col + " | " + currentValue + " | ";

            if (currentValue == target) {
                System.out.println(textoBase + currentValue + " == " + target + " | Retorna posicion en matriz [" + row + ", " + col + "]");
                return new int[]{row, col};
            } else if (currentValue > target) {
                System.out.println(textoBase + currentValue + " > " + target + " | col-- (Izquierda)");
                col--;
            } else {
                System.out.println(textoBase + currentValue + " < " + target + " | row++ (Abajo)");
                row++;
            }
            iteracion++;
        }

        System.out.println("Elemento no encontrado.");
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        int k = 22;
        int[] result = findInSortedMatrix(matrix, k);

        System.out.println("\n--- RESULTADO FINAL ---");
        if (result[0] != -1) {
            System.out.println("Elemento " + k + " encontrado en:");
            System.out.println("Fila: " + result[0]);
            System.out.println("Columna: " + result[1]);
        } else {
            System.out.println("El elemento " + k + " no se encuentra en la matriz.");
        }
    }
}
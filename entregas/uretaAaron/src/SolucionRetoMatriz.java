```java
public class SolucionRetoMatriz {

    public static boolean search(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            }

            if (current > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 2,  5,  9, 14, 21 },
            { 4,  7, 11, 17, 25 },
            { 8, 12, 15, 20, 30 },
            { 13, 18, 22, 27, 35 },
            { 19, 24, 28, 33, 40 }
        };

        int target = 22;
        System.out.println(search(matrix, target));
    }
}

```
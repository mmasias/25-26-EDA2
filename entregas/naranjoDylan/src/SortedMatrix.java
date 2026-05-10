
public class SortedMatrix {

    private final int[][] data;
    private final int rows;
    private final int cols;

    public SortedMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matriz no valida");
        }
        this.data = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        validateOrder();
    }

    public SearchResult search(int k) {
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = data[row][col];

            if (current == k) {
                return SearchResult.foundAt(row, col);
            } else if (current > k) {
                col--;
            } else {
                row++;
            }
        }
        return SearchResult.notFound();
    }

    public int getValueAt(int row, int col) {
        return data[row][col];
    }

    private void validateOrder() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (data[i][j] >= data[i][j + 1]) {
                    throw new IllegalArgumentException(
                            "Fila " + i + " no ordenada crecientemente");
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows - 1; i++) {
                if (data[i][j] >= data[i + 1][j]) {
                    throw new IllegalArgumentException(
                            "Columna " + j + " no ordenada crecientemente");
                }
            }
        }
    }
}

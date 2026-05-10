
public class Main {

    private static final int[][] MATRIX = {
        {2, 5, 9, 14, 21},
        {4, 7, 11, 17, 25},
        {8, 12, 15, 20, 30},
        {13, 18, 22, 27, 35},
        {19, 24, 28, 33, 40}
    };

    public static void main(String[] args) {
        SortedMatrix matrix = new SortedMatrix(MATRIX);

        System.out.println("Busqueda en matriz ordenada — Pruebas\n");

        testCase(matrix, 22, "Caso enunciado: valor presente (22)");
        testCase(matrix, 21, "Mejor caso: esquina de inicio (21)");
        testCase(matrix, 16, "Valor ausente (16)");
        testCase(matrix, 19, "Peor caso: esquina opuesta (19)");

        testCase(matrix, 1, "Valor menor que minimo");
        testCase(matrix, 50, "Valor mayor que maximo");
        testCase(matrix, 15, "Valor en centro aproximado");
    }

    private static void testCase(SortedMatrix matrix, int k, String description) {
        System.out.printf("%s (k=%d)%n", description, k);
        SearchResult result = matrix.search(k);
        System.out.println("   " + result);
        System.out.println();
    }
}

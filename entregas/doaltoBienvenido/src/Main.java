public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                { 2, 5, 9, 14, 21 },
                { 4, 7, 11, 17, 25 },
                { 8, 12, 15, 20, 30 },
                { 13, 18, 22, 27, 35 },
                { 19, 24, 28, 33, 40 }
        };

        BuscadorMatriz buscadorMatriz = new BuscadorMatriz();

        buscadorMatriz.buscar(matriz, 22);
        buscadorMatriz.buscar(matriz, 21);
        buscadorMatriz.buscar(matriz, 16);
    }
}

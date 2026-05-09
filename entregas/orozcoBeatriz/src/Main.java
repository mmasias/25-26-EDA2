public class Main {

    public static void mostrarResultado(int k, ResultadoBusqueda resultado) {
        if (resultado.encontrado) {
            System.out.println(k + " encontrado en posicion ("
                    + resultado.fila + ", " + resultado.columna + ")");
        } else {
            System.out.println(k + " no esta en la matriz");
        }

        System.out.println("Comparaciones: " + resultado.comparaciones);
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        BuscadorMatrizOrdenada buscador = new BuscadorMatrizOrdenada();

        mostrarResultado(22, buscador.buscar(matriz, 22));
        System.out.println();

        mostrarResultado(21, buscador.buscar(matriz, 21));
        System.out.println();

        mostrarResultado(16, buscador.buscar(matriz, 16));
        System.out.println();

        mostrarResultado(19, buscador.buscar(matriz, 19));
    }
}
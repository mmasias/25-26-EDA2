class BusquedaMatriz {

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        probarBusqueda(matriz, 22);
        probarBusqueda(matriz, 21);
        probarBusqueda(matriz, 16);
        probarBusqueda(matriz, 19);
        probarBusqueda(matriz, 15);
    }

    static void probarBusqueda(int[][] matriz, int k) {
        ResultadoBusqueda resultado = buscar(matriz, k);

        System.out.println("Buscando k = " + k);

        if (resultado.encontrado) {
            System.out.println("Resultado: encontrado");
            System.out.println("Fila: " + resultado.fila);
            System.out.println("Columna: " + resultado.columna);
        } else {
            System.out.println("Resultado: no encontrado");
        }

        System.out.println("Comparaciones: " + resultado.comparaciones);
        System.out.println();
    }

    static ResultadoBusqueda buscar(int[][] matriz, int k) {
        int fila = 0;
        int columna = matriz[0].length - 1;
        int comparaciones = 0;

        while (fila < matriz.length && columna >= 0) {
            comparaciones++;

            if (matriz[fila][columna] == k) {
                return new ResultadoBusqueda(true, fila, columna, comparaciones);
            }

            if (k < matriz[fila][columna]) {
                columna--;
            } else {
                fila++;
            }
        }

        return new ResultadoBusqueda(false, -1, -1, comparaciones);
    }
}

class ResultadoBusqueda {

    boolean encontrado;
    int fila;
    int columna;
    int comparaciones;

    ResultadoBusqueda(boolean encontrado, int fila, int columna, int comparaciones) {
        this.encontrado = encontrado;
        this.fila = fila;
        this.columna = columna;
        this.comparaciones = comparaciones;
    }
}
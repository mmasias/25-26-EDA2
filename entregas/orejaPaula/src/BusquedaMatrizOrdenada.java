public class BusquedaMatrizOrdenada {

    public static void main(String[] args) {
        int[][] matriz;

        matriz = new int[][] {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        buscar(matriz, 22);
        buscar(matriz, 21);
        buscar(matriz, 16);
    }

    public static boolean buscar(int[][] matriz, int valorBuscado) {
        int fila;
        int columna;
        int comparaciones;
        boolean encontrado;
        boolean dentroMatriz;

        fila = matriz.length - 1;
        columna = 0;
        comparaciones = 0;
        encontrado = false;
        dentroMatriz = true;

        while (dentroMatriz && !encontrado) {
            comparaciones++;

            if (matriz[fila][columna] == valorBuscado) {
                encontrado = true;
            } else {
                if (valorBuscado > matriz[fila][columna]) {
                    columna++;
                } else {
                    fila--;
                }

                dentroMatriz = fila >= 0 && columna < matriz[0].length;
            }
        }

        if (encontrado) {
            System.out.println(valorBuscado + " encontrado");
        } else {
            System.out.println(valorBuscado + " no encontrado");
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println();

        return encontrado;
    }
}
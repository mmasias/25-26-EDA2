public class Main {

    public static void main(String[] args) {
        int[][] M = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        System.out.println(java.util.Arrays.toString(BusquedaMatriz.buscar(M, 22)));
        System.out.println(java.util.Arrays.toString(BusquedaMatriz.buscar(M, 21)));
        System.out.println(java.util.Arrays.toString(BusquedaMatriz.buscar(M, 16)));
        System.out.println(java.util.Arrays.toString(BusquedaMatriz.buscar(M, 40)));
    }
}
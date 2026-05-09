public class Main{
    public static void main(String[] args){
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        int[] centro = obtenerCentro(matriz);
        BeMo.buscarElemento(matriz, centro);
    }

    public static int[] obtenerCentro(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int filaCentro = (filas - 1) / 2;
        int columnaCentro = (columnas - 1) / 2;

        return new int[]{filaCentro, columnaCentro};
    } 
}
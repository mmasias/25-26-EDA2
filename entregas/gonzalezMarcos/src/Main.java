public class Main {

    public static void main(String[] args) {

        int[][] datos = {
            {  2,  5,  9, 14, 21 },
            {  4,  7, 11, 17, 25 },
            {  8, 12, 15, 20, 30 },
            { 13, 18, 22, 27, 35 },
            { 19, 24, 28, 33, 40 }
        };

        MatrizOrdenada matriz = new MatrizOrdenada(datos);
        int k = 22;

        System.out.println("=== Búsqueda por Eliminación ===");
        System.out.println("\nMatriz " + matriz.getFilas() + "×" + matriz.getColumnas() + ":");
        matriz.imprimir();

        BusquedaPorEliminacion.Resultado resultado = BusquedaPorEliminacion.buscar(matriz, k);

        System.out.println("\nResultado: " + resultado);

        int n = matriz.getFilas();
        int m = matriz.getColumnas();
        System.out.println("\n--- Análisis de casos para matriz " + n + "×" + m + " ---");
        System.out.println("Mejor caso (elemento en esquina de inicio):  "
                + BusquedaPorEliminacion.mejorCaso(n, m) + " comparación");
        System.out.println("Peor caso  (N + M - 1 = " + n + " + " + m + " - 1): "
                + BusquedaPorEliminacion.peorCaso(n, m) + " comparaciones");
    }
}

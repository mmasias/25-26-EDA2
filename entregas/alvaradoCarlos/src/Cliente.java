public class Cliente {

    public static void main(String[] args) {
        int[][] matriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        System.out.println("=== Pruebas del Algoritmo: Búsqueda con Filtro ===\n");

        ejecutarPrueba(matriz, 22, "Caso Promedio");

        ejecutarPrueba(matriz, 19, "Peor Caso");

        ejecutarPrueba(matriz, 2, "Mejor Caso");

        ejecutarPrueba(matriz, 16, "Elemento Inexistente");
    }

    private static void ejecutarPrueba(int[][] matriz, int k, String descripcion) {
        System.out.println("Buscando " + k + " (" + descripcion + ")...");
        
        boolean encontrado = BusquedaConFiltro.buscar(matriz, k);
        
        if (encontrado) {
            System.out.println(" -> [RESULTADO: ¡ENCONTRADO!]\n");
        } else {
            System.out.println(" -> [RESULTADO: NO EXISTE]\n");
        }
    }
}
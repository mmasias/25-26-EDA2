public class Cliente {
    public static void main(String[] args) {
        int[][] matriz = {
            { 2,  5,  9, 14, 21 },
            { 4,  7, 11, 17, 25 },
            { 8, 12, 15, 20, 30 },
            { 13, 18, 22, 27, 35 },
            { 19, 24, 28, 33, 40 }
        };

        AlgoritmoAtraparRaton buscador = new AlgoritmoAtraparRaton().verbose();

        System.out.println("¿Encontrado el 22? " + buscador.buscar(matriz, 22) + "\n");
        System.out.println("¿Encontrado el 21? " + buscador.buscar(matriz, 21) + "\n");
        System.out.println("¿Encontrado el 16? " + buscador.buscar(matriz, 16) + "\n");
    }
}
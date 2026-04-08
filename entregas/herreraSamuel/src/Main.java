public class Main {
    public static void main(String[] args) {
        Reto puzzle = new Reto();
        
        System.out.println("Buscando solución para SEND + MORE = MONEY...");
        long tiempoInicio = System.currentTimeMillis();
        
        puzzle.resolverPuzzle();
        
        long tiempoFin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + (tiempoFin - tiempoInicio) + " ms");
    }
}
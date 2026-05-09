public class Main { 
    public static void main(String[] args) { 
        int[][] numeros = { 
            {  2,  5,  9, 14, 21 }, 
            {  4,  7, 11, 17, 25 }, 
            {  8, 12, 15, 20, 30 }, 
            { 13, 18, 22, 27, 35 }, 
            { 19, 24, 28, 33, 40 } 
        }; 

        MatrizOrdenada miMatriz = new MatrizOrdenada(numeros); 
        int valorBuscado = 22; 

        System.out.println("--- ALGORITMO DE BÚSQUEDA EN MATRIZ ORDENADA ---"); 
        System.out.println("\nDimensiones de la cuadrícula: " + miMatriz.getFilas() + "x" + miMatriz.getColumnas()); 
        miMatriz.mostrarMatriz(); 

        BusquedaPorEliminacion.Informe resultadoFinal = BusquedaPorEliminacion.ejecutarBusqueda(miMatriz, valorBuscado); 
        System.out.println("\nResumen: " + resultadoFinal.toString()); 

        int f = miMatriz.getFilas(); 
        int c = miMatriz.getColumnas(); 
        
        System.out.println("\n*** Complejidad Teórica ***"); 
        System.out.println("- Mejor escenario: " + BusquedaPorEliminacion.calcularMejorCaso() + " paso (esquina inicial)."); 
        System.out.println("- Peor escenario:  " + BusquedaPorEliminacion.calcularPeorCaso(f, c) + " pasos (recorrido N+M-1)."); 
    } 
}
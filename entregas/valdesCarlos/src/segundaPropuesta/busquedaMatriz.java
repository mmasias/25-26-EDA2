package segundaPropuesta;

import java.util.Scanner;

public class busquedaMatriz {

    public static void main(String[] args) {
        int[][] matriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BUSCADOR DESDE EL CENTRO (DIVIDE Y VENCERÁS) ---");
        
        System.out.print("\nIntroduce un número para buscar (o escribe -1 para salir): ");
        int numeroBuscado = scanner.nextInt();
        
        while (numeroBuscado != -1) {
            
            
            int[] comparaciones = {0}; 
            
            
            boolean encontrado = busquedaRecursiva(matriz, 0, matriz.length - 1, 0, matriz[0].length - 1, numeroBuscado, comparaciones);
            
            if (encontrado) {
                System.out.println(" RESULTADO: El número " + numeroBuscado + " SÍ existe.");
            } else {
                System.out.println(" RESULTADO: El número " + numeroBuscado + " NO existe en la matriz.");
            }
            
            System.out.println(" CELDAS EVALUADAS (Comparaciones): " + comparaciones[0]);
            
            System.out.print("\nIntroduce un número para buscar (o escribe -1 para salir): ");
            numeroBuscado = scanner.nextInt();
        }
        
        System.out.println("Saliendo del programa. ¡Hasta pronto!");
        scanner.close();
    }

    private static boolean busquedaRecursiva(int[][] matriz, int filaInicio, int filaFin, int colInicio, int colFin, int k, int[] comparaciones) {
        
        if (filaInicio > filaFin || colInicio > colFin) {
            return false;
        }

       
        int mitadFila = filaInicio + (filaFin - filaInicio) / 2;
        int mitadCol = colInicio + (colFin - colInicio) / 2;
        
        int valorCentro = matriz[mitadFila][mitadCol];
        comparaciones[0]++; 

        if (valorCentro == k) {
            return true;
        } 

        else if (k < valorCentro) {
            return busquedaRecursiva(matriz, filaInicio, mitadFila - 1, colInicio, colFin, k, comparaciones) ||  
                   busquedaRecursiva(matriz, mitadFila, filaFin, colInicio, mitadCol - 1, k, comparaciones);    
        } 
        
        else {
            return busquedaRecursiva(matriz, mitadFila + 1, filaFin, colInicio, colFin, k, comparaciones) ||     
                   busquedaRecursiva(matriz, filaInicio, mitadFila, mitadCol + 1, colFin, k, comparaciones);     
        }
    }
}
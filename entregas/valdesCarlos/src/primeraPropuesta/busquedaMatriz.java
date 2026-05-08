package primeraPropuesta;

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
        System.out.println("--- BUSCADOR EN MATRIZ ORDENADA ---");
        
        System.out.print("\nIntroduce un número para buscar (o escribe -1 para salir): ");
        int numeroBuscado = scanner.nextInt();
        
        while (numeroBuscado != -1) {
            
            buscarYContar(matriz, numeroBuscado);
            
            System.out.print("\nIntroduce un número para buscar (o escribe -1 para salir): ");
            numeroBuscado = scanner.nextInt();
        }
        
        System.out.println("Saliendo del programa. ¡Hasta pronto!");
        scanner.close();
    }

    public static void buscarYContar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.out.println("Error: La matriz está vacía.");
            return;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        int filaActual = 0;
        int colActual = columnas - 1;
        
        int comparaciones = 0;
        int saltos = 0; 
        boolean encontrado = false;

        while (filaActual < filas && colActual >= 0 && !encontrado) {
            comparaciones++; 
            
            int valorActual = matriz[filaActual][colActual];
            
            if (valorActual == k) {
                encontrado = true;
            } else if (k < valorActual) {
                colActual--;
                saltos++; 
            } else {
                filaActual++;
                saltos++; 
            }
        }
        
        if (encontrado) {
            System.out.println("✅ RESULTADO: El número " + k + " SÍ existe.");
            System.out.println(" POSICIÓN: Fila " + (filaActual + 1) + ", Columna " + (colActual + 1));
        } else {
            System.out.println(" RESULTADO: El número " + k + " NO existe en la matriz.");
        }
        
        System.out.println(" CELDAS EVALUADAS (Comparaciones): " + comparaciones);
        System.out.println(" MOVIMIENTOS REALIZADOS (Saltos): " + saltos);
    }
}
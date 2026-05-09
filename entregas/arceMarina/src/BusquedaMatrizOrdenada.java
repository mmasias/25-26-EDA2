import java.util.Scanner;

public class BusquedaMatrizOrdenada {

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        System.out.println("Matriz actual:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Ingrese el valor a buscar (o '0' para salir): ");
            int k = sc.nextInt();

            if (k == 0) {
                System.out.println("Programa terminado.");
                continuar = false;
            } else {
                int fila = 0;
                int columna = matriz[0].length - 1;
                int comparaciones = 0;
                boolean encontrado = false;

                System.out.println("Iniciando búsqueda de " + k + "...\n");

                while (fila < matriz.length && columna >= 0 && !encontrado) {
                    comparaciones++;
                    int valorActual = matriz[fila][columna];
                    System.out.print("Paso " + comparaciones + ": Posición (" + fila + "," + columna + ") = " + valorActual + " -> ");

                    if (valorActual == k) {
                        System.out.println("¡Encontrado!");
                        encontrado = true;
                    } else if (valorActual > k) {
                        System.out.println("Mayor que " + k + " → Mover izquierda");
                        columna--;
                    } else {
                        System.out.println("Menor que " + k + " → Mover abajo");
                        fila++;
                    }
                }

                if (encontrado) {
                    System.out.println("\nResultado: Valor " + k + " encontrado en posición (Fila " + fila + ", Columna " + columna + ")");
                } else {
                    System.out.println("\nResultado: Valor " + k + " no encontrado en la matriz");
                }

                System.out.println("Total comparaciones realizadas: " + comparaciones + "\n");
            }
        }
        sc.close();
    }
}
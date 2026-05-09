import java.util.Scanner;

public class BuscadorMatrizVisual {

    public static void main(String[] args) {
        int[][] matriz = {
                { 2, 5, 9, 14, 21 },
                { 4, 7, 11, 17, 25 },
                { 8, 12, 15, 20, 30 },
                { 13, 18, 22, 27, 35 },
                { 19, 24, 28, 33, 40 }
        };

        int numero = 22;

        System.out.println("=== EXPLORADOR DE MATRICES EDA ===");
        System.out.println("Buscando el tesoro (k = " + numero + ")\n");

        if (buscarConVisualizacion(matriz, numero)) {
            System.out.println("\n✨ ¡Éxito! El valor " + numero + " ha sido localizado.");
        } else {
            System.out.println("\n❌ El valor " + numero + " no se encuentra en la matriz.");
        }
    }

    public static boolean buscarConVisualizacion(int[][] matriz, int k) {
        boolean hallado = false;

        if (matriz != null && matriz.length > 0) {
            hallado = ejecutarCicloDeBusqueda(matriz, k);
        }

        return hallado;
    }

    private static boolean ejecutarCicloDeBusqueda(int[][] matriz, int k) {
        boolean hallado = false;
        int f = 0;
        int c = matriz[0].length - 1;
        int paso = 1;
        Scanner scanner = new Scanner(System.in);

        while (f < matriz.length && c >= 0 && !hallado) {
            int valorActual = matriz[f][c];

            imprimirPaso(paso, f, c, valorActual, k);
            dibujarMatriz(matriz, f, c);

            if (valorActual == k) {
                hallado = true;
            } else {

                if (k < valorActual) {
                    c--;
                } else {
                    f++;
                }
                paso++;
                esperarEnter(scanner);
            }
        }

        return hallado;
    }

    private static void dibujarMatriz(int[][] matriz, int filaPuntero, int colPuntero) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("    ");
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == filaPuntero && j == colPuntero) {

                    System.out.printf("[%2d] ", matriz[i][j]);
                } else {
                    System.out.printf(" %2d  ", matriz[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------");
    }

    private static void imprimirPaso(int paso, int f, int c, int valor, int k) {
        System.out.print("\nPASO " + paso + " (Fila " + f + ", Col " + c + "): ");
        if (valor == k) {
            System.out.println("¡" + valor + " == " + k + "!");
        } else if (k < valor) {
            System.out.println(k + " < " + valor + " -> Descartamos columna y vamos a la IZQUIERDA.");
        } else {
            System.out.println(k + " > " + valor + " -> Descartamos fila y vamos ABAJO.");
        }
    }

    private static void esperarEnter(Scanner scanner) {
        System.out.print("Presiona [ENTER] para ver el siguiente paso...");
        scanner.nextLine();
    }
}
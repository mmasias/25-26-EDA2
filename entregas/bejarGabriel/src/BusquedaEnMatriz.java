
import java.util.Scanner;

public class BusquedaEnMatriz {

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        Scanner lector = new Scanner(System.in);
        System.out.print("Introduce el valor a buscar (k): ");
        int valorObjetivo = lector.nextInt();

        buscarValorEnMatriz(matriz, valorObjetivo);
        lector.close();
    }

    public static void buscarValorEnMatriz(int[][] matriz, int valorObjetivo) {
        int filaActual = 0;
        int columnaActual = matriz[0].length - 1;
        boolean fueEncontrado = false;
        int numeroComparacion = 0;

        System.out.println("Iniciando la busqueda...");

        while (filaActual < matriz.length && columnaActual >= 0 && !fueEncontrado) {
            numeroComparacion++;
            int valorActual = matriz[filaActual][columnaActual];

            if (valorObjetivo == valorActual) {
                System.out.println("Comparacion " + numeroComparacion + " - Actual: " + valorActual + ". Coincidencia exacta. Encontrado.");
                fueEncontrado = true;
            } else if (valorObjetivo < valorActual) {
                System.out.println("Comparacion " + numeroComparacion + " - Actual: " + valorActual + ". " + valorObjetivo + " es menor. Nos movemos a la izquierda.");
                columnaActual--;
            } else {
                System.out.println("Comparacion " + numeroComparacion + " - Actual: " + valorActual + ". " + valorObjetivo + " es mayor. Nos movemos hacia abajo.");
                filaActual++;
            }
        }

        if (!fueEncontrado) {
            System.out.println("Busqueda finalizada. El valor " + valorObjetivo + " no existe en la matriz. Total de comparaciones: " + numeroComparacion);
        }
    }
}

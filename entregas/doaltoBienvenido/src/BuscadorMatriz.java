public class BuscadorMatriz {

    public void buscar(int[][] matriz, int k) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int filaActual = filas - 1;
        int columnaActual = 0;
        int comparaciones = 0;
        boolean encontrado = false;

        System.out.println("Buscando el valor " + k + ":");

        while (filaActual >= 0 && columnaActual < columnas && !encontrado) {
            comparaciones++;
            int valorActual = matriz[filaActual][columnaActual];

            if (valorActual == k) {
                System.out.println("Encontrado en: [" + filaActual + "][" + columnaActual + "]");
                encontrado = true;
            } else if (valorActual < k) {
                columnaActual++;
            } else {
                filaActual--;
            }
        }

        if (!encontrado) {
            System.out.println("El valor " + k + " no existe.");
        }
        System.out.println("Total de comparaciones: " + comparaciones);
        System.out.println("-------------------------------------------");
    }
}

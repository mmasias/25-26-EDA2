public class BusquedaMatriz {

    public static boolean buscar(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0) return false;

        
        int fila = matriz.length - 1;
        int columna = 0;

        System.out.println("--- Buscando " + objetivo + " ---");
        System.out.println("Inicio en esquina inferior izquierda: [" + fila + "][" + columna + "]");

        while (fila >= 0 && columna < matriz[0].length) {
            int actual = matriz[fila][columna];
            System.out.print("Posicion [" + fila + "][" + columna + "] = " + actual);

            if (actual == objetivo) {
                System.out.println(" -> ¡Encontrado!");
                return true;
            } else if (actual > objetivo) {
                System.out.println(" -> " + actual + " > " + objetivo + ": Subo fila");
                fila--;
            } else {
                System.out.println(" -> " + actual + " < " + objetivo + ": Muevo a la derecha");
                columna++;
            }
        }

        System.out.println("Resultado: No se encontro el valor.");
        return false;
    }

    public static void main(String[] args) {
        int[][] matriz = {
            { 2,  5,  9, 14, 21},
            { 4,  7, 11, 17, 25},
            { 8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        buscar(matriz, 22);
    }
}
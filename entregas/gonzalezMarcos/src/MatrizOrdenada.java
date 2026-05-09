public class MatrizOrdenada {

    private final int[][] datos;
    private final int filas;
    private final int columnas;

    public MatrizOrdenada(int[][] datos) {
        this.datos = datos;
        this.filas = datos.length;
        this.columnas = (datos.length > 0) ? datos[0].length : 0;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int get(int fila, int col) {
        return datos[fila][col];
    }

    public void imprimir() {
        for (int[] fila : datos) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }
}

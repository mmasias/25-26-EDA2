public class ResultadoBusqueda {
    boolean encontrado;
    int fila;
    int columna;
    int comparaciones;

    ResultadoBusqueda(boolean encontrado, int fila, int columna, int comparaciones) {
        this.encontrado = encontrado;
        this.fila = fila;
        this.columna = columna;
        this.comparaciones = comparaciones;
    }
}
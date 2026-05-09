public class EstadoBusqueda {
    private final int[][] matriz;
    private final boolean[][] descartados;
    private final boolean[][] visitados;
    private final int objetivo;
    private int comparaciones;

    public EstadoBusqueda(int[][] matriz, int objetivo) {
        this.matriz = matriz;
        this.objetivo = objetivo;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        this.descartados = new boolean[filas][columnas];
        this.visitados = new boolean[filas][columnas];
        this.comparaciones = 0;
    }

    public int getObjetivo() { return objetivo; }
    public int getComparaciones() { return comparaciones; }
    
    public void contarComparacion() { comparaciones++; }

    public int getValor(int f, int c) {
        return matriz[f][c];
    }

    public boolean esInvalidaOVisitada(int f, int c) {
        if (f < 0 || f >= matriz.length || c < 0 || c >= matriz[0].length) {
            return true;
        }
        return descartados[f][c] || visitados[f][c];
    }

    public void marcarComoVisitada(int f, int c) {
        visitados[f][c] = true;
    }

    public void descartarMenores(int fMax, int cMax) {
        for (int i = 0; i <= fMax; i++) {
            for (int j = 0; j <= cMax; j++) {
                descartados[i][j] = true;
            }
        }
    }

    public void descartarMayores(int fMin, int cMin) {
        for (int i = fMin; i < matriz.length; i++) {
            for (int j = cMin; j < matriz[0].length; j++) {
                descartados[i][j] = true;
            }
        }
    }
}
package recursivo;

public class ResultadoCriptaritmo {

    private final int[] asignacion;
    private final boolean tieneSolucion;

    public ResultadoCriptaritmo(int[] asignacion, boolean tieneSolucion) {
        this.asignacion = asignacion;
        this.tieneSolucion = tieneSolucion;
    }

    public boolean tieneSolucion() {
        return tieneSolucion;
    }

    public int getValor(char c) {
        return asignacion[c - 'A'];
    }
}

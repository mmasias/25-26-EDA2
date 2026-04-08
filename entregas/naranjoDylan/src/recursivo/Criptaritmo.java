package recursivo;
public class Criptaritmo {

    private final String[] sumandos;
    private final String resultado;

    public Criptaritmo(String[] sumandos, String resultado) {
        this.sumandos = sumandos;
        this.resultado = resultado;
    }

    public String[] getSumandos() {
        return sumandos;
    }

    public String getResultado() {
        return resultado;
    }
}
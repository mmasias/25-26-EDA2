public class Money {
    private String letrasUnicas;
    private int[] asignacion;
    private boolean[] digitoUsado;

    public Money() {
        this.letrasUnicas = "SENDMORY";
        this.asignacion = new int[letrasUnicas.length()];
        this.digitoUsado = new boolean[10];
    }

public void resolver() {
        if (ejecutarRecursion(0)) {
            imprimirResultado();
        } else {
            System.out.println("No se encontro solucion.");
        }
    }
    private boolean ejecutarRecursion(int indice) {
        if (indice == letrasUnicas.length()) {
            return esSumaCorrecta();
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (esAsignacionValida(indice, digito)) {
                asignacion[indice] = digito;
                digitoUsado[digito] = true;

                if (ejecutarRecursion(indice + 1)) {
                    return true;
                }

                digitoUsado[digito] = false;
            }
        }
        return false;
    }
    private boolean esAsignacionValida(int indice, int digito) {
        if (digitoUsado[digito]) return false;
        if (digito == 0 && (indice == 0 || indice == 4)) return false;
        return true;
    }

    private boolean esSumaCorrecta() {
        int s = asignacion[0];
        int e = asignacion[1];
        int n = asignacion[2];
        int d = asignacion[3];
        int m = asignacion[4];
        int o = asignacion[5];
        int r = asignacion[6];
        int y = asignacion[7];

        int send = s * 1000 + e * 100 + n * 10 + d;
        int more = m * 1000 + o * 100 + r * 10 + e;
        int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;

        return (send + more) == money;
    }
    private void imprimirResultado() {
        for (int i = 0; i < letrasUnicas.length(); i++) {
            System.out.println(letrasUnicas.charAt(i) + " = " + asignacion[i]);
        }
    }    

    public static void main(String[] args) {
        Money examen = new Money();
        examen.resolver();
    }
}
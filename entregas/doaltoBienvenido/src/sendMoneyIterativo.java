public class sendMoneyIterativo {

    private final int TOTAL_NUMEROS_A_ASIGNAR = 10;
    private final char[] letras = { 'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y' };
    private final int[] valores = new int[letras.length];
    private final boolean[] usado = new boolean[TOTAL_NUMEROS_A_ASIGNAR];

    public static void main(String[] args) {
        new sendMoneyIterativo().resolver();
    }

    public void resolver() {
        inicializarValores();

        if (buscarSolucionIterativa()) {
            mostrarResultado();
        } else {
            System.out.println("No hay solución.");
        }
    }

    private void inicializarValores() {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = -1;
        }
    }

    private boolean buscarSolucionIterativa() {
        int indice = 0;

        while (indice >= 0) {
            if (indice == letras.length) {
                if (esSumaCorrecta()) {
                    return true;
                }
                indice--;
                continue;
            }

            if (intentarAsignarSiguienteDigito(indice)) {
                indice++;
            } else {
                valores[indice] = -1;
                indice--;
            }
        }
        return false;
    }

    private boolean intentarAsignarSiguienteDigito(int indice) {
        int digitoInicio = valores[indice] + 1;

        liberarDigitoActual(indice);

        for (int caracter = digitoInicio; caracter <= 9; caracter++) {
            if (esDigitoValido(caracter, indice)) {
                asignarDigito(caracter, indice);
                return true;
            }
        }
        return false;
    }

    private boolean esDigitoValido(int digito, int indice) {
        if (usado[digito]) {
            return false;
        }

        if (digito == 0 && (letras[indice] == 'S' || letras[indice] == 'M')) {
            return false;
        }

        return true;
    }

    private void asignarDigito(int digito, int indice) {
        valores[indice] = digito;
        usado[digito] = true;
    }

    private void liberarDigitoActual(int indice) {
        if (valores[indice] != -1) {
            usado[valores[indice]] = false;
        }
    }

    private boolean esSumaCorrecta() {
        int s = valores[0], e = valores[1], n = valores[2], d = valores[3];
        int m = valores[4], o = valores[5], r = valores[6], y = valores[7];

        int send = s * 1000 + e * 100 + n * 10 + d;
        int more = m * 1000 + o * 100 + r * 10 + e;
        int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;

        return (send + more) == money;
    }

    private void mostrarResultado() {
        int s = valores[0], e = valores[1], n = valores[2], d = valores[3];
        int m = valores[4], o = valores[5], r = valores[6], y = valores[7];

        System.out.println("   S E N D      " + s + " " + e + " " + n + " " + d);
        System.out.println("+  M O R E    + " + m + " " + o + " " + r + " " + e);
        System.out.println("-----------   _________");
        System.out.println(" M O N E Y    " + m + " " + o + " " + n + " " + e + " " + y);
    }
}
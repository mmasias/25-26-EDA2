public class sendMoney {

    
    
    private char[] letras = { 'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y' };
    private int[] valores = new int[letras.length];
    private boolean[] valorUsado = new boolean[10];

    public static void main(String[] args) {
        sendMoney juego = new sendMoney();
        juego.resolverProblema();
    }

    public void resolverProblema() {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = -1;
        }

        if (backtracking(0)) {
            mostrarResultado();
        } else {
            System.out.println("No hay solución.");
        }
    }

    private boolean backtracking(int indice) {
        if (indice == letras.length) {
            return esSumaCorrecta();
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (!valorUsado[digito]) {

                if (digito == 0 && (letras[indice] == 'S' || letras[indice] == 'M')) {
                    continue;
                }

                valorUsado[digito] = true;
                valores[indice] = digito;

                if (backtracking(indice + 1)) {
                    return true;
                }

                valorUsado[digito] = false;
                valores[indice] = -1;
            }
        }
        return false;
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

        System.out.println("Solución:");

        System.out.println("   S E N D      " + s + " " + e + " " + n + " " + d);
        System.out.println("+  M O R E    + " + m + " " + o + " " + r + " " + e);
        System.out.println("-----------   ----------");
        System.out.println(" M O N E Y    " + m + " " + o + " " + n + " " + e + " " + y);
        ;
    }
}
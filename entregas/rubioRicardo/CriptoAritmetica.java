public class CriptoAritmetica {

    private static final int TOTAL_DIGITOS = 10;
    private static final int ACERTIJO_SEND = 1;
    private static final int ACERTIJO_FORTY = 2;
    private static final int ACERTIJO_ODD = 3;

    private static char[] letras;
    private static int[] valores;
    private static boolean[] usado;
    private static int tipoActual;

    public static void main(String[] args) {
        System.out.println("--- SEND + MORE = MONEY ---");
        prepararAcertijo(ACERTIJO_SEND, new char[]{'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'});

        System.out.println("");
        System.out.println("--- FORTY + TEN + TEN = SIXTY ---");
        prepararAcertijo(ACERTIJO_FORTY, new char[]{'F', 'O', 'R', 'T', 'Y', 'E', 'N', 'S', 'I', 'X'});

        System.out.println("");
        System.out.println("--- ODD + ODD = EVEN ---");
        prepararAcertijo(ACERTIJO_ODD, new char[]{'O', 'D', 'E', 'V', 'N'});
    }

    private static void prepararAcertijo(int tipo, char[] arregloLetras) {
        tipoActual = tipo;
        letras = arregloLetras;
        valores = new int[letras.length];
        usado = new boolean[TOTAL_DIGITOS];

        if (!resolver(0)) {
            System.out.println("No se encontro solucion.");
        }
    }

    private static boolean resolver(int indice) {
        if (indice == letras.length) {
            return comprobarSuma();
        }

        for (int digito = 0; digito < TOTAL_DIGITOS; digito++) {
            if (!usado[digito]) {
                valores[indice] = digito;
                usado[digito] = true;

                if (resolver(indice + 1)) {
                    return true;
                }

                usado[digito] = false;
            }
        }
        return false;
    }

    private static boolean comprobarSuma() {
        if (tipoActual == ACERTIJO_SEND) {
            return comprobarSend();
        } else if (tipoActual == ACERTIJO_FORTY) {
            return comprobarForty();
        } else if (tipoActual == ACERTIJO_ODD) {
            return comprobarOdd();
        }
        return false;
    }

    private static boolean comprobarSend() {
        int s = valores[0], e = valores[1], n = valores[2], d = valores[3];
        int m = valores[4], o = valores[5], r = valores[6], y = valores[7];

        if (s == 0 || m == 0) return false;

        int send = (s * 1000) + (e * 100) + (n * 10) + d;
        int more = (m * 1000) + (o * 100) + (r * 10) + e;
        int money = (m * 10000) + (o * 1000) + (n * 100) + (e * 10) + y;

        if (send + more == money) {
            System.out.println("  " + send);
            System.out.println("+ " + more);
            System.out.println("-------");
            System.out.println(" " + money);
            return true;
        }
        return false;
    }

    private static boolean comprobarForty() {
        int f = valores[0], o = valores[1], r = valores[2], t = valores[3], y = valores[4];
        int e = valores[5], n = valores[6], s = valores[7], i = valores[8], x = valores[9];

        if (f == 0 || t == 0 || s == 0) return false;

        int forty = (f * 10000) + (o * 1000) + (r * 100) + (t * 10) + y;
        int ten = (t * 100) + (e * 10) + n;
        int sixty = (s * 10000) + (i * 1000) + (x * 100) + (t * 10) + y;

        if (forty + ten + ten == sixty) {
            System.out.println("  " + forty);
            System.out.println("+   " + ten);
            System.out.println("+   " + ten);
            System.out.println("-------");
            System.out.println("  " + sixty);
            return true;
        }
        return false;
    }

    private static boolean comprobarOdd() {
        int o = valores[0], d = valores[1], e = valores[2], v = valores[3], n = valores[4];

        if (o == 0 || e == 0) return false;

        int odd = (o * 100) + (d * 10) + d;
        int even = (e * 1000) + (v * 100) + (e * 10) + n;

        if (odd + odd == even) {
            System.out.println("  " + odd);
            System.out.println("+ " + odd);
            System.out.println("-------");
            System.out.println(" " + even);
            return true;
        }
        return false;
    }
}
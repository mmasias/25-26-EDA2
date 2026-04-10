import java.util.*;

public class SendMoreMoney {

    static char[] letras = {'S','E','N','D','M','O','R','Y'};
    static int[] valores = new int[letras.length];
    static boolean[] usados = new boolean[10];

    public static void main(String[] args) {
        backtracking(0);
    }

    static void backtracking(int index) {

        // 🔹 CASO BASE
        if (index == letras.length) {
            if (esSolucion()) {
                imprimir();
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {

            if (usados[d]) continue;

            // 🔹 Restricción: S y M no pueden ser 0
            if ((letras[index] == 'S' || letras[index] == 'M') && d == 0)
                continue;

            // Elegir
            valores[index] = d;
            usados[d] = true;

            // Explorar
            backtracking(index + 1);

            // Deshacer (backtracking)
            usados[d] = false;
        }
    }

    static int getValor(char c) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == c) return valores[i];
        }
        return -1;
    }

    static boolean esSolucion() {

        int S = getValor('S');
        int E = getValor('E');
        int N = getValor('N');
        int D = getValor('D');
        int M = getValor('M');
        int O = getValor('O');
        int R = getValor('R');
        int Y = getValor('Y');

        int SEND = 1000*S + 100*E + 10*N + D;
        int MORE = 1000*M + 100*O + 10*R + E;
        int MONEY = 10000*M + 1000*O + 100*N + 10*E + Y;

        return SEND + MORE == MONEY;
    }

    static void imprimir() {

        int S = getValor('S');
        int E = getValor('E');
        int N = getValor('N');
        int D = getValor('D');
        int M = getValor('M');
        int O = getValor('O');
        int R = getValor('R');
        int Y = getValor('Y');

        int SEND = 1000*S + 100*E + 10*N + D;
        int MORE = 1000*M + 100*O + 10*R + E;
        int MONEY = 10000*M + 1000*O + 100*N + 10*E + Y;

        System.out.println("Solución encontrada:");
        System.out.println("S=" + S + " E=" + E + " N=" + N + " D=" + D);
        System.out.println("M=" + M + " O=" + O + " R=" + R + " Y=" + Y);

        System.out.println("\nComprobación:");
        System.out.println(" " + SEND);
        System.out.println("+" + MORE);
        System.out.println("------");
        System.out.println(" " + MONEY);
    }
}
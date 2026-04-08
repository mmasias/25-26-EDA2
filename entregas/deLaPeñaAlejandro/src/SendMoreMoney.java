import java.util.*;

public class SendMoreMoney {

    static char[] letras = {'S','E','N','D','M','O','R','Y'};
    static int[] valor = new int[26];
    static boolean[] usado = new boolean[10];

    public static void main(String[] args) {
        Arrays.fill(valor, -1);
        resolver(0);
    }

    static void resolver(int pos) {
        if (pos == letras.length) {
            if (comprobar()) {
                mostrar();
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (!usado[d]) {

                char l = letras[pos];

                // Restricción: letras iniciales no pueden ser 0
                if ((l == 'S' || l == 'M') && d == 0) continue;

                valor[l - 'A'] = d;
                usado[d] = true;

                resolver(pos + 1);

                valor[l - 'A'] = -1;
                usado[d] = false;
            }
        }
    }

    static boolean comprobar() {
        int S = valor['S'-'A'];
        int E = valor['E'-'A'];
        int N = valor['N'-'A'];
        int D = valor['D'-'A'];
        int M = valor['M'-'A'];
        int O = valor['O'-'A'];
        int R = valor['R'-'A'];
        int Y = valor['Y'-'A'];

        int SEND  = 1000*S + 100*E + 10*N + D;
        int MORE  = 1000*M + 100*O + 10*R + E;
        int MONEY = 10000*M + 1000*O + 100*N + 10*E + Y;

        return SEND + MORE == MONEY;
    }

    static void mostrar() {
        for (char c : letras) {
            System.out.println(c + " = " + valor[c - 'A']);
        }
        System.out.println("-------------------");
    }
}
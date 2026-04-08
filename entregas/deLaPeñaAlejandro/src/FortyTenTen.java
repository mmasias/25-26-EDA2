import java.util.*;

public class FortyTenTen {

    static char[] letras = {'F','O','R','T','Y','E','N','S','I','X'};
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

                if ((l == 'F' || l == 'T' || l == 'S') && d == 0) continue;

                valor[l - 'A'] = d;
                usado[d] = true;

                resolver(pos + 1);

                valor[l - 'A'] = -1;
                usado[d] = false;
            }
        }
    }

    static boolean comprobar() {
        int F = valor['F'-'A'];
        int O = valor['O'-'A'];
        int R = valor['R'-'A'];
        int T = valor['T'-'A'];
        int Y = valor['Y'-'A'];
        int E = valor['E'-'A'];
        int N = valor['N'-'A'];
        int S = valor['S'-'A'];
        int I = valor['I'-'A'];
        int X = valor['X'-'A'];

        int FORTY = 10000*F + 1000*O + 100*R + 10*T + Y;
        int TEN   = 100*T + 10*E + N;
        int SIXTY = 10000*S + 1000*I + 100*X + 10*T + Y;

        return FORTY + TEN + TEN == SIXTY;
    }

    static void mostrar() {
        for (char c : letras) {
            System.out.println(c + " = " + valor[c - 'A']);
        }
        System.out.println("-------------------");
    }
}
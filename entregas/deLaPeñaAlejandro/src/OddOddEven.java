import java.util.*;

public class OddOddEven {

    static char[] letras = {'O','D','E','V','N'};
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

                if ((l == 'O' || l == 'E') && d == 0) continue;

                valor[l - 'A'] = d;
                usado[d] = true;

                resolver(pos + 1);

                valor[l - 'A'] = -1;
                usado[d] = false;
            }
        }
    }

    static boolean comprobar() {
        int O = valor['O'-'A'];
        int D = valor['D'-'A'];
        int E = valor['E'-'A'];
        int V = valor['V'-'A'];
        int N = valor['N'-'A'];

        int ODD  = 100*O + 10*D + D;
        int EVEN = 1000*E + 100*V + 10*E + N;

        return ODD + ODD == EVEN;
    }

    static void mostrar() {
        for (char c : letras) {
            System.out.println(c + " = " + valor[c - 'A']);
        }
        System.out.println("-------------------");
    }
}
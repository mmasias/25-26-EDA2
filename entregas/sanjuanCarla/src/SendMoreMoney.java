public class SendMoreMoney {

    static int[] valores = new int[8];
    static boolean[] usado = new boolean[10];
    static boolean encontrado = false;

    public static void main(String[] args) {
        resolver(0);
        if (encontrado == false) {
            System.out.println("No hay solución");
        }
    }

    static void resolver(int pos) {
        if (encontrado == true) return;

        if (pos == 8) {
            int S = valores[0];
            int E = valores[1];
            int N = valores[2];
            int D = valores[3];
            int M = valores[4];
            int O = valores[5];
            int R = valores[6];
            int Y = valores[7];

            int SEND = 1000 * S + 100 * E + 10 * N + D;
            int MORE = 1000 * M + 100 * O + 10 * R + E;
            int MONEY = 10000 * M + 1000 * O + 100 * N + 10 * E + Y;

            if (SEND + MORE == MONEY) {
                System.out.println("SEND = " + SEND);
                System.out.println("MORE = " + MORE);
                System.out.println("MONEY = " + MONEY);

                System.out.println("S=" + S + " E=" + E + " N=" + N + " D=" + D);
                System.out.println("M=" + M + " O=" + O + " R=" + R + " Y=" + Y);

                encontrado = true;
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (usado[d] == false) {

                if (pos == 0 && d == 0) continue;
                if (pos == 4 && d == 0) continue;

                valores[pos] = d;
                usado[d] = true;

                resolver(pos + 1);

                usado[d] = false;
            }
        }
    }
}

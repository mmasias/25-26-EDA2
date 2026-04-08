public class FortyTenTenSixty {

    static int[] valores = new int[10];
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

        if (pos == 10) {
            int F = valores[0];
            int O = valores[1];
            int R = valores[2];
            int T = valores[3];
            int Y = valores[4];
            int E = valores[5];
            int N = valores[6];
            int S = valores[7];
            int I = valores[8];
            int X = valores[9];

            int FORTY = 10000 * F + 1000 * O + 100 * R + 10 * T + Y;
            int TEN = 100 * T + 10 * E + N;
            int SIXTY = 10000 * S + 1000 * I + 100 * X + 10 * T + Y;

            if (FORTY + TEN + TEN == SIXTY) {
                System.out.println("FORTY = " + FORTY);
                System.out.println("TEN = " + TEN);
                System.out.println("TEN = " + TEN);
                System.out.println("SIXTY = " + SIXTY);

                System.out.println("F=" + F + " O=" + O + " R=" + R + " T=" + T + " Y=" + Y);
                System.out.println("E=" + E + " N=" + N + " S=" + S + " I=" + I + " X=" + X);

                encontrado = true;
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (usado[d] == false) {

                if (pos == 0 && d == 0) continue;
                if (pos == 3 && d == 0) continue;
                if (pos == 7 && d == 0) continue;

                valores[pos] = d;
                usado[d] = true;

                resolver(pos + 1);

                usado[d] = false;
            }
        }
    }
}

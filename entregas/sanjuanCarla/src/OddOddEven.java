public class OddOddEven {

    static int[] valores = new int[5];
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

        if (pos == 5) {
            int O = valores[0];
            int D = valores[1];
            int E = valores[2];
            int V = valores[3];
            int N = valores[4];

            int ODD = 100 * O + 10 * D + D;
            int EVEN = 1000 * E + 100 * V + 10 * E + N;

            if (ODD + ODD == EVEN) {
                System.out.println("ODD = " + ODD);
                System.out.println("ODD = " + ODD);
                System.out.println("EVEN = " + EVEN);

                System.out.println("O=" + O + " D=" + D + " E=" + E + " V=" + V + " N=" + N);

                encontrado = true;
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (usado[d] == false) {

                if (pos == 0 && d == 0) continue;
                if (pos == 2 && d == 0) continue;

                valores[pos] = d;
                usado[d] = true;

                resolver(pos + 1);

                usado[d] = false;
            }
        }
    }
}

import java.util.Scanner;

public class Reto002 {

    static int[] valores;
    static boolean[] usado = new boolean[10];
    static boolean encontrado = false;
    static int opcion;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el acertijo:");
        System.out.println("1. SEND + MORE = MONEY");
        System.out.println("2. FORTY + TEN + TEN = SIXTY");
        System.out.println("3. ODD + ODD = EVEN");
        System.out.print("Opción: ");
        opcion = sc.nextInt();

        if (opcion == 1) {
            valores = new int[8];
        } else if (opcion == 2) {
            valores = new int[10];
        } else if (opcion == 3) {
            valores = new int[5];
        } else {
            System.out.println("Opción no válida");
            return;
        }

        resolver(0);

        if (encontrado == false) {
            System.out.println("No hay solución");
        }
    }

    static void resolver(int pos) {
        if (encontrado == true) return;

        int totalLetras = 0;

        if (opcion == 1) totalLetras = 8;
        if (opcion == 2) totalLetras = 10;
        if (opcion == 3) totalLetras = 5;

        if (pos == totalLetras) {
            verificar();
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (usado[d] == false) {

                if (opcion == 1) {
                    if (pos == 0 && d == 0) continue;
                    if (pos == 4 && d == 0) continue;
                }

                if (opcion == 2) {
                    if (pos == 0 && d == 0) continue;
                    if (pos == 3 && d == 0) continue;
                    if (pos == 7 && d == 0) continue;
                }

                if (opcion == 3) {
                    if (pos == 0 && d == 0) continue;
                    if (pos == 2 && d == 0) continue;
                }

                valores[pos] = d;
                usado[d] = true;

                resolver(pos + 1);

                usado[d] = false;
            }
        }
    }

    static void verificar() {
        if (opcion == 1) {
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
        }

        if (opcion == 2) {
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
        }

        if (opcion == 3) {
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
        }
    }
}

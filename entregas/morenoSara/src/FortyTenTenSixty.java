public class FortyTenTenSixty {

    static char[] letras = {'S','F','T','O','R','Y','E','N','I','X'};
    static int[] valorLetra = new int[256];
    static boolean[] digitoUsado = new boolean[10];

    public static void main(String[] args) {
        resolverRecursivo(letras.length);
    }

    private static void resolverRecursivo(int letrasRestantes) {

        if (letrasRestantes == 0) {
            int F = valorLetra['F'];
            int O = valorLetra['O'];
            int R = valorLetra['R'];
            int T = valorLetra['T'];
            int Y = valorLetra['Y'];
            int E = valorLetra['E'];
            int N = valorLetra['N'];
            int S = valorLetra['S'];
            int I = valorLetra['I'];
            int X = valorLetra['X'];

            int FORTY = 10000*F + 1000*O + 100*R + 10*T + Y;
            int TEN = 100*T + 10*E + N;
            int SIXTY = 10000*S + 1000*I + 100*X + 10*T + Y;

            if (FORTY + TEN + TEN == SIXTY) {
                System.out.println("  " + F + " " + O + " " + R + " " + T + " " + Y);
                System.out.println("    " + T + " " + E + " " + N);
                System.out.println("+   " + T + " " + E + " " + N);
                System.out.println("-------------");
                System.out.println("  " + S + " " + I + " " + X + " " + T + " " + Y);
            }
            return;
        }

        int indiceLetra = letras.length - letrasRestantes;
        char letraActual = letras[indiceLetra];

        for (int digito = 9; digito >= 0; digito--) {
            if (!digitoUsado[digito]) {

                if ((letraActual == 'F' || letraActual == 'T' || letraActual == 'S') && digito == 0) {
                    continue;
                }

                valorLetra[letraActual] = digito;
                digitoUsado[digito] = true;

                resolverRecursivo(letrasRestantes - 1);

                digitoUsado[digito] = false;
            }
        }
    }
}


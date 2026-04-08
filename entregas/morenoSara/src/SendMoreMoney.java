public class SendMoreMoney {

    static char[] letras = {'M','S','E','N','D','O','R','Y'};
    static int[] valorLetra = new int[256];
    static boolean[] digitoUsado = new boolean[10];

    public static void main(String[] args) {
        resolverRecursivo(letras.length);
    }

    private static void resolverRecursivo(int letrasRestantes) {

        if (letrasRestantes == 0) {
            int S = valorLetra['S'];
            int E = valorLetra['E'];
            int N = valorLetra['N'];
            int D = valorLetra['D'];
            int M = valorLetra['M'];
            int O = valorLetra['O'];
            int R = valorLetra['R'];
            int Y = valorLetra['Y'];

            int SEND = 1000*S + 100*E + 10*N + D;
            int MORE = 1000*M + 100*O + 10*R + E;
            int MONEY = 10000*M + 1000*O + 100*N + 10*E + Y;

            if (SEND + MORE == MONEY) {
                System.out.println("  " + S + " " + E + " " + N + " " + D);
                System.out.println("+ " + M + " " + O + " " + R + " " + E);
                System.out.println("-------------");
                System.out.println(M + " " + O + " " + N + " " + E + " " + Y);
            }
            return;
        }

        int indiceLetra = letras.length - letrasRestantes;
        char letraActual = letras[indiceLetra];

        for (int digito = 9; digito >= 0; digito--) {
            if (!digitoUsado[digito]) {

                if ((letraActual == 'S' || letraActual == 'M') && digito == 0) {
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


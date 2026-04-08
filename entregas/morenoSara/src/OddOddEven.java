public class OddOddEven {

    static char[] letras = {'E','O','D','V','N'};
    static int[] valorLetra = new int[256];
    static boolean[] digitoUsado = new boolean[10];

    public static void main(String[] args) {
        resolverRecursivo(letras.length);
    }

    private static void resolverRecursivo(int letrasRestantes) {

        if (letrasRestantes == 0) {
            int O = valorLetra['O'];
            int D = valorLetra['D'];
            int E = valorLetra['E'];
            int V = valorLetra['V'];
            int N = valorLetra['N'];

            int ODD = 100*O + 10*D + D;
            int EVEN = 10000*E + 1000*V + 100*E + 10*V + N;

            if (ODD + ODD == EVEN) {
                System.out.println("  " + O + " " + D + " " + D);
                System.out.println("+ " + O + " " + D + " " + D);
                System.out.println("-------------");
                System.out.println(E + " " + V + " " + E + " " + V + " " + N);
            }
            return;
        }

        int indiceLetra = letras.length - letrasRestantes;
        char letraActual = letras[indiceLetra];

        for (int digito = 9; digito >= 0; digito--) {
            if (!digitoUsado[digito]) {

                if ((letraActual == 'O' || letraActual == 'E') && digito == 0) {
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
    

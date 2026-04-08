public class sendMoreMoneyGrupo {

    private static final char[] LETRAS = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};

    private static final char[] SEND = {'S', 'E', 'N', 'D'};
    private static final char[] MORE = {'M', 'O', 'R', 'E'};
    private static final char[] MONEY = {'M', 'O', 'N', 'E', 'Y'};

    private static final int[] valores = new int[256];
    private static final boolean[] digitoAsignado = new boolean[10];

    public static void main(String[] args) {
        for (int i = 0; i < 256; i++) {
            valores[i] = -1;
        }

        if (resolver(0)) {
            imprimirSolucion();
        }
    }

    private static boolean resolver(int indice) {
        if (indice == LETRAS.length) { 
            return esSumaValida();
        }

        char letraActual = LETRAS[indice];

        for (int digito = 0; digito <= 9; digito++) {
            if (!digitoAsignado[digito]) {

                valores[letraActual] = digito;
                digitoAsignado[digito] = true;

                if (resolver(indice + 1)) { 
                    return true;
                }

                valores[letraActual] = -1;
                digitoAsignado[digito] = false;
            }
        }

        return false;
    }

    private static int asignarNumero(char[] letras) {
        int numero = 0;
        for (int i = 0; i < letras.length; i++) {
            numero = numero * 10 + valores[letras[i]];
        }
        return numero;
    }

    private static boolean esSumaValida() {
        if (valores['S'] == 0 || valores['M'] == 0) {
            return false;
        }

        int send = asignarNumero(SEND);
        int more = asignarNumero(MORE);
        int money = asignarNumero(MONEY);

        return (send + more == money);
    }

    private static void imprimirSolucion() {
        int send = asignarNumero(SEND);
        int more = asignarNumero(MORE);
        int money = asignarNumero(MONEY);

        System.out.println("  " + send);
        System.out.println("+ " + more);
        System.out.println("-------");
        System.out.println(" " + money);

        System.out.println("\nAsignación de letras:");
        for (char letra : LETRAS) {
            System.out.println(letra + " = " + valores[letra]);
        }
    }
}
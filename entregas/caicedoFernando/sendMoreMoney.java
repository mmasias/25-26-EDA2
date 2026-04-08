
public class sendMoreMoney {

    private static final char[] LETRAS = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
    private final static int[] valores = new int[256];
    private final static boolean[] digitoAsignado = new boolean[10];

    public static void main(String[] args) {
        for (int i = 0; i < 256; i++) {
            valores[i] = -1;
        }

        if (resolver(0)) {
            imprimirSolucion();
        } else {
            System.out.println("No se encontró ninguna solución.");
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

    private static boolean esSumaValida() {
        if (valores['S'] == 0 || valores['M'] == 0) {
            return false;
        }

        int send = valores['S'] * 1000 + valores['E'] * 100 + valores['N'] * 10 + valores['D'];
        int more = valores['M'] * 1000 + valores['O'] * 100 + valores['R'] * 10 + valores['E'];
        int money = valores['M'] * 10000 + valores['O'] * 1000 + valores['N'] * 100 + valores['E'] * 10 + valores['Y'];

        return (send + more == money);
    }

    private static void imprimirSolucion() {
        int send = valores['S'] * 1000 + valores['E'] * 100 + valores['N'] * 10 + valores['D'];
        int more = valores['M'] * 1000 + valores['O'] * 100 + valores['R'] * 10 + valores['E'];
        int money = valores['M'] * 10000 + valores['O'] * 1000 + valores['N'] * 100 + valores['E'] * 10 + valores['Y'];

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

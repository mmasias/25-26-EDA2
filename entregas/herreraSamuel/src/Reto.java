public class Reto {

    private final char[] letras = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
    private final int[] valores = new int[256];
    private final boolean[] digitoUsado = new boolean[10];

    public void resolverPuzzle() {
        if (buscarSolucion(0)) {
            imprimirResultado();
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    private boolean buscarSolucion(int indice) {
        boolean exito = false;

        if (indice == letras.length) {
            exito = esSumaCorrecta();
        } else {
            char letraActual = letras[indice];

            for (int digito = 0; digito <= 9 && !exito; digito++) {
                if (!digitoUsado[digito] && esAsignacionValida(letraActual, digito)) {
                    
                    valores[letraActual] = digito;
                    digitoUsado[digito] = true;

                    exito = buscarSolucion(indice + 1);

                    if (!exito) {
                        digitoUsado[digito] = false;
                        valores[letraActual] = -1;
                    }
                }
            }
        }
        return exito;
    }

    private boolean esAsignacionValida(char letra, int digito) {
        boolean esPrimeraLetraValida = (letra == 'S' || letra == 'M') ? (digito != 0) : true;
        return esPrimeraLetraValida;
    }

    private boolean esSumaCorrecta() {
        int send = getValorPalabra("SEND");
        int more = getValorPalabra("MORE");
        int money = getValorPalabra("MONEY");
        return (send + more) == money;
    }

    private int getValorPalabra(String palabra) {
        int numero = 0;
        for (int i = 0; i < palabra.length(); i++) {
            numero = numero * 10 + valores[palabra.charAt(i)];
        }
        return numero;
    }

    private void imprimirResultado() {
        System.out.println("  " + getValorPalabra("SEND") + " (SEND)");
        System.out.println("+ " + getValorPalabra("MORE") + " (MORE)");
        System.out.println("-------");
        System.out.println(" " + getValorPalabra("MONEY") + " (MONEY)");
    }
}
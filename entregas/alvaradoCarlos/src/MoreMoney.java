public class MoreMoney {

    static char[] letras = "SENDMORY".toCharArray();

    static String noCero = "SM";

    static boolean esSumaCorrecta() {
        return (
            calcularValor("SEND") +
                calcularValor("MORE") ==
            calcularValor("MONEY")
        );
    }

    static int[] valores = new int[256];
    static boolean[] digitosUsados = new boolean[10];

    public static void main(String[] args) {
        System.out.println("Buscando solución...");
        resolver(0);
    }

    static void resolver(int indiceLetra) {
        if (indiceLetra == letras.length) {
            if (esSumaCorrecta()) {
                imprimirSolucion();
            }

            return;
        }

        char letraActual = letras[indiceLetra];

        for (int digito = 0; digito <= 9; digito++) {
            if (!digitosUsados[digito] && (digito != 0 || noCero.indexOf(letraActual) == -1)) {
                
                valores[letraActual] = digito;
                digitosUsados[digito] = true;

                resolver(indiceLetra + 1);

                digitosUsados[digito] = false;
            }
        }
    }

    static int calcularValor(String palabra) {
        int numero = 0;
        for (char c : palabra.toCharArray()) {
            numero = numero * 10 + valores[c];
        }
        return numero;
    }

    static void imprimirSolucion() {
        System.out.println("Solución encontrada: ");
        for (char letra : letras) {
            System.out.println(letra + " = " + valores[letra]);
        }
        System.out.println("-------------------");
    }
}

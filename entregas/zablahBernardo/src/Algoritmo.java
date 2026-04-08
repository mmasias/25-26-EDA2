package src;

public class Algoritmo {

    private static String[] sumandos;
    private static String resultado;
    private static char[] letras;
    private static int[] valores;
    private static boolean[] usados;

    public static void main(String[] args) {
        sumandos = new String[] { "SEND", "MORE" };
        resultado = "MONEY";
        preparar();
        resolver(0);

        System.out.println();

        sumandos = new String[] { "FORTY", "TEN", "TEN" };
        resultado = "SIXTY";
        preparar();
        resolver(0);

        System.out.println();

        sumandos = new String[] { "ODD", "ODD" };
        resultado = "EVEN";
        preparar();
        resolver(0);
    }

    public static void preparar() {
        String texto = "";
        
        for (String sumando : sumandos) {
            texto += sumando;
        }
        texto += resultado;

        String distintas = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (distintas.indexOf(letra) == -1) {
                distintas += letra;
            }
        }

        letras = distintas.toCharArray();
        valores = new int[letras.length];
        usados = new boolean[10];
    }

    public static boolean resolver(int posicion) {
        if (posicion == letras.length) {
            int suma = 0;

            for (String sumando : sumandos) {
                suma += formarNumero(sumando);
            }

            int valorResultado = formarNumero(resultado);

            if (suma == valorResultado) {
                for (String sumando : sumandos) {
                    System.out.println(formarNumero(sumando));
                }

                System.out.println("-----");
                System.out.println(valorResultado);
                System.out.println();

                for (int i = 0; i < letras.length; i++) {
                    System.out.println(letras[i] + " = " + valores[i]);
                }

                return true;
            }
            return false;
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (!usados[digito]) {
                char letraActual = letras[posicion];

                if (!esInicial(letraActual) || digito != 0) {
                    valores[posicion] = digito;
                    usados[digito] = true;

                    if (resolver(posicion + 1)) {
                        return true;
                    }

                    usados[digito] = false;
                }
            }
        }
        return false;
    }

    public static boolean esInicial(char letra) {
        for (String sumando : sumandos) {
            if (sumando.charAt(0) == letra) {
                return true;
            }
        }
        return resultado.charAt(0) == letra;
    }

    public static int formarNumero(String palabra) {
        int numero = 0;
        for (int i = 0; i < palabra.length(); i++) {
            numero = numero * 10 + valorDe(palabra.charAt(i));
        }
        return numero;
    }

    public static int valorDe(char letra) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == letra) {
                return valores[i];
            }
        }
        return -1;
    }
}
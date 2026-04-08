package src;
public class ExtensionCriptoAritmo {

    static String[] sumandos;
    static String resultado;
    static char[] letras;
    static int[] valores;
    static int[] digitos;

    public static void main(String[] args) {

        sumandos = new String[]{"SEND", "MORE"};
        resultado = "MONEY";
        preparar();
        resolverIterativo();

        System.out.println();

        sumandos = new String[]{"FORTY", "TEN", "TEN"};
        resultado = "SIXTY";
        preparar();
        resolverIterativo();

        System.out.println();

        sumandos = new String[]{"ODD", "ODD"};
        resultado = "EVEN";
        preparar();
        resolverIterativo();
    }

    public static void preparar() {
        String texto = "";

        for (int i = 0; i < sumandos.length; i++) {
            texto = texto + sumandos[i];
        }

        texto = texto + resultado;

        String distintas = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!contiene(distintas, c)) {
                distintas = distintas + c;
            }
        }

        letras = new char[distintas.length()];
        for (int i = 0; i < distintas.length(); i++) {
            letras[i] = distintas.charAt(i);
        }

        valores = new int[letras.length];

        digitos = new int[10];
        for (int i = 0; i < 10; i++) {
            digitos[i] = i;
        }
    }

    public static void resolverIterativo() {
        permutar(0);
    }

    public static void permutar(int indice) {

        if (indice == letras.length) {

            for (int i = 0; i < letras.length; i++) {
                valores[i] = digitos[i];
            }

            if (!validarIniciales()) {
                return;
            }

            int suma = 0;
            for (int i = 0; i < sumandos.length; i++) {
                suma = suma + formarNumero(sumandos[i]);
            }

            int res = formarNumero(resultado);

            if (suma == res) {

                for (int i = 0; i < sumandos.length; i++) {
                    System.out.println(formarNumero(sumandos[i]));
                }

                System.out.println("-----");
                System.out.println(res);
                System.out.println();

                for (int i = 0; i < letras.length; i++) {
                    System.out.println(letras[i] + " = " + valores[i]);
                }

                System.out.println();
            }

            return;
        }

        for (int i = indice; i < 10; i++) {

            intercambiar(indice, i);

            permutar(indice + 1);

            intercambiar(indice, i);
        }
    }

    public static void intercambiar(int i, int j) {
        int temp = digitos[i];
        digitos[i] = digitos[j];
        digitos[j] = temp;
    }

    public static boolean validarIniciales() {
        for (int i = 0; i < sumandos.length; i++) {
            char c = sumandos[i].charAt(0);
            if (valorDe(c) == 0) {
                return false;
            }
        }

        if (valorDe(resultado.charAt(0)) == 0) {
            return false;
        }

        return true;
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

    public static boolean contiene(String texto, char c) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}
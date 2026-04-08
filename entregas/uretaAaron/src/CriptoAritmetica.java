public class CriptoAritmetica {

    private static String[] sumandos;
    private static String resultado;
    private static char[] letras;
    private static int[] valores;
    private static boolean[] usados;

    public static void main(String[] args) {
        ejecutar("SEND", "MORE", "MONEY");
        ejecutar("FORTY", "TEN", "TEN", "SIXTY");
        ejecutar("ODD", "ODD", "EVEN");
    }

    private static void ejecutar(String... palabras) {
        resultado = palabras[palabras.length - 1];
        sumandos = new String[palabras.length - 1];
        for (int i = 0; i < sumandos.length; i++) {
            sumandos[i] = palabras[i];
        }
        preparar();
        if (resolver(0)) {
            System.out.println("Solución para " + resultado + " encontrada.");
        }
        System.out.println("---------------------------");
    }

    public static void preparar() {
        String texto = "";
        for (String s : sumandos) texto += s;
        texto += resultado;

        String distintas = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (!estaEn(distintas, letra)) distintas += letra;
        }

        letras = distintas.toCharArray();
        valores = new int[letras.length];
        usados = new boolean[10];
    }

    public static boolean resolver(int posicion) {
        if (posicion == letras.length) {
            int suma = 0;
            for (String s : sumandos) suma += formarNumero(s);
            int valorResultado = formarNumero(resultado);

            if (suma == valorResultado) {
                for (String s : sumandos) System.out.println(formarNumero(s));
                System.out.println("-----");
                System.out.println(valorResultado);
                for (int i = 0; i < letras.length; i++) {
                    System.out.println(letras[i] + " = " + valores[i]);
                }
                return true;
            }
            return false;
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (!usados[digito]) {
                if (digito == 0 && esInicial(letras[posicion])) continue;

                valores[posicion] = digito;
                usados[digito] = true;
                if (resolver(posicion + 1)) return true;
                usados[digito] = false;
            }
        }
        return false;
    }

    public static boolean esInicial(char letra) {
        for (String s : sumandos) if (s.charAt(0) == letra) return true;
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
            if (letras[i] == letra) return valores[i];
        }
        return -1;
    }

    public static boolean estaEn(String texto, char letra) {
        return texto.indexOf(letra) != -1;
    }
}
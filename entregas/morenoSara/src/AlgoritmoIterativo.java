public class AlgoritmoIterativo {

    public static void main(String[] args) {
        resolver(new char[]{'M', 'S', 'E', 'N', 'D', 'O', 'R', 'Y'},
                new String[]{"SEND", "MORE"}, "MONEY");
        resolver(new char[]{'S', 'F', 'T', 'O', 'R', 'Y', 'E', 'N', 'I', 'X'},
                new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");
        resolver(new char[]{'E', 'O', 'D', 'V', 'N'},
                new String[]{"ODD", "ODD"}, "EVEN");
    }

    private static void resolver(char[] letras, String[] sumandos, String resultado) {
        int[] asignacion = new int[256];
        boolean[] digitosUsados = new boolean[10];
        resolverIterativo(letras, sumandos, resultado, asignacion, digitosUsados);
    }

    private static void resolverIterativo(
            char[] letras, String[] sumandos, String resultado,
            int[] asignacion, boolean[] digitosUsados) {

        int n = letras.length;
        int[] digitoEnNivel = new int[n];
        digitoEnNivel[0] = 9;
        int nivel = 0;

        while (nivel >= 0) {
            int digito = digitoEnNivel[nivel];
            char letra = letras[nivel];

            if (digito < 0) {
                digitoEnNivel[nivel] = 9;
                nivel--;
                if (nivel >= 0) {
                    digitosUsados[asignacion[letras[nivel]]] = false;
                    digitoEnNivel[nivel]--;
                }
            } else if (digitosUsados[digito] || (digito == 0 && esPrimeraLetra(letra, sumandos, resultado))) {
                digitoEnNivel[nivel]--;
            } else {
                asignacion[letra] = digito;
                digitosUsados[digito] = true;

                if (nivel == n - 1) {
                    if (ecuacionValida(sumandos, resultado, asignacion))
                        imprimirResultado(sumandos, resultado, asignacion);
                    digitosUsados[digito] = false;
                    digitoEnNivel[nivel]--;
                } else {
                    nivel++;
                    digitoEnNivel[nivel] = 9;
                }
            }
        }
    }

    private static boolean ecuacionValida(String[] sumandos, String resultado, int[] asignacion) {
        int suma = 0;
        for (String s : sumandos)
            suma += palabraANumero(s, asignacion);
        return suma == palabraANumero(resultado, asignacion);
    }

    private static int palabraANumero(String palabra, int[] asignacion) {
        int numero = 0;
        for (char letra : palabra.toCharArray())
            numero = numero * 10 + asignacion[letra];
        return numero;
    }

    private static boolean esPrimeraLetra(char letra, String[] sumandos, String resultado) {
        for (String s : sumandos)
            if (s.charAt(0) == letra) return true;
        return resultado.charAt(0) == letra;
    }

    private static void imprimirResultado(String[] sumandos, String resultado, int[] asignacion) {
        int ancho = resultado.length();
        for (String palabra : sumandos) {
            System.out.print(" ".repeat((ancho - palabra.length()) * 2));
            for (char letra : palabra.toCharArray())
                System.out.print(asignacion[letra] + " ");
            System.out.println();
        }
        System.out.println("-".repeat(ancho * 2));
        for (char letra : resultado.toCharArray())
            System.out.print(asignacion[letra] + " ");
        System.out.println("\n");
    }
}

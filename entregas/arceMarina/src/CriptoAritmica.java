public class CriptoAritmica {

    private static String[] sumandos;
    private static String resultado;
    private static char[] letras;
    private static int[] valores;
    private static boolean[] usados;

    public static void main(String[] args) {
        ejecutarAcertijo(new String[]{"SEND", "MORE"}, "MONEY");

        ejecutarAcertijo(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");

        ejecutarAcertijo(new String[]{"ODD", "ODD"}, "EVEN");
    }

    private static void ejecutarAcertijo(String[] s, String r) {
        sumandos = s;
        resultado = r;
        System.out.println("--- Acertijo: " + concatenarSumandos() + " = " + resultado + " ---");
        preparar();
        if (!resolver(0)) {
            System.out.println("Sin solución.");
        }
        System.out.println();
    }

    public static void preparar() {
        String todo = "";
        for (String s : sumandos) todo += s;
        todo += resultado;

        String distintas = "";
        for (int i = 0; i < todo.length(); i++) {
            char c = todo.charAt(i);
            if (distintas.indexOf(c) == -1) {
                distintas += c;
            }
        }

        letras = distintas.toCharArray();
        valores = new int[letras.length];
        usados = new boolean[10];
    }

    public static boolean resolver(int posicion) {
        if (posicion == letras.length) {
            return esValido();
        }

        char letraActual = letras[posicion];

        for (int d = 0; d <= 9; d++) {
            if (!usados[d]) {
                if (d == 0 && esLetraInicial(letraActual)) {
                    continue; 
                }

                valores[posicion] = d;
                usados[d] = true;

                if (resolver(posicion + 1)) {
                    return true;
                }

                usados[d] = false;
            }
        }
        return false;
    }

    private static boolean esValido() {
        int sumaActual = 0;
        for (String s : sumandos) {
            sumaActual += palabraAInt(s);
        }
        int totalEsperado = palabraAInt(resultado);

        if (sumaActual == totalEsperado) {
            imprimir(totalEsperado);
            return true;
        }
        return false;
    }

    private static int palabraAInt(String p) {
        int num = 0;
        for (int i = 0; i < p.length(); i++) {
            num = num * 10 + buscarValor(p.charAt(i));
        }
        return num;
    }

    private static int buscarValor(char c) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == c) return valores[i];
        }
        return 0;
    }

    private static boolean esLetraInicial(char c) {
        for (String s : sumandos) {
            if (s.length() > 1 && s.charAt(0) == c) return true;
        }
        return resultado.length() > 1 && resultado.charAt(0) == c;
    }

    private static String concatenarSumandos() {
        String res = "";
        for (int i = 0; i < sumandos.length; i++) {
            res += sumandos[i] + (i < sumandos.length - 1 ? " + " : "");
        }
        return res;
    }

    private static void imprimir(int total) {
        for (String s : sumandos) {
            System.out.println(palabraAInt(s));
        }
        System.out.println("-----");
        System.out.println(total + "\n");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + "=" + valores[i] + "  ");
        }
        System.out.println();
    }
}
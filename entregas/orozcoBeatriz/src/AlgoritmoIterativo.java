import java.util.*;

public class AlgoritmoIterativo {

    private static int[] digito = new int[26];
    private static boolean[] usado = new boolean[10];

    public static void main(String[] args) {
        resolver(new String[]{"SEND", "MORE"}, "MONEY");
    }

    private static void resolver(String[] sumandos, String resultado) {
        String letras = "";
        for (String palabra : sumandos) {
            for (char c : palabra.toCharArray()) {
                if (!letras.contains(String.valueOf(c))) {
                    letras += c;
                }
            }
        }
        for (char c : resultado.toCharArray()) {
            if (!letras.contains(String.valueOf(c))) {
                letras += c;
            }
        }

        int n = letras.length();
        int[] asignacion = new int[n];
        Arrays.fill(asignacion, -1);
        int pos = 0;

        while (pos >= 0) {
            char letra = letras.charAt(pos);

            int inicio = asignacion[pos] + 1;

            if (asignacion[pos] != -1) {
                usado[asignacion[pos]] = false;
                digito[letra - 'A'] = 0;
                asignacion[pos] = -1;
            }

            boolean encontrado = false;
            int d = inicio;
            while (d <= 9 && !encontrado) {
                if (!(d == 0 && esInicial(letra, sumandos, resultado)) && !usado[d]) {
                    digito[letra - 'A'] = d;
                    usado[d] = true;
                    asignacion[pos] = d;
                    encontrado = true;
                }
                if (!encontrado) {
                    d++;
                }
            }

            if (encontrado) {
                if (pos == n - 1) {
                    if (verificar(sumandos, resultado)) {
                        imprimir(letras, sumandos, resultado);
                    }
                } else {
                    pos++;
                }
            } else {
                pos--;
            }
        }
    }

    private static boolean esInicial(char c, String[] sumandos, String resultado) {
        for (String palabra : sumandos) {
            if (palabra.charAt(0) == c) {
                return true;
            }
        }
        return resultado.charAt(0) == c;
    }

    private static long valor(String palabra) {
        long v = 0;
        for (char c : palabra.toCharArray()) {
            v = v * 10 + digito[c - 'A'];
        }
        return v;
    }

    private static boolean verificar(String[] sumandos, String resultado) {
        long suma = 0;
        for (String palabra : sumandos) {
            suma += valor(palabra);
        }
        return suma == valor(resultado);
    }

    private static void imprimir(String letras, String[] sumandos, String resultado) {
        System.out.print("Solución: ");
        for (char c : letras.toCharArray()) {
            System.out.print(c + "=" + digito[c - 'A'] + " ");
        }
        System.out.println();
        for (String palabra : sumandos) {
            System.out.println("  " + palabra + " = " + valor(palabra));
        }
        System.out.println("  " + resultado + " = " + valor(resultado));
        System.out.println();
    }
}

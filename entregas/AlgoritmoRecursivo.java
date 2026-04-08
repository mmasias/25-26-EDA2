import java.util.*;

public class AlgoritmoRecursivo {
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

        asignar(letras, 0, sumandos, resultado);
    }

    private static void asignar(String letras, int pos, String[] sumandos, String resultado) {

        if (pos == letras.length()) {
            if (verificar(sumandos, resultado)) {
                imprimir(letras, sumandos, resultado);
            }
            return;
        }

        char letra = letras.charAt(pos);

        for (int d = 0; d <= 9; d++) {
            if (usado[d]) continue;
            if (d == 0 && esInicial(letra, sumandos, resultado)) continue;

            digito[letra - 'A'] = d;
            usado[d] = true;

            asignar(letras, pos + 1, sumandos, resultado);

            digito[letra - 'A'] = 0;
            usado[d] = false;
        }
    }

    private static boolean esInicial(char c, String[] sumandos, String resultado) {
        for (String palabra : sumandos) {
            if (palabra.charAt(0) == c) return true;
        }
        return resultado.charAt(0) == c;
    }

    private static long valor(String palabra) {
        long v = 0;
        long multiplicador = 1;
        for (int i = palabra.length() - 1; i >= 0; i--) {
            char c = palabra.charAt(i);
            v += digito[c - 'A'] * multiplicador;
            multiplicador *= 10;
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
        int maxLen = resultado.length();

        System.out.print("Solución: ");
        for (char c : letras.toCharArray()) {
            System.out.print(c + "=" + digito[c - 'A'] + " ");
        }
        System.out.println();

        for (String palabra : sumandos) {
            String numFormateado = String.format("%0" + maxLen + "d", valor(palabra));
            System.out.println("  " + palabra + " = " + numFormateado);
        }

        System.out.println("  " + "-".repeat(maxLen + 6));

        String resFormateado = String.format("%0" + maxLen + "d", valor(resultado));
        System.ou

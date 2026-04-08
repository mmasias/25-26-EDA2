package recursivo;

import java.util.Arrays;

public class SolverCriptaritmo {

    private final Criptaritmo problema;

    private final int[] asignacion = new int[26];
    private final boolean[] usado = new boolean[10];
    private final boolean[] noCero = new boolean[26];

    private final int maxLen;
    private final int filas;

    public SolverCriptaritmo(Criptaritmo problema) {
        this.problema = problema;

        Arrays.fill(asignacion, -1);

        this.filas = problema.getSumandos().length;
        this.maxLen = calcularMaxLen();

        marcarNoCero();
        validar();
    }

    public ResultadoCriptaritmo resolver() {
        boolean ok = backtrack(0, 0, 0);
        return new ResultadoCriptaritmo(asignacion.clone(), ok);
    }

    private boolean backtrack(int col, int fila, int suma) {

        if (col == maxLen) {
            return suma == 0;
        }

        if (fila < filas) {
            char c = getChar(problema.getSumandos()[fila], col);

            if (c == 0) {
                return backtrack(col, fila + 1, suma);
            }

            int idx = c - 'A';

            if (asignacion[idx] != -1) {
                return backtrack(col, fila + 1, suma + asignacion[idx]);
            }

            for (int d = 0; d <= 9; d++) {

                if (usado[d]) {
                    continue;
                }
                if (d == 0 && noCero[idx]) {
                    continue;
                }
                
                asignacion[idx] = d;
                usado[d] = true;

                if (backtrack(col, fila + 1, suma + d)) {
                    return true;
                }

                asignacion[idx] = -1;
                usado[d] = false;
            }

            return false;
        }

        char r = getChar(problema.getResultado(), col);
        int idx = r - 'A';

        int esperado = suma % 10;
        int acarreo = suma / 10;

        if (asignacion[idx] != -1) {
            if (asignacion[idx] != esperado) {
                return false;
            }
            return backtrack(col + 1, 0, acarreo);
        }

        if (usado[esperado]) {
            return false;
        }
        if (esperado == 0 && noCero[idx]) {
            return false;
        }

        asignacion[idx] = esperado;
        usado[esperado] = true;

        if (backtrack(col + 1, 0, acarreo)) {
            return true;
        }

        asignacion[idx] = -1;
        usado[esperado] = false;

        return false;
    }

    private void marcarNoCero() {
        for (String s : problema.getSumandos()) {
            if (s.length() > 1) {
                noCero[s.charAt(0) - 'A'] = true;
            }
        }

        String r = problema.getResultado();
        if (r.length() > 1) {
            noCero[r.charAt(0) - 'A'] = true;
        }
    }

    private void validar() {
        boolean[] v = new boolean[26];
        int count = 0;

        for (String s : problema.getSumandos()) {
            for (char c : s.toCharArray()) {
                if (!v[c - 'A']) {
                    v[c - 'A'] = true;
                    count++;
                }
            }
        }

        for (char c : problema.getResultado().toCharArray()) {
            if (!v[c - 'A']) {
                v[c - 'A'] = true;
                count++;
            }
        }

        if (count > 10) {
            throw new IllegalArgumentException("Demasiadas letras");
        }
    }

    private int calcularMaxLen() {
        int max = problema.getResultado().length();

        for (String s : problema.getSumandos()) {
            if (s.length() > max) {
                max = s.length();
            }
        }

        return max;
    }

    private char getChar(String s, int col) {
        int pos = s.length() - 1 - col;
        return (pos >= 0) ? s.charAt(pos) : 0;
    }
}

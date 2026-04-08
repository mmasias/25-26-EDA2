package iterativo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolverCriptaritmoIterativo {

    private final Criptaritmo problema;

    private final int[] asignacion = new int[26];
    private final boolean[] usado = new boolean[10];
    private final boolean[] noCero = new boolean[26];

    private final int maxLen;
    private final int filas;

    public SolverCriptaritmoIterativo(Criptaritmo problema) {
        this.problema = problema;

        Arrays.fill(asignacion, -1);

        this.filas = problema.getSumandos().length;
        this.maxLen = calcularMaxLen();

        marcarNoCero();
        validar();
    }

    public ResultadoCriptaritmo resolver() {
        Deque<Comando> pila = new ArrayDeque<>();
        pila.push(Comando.explorar(0, 0, 0));

        while (!pila.isEmpty()) {
            Comando comando = pila.pop();

            switch (comando.tipo) {
                case ASIGNAR -> asignar(comando.indiceLetra, comando.digito);
                case DESASIGNAR -> desasignar(comando.indiceLetra, comando.digito);
                case EXPLORAR -> {
                    if (explorar(comando, pila)) {
                        return new ResultadoCriptaritmo(asignacion.clone(), true);
                    }
                }
            }
        }

        return new ResultadoCriptaritmo(asignacion.clone(), false);
    }

    private boolean explorar(Comando comando, Deque<Comando> pila) {
        int columna = comando.columna;
        int fila = comando.fila;
        int sumaParcial = comando.sumaParcial;

        // Caso base
        if (columna == maxLen) {
            return sumaParcial == 0;
        }

        // Procesar sumandos
        if (fila < filas) {
            char letra = getChar(problema.getSumandos()[fila], columna);

            if (letra == 0) {
                pila.push(Comando.explorar(columna, fila + 1, sumaParcial));
                return false;
            }

            int idx = indice(letra);

            if (asignacion[idx] != -1) {
                pila.push(Comando.explorar(columna, fila + 1, sumaParcial + asignacion[idx]));
                return false;
            }

            // Probamos dígitos. Se apilan en orden inverso para mantener el orden natural.
            for (int d = 9; d >= 0; d--) {
                if (usado[d]) continue;
                if (d == 0 && noCero[idx]) continue;

                pila.push(Comando.desasignar(idx, d));
                pila.push(Comando.explorar(columna, fila + 1, sumaParcial + d));
                pila.push(Comando.asignar(idx, d));
            }

            return false;
        }

        // Procesar resultado de la columna
        char letraResultado = getChar(problema.getResultado(), columna);
        int idxResultado = indice(letraResultado);

        int digitoEsperado = sumaParcial % 10;
        int nuevoAcarreo = sumaParcial / 10;

        if (asignacion[idxResultado] != -1) {
            if (asignacion[idxResultado] == digitoEsperado) {
                pila.push(Comando.explorar(columna + 1, 0, nuevoAcarreo));
            }
            return false;
        }

        if (usado[digitoEsperado]) return false;
        if (digitoEsperado == 0 && noCero[idxResultado]) return false;

        pila.push(Comando.desasignar(idxResultado, digitoEsperado));
        pila.push(Comando.explorar(columna + 1, 0, nuevoAcarreo));
        pila.push(Comando.asignar(idxResultado, digitoEsperado));

        return false;
    }

    private void asignar(int indiceLetra, int digito) {
        asignacion[indiceLetra] = digito;
        usado[digito] = true;
    }

    private void desasignar(int indiceLetra, int digito) {
        asignacion[indiceLetra] = -1;
        usado[digito] = false;
    }

    private void marcarNoCero() {
        for (String s : problema.getSumandos()) {
            if (s.length() > 1) {
                noCero[indice(s.charAt(0))] = true;
            }
        }

        String resultado = problema.getResultado();
        if (resultado.length() > 1) {
            noCero[indice(resultado.charAt(0))] = true;
        }
    }

    private void validar() {
        boolean[] vistas = new boolean[26];
        int total = 0;

        for (String s : problema.getSumandos()) {
            for (char c : s.toCharArray()) {
                int idx = indice(c);
                if (!vistas[idx]) {
                    vistas[idx] = true;
                    total++;
                }
            }
        }

        for (char c : problema.getResultado().toCharArray()) {
            int idx = indice(c);
            if (!vistas[idx]) {
                vistas[idx] = true;
                total++;
            }
        }

        if (total > 10) {
            throw new IllegalArgumentException("El criptaritmo tiene más de 10 letras distintas.");
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

    private char getChar(String palabra, int columna) {
        int pos = palabra.length() - 1 - columna;
        return (pos >= 0) ? palabra.charAt(pos) : 0;
    }

    private int indice(char c) {
        return c - 'A';
    }

    private enum TipoComando {
        EXPLORAR,
        ASIGNAR,
        DESASIGNAR
    }

    private static class Comando {
        private final TipoComando tipo;
        private final int columna;
        private final int fila;
        private final int sumaParcial;
        private final int indiceLetra;
        private final int digito;

        private Comando(TipoComando tipo, int columna, int fila, int sumaParcial, int indiceLetra, int digito) {
            this.tipo = tipo;
            this.columna = columna;
            this.fila = fila;
            this.sumaParcial = sumaParcial;
            this.indiceLetra = indiceLetra;
            this.digito = digito;
        }

        public static Comando explorar(int columna, int fila, int sumaParcial) {
            return new Comando(TipoComando.EXPLORAR, columna, fila, sumaParcial, -1, -1);
        }

        public static Comando asignar(int indiceLetra, int digito) {
            return new Comando(TipoComando.ASIGNAR, -1, -1, -1, indiceLetra, digito);
        }

        public static Comando desasignar(int indiceLetra, int digito) {
            return new Comando(TipoComando.DESASIGNAR, -1, -1, -1, indiceLetra, digito);
        }
    }
}
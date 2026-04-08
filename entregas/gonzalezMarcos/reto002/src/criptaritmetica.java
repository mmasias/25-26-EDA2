public class criptaritmetica {

    private final char[]    letras;
    private final int[]     asignacion;
    private final boolean[] digitoUsado;
    private final boolean[] esInicial;

    private final String[] sumandos;
    private final String   resultado;

    public Criptaritmetica(String[] sumandos, String resultado) {
        this.sumandos  = sumandos;
        this.resultado = resultado;

        letras      = extraerLetras(sumandos, resultado);
        asignacion  = new int[letras.length];
        digitoUsado = new boolean[10];
        esInicial   = new boolean[letras.length];

        for (int i = 0; i < letras.length; i++) {
            asignacion[i] = -1;
        }

        for (String palabra : sumandos) {
            marcarInicial(palabra.charAt(0));
        }
        marcarInicial(resultado.charAt(0));
    }

    public boolean unaSolucion() {
        return resolver(0);
    }

    private boolean resolver(int nivel) {
        if (nivel == letras.length) {
            return esSolucionCorrecta();
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (puedeAsignar(nivel, digito)) {
                asignacion[nivel]   = digito;   
                digitoUsado[digito] = true;

                if (resolver(nivel + 1)) {
                    return true;
                }

                asignacion[nivel]   = -1;       
                digitoUsado[digito] = false;
            }
        }
        return false;
    }

    private boolean puedeAsignar(int posicion, int digito) {
        if (digitoUsado[digito])              return false;
        if (esInicial[posicion] && digito == 0) return false;
        return true;
    }

    private boolean esSolucionCorrecta() {
        long suma = 0;
        for (String palabra : sumandos) {
            suma += valorDe(palabra);
        }
        return suma == valorDe(resultado);
    }

    private long valorDe(String palabra) {
        long valor = 0;
        for (char c : palabra.toCharArray()) {
            valor = valor * 10 + asignacion[indiceDe(c)];
        }
        return valor;
    }

    public void mostrar() {
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + "=" + asignacion[i] + "  ");
        }
        System.out.println();

        StringBuilder sb = new StringBuilder("  ");
        for (int s = 0; s < sumandos.length; s++) {
            if (s > 0) sb.append(" + ");
            sb.append(sumandos[s]).append("(").append(valorDe(sumandos[s])).append(")");
        }
        sb.append(" = ").append(resultado).append("(").append(valorDe(resultado)).append(")");
        System.out.println(sb);
    }

    private int indiceDe(char c) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == c) return i;
        }
        throw new IllegalArgumentException("Letra desconocida: " + c);
    }

    private void marcarInicial(char c) {
        esInicial[indiceDe(c)] = true;
    }

    private static char[] extraerLetras(String[] sumandos, String resultado) {
        boolean[] vistas = new boolean[256];
        for (String palabra : sumandos) {
            for (char c : palabra.toCharArray()) vistas[c] = true;
        }
        for (char c : resultado.toCharArray()) vistas[c] = true;

        int cuenta = 0;
        for (boolean v : vistas) if (v) cuenta++;

        char[] letras = new char[cuenta];
        int idx = 0;
        for (int c = 0; c < 256; c++) {
            if (vistas[c]) letras[idx++] = (char) c;
        }
        return letras;
    }

    public static void main(String[] args) {
        resolver("SEND + MORE = MONEY",
                new String[]{"SEND", "MORE"}, "MONEY");

        resolver("FORTY + TEN + TEN = SIXTY",
                new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");

        resolver("ODD + ODD = EVEN",
                new String[]{"ODD", "ODD"}, "EVEN");
    }

    private static void resolver(String titulo, String[] sumandos, String resultado) {
        System.out.println("=".repeat(50));
        System.out.println("Puzzle: " + titulo);
        System.out.println("=".repeat(50));

        Criptaritmetica puzzle = new Criptaritmetica(sumandos, resultado);
        if (puzzle.unaSolucion()) {
            puzzle.mostrar();
        } else {
            System.out.println("Sin solución.");
        }
        System.out.println();
    }
}

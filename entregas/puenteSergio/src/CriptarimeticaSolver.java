public class CriptarimeticaSolver {

    private char[] letras;
    private int totalLetras;
    private int[] asignacion;
    private boolean[] digitoUsado;
    private String[] operandos;
    private String resultado;
    private char[] letrasIniciales;

    public CriptarimeticaSolver(String[] operandos, String resultado) {
        this.operandos = operandos;
        this.resultado = resultado;
        this.letras = extraerLetrasUnicas();
        this.totalLetras = letras.length;
        this.asignacion = new int[totalLetras];
        this.digitoUsado = new boolean[10];
        this.letrasIniciales = extraerLetrasIniciales();
        inicializarAsignacion();
    }

    private char[] extraerLetrasUnicas() {
        String todas = resultado;
        for (String operando : operandos) {
            todas += operando;
        }
        String unicas = "";
        for (int i = 0; i < todas.length(); i++) {
            if (unicas.indexOf(todas.charAt(i)) == -1) {
                unicas += todas.charAt(i);
            }
        }
        return unicas.toCharArray();
    }

    private char[] extraerLetrasIniciales() {
        String iniciales = "" + resultado.charAt(0);
        for (String operando : operandos) {
            if (iniciales.indexOf(operando.charAt(0)) == -1) {
                iniciales += operando.charAt(0);
            }
        }
        return iniciales.toCharArray();
    }

    private void inicializarAsignacion() {
        for (int i = 0; i < totalLetras; i++) {
            asignacion[i] = -1;
        }
    }

    public void resolver() {
        if (!asignarLetra(0)) {
            System.out.println("No se encontro solucion.");
        }
    }

    private boolean asignarLetra(int indice) {
        if (indice == totalLetras) {
            return verificarSuma();
        }
        for (int digito = 0; digito <= 9; digito++) {
            if (esAsignacionValida(indice, digito)) {
                asignacion[indice] = digito;
                digitoUsado[digito] = true;
                if (asignarLetra(indice + 1)) {
                    return true;
                }
                asignacion[indice] = -1;
                digitoUsado[digito] = false;
            }
        }
        return false;
    }

    private boolean esAsignacionValida(int indice, int digito) {
        if (digitoUsado[digito]) {
            return false;
        }
        if (digito == 0 && esLetraInicial(letras[indice])) {
            return false;
        }
        return true;
    }

    private boolean esLetraInicial(char letra) {
        for (char inicial : letrasIniciales) {
            if (inicial == letra) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarSuma() {
        long sumaOperandos = 0;
        for (String operando : operandos) {
            sumaOperandos += construirNumero(operando);
        }
        long valorResultado = construirNumero(resultado);
        if (sumaOperandos == valorResultado) {
            imprimirSolucion(sumaOperandos, valorResultado);
            return true;
        }
        return false;
    }

    private long construirNumero(String palabra) {
        long numero = 0;
        for (int i = 0; i < palabra.length(); i++) {
            numero = numero * 10 + valor(palabra.charAt(i));
        }
        return numero;
    }

    private int valor(char letra) {
        return asignacion[obtenerIndice(letra)];
    }

    private int obtenerIndice(char letra) {
        for (int i = 0; i < totalLetras; i++) {
            if (letras[i] == letra) {
                return i;
            }
        }
        return -1;
    }

    private void imprimirSolucion(long sumaOperandos, long valorResultado) {
        System.out.println("Solucion encontrada:");
        System.out.println();
        for (int i = 0; i < totalLetras; i++) {
            System.out.println("  " + letras[i] + " = " + asignacion[i]);
        }
        System.out.println();
        for (int i = 0; i < operandos.length; i++) {
            String prefijo = (i == 0) ? "  " : "+ ";
            System.out.println(prefijo + construirNumero(operandos[i]));
        }
        System.out.println("-----------");
        System.out.println("  " + valorResultado);
    }

    public static void main(String[] args) {
        System.out.println("=== SEND + MORE = MONEY ===");
        new CriptarimeticaSolver(
            new String[]{"SEND", "MORE"}, "MONEY"
        ).resolver();

        System.out.println();
        System.out.println("=== FORTY + TEN + TEN = SIXTY ===");
        new CriptarimeticaSolver(
            new String[]{"FORTY", "TEN", "TEN"}, "SIXTY"
        ).resolver();

        System.out.println();
        System.out.println("=== ODD + ODD = EVEN ===");
        new CriptarimeticaSolver(
            new String[]{"ODD", "ODD"}, "EVEN"
        ).resolver();
    }
}
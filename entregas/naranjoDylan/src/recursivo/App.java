package recursivo;

public class App {

    public static void main(String[] args) {
        ejecutar(new String[]{"SEND", "MORE"}, "MONEY");
        ejecutar(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");
        ejecutar(new String[]{"ODD", "ODD"}, "EVEN");
    }

    private static void ejecutar(String[] sumandos, String resultado) {
        System.out.println("=================================");
        for (int i = 0; i < sumandos.length; i++) {
            if (i == 0) {
                System.out.println("  " + sumandos[i]);
            } else {
                System.out.println("+ " + sumandos[i]);
            }
        }
        System.out.println("--------");
        System.out.println("  " + resultado);

        Criptaritmo c = new Criptaritmo(sumandos, resultado);
        SolverCriptaritmo solver = new SolverCriptaritmo(c);
        ResultadoCriptaritmo res = solver.resolver();

        if (!res.tieneSolucion()) {
            System.out.println("\nNo hay solución");
            return;
        }

        System.out.println("\nAsignación:");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int v = res.getValor(ch);
            if (v != -1) {
                System.out.println(ch + " = " + v);
            }
        }

        System.out.println("\nComprobación:");
        int sumaTotal = 0;

        for (String s : sumandos) {
            int valor = convertir(s, res);
            sumaTotal += valor;
            System.out.println(s + " = " + valor);
        }

        int valorResultado = convertir(resultado, res);
        System.out.println("-----------------");
        System.out.println(resultado + " = " + valorResultado);
        System.out.println("Suma total = " + sumaTotal);

        if (sumaTotal == valorResultado) {
            System.out.println("La solución es correcta.");
        } else {
            System.out.println("La solución NO es correcta.");
        }
    }

    private static int convertir(String palabra, ResultadoCriptaritmo res) {
        int numero = 0;

        for (int i = 0; i < palabra.length(); i++) {
            numero = numero * 10 + res.getValor(palabra.charAt(i));
        }

        return numero;
    }
}

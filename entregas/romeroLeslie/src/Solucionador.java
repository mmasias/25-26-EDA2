public class Solucionador {

    static char[] letras;
    static int[] valoresDeLetras = new int[256];
    static boolean[] ocupado = new boolean[10];

    public static void main(String[] args) {
        System.out.println("--- RETO 1: SEND + MORE = MONEY ---");
        ejecutar(new String[]{"SEND", "MORE"}, "MONEY");
        
        System.out.println("\n--- RETO 2: ODD + ODD = EVEN ---");
        ejecutar(new String[]{"ODD", "ODD"}, "EVEN");
        
        System.out.println("\n--- RETO 3: FORTY + TEN + TEN = SIXTY ---");
        ejecutar(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");
    }

    static void ejecutar(String[] sumandos, String resultado) {
        String temp = "";
        String todas = resultado;
        for (String s : sumandos) todas += s;

        for (int i = 0; i < todas.length(); i++) {
            char c = todas.charAt(i);
            if (temp.indexOf(c) == -1) temp += c;
        }

        letras = temp.toCharArray();
        for (int i = 0; i < 10; i++) ocupado[i] = false;

        if (buscar(0, sumandos, resultado)) {
            System.out.println("SOLUCIÓN ENCONTRADA:");
            imprimir(sumandos, resultado);
        } else {
            System.out.println("No hay solución posible.");
        }
    }

    static boolean buscar(int i, String[] sumandos, String resultado) {
        if (i == letras.length) {
            return validar(sumandos, resultado);
        }

        for (int d = 0; d <= 9; d++) {
            if (!ocupado[d]) {
                if (d == 0 && esCabeza(letras[i], sumandos, resultado)) continue;

                valoresDeLetras[letras[i]] = d;
                ocupado[d] = true;

                if (buscar(i + 1, sumandos, resultado)) return true;

                ocupado[d] = false;
            }
        }
        return false;
    }

    static boolean esCabeza(char c, String[] sumandos, String resultado) {
        if (c == resultado.charAt(0)) return true;
        for (String s : sumandos) {
            if (c == s.charAt(0)) return true;
        }
        return false;
    }

    static boolean validar(String[] sumandos, String resultado) {
        long sumaTotal = 0;
        for (String s : sumandos) {
            sumaTotal += transformar(s);
        }
        return sumaTotal == transformar(resultado);
    }

    static long transformar(String s) {
        long n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 10 + valoresDeLetras[s.charAt(i)];
        }
        return n;
    }

    static void imprimir(String[] sumandos, String resultado) {
        for (char c : letras) {
            System.out.print(c + "=" + valoresDeLetras[c] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < sumandos.length; i++) {
            System.out.print(transformar(sumandos[i]) + (i < sumandos.length - 1 ? " + " : ""));
        }
        System.out.println(" = " + transformar(resultado));
    }
}
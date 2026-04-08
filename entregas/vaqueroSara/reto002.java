import java.util.*;

public class reto002 {

    static List<Character> letras;
    static Map<Character, Integer> asignacion = new HashMap<>();
    static boolean[] usado = new boolean[10];

    static String[] palabras;
    static String resultado;

    public static void main(String[] args) {
        resolver(new String[]{"SEND", "MORE"}, "MONEY");
        System.out.println("------");
        resolver(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");
        System.out.println("------");
        resolver(new String[]{"ODD", "ODD"}, "EVEN");
    }

    static void resolver(String[] ops, String res) {
        palabras = ops;
        resultado = res;

        Set<Character> set = new LinkedHashSet<>();

        for (String p : palabras)
            for (char c : p.toCharArray())
                set.add(c);

        for (char c : resultado.toCharArray())
            set.add(c);

        letras = new ArrayList<>(set);

        if (letras.size() > 10) {
            System.out.println("Demasiadas letras");
            return;
        }

        backtrack(0);
    }

    static void backtrack(int idx) {
        if (idx == letras.size()) {
            if (valido()) {
                imprimir();
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (!usado[d]) {
                asignacion.put(letras.get(idx), d);
                usado[d] = true;

                if (esParcialValido()) {
                    backtrack(idx + 1);
                }

                usado[d] = false;
                asignacion.remove(letras.get(idx));
            }
        }
    }

    static boolean esParcialValido() {
        // Evitar ceros iniciales
        for (String p : palabras) {
            if (asignacion.containsKey(p.charAt(0)) &&
                asignacion.get(p.charAt(0)) == 0)
                return false;
        }

        if (asignacion.containsKey(resultado.charAt(0)) &&
            asignacion.get(resultado.charAt(0)) == 0)
            return false;

        return true;
    }

    static boolean valido() {
        long suma = 0;

        for (String p : palabras) {
            suma += valor(p);
        }

        return suma == valor(resultado);
    }

    static long valor(String palabra) {
        long num = 0;
        for (char c : palabra.toCharArray()) {
            num = num * 10 + asignacion.get(c);
        }
        return num;
    }

    static void imprimir() {
        System.out.println("Solución:");
        for (Map.Entry<Character, Integer> e : asignacion.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        for (String p : palabras) {
            System.out.println(p + " = " + valor(p));
        }
        System.out.println("Resultado = " + valor(resultado));
        System.out.println();
    }
}
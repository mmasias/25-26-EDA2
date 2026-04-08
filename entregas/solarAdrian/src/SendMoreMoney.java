import java.util;

public class SendMoreMoney {
    private static final String[] SUMANDOS = {"SEND", "MORE"};
    private static final String RESULTADO = "MONEY";

    public static void main(String[] args) {
        List<Character> letras = Arrays.asList('S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y');
        Set<Character> iniciales = new HashSet<>(Arrays.asList('S', 'M'));
        
        Map<Character, Integer> mapeo = new HashMap<>();
        if (backtrack(letras, 0, mapeo, new HashSet<>(), iniciales)) {
            imprimirSolucion(mapeo);
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    private static boolean backtrack(List<Character> letras, int index, Map<Character, Integer> mapeo, Set<Integer> usados, Set<Character> iniciales) {
        if (index == letras.size()) return esValido(mapeo);

        char letra = letras.get(index);
        for (int digito = 0; digito <= 9; digito++) {
            if (usados.contains(digito)) continue;
            if (digito == 0 && iniciales.contains(letra)) continue;

            mapeo.put(letra, digito);
            usados.add(digito);

            if (backtrack(letras, index + 1, mapeo, usados, iniciales)) return true;

            mapeo.remove(letra);
            usados.remove(digito);
        }
        return false;
    }

    private static boolean esValido(Map<Character, Integer> mapeo) {
        long s1 = aNumero(SUMANDOS[0], mapeo);
        long s2 = aNumero(SUMANDOS[1], mapeo);
        long res = aNumero(RESULTADO, mapeo);
        return (s1 + s2) == res;
    }

    private static long aNumero(String palabra, Map<Character, Integer> mapeo) {
        long num = 0;
        for (char c : palabra.toCharArray()) num = num * 10 + mapeo.get(c);
        return num;
    }

    private static void imprimirSolucion(Map<Character, Integer> mapeo) {
        System.out.println("Solución para SEND + MORE = MONEY:");
        System.out.println(aNumero(SUMANDOS[0], mapeo) + " + " + aNumero(SUMANDOS[1], mapeo) + " = " + aNumero(RESULTADO, mapeo));
        System.out.println("Mapeo: " + new TreeMap<>(mapeo) + "\n");
    }
}
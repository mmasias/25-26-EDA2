import java.util;

public class FortyTenTenSixty {
    private static final String[] SUMANDOS = {"FORTY", "TEN", "TEN"};
    private static final String RESULTADO = "SIXTY";

    public static void main(String[] args) {
        List<Character> letras = Arrays.asList('F', 'O', 'R', 'T', 'Y', 'E', 'N', 'S', 'I', 'X');
        Set<Character> iniciales = new HashSet<>(Arrays.asList('F', 'T', 'S'));
        
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
        long s3 = aNumero(SUMANDOS[2], mapeo); // El segundo TEN
        long res = aNumero(RESULTADO, mapeo);
        return (s1 + s2 + s3) == res;
    }

    private static long aNumero(String palabra, Map<Character, Integer> mapeo) {
        long num = 0;
        for (char c : palabra.toCharArray()) num = num * 10 + mapeo.get(c);
        return num;
    }

    private static void imprimirSolucion(Map<Character, Integer> mapeo) {
        System.out.println("Solución para FORTY + TEN + TEN = SIXTY:");
        System.out.println(aNumero(SUMANDOS[0], mapeo) + " + " + aNumero(SUMANDOS[1], mapeo) + " + " + aNumero(SUMANDOS[2], mapeo) + " = " + aNumero(RESULTADO, mapeo));
        System.out.println("Mapeo: " + new TreeMap<>(mapeo) + "\n");
    }
}
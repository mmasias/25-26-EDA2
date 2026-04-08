import java.util.*;

public class CriptoAlgorithm {

    private Map<Character, Integer> mapa = new HashMap<>();
    private boolean[] usados = new boolean[10];

    void resolver(char[] letras, int index, char[][] suma, char[] resultado) {

        // Caso base
        if (index == letras.length) {
            if (esValido(suma, resultado)) {
                imprimir(suma, resultado);
            }
            return;
        }

        // Probar todos los dígitos
        for (int d = 0; d <= 9; d++) {

            if (!usados[d]) {

                mapa.put(letras[index], d);
                usados[d] = true;

                resolver(letras, index + 1, suma, resultado);

                // Backtracking
                usados[d] = false;
                mapa.remove(letras[index]);
            }
        }
    }

    boolean esValido(char[][] suma, char[] resultado) {

        // No permitir ceros iniciales
        for (char[] palabra : suma) {
            if (mapa.get(palabra[0]) == 0) return false;
        }

        if (mapa.get(resultado[0]) == 0) return false;

        int total = 0;

        for (char[] palabra : suma) {
            total += convertir(palabra);
        }

        return total == convertir(resultado);
    }

    int convertir(char[] palabra) {

        int num = 0;

        for (char c : palabra) {
            num = num * 10 + mapa.get(c);
        }

        return num;
    }

    void imprimir(char[][] suma, char[] resultado) {

        for (char[] palabra : suma) {
            System.out.print(convertir(palabra) + " + ");
        }

        System.out.println(" = " + convertir(resultado));
        System.out.println(mapa);
        System.out.println("---------------------");
    }

    static char[] obtenerLetrasUnicas(String[] palabras) {

        Set<Character> set = new LinkedHashSet<>();

        for (String palabra : palabras) {
            for (char c : palabra.toCharArray()) {
                set.add(c);
            }
        }

        char[] letras = new char[set.size()];
        int i = 0;

        for (char c : set) {
            letras[i++] = c;
        }

        return letras;
    }

    public static void main(String[] args) {

        final String[] WORDS = {"SEND", "MORE", "MONEY"};

        char[][] suma = {
                WORDS[0].toCharArray(),
                WORDS[1].toCharArray()
        };

        char[] resultado = WORDS[2].toCharArray();

        char[] letras = obtenerLetrasUnicas(WORDS);

        CriptoAlgorithm solver = new CriptoAlgorithm();
        solver.resolver(letras, 0, suma, resultado);
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriptoAritmetica {

    public static void main(String[] args) {
        System.out.println("--- SEND + MORE = MONEY ---");
        resolverAcertijo(new String[]{"SEND", "MORE"}, "MONEY");

        System.out.println("\n--- FORTY + TEN + TEN = SIXTY ---");
        resolverAcertijo(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");

        System.out.println("\n--- ODD + ODD = EVEN ---");
        resolverAcertijo(new String[]{"ODD", "ODD"}, "EVEN");
    }

    public static void resolverAcertijo(String[] sumandos, String resultado) {
        List<Character> letrasUnicas = new ArrayList<>();
        boolean[] noPuedeSerCero = new boolean[256];

        for (String palabra : sumandos) {
            if (palabra.length() > 1) {
                noPuedeSerCero[palabra.charAt(0)] = true;
            }
            for (char c : palabra.toCharArray()) {
                if (!letrasUnicas.contains(c)) {
                    letrasUnicas.add(c);
                }
            }
        }
        
        if (resultado.length() > 1) {
            noPuedeSerCero[resultado.charAt(0)] = true;
        }
        for (char c : resultado.toCharArray()) {
            if (!letrasUnicas.contains(c)) {
                letrasUnicas.add(c);
            }
        }

        if (letrasUnicas.size() > 10) {
            System.out.println("Invalido");
            return;
        }

        Map<Character, Integer> mapaAsignaciones = new HashMap<>();
        boolean[] digitosUsados = new boolean[10];

        if (!asignarLetrasRecursivo(0, letrasUnicas, mapaAsignaciones, digitosUsados, noPuedeSerCero, sumandos, resultado)) {
            System.out.println("Sin solucion");
        }
    }

    private static boolean asignarLetrasRecursivo(int indice, List<Character> letrasUnicas,
                                                  Map<Character, Integer> asignaciones, boolean[] digitosUsados,
                                                  boolean[] noPuedeSerCero, String[] sumandos, String resultado) {
        
        if (indice == letrasUnicas.size()) {
            return comprobarSuma(asignaciones, sumandos, resultado);
        }

        char letraActual = letrasUnicas.get(indice);

        for (int digito = 0; digito <= 9; digito++) {
            if (!digitosUsados[digito]) {
                if (digito != 0 || !noPuedeSerCero[letraActual]) {
                    asignaciones.put(letraActual, digito);
                    digitosUsados[digito] = true;

                    if (asignarLetrasRecursivo(indice + 1, letrasUnicas, asignaciones, digitosUsados, noPuedeSerCero, sumandos, resultado)) {
                        return true;
                    }

                    digitosUsados[digito] = false;
                    asignaciones.remove(letraActual);
                }
            }
        }
        return false;
    }

    private static boolean comprobarSuma(Map<Character, Integer> asignaciones, String[] sumandos, String resultado) {
        long sumaAcumulada = 0;
        
        for (String palabra : sumandos) {
            sumaAcumulada += convertirPalabraANumero(palabra, asignaciones);
        }
        
        long valorResultado = convertirPalabraANumero(resultado, asignaciones);

        if (sumaAcumulada == valorResultado) {
            System.out.print("Valores asignados: ");
            for (Map.Entry<Character, Integer> entrada : asignaciones.entrySet()) {
                System.out.print("[" + entrada.getKey() + "=" + entrada.getValue() + "] ");
            }
            System.out.println("\n");

            for (int i = 0; i < sumandos.length; i++) {
                String prefijo = (i == sumandos.length - 1) ? "+ " : "  ";
                System.out.println(prefijo + convertirPalabraANumero(sumandos[i], asignaciones) + " (" + sumandos[i] + ")");
            }
            System.out.println("-------");
            System.out.println("  " + valorResultado + " (" + resultado + ")");
            return true;
        }
        return false;
    }

    private static long convertirPalabraANumero(String palabra, Map<Character, Integer> asignaciones) {
        long numero = 0;
        for (char c : palabra.toCharArray()) {
            numero = (numero * 10) + asignaciones.get(c);
        }
        return numero;
    }
}
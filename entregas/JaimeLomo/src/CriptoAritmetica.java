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
        char[] letrasUnicas = new char[10];
        int cantidadLetras = 0;
        boolean[] letraVista = new boolean[256];
        boolean[] noPuedeSerCero = new boolean[256];

        for (int i = 0; i < sumandos.length; i++) {
            String palabra = sumandos[i];
            if (palabra.length() > 1) {
                noPuedeSerCero[palabra.charAt(0)] = true;
            }
            for (int j = 0; j < palabra.length(); j++) {
                char c = palabra.charAt(j);
                if (!letraVista[c]) {
                    if (cantidadLetras == 10) {
                        System.out.println("Invalido");
                        return;
                    }
                    letraVista[c] = true;
                    letrasUnicas[cantidadLetras] = c;
                    cantidadLetras++;
                }
            }
        }
        
        if (resultado.length() > 1) {
            noPuedeSerCero[resultado.charAt(0)] = true;
        }
        for (int j = 0; j < resultado.length(); j++) {
            char c = resultado.charAt(j);
            if (!letraVista[c]) {
                if (cantidadLetras == 10) {
                    System.out.println("Invalido");
                    return;
                }
                letraVista[c] = true;
                letrasUnicas[cantidadLetras] = c;
                cantidadLetras++;
            }
        }

        int[] asignaciones = new int[256];
        boolean[] digitosUsados = new boolean[10];

        if (!asignarLetrasRecursivo(0, letrasUnicas, cantidadLetras, asignaciones, digitosUsados, noPuedeSerCero, sumandos, resultado)) {
            System.out.println("Sin solucion");
        }
    }

    private static boolean asignarLetrasRecursivo(int indice, char[] letrasUnicas, int cantidadLetras,
                                                  int[] asignaciones, boolean[] digitosUsados,
                                                  boolean[] noPuedeSerCero, String[] sumandos, String resultado) {
        
        if (indice == cantidadLetras) {
            return comprobarSuma(asignaciones, sumandos, resultado, letrasUnicas, cantidadLetras);
        }

        char letraActual = letrasUnicas[indice];

        for (int digito = 0; digito <= 9; digito++) {
            if (!digitosUsados[digito]) {
                if (digito != 0 || !noPuedeSerCero[letraActual]) {
                    asignaciones[letraActual] = digito;
                    digitosUsados[digito] = true;

                    if (asignarLetrasRecursivo(indice + 1, letrasUnicas, cantidadLetras, asignaciones, digitosUsados, noPuedeSerCero, sumandos, resultado)) {
                        return true;
                    }

                    digitosUsados[digito] = false;
                }
            }
        }
        return false;
    }

    private static boolean comprobarSuma(int[] asignaciones, String[] sumandos, String resultado, char[] letrasUnicas, int cantidadLetras) {
        long sumaAcumulada = 0;
        
        for (int i = 0; i < sumandos.length; i++) {
            sumaAcumulada += convertirPalabraANumero(sumandos[i], asignaciones);
        }
        
        long valorResultado = convertirPalabraANumero(resultado, asignaciones);

        if (sumaAcumulada == valorResultado) {
            System.out.print("Valores asignados: ");
            for (int i = 0; i < cantidadLetras; i++) {
                char c = letrasUnicas[i];
                System.out.print("[" + c + "=" + asignaciones[c] + "] ");
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

    private static long convertirPalabraANumero(String palabra, int[] asignaciones) {
        long numero = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            numero = (numero * 10) + asignaciones[c];
        }
        return numero;
    }
}
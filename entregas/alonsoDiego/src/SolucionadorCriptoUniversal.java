public class SolucionadorCriptoUniversal {

    static char[] letrasUnicas;
    static int[] asignacion = new int[256]; 
    static boolean[] usados = new boolean[10];
    static boolean[] inicialesProhibidas = new boolean[256];
    
    static String[] sumandosActuales;
    static String resultadoActual;

    public static void main(String[] args) {
        System.out.println("Resolviendo FORTY + TEN + TEN = SIXTY...");
        prepararTablero(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY");
        resolver(0);

        System.out.println("-----------------------------------");

        System.out.println("Resolviendo ODD + ODD = EVEN...");
        prepararTablero(new String[]{"ODD", "ODD"}, "EVEN");
        resolver(0);
    }

    static void prepararTablero(String[] sumandos, String resultado) {
        sumandosActuales = sumandos;
        resultadoActual = resultado;
        
        for (int i = 0; i < asignacion.length; i++) {
            asignacion[i] = -1;
            inicialesProhibidas[i] = false;
        }
        for (int i = 0; i < 10; i++) usados[i] = false;

        boolean[] letraPresente = new boolean[256];
        int totalLetrasDiferentes = 0;
        
        for (String palabra : sumandos) {
            inicialesProhibidas[palabra.charAt(0)] = true;
            for (char c : palabra.toCharArray()) {
                if (!letraPresente[c]) {
                    letraPresente[c] = true;
                    totalLetrasDiferentes++;
                }
            }
        }
        
        inicialesProhibidas[resultado.charAt(0)] = true;
        for (char c : resultado.toCharArray()) {
            if (!letraPresente[c]) {
                letraPresente[c] = true;
                totalLetrasDiferentes++;
            }
        }
        
        letrasUnicas = new char[totalLetrasDiferentes];
        int indice = 0;
        
        for (int i = 0; i < 256; i++) {
            if (letraPresente[i]) {
                letrasUnicas[indice] = (char) i;
                indice++;
            }
        }
    }

    static boolean resolver(int indiceLetra) {
        if (indiceLetra == letrasUnicas.length) {
            return comprobarSuma();
        }

        char letraActual = letrasUnicas[indiceLetra];

        for (int digito = 0; digito <= 9; digito++) {
            if (puedeColocar(letraActual, digito)) {
                asignacion[letraActual] = digito;
                usados[digito] = true;

                if (resolver(indiceLetra + 1)) {
                    return true; 
                }

                asignacion[letraActual] = -1;
                usados[digito] = false;
            }
        }
        return false;
    }

    static boolean puedeColocar(char letra, int digito) {
        if (usados[digito]) {
            return false;
        }
        if (digito == 0 && inicialesProhibidas[letra]) {
            return false;
        }
        return true;
    }

    static boolean comprobarSuma() {
        int sumaTotal = 0;
        
        for (String palabra : sumandosActuales) {
            sumaTotal += convertirPalabraANumero(palabra);
        }
        
        int valorResultado = convertirPalabraANumero(resultadoActual);

        if (sumaTotal == valorResultado) {
            for (String palabra : sumandosActuales) {
                System.out.printf("%10s -> %10d\n", palabra, convertirPalabraANumero(palabra));
            }
            System.out.println("-------------------------");
            System.out.printf("%10s -> %10d\n\n", resultadoActual, valorResultado);
            return true;
        }
        return false;
    }

    static int convertirPalabraANumero(String palabra) {
        int acumulador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            acumulador = (acumulador * 10) + asignacion[palabra.charAt(i)];
        }
        return acumulador;
    }
}
public class sendMoreMoney {
    char[][] sumandos;
    char[] resultado;
    char[] letras;
    int[] valores;
    boolean[] usados;

    public sendMoreMoney(char[][] sumandos, char[] resultado) {
        this.sumandos = sumandos;
        this.resultado = resultado;
        this.valores = new int[256];
        this.usados = new boolean[10];

        for (int i = 0; i < valores.length; i++) {
            valores[i] = -1;
        }
        extraerLetrasUnicas();
    }

    private void extraerLetrasUnicas() {
        boolean[] encontradas = new boolean[256];
        int contadorUnicas = 0;

        for (int i = 0; i < sumandos.length; i++) {
            char[] palabra = sumandos[i];
            for (int j = 0; j < palabra.length; j++) {
                char c = palabra[j];
                if (!encontradas[c]) {
                    encontradas[c] = true;
                    contadorUnicas++;
                }
            }
        }

        for (int j = 0; j < resultado.length; j++) {
            char c = resultado[j];
            if (!encontradas[c]) {
                encontradas[c] = true;
                contadorUnicas++;
            }
        }

        letras = new char[contadorUnicas];
        int indice = 0;
        for (int i = 0; i < encontradas.length; i++) {
            if (encontradas[i]) {
                letras[indice++] = (char) i;
            }
        }
    }

    public void ejecutar() {
        if (letras.length > 10) {
            System.out.println("Error: Hay más de 10 letras únicas. Imposible mapear a digitos 0-9.");
            return;
        }

        if (!resolver(0)) {
            System.out.println("No se encontro ninguna solucion. :(\n");
        }
    }

    public boolean resolver(int indice) {
        if (indice == letras.length) { //CASO BASE
            return evaluarSolucion();
        }

        for (int digito = 0; digito <= 9; digito++) {//CASO RECURSIVO
            if (!usados[digito]) {
                valores[letras[indice]] = digito;
                usados[digito] = true;

                if (resolver(indice + 1)) {
                    return true;
                }

                usados[digito] = false;
                valores[letras[indice]] = -1;
            }
        }
        return false;
    }

    private boolean evaluarSolucion() {
        for (int i = 0; i < sumandos.length; i++) {
            if (valores[sumandos[i][0]] == 0)
                return false;
        }
        if (valores[resultado[0]] == 0)
            return false;

        long sumaTotal = 0;
        for (int i = 0; i < sumandos.length; i++) {
            sumaTotal += obtenerValorPalabra(sumandos[i]);
        }

        long valorResultado = obtenerValorPalabra(resultado);

        if (sumaTotal == valorResultado) {
            imprimirExito(sumaTotal, valorResultado);
            return true;
        }
        return false;
    }

    private long obtenerValorPalabra(char[] palabra) {
        long valor = 0;
        for (int i = 0; i < palabra.length; i++) {
            valor = valor * 10 + valores[palabra[i]];
        }
        return valor;
    }

    private void imprimirExito(long sumaTotal, long valorResultado) {
        System.out.println("Solucion encontrada!");
        for (int i = 0; i < sumandos.length; i++) {
            System.out.print("   " + obtenerValorPalabra(sumandos[i]) + "  (");
            imprimirArreglo(sumandos[i]);
            System.out.println(")");
        }
        System.out.println("  ---------");
        System.out.print("   " + valorResultado + "  (");
        imprimirArreglo(resultado);
        System.out.println(")\n");

        System.out.println("Mapeo de digitos:");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + " = " + valores[letras[i]] + "  ");
        }
        System.out.println("\n-----------------------------------------\n");
    }

    private void imprimirArreglo(char[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Buscando soluciones \n");

        new sendMoreMoney(
                new char[][] { { 'S', 'E', 'N', 'D' }, { 'M', 'O', 'R', 'E' } },
                new char[] { 'M', 'O', 'N', 'E', 'Y' }).ejecutar();

        new sendMoreMoney(
                new char[][] { { 'F', 'O', 'R', 'T', 'Y' }, { 'T', 'E', 'N' }, { 'T', 'E', 'N' } },
                new char[] { 'S', 'I', 'X', 'T', 'Y' }).ejecutar();

        new sendMoreMoney(
                new char[][] { { 'O', 'D', 'D' }, { 'O', 'D', 'D' } },
                new char[] { 'E', 'V', 'E', 'N' }).ejecutar();
    }
}
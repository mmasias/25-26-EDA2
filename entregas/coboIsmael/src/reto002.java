public class reto002 {

    static int[] letras = new int[26];
    static boolean[] usados = new boolean[10];
    static String[] sumandos;
    static String resultado;

    public static void main(String[] args) {
        resolver(new String[]{"SEND", "MORE", "MONEY"});
        resolver(new String[]{"FORTY", "TEN", "TEN", "SIXTY"});
        resolver(new String[]{"ODD", "ODD", "EVEN"});
    }

    static void resolver(String[] palabras) {
        resultado = palabras[palabras.length - 1];
        sumandos = new String[palabras.length - 1];

        for (int indice = 0; indice < palabras.length - 1; indice++) {
            sumandos[indice] = palabras[indice];
        }

        for (int indice = 0; indice < 26; indice++) {
            letras[indice] = -1;
        }

        resolverColumna(0, 0, 0);
        System.out.println("------------------");
    }

    static boolean resolverColumna(int columna, int fila, int suma) {
        if (columna == resultado.length()) {
            mostrar();
            return true;
        }

        if (fila < sumandos.length) {
            int posicion = sumandos[fila].length() - 1 - columna;

            if (posicion < 0) {
                return resolverColumna(columna, fila + 1, suma);
            }

            char letra = sumandos[fila].charAt(posicion);
            int indice = letra - 'A';

            if (letras[indice] != -1) {
                return resolverColumna(columna, fila + 1, suma + letras[indice]);
            }

            for (int numero = 0; numero <= 9; numero++) {
                if (!usados[numero]) {
                    letras[indice] = numero;
                    usados[numero] = true;

                    if (resolverColumna(columna, fila + 1, suma + numero)) {
                        return true;
                    }

                    letras[indice] = -1;
                    usados[numero] = false;
                }
            }

            return false;
        }

        int posicion = resultado.length() - 1 - columna;
        char letra = resultado.charAt(posicion);
        int indice = letra - 'A';

        int digito = suma % 10;
        int acarreo = suma / 10;

        if (letras[indice] == -1 && !usados[digito]) {
            letras[indice] = digito;
            usados[digito] = true;

            if (resolverColumna(columna + 1, 0, acarreo)) {
                return true;
            }

            letras[indice] = -1;
            usados[digito] = false;
        }

        if (letras[indice] == digito) {
            return resolverColumna(columna + 1, 0, acarreo);
        }

        return false;
    }

    static void mostrar() {
        for (int indice = 0; indice < sumandos.length; indice++) {
            System.out.println(sumandos[indice] + " = " + valor(sumandos[indice]));
        }
        System.out.println(resultado + " = " + valor(resultado));
    }

    static int valor(String palabra) {
        int numero = 0;

        for (int indice = 0; indice < palabra.length(); indice++) {
            numero = numero * 10 + letras[palabra.charAt(indice) - 'A'];
        }

        return numero;
    }
}
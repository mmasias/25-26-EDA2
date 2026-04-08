package propuestaPropia;
public class CriptoAlgorithm {

    public int contador = 0; 
    public int contadorColum = 0;
    private Mapa mapa = new Mapa();
    private boolean[] ocupado = new boolean[10];

    public void resolverCripto(String[] sumasString, String resultadoString) {
        contador = 0; 
        
        char[][] sumas = new char[sumasString.length][];

        for(int i=0; i<sumasString.length ;i++){
            sumas[i]= sumasString[i].toCharArray();
        }
        char[] resultado = resultadoString.toCharArray();

        if (resolver(sumas, resultado, 0, 0)) {
            imprimirResultado(sumas, resultado);
        } else {
            System.out.println("No hay solución.");
        }
    }

    private boolean resolver(char[][] sumas, char[] resultado, int columna, int carry) {

        contadorColum++;
        if (columna == resultado.length) {
            return carry == 0;
        }

        char[] caracteres = new char[sumas.length+1];
        for (int i=0;i<sumas.length;i++ ) {
            caracteres[i] = (columna < sumas[i].length) ? sumas[i][sumas[i].length - 1 - columna] : '\0';
        }
        caracteres[caracteres.length-1] = resultado[resultado.length - 1 - columna];

        return asignarLetras(sumas, resultado, columna, carry, caracteres, 0);
    }

    private boolean asignarLetras(char[][] sumas, char[] resultado, int columna, int carry, char[] caracteres, int charIdx) {
        if (charIdx == caracteres.length) {
            int suma = carry;
            int[] valores = new int[sumas.length+1];

            for (int i=0;i<sumas.length;i++) {
                valores[i] = (columna < sumas[i].length) ? mapa.find(sumas[i][sumas[i].length - 1 - columna]) : 0;
                suma+=valores[i];
            }
            valores[valores.length-1] = mapa.find(resultado[resultado.length - 1 - columna]);

            if (suma % 10 == valores[valores.length-1]) {
                return resolver(sumas, resultado, columna + 1, suma / 10);
            }
            return false;
        }

        char caracter = caracteres[charIdx];

        if (caracter == '\0' || mapa.find(caracter) != -1) {
            return asignarLetras(sumas, resultado, columna, carry, caracteres, charIdx + 1);
        }

        for (int i = 0; i <= 9; i++) {
            contador++; 
            
            if (i == 0 && esInicio(caracter, sumas, resultado)) continue;

            if (!ocupado[i]) {
                mapa.add(caracter, i);
                ocupado[i] = true;

                if (asignarLetras(sumas, resultado, columna, carry, caracteres, charIdx + 1)) {
                    return true;
                }

                ocupado[i] = false;
                mapa.remove(caracter);
            }
        }
        return false;
    }

    private boolean esInicio(char c, char[][] sumas, char[] resultado) {
        boolean sumasInicio=false;
        for (int i =0; i<sumas.length;i++) {
            sumasInicio = sumasInicio || (c==sumas[i][0]);
        }

        return sumasInicio || c == resultado[0];
    }

    private void imprimirResultado(char[][] sumas, char[] resultado) {
        for (char c : sumas[0]) System.out.print(mapa.find(c));
        for(int i=1;i<sumas.length;i++) {
            System.out.print(" + ");
            for (char c : sumas[i]) System.out.print(mapa.find(c));
        }
        System.out.print(" = ");
        for (char c : resultado) System.out.print(mapa.find(c));
        System.out.println();
    }


    public static void main(String[] args) {
        CriptoAlgorithm app = new CriptoAlgorithm();
        app.resolverCripto(new String[]{"SEND", "MORE"}, "MONEY");
        
        // ¡IMPORTANTE! Acceder a través de 'app'
        System.out.println("Intentos realizados: " + app.contador + "\nContador de columnas recorridas: " + app.contadorColum);
    }
}
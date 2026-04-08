import java.io.Console;
import java.util.Arrays;

public class StringsRecursivos {
    static final char[] ABECEDARIO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static Console console = System.console();
    public static void main(String[] args) {

        String primeraPalabra = console.readLine();
        String segundaPalabra = console.readLine();

        int tamañoDeSolucion;
        if(longitudString(primeraPalabra) > longitudString(segundaPalabra)){
            tamañoDeSolucion = longitudString(primeraPalabra);
        }else{
            tamañoDeSolucion = longitudString(segundaPalabra);
        }

        char[] solucion = new char[tamañoDeSolucion+1];
        int[] contador = {tamañoDeSolucion};
        int[] letraMayor = {1};
        sumaDeStrings(solucion, contador, letraMayor, primeraPalabra.toCharArray(), segundaPalabra.toCharArray());
        String respuesta = charArrayToString(solucion);

        System.out.println(respuesta);

    }

    static public void sumaDeStrings(char[] solucion, int[] contador, int[] letraMayor, char[] ...palabras) {
        
        for(int i = 0; i < palabras.length; i++){
            if(palabras[i].length == 0){
                return;
            }
        }

        if(palabras[0].length == palabras[1].length) {
            if (palabras[0].length == 1){
                System.out.println(valorDeChar(palabras[0][0]) + "");
                System.out.println(valorDeChar(palabras[1][0]) + "");
                char nuevoChar = charABaseDeValor(valorDeChar(palabras[0][0]) + valorDeChar(palabras[1][0]));
                solucion[contador[0]] = nuevoChar;
                return;
            }

            char[] recortarPrimeraPalabra = Arrays.copyOfRange(palabras[0], 1, palabras[0].length);
            char[] recortarSegundaPalabra = Arrays.copyOfRange(palabras[1], 1, palabras[1].length);
            System.out.println("Primera palabra: " + new String(recortarPrimeraPalabra) + "\nSegunda Palabra: " + new String(recortarSegundaPalabra) + "\ncontador: " + contador[0]);

            sumaDeStrings(solucion, contador, letraMayor, recortarPrimeraPalabra, recortarSegundaPalabra);
            System.out.println("Primera palabra: " + new String(recortarPrimeraPalabra) + "\nSegunda Palabra: " + new String(recortarSegundaPalabra) + "\ncontador: " + contador[0]);

            contador[0]-=1;

            if(letraMayor[0] == 1){
                solucion[contador[0]] = compararCharMayor(recortarPrimeraPalabra[0], recortarSegundaPalabra[0]); 
                letraMayor[0] = 0;
            }else{
                solucion[contador[0]] = compararCharMenor(recortarPrimeraPalabra[0], recortarSegundaPalabra[0]); 
                letraMayor[0] = 1;
            }

        }
        if(letraMayor[0] == 1){
            solucion[contador[0] - 1] = compararCharMayor(palabras[0][0], palabras[1][0]); 
            letraMayor[0] = 0;
        }else{
            solucion[contador[0] - 1] = compararCharMenor(palabras[0][0], palabras[1][0]);
            letraMayor[0] = 1;
        }    
    
    }

    static private int valorDeChar(char c){
        return Character.getNumericValue(c);
    }

    static private char charABaseDeValor(int numero){
        return ABECEDARIO[numero - 3];
    }

    static private int longitudString(String string){
        return string.toCharArray().length;
    }

    static private char compararCharMayor(char... chars) {
        char mayor = ABECEDARIO[0];

        for (int i = 0; i < chars.length; i++) {
            if (posicion(chars[i]) > posicion(mayor)) {
                mayor = chars[i];
            }
        }
        return mayor;
    }

    static private char compararCharMenor(char... chars) {
        char menor = ABECEDARIO[ABECEDARIO.length - 1];

        for (int i = 0; i < chars.length; i++) {
            if (posicion(chars[i]) < posicion(menor)) {
                menor = chars[i];
            }
        }
        return menor;
    }

    static private int posicion(char c) {
        for (int i = 0; i < ABECEDARIO.length; i++) {
            if (ABECEDARIO[i] == c) {
                return i;
            }
        }
        return -1;
    }

    static private String charArrayToString(char[] charArray){
        return new String(charArray);
    }
}
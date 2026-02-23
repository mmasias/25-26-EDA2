import java.util.*;


public class Recursividad2Think {

    
    public static int productoPares(int n){
        if(n < 2)
            return 1;

        if(n % 2 != 0)
            return productoPares(n-1);

        return n * productoPares(n-2);
    }

    
    public static int contarCifras(int n){
        n = Math.abs(n);

        if(n < 10)
            return 1;

        return 1 + contarCifras(n/10);
    }

    
    public static int cuadrado(int n){
        if(n == 0)
            return 0;

        return cuadrado(n-1) + (2*n - 1);
    }

    
    public static String eliminarLetra(String texto, char letra){
        if(texto.length() == 0)
            return "";

        char c = texto.charAt(0);

        if(c == letra)
            return eliminarLetra(texto.substring(1), letra);

        return c + eliminarLetra(texto.substring(1), letra);
    }

    
    public static String reemplazarLetra(String texto, char buscar, char reemplazo){
        if(texto.length() == 0)
            return "";

        char c = texto.charAt(0);

        if(c == buscar)
            c = reemplazo;

        return c + reemplazarLetra(texto.substring(1), buscar, reemplazo);
    }

    
    public static boolean esPalindromo(String texto){
        texto = texto.replace(" ", "").toLowerCase();

        if(texto.length() <= 1)
            return true;

        if(texto.charAt(0) != texto.charAt(texto.length()-1))
            return false;

        return esPalindromo(texto.substring(1, texto.length()-1));
    }

    
    public static List<Integer> duplicarLista(List<Integer> lista){
        return duplicarAux(lista, 0);
    }

    private static List<Integer> duplicarAux(List<Integer> lista, int i){
        if(i == lista.size())
            return new ArrayList<>();

        List<Integer> resultado = duplicarAux(lista, i+1);

        resultado.add(0, lista.get(i));
        resultado.add(0, lista.get(i));

        return resultado;
    }

    
    public static int sumaPosicionesPares(List<Integer> lista){
        return sumaAux(lista, 0);
    }

    private static int sumaAux(List<Integer> lista, int i){
        if(i >= lista.size())
            return 0;

        return lista.get(i) + sumaAux(lista, i+2);
    }

   
    public static String decimalABinario(int n){
        if(n < 2)
            return String.valueOf(n);

        return decimalABinario(n/2) + (n%2);
    }

    public static void main(String[] args) {

        System.out.println(productoPares(6));
        System.out.println(contarCifras(12345));
        System.out.println(cuadrado(5));
        System.out.println(eliminarLetra("banana",'a'));
        System.out.println(reemplazarLetra("banana",'a','x'));
        System.out.println(esPalindromo("reconocer"));

        List<Integer> lista = Arrays.asList(1,2,3);
        System.out.println(duplicarLista(lista));

        List<Integer> lista2 = Arrays.asList(1,2,3,4,5);
        System.out.println(sumaPosicionesPares(lista2));

        System.out.println(decimalABinario(10));
    }
}
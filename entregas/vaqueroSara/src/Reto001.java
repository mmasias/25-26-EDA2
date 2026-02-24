import java.util.*;

public class Reto001 {

    public static void main(String[] args) {
        productoPares(10);
        contarCifras(100);
        elevarAlCuadrado(5);
        borrarLetra("Hola Mundo", 'o');
        reemplazarLetra("Hola Mundo", 'o', 'x');
        System.out.println("¿Es palíndromo? " + esPalindromo("Anita lava la tina"));
        convertirBinario(10);

        List<Integer> lista = Arrays.asList(1, 2, 3);
        duplicarLista(lista);
        sumaPosicionesPares(lista);
    }

    public static void productoPares(int n) {
        int producto = 1;
        for (int i = 2; i <= n; i += 2) {
            producto *= i;
        }
        System.out.println("El producto de los números pares del 1 al " + n + " es: " + producto);
    }

    private static void contarCifras(int i) {
        int cifras = 0;
        int num = i;

        if (num == 0) cifras = 1;

        while (num > 0) {
            cifras++;
            num /= 10;
        }
        System.out.println("El número " + i + " tiene " + cifras + " cifras.");
    }

    private static void elevarAlCuadrado(int i) {
        System.out.println("El número " + i + " elevado al cuadrado es: " + (i * i));
    }

    private static void borrarLetra(String str, char letra) {
        String resultado = str.replace(Character.toString(letra), "");
        System.out.println("La cadena resultante después de eliminar la letra '" + letra + "' es: " + resultado);
    }

    private static void reemplazarLetra(String str, char letraVieja, char letraNueva) {
        String resultado = str.replace(letraVieja, letraNueva);
        System.out.println("La cadena resultante después de reemplazar la letra '" + letraVieja + "' por '" + letraNueva + "' es: " + resultado);
    }

    private static boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase().replaceAll("\\s+", "");
        String invertida = new StringBuilder(palabra).reverse().toString();
        return palabra.equals(invertida);
    }

    private static void convertirBinario(int numero) {
        if (numero == 0) {
            System.out.println("El número 0 en binario es: 0");
            return;
        }

        StringBuilder binario = new StringBuilder();
        int num = numero;

        while (num > 0) {
            binario.insert(0, num % 2);
            num /= 2;
        }
        System.out.println("El número " + numero + " en binario es: " + binario.toString());
    }

    private static void duplicarLista(List<Integer> lista) {
        List<Integer> nueva = new ArrayList<>();

        for (int num : lista) {
            nueva.add(num);
            nueva.add(num);
        }

        System.out.println("Lista duplicada: " + nueva);
    }

    private static void sumaPosicionesPares(List<Integer> lista) {
        int suma = 0;

        for (int i = 0; i < lista.size(); i += 2) {
            suma += lista.get(i);
        }

        System.out.println("Suma de posiciones pares: " + suma);
    }
}
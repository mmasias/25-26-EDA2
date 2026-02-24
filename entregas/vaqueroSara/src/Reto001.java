public class Reto001 {


    public static void main(String[] args) {
        productoPares(10);
        contarCifras(100);
        elevarAlCuadrado(5);
        borrarLetra("Hola Mundo", 'o');
        reemplazarLetra("Hola Mundo", 'o', 'x');
    }

    private static void elevarAlCuadrado(int i) {
        System.out.println("El número " + i + " elevado al cuadrado es: " + (i * i));
    }

    private static void contarCifras(int i) {
        int cifras = 0;
        int num = i;
        while (num > 0) {
            cifras++;
            num /= 10;
        }
        System.out.println("El número " + i + " tiene " + cifras + " cifras.");
    }

    public static void productoPares(int n) {
        int producto = 1;
        for (int i = 2; i <= n; i += 2) {

            producto *= i;
        }
        System.out.println("El producto de los números pares del 1 al " + n + " es: " + producto);
    }

    private static void borrarLetra(String str, char letra) {
        String resultado = str.replace(Character.toString(letra), "");
        System.out.println("La cadena resultante después de eliminar la letra '" + letra + "' es: " + resultado);
    }

    private static void reemplazarLetra(String str, char letraVieja, char letraNueva) {
        String resultado = str.replace(letraVieja, letraNueva);
        System.out.println("La cadena resultante después de reemplazar la letra '" + letraVieja + "' por '" + letraNueva + "' es: " + resultado);
    }


    
}
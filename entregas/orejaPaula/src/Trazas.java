import java.util.Arrays;

public class Trazas {

    public static void titulo(String texto) {
        System.out.println();
        System.out.println("========================================");
        System.out.println(texto);
        System.out.println("========================================");
    }

    public static void estadoInicial(int[] array) {
        System.out.println("Estado inicial: " + Arrays.toString(array));
    }

    public static void estadoFinal(int[] array) {
        System.out.println("Estado final:   " + Arrays.toString(array));
    }

    public static void array(int[] array, int nivel) {
        System.out.println(indentar(nivel) + "Array: " + Arrays.toString(array));
    }

    public static String indentar(int nivel) {
        String texto = "";
        for (int i = 0; i < nivel; i++) {
            texto = texto + "  ";
        }
        return texto;
    }
}
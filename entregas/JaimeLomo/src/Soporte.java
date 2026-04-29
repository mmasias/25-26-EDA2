import java.util.Arrays;

public class Soporte {
    
    private static int nivel = 0;

    public static void indentar() { nivel++; }
    
    public static void desindentar() { nivel--; }

    public static void trazar(String mensaje) {
        String prefijo = "  ".repeat(Math.max(0, nivel));
        System.out.println(prefijo + mensaje);
    }

    public static void trazarEstado(String prefijo, int[] array) {
        trazar(prefijo + Arrays.toString(array));
    }

    public static void evaluarWhileInsertion(int j, int[] array, int valor) {
        if (j < 0) {
            trazar("  [Condicion While] j=" + j + " < 0 -> FALSE (Limite alcanzado)");
        } else if (array[j] <= valor) {
            trazar("  [Condicion While] array[" + j + "]=" + array[j] + " <= " + valor + " -> FALSE (Lugar encontrado)");
        } else {
            trazar("  [Condicion While] array[" + j + "]=" + array[j] + " > " + valor + " -> TRUE (Moviendo)");
        }
    }
}
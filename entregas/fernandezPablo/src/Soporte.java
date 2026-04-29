import java.util.Arrays;

public class Soporte {
    public static int nivelRecursion = 0;

    public static void ejecutarPrueba(String nombre, int[] array, Runnable algoritmo) {
        System.out.printf("%n=== %s ===%n", nombre);
        System.out.printf("ESTADO INICIAL: %s%n", Arrays.toString(array));
        
        nivelRecursion = 0;
        algoritmo.run();
        
        System.out.printf("ESTADO FINAL: %s%n", Arrays.toString(array));
    }

    public static String ind() {
        return "  ".repeat(nivelRecursion);
    }
}

public class ConsolaTraza {

    public static void mostrarEstado(String mensaje, int[] array) {
        System.out.print(mensaje);
        mostrarArray(array);
        System.out.println();
    }

    public static void mostrarEstadoIndentado(int nivel, String mensaje, int[] array) {
        aplicarIndentacion(nivel);
        System.out.print(mensaje);
        mostrarArray(array);
        System.out.println();
    }

    public static void aplicarIndentacion(int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
    }

    private static void mostrarArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }
}

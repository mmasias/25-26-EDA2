public class Formato {

    public static String formatear(int[] array) {
        String texto = "[";

        for (int i = 0; i < array.length; i++) {
            texto = texto + array[i];

            if (i < array.length - 1) {
                texto = texto + ", ";
            }
        }

        texto = texto + "]";
        return texto;
    }

    public static String sangria(int nivel) {
        String texto = "";

        for (int i = 0; i < nivel; i++) {
            texto = texto + "  ";
        }

        return texto;
    }
}
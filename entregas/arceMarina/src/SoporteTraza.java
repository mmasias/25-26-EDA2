public class SoporteTraza {
    
    private static int nivel = 0;
    
    public static void entrarNivel() { nivel++; }
    public static void salirNivel() { nivel--; }
    public static void reiniciar() { nivel = 0; }
    
    public static String getInd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void imprimirComparacion(int[] array, int j, int valor, String ind) {
        if (j >= 0) {
            System.out.println(ind + "Comparando array[" + j + "]=" + array[j] + " > " + valor + " -> " + (array[j] > valor));
        }
    }

    public static void imprimirCorteBucle(int[] array, int j, int actual, String ind) {
        if (j < 0) {
            System.out.println(ind + "Comparación final: j >= 0 -> false. Se detiene desplazamiento.");
        } else {
            System.out.println(ind + "Comparación final: array[" + j + "]=" + array[j] + " > " + actual + " -> false. Se detiene desplazamiento.");
        }
    }

    public static void imprimirFinFusion(int i, int tamIzq, int j, int tamDer, String ind) {
        if (i >= tamIzq) {
            System.out.println(ind + "Fin de comparaciones: i == " + tamIzq + " (izquierda agotada). Se copiarán los elementos restantes de la derecha.");
        } else if (j >= tamDer) {
            System.out.println(ind + "Fin de comparaciones: j == " + tamDer + " (derecha agotada). Se copiarán los elementos restantes de la izquierda.");
        }
    }
}
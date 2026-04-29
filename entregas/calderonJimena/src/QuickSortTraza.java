public class QuickSortTraza {

    private static int nivel = 0;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        System.out.println(identar() + "ordenar(array, " + izquierda + ", " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(identar() + "Caso base: izquierda >= derecha");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha);

        nivel++;
        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
        nivel--;
    } 

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                System.out.println(identar() + "Comparacion: " + array[j] + " <= " + pivote + " = true");
                i++;
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                System.out.println(identar() + "Intercambio: " + mostrar(array));
            } else {
                System.out.println(identar() + "Comparacion: " + array[j] + " <= " + pivote + " = false");
            }
        }
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;
        System.out.println(identar() + "Pivote colocado: " + mostrar(array));
        return i + 1;
    }

    private static String identar() {
        String texto = "";
        for (int i = 0; i < nivel; i++) texto += "  ";
        return texto;
    }

    private static String mostrar(int[] array) {
        String texto = "[";
        for (int i = 0; i < array.length; i++) {
            texto += array[i];
            if (i < array.length - 1) texto += ", ";
        }
        return texto + "]";
    }
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
    
        System.out.println("Quick Sort");
        System.out.println("Estado inicial: " + mostrar(array));
    
        ordenar(array, 0, array.length - 1);
    
        System.out.println("Estado final: " + mostrar(array));
    }
}
public class InsertionSortRecursivo {

    private static int nivel = 0;

    public static void ordenar(int[] array, int n) {
        System.out.println(identar() + "ordenar(array, " + n + ")");

        if (n <= 1) {
            System.out.println(identar() + "Caso base: n <= 1");
            return;
        }

        nivel++;
        ordenar(array, n - 1);
        nivel--;

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(identar() + "Ultimo: " + ultimo);

        while (j >= 0 && array[j] > ultimo) {
            System.out.println(identar() + "Comparacion: " + array[j] + " > " + ultimo + " = true");
            array[j + 1] = array[j];
            System.out.println(identar() + "Desplazamiento: " + mostrar(array));
            j--;
        }

        if (j >= 0) {
            System.out.println(identar() + "Comparacion: " + array[j] + " > " + ultimo + " = false");
        } else {
            System.out.println(identar() + "Comparacion: j >= 0 = false");
        }

        array[j + 1] = ultimo;
        System.out.println(identar() + "Insercion: " + mostrar(array));
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
    
        System.out.println("Insertion Sort Recursivo");
        System.out.println("Estado inicial: " + mostrar(array));
    
        ordenar(array, array.length);
    
        System.out.println("Estado final: " + mostrar(array));
    }
}
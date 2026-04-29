public class InsertionSortRecursivo {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        System.out.println("Estado inicial del array (Insertion Sort Recursivo):");
        imprimirArray(array, "");
        System.out.println("Iniciando proceso de ordenación...");
        ordenar(array, array.length);
        System.out.println("Proceso finalizado. Estado final del array:");
        imprimirArray(array, "");
    }

    public static void ordenar(int[] array, int n) {
        String ind = obtenerIndentacion(array.length - n);
        System.out.println(ind + "Llamada recursiva iniciada para n=" + n);
        
        if (n <= 1) {
            System.out.println(ind + "CASO BASE ALCANZADO: n <= 1 (n=" + n + "). Un sub-array de un solo elemento se considera ordenado.");
            return;
        }
        
        System.out.println(ind + "Delegando ordenación para el sub-array de tamaño n=" + (n - 1));
        ordenar(array, n - 1);
        
        int ultimo = array[n - 1];
        int j = n - 2;
        
        System.out.println(ind + "Retorno de llamada recursiva. Evaluando inserción del elemento en posición " + (n - 1) + ", valor=" + ultimo);
        
        while (j >= 0 && array[j] > ultimo) {
            System.out.println(ind + "Comparación: índice j=" + j + " es >= 0 y array[" + j + "] (" + array[j] + ") es > que el valor a insertar (" + ultimo + "). Intercambio necesario.");
            array[j + 1] = array[j];
            System.out.println(ind + "Desplazamiento: El valor " + array[j + 1] + " se mueve a la posición " + (j + 1));
            imprimirArray(array, ind);
            j--;
        }
        
        if (j < 0) {
            System.out.println(ind + "Comparación: índice j=" + j + " es menor que 0. Se alcanzo el limite izquierdo del sub-array.");
        } else {
            System.out.println(ind + "Comparación: array[" + j + "] (" + array[j] + ") NO es > que el valor a insertar (" + ultimo + "). Posicion correcta encontrada.");
        }
        
        array[j + 1] = ultimo;
        System.out.println(ind + "Inserción: El valor " + ultimo + " se coloca en la posición " + (j + 1));
        imprimirArray(array, ind);
    }

    public static String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public static void imprimirArray(int[] array, String ind) {
        System.out.print(ind + "[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
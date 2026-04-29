public class TrazasAlgoritmosOrdenacion {

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};

        System.out.println("===== INSERTION SORT ITERATIVO =====");
        System.out.println("Estado inicial: " + Formato.formatear(array));
        InsertionSort.ordenar(array);
        System.out.println("Estado final: " + Formato.formatear(array));
        System.out.println();

        array = new int[] {5, 2, 8, 1, 9, 3};

        System.out.println("===== INSERTION SORT RECURSIVO =====");
        System.out.println("Estado inicial: " + Formato.formatear(array));
        InsertionSort.ordenar(array, array.length);
        System.out.println("Estado final: " + Formato.formatear(array));
        System.out.println();

        array = new int[] {5, 2, 8, 1, 9, 3};

        System.out.println("===== MERGE SORT RECURSIVO =====");
        System.out.println("Estado inicial: " + Formato.formatear(array));
        MergeSort.ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + Formato.formatear(array));
        System.out.println();

        array = new int[] {5, 2, 8, 1, 9, 3};

        System.out.println("===== MERGE SORT ITERATIVO =====");
        System.out.println("Estado inicial: " + Formato.formatear(array));
        MergeSort.ordenarIterativo(array);
        System.out.println("Estado final: " + Formato.formatear(array));
        System.out.println();

        array = new int[] {5, 2, 8, 1, 9, 3};

        System.out.println("===== QUICK SORT =====");
        System.out.println("Estado inicial: " + Formato.formatear(array));
        QuickSort.ordenar(array, 0, array.length - 1);
        System.out.println("Estado final: " + Formato.formatear(array));
    }
}
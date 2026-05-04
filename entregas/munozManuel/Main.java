package munozManuel;


class Main {
    
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        printArray(array);
        System.out.println("Insertion sort iterativo");
        System.out.println("-----------------------------------------------------------");
        InsertionSort.ordenar(array);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Insertion sort recursivo");
        System.out.println("-----------------------------------------------------------");
        InsertionSort.ordenar(array, array.length, new int[1]);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Quick sort");
        System.out.println("-----------------------------------------------------------");
        QuickSort.ordenar(array, 1, 4, new int[1]);
        
    }

    private static void printArray(int[] array){
        for (int numero : array){
            System.out.print(numero + " ");
        }
        System.out.println("");
    }

}

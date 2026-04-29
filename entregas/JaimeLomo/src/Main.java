public class Main {
    
    public static void main(String[] args) {
        
        int[] datos = {5, 2, 8, 1, 9, 3};

        System.out.println("=== INICIANDO PRUEBAS DE ALGORITMOS CON TRAZA ===");

        InsertionSort.ordenarIterativo(datos.clone());
        InsertionSort.ordenarRecursivo(datos.clone(), datos.length);
        
        MergeSort.ordenarRecursivo(datos.clone(), 0, datos.length - 1);
        MergeSort.ordenarIterativo(datos.clone());
        
        QuickSort.ordenar(datos.clone(), 0, datos.length - 1);
    }
}
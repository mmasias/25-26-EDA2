import java.util.Arrays;
    
    public class InsertionSort {
        public static void ordenar(int[] array) {
            System.out.println("Array desordenado: " + Arrays.toString(array));
            for (int i = 1; i < array.length; i++) {
                int actual = array[i];
                System.out.println("Insertando elemento: " + actual);
                int j = i - 1;
                while (j >= 0 && array[j] > actual) {
                    System.out.println("Desplazando " + array[j]);
                    array[j + 1] = array[j];
                    j--;
                    System.out.println("Estado temporal: " + Arrays.toString(array));
                }
                array[j + 1] = actual;
                System.out.println("Orden alterado: " + Arrays.toString(array));
            }
            System.out.println("Array ordenado: " + Arrays.toString(array));
        }
        
        public static void ordenar(int[] array, int n, int nivel) {
            String indent = "  ".repeat(nivel);
            if (n <= 1) {
                System.out.println(indent + "-> Caso base alcanzado: n=" + n + " (Array de un solo elemento ya está ordenado)");
                return;
            }
            
            System.out.println(indent + "Llamada recursiva para n=" + n);
            ordenar(array, n - 1, nivel+1);

            int ultimo = array[n - 1];
            System.out.println(indent + "Insertando elemento " + ultimo);
            int j = n - 2;
            while (j >= 0 && array[j] > ultimo) {
                System.out.println(indent + "Desplazando " + array[j]);
                array[j + 1] = array[j];
                j--;
                System.out.println(indent + "Estado temporal: " + Arrays.toString(array));
            }
            array[j + 1] = ultimo;
            System.out.println(indent + "Orden alterado: " + Arrays.toString(array));
            
        }
        public static void main(String[] args) {
           int[] array = {5, 2, 8, 1, 9, 3};
           int[] array2 = {5, 2, 8, 1, 9, 3};

           System.out.println("---------METODO ITERATIVO-------"); 
           InsertionSort.ordenar(array);
            System.out.println(""); 
            
            System.out.println("--------METODO RECURSIVO-------"); 
           System.out.println("Array desordenado: " + Arrays.toString(array));
           InsertionSort.ordenar(array2, array2.length, 1);
           System.out.println("Array ordenado: " + Arrays.toString(array));
        }

    }

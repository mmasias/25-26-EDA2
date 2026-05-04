package munozManuel;

class QuickSort {
    public static void ordenar(int[] array, int izquierda, int derecha, int[] profundidad) {
        if (izquierda >= derecha) {
            return;
        }
        int indicePivote = particionar(array, izquierda, derecha, profundidad[0]);
        System.out.println("--".repeat(profundidad[0])+"El indice pivote es: " + indicePivote);
        
        System.out.println("--".repeat(profundidad[0])+"Inicio de llamada recursiva a la izquierda");
        profundidad[0]++;
        ordenar(array, izquierda, indicePivote - 1, profundidad);
        profundidad[0]--;
        System.out.println("--".repeat(profundidad[0])+"Parada de llamada recursiva a la izquierda");

        
        System.out.println("--".repeat(profundidad[0])+"Inicio de llamada recursiva a la derecha");
        profundidad[0]++;
        ordenar(array, indicePivote + 1, derecha, profundidad);
        profundidad[0]--;
        System.out.println("--".repeat(profundidad[0])+"Parada de llamada recursiva a la derecha");
        
    }

    private static int particionar(int[] array, int izquierda, int derecha, int profundidad) {
        int pivote = array[derecha];
        System.out.println("--".repeat(profundidad)+"El pivote es: " + pivote);
        int i = izquierda - 1;
        System.out.println("--".repeat(profundidad)+"El valor de i es: " + i);
        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                System.out.println("--".repeat(profundidad)+"El valor de i despues de incrementar es: " + i);
                int temporal = array[i];
                System.out.println("--".repeat(profundidad)+"El valor temporal es igual a " + array[i]);
                array[i] = array[j];
                System.out.println("--".repeat(profundidad)+"El valor en la posicion " + i + " se remplazo por el valor de la posicion " + j);
                array[j] = temporal;
                System.out.println("--".repeat(profundidad)+"El valor en la posicion " + j + " se remplaza por el valor temporal " + temporal);
            }
        }
        int temporal = array[i + 1];
        System.out.println("--".repeat(profundidad)+"El valor temporal es igual a " + array[i]);
        array[i + 1] = array[derecha];
        System.out.println("--".repeat(profundidad)+"El valor en la posicion " + (i+1) + " se remplazo por el valor de la posicion " + derecha);
        array[derecha] = temporal;
        System.out.println("--".repeat(profundidad)+"El valor en la posicion " + derecha + " se remplaza por el valor temporal " + temporal);
        System.out.print("--".repeat(profundidad)+ "El array: ");
        printArray(array);
        return i + 1;
    }

    private static void printArray(int[] array){
        for (int numero : array){
            System.out.print(numero + " ");
        }
        System.out.println("");
    }
}

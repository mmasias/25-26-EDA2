import java.util.Arrays;

public class MergeSort {
    public static void ordenar(int[] array, int izquierda, int derecha, int nivel) {
        String indent = "  ".repeat(nivel);
        if (izquierda >= derecha) {
            System.out.println(indent + "-> Caso base alcanzado: [" + izquierda + "]. Elemento: " + (izquierda < array.length ? array[izquierda] : "fuera de rango"));
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        System.out.println(indent + "Dividir Rango [" + izquierda + "-" + derecha + "] en medio: " + medio);
        
        System.out.println(indent + "  Llamando mitad izquierda...");
        ordenar(array, izquierda, medio, nivel + 1);

        System.out.println(indent + "  Llamando mitad derecha...");
        ordenar(array, medio + 1, derecha, nivel + 1);
        fusionar(array, izquierda, medio, derecha, nivel);
    }

    public static void ordenarIterativo(int[] array) {
        int n = array.length;
        System.out.println("\n------- INICIO MERGE SORT ITERATIVO ----------");

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n>>> TRABAJANDO CON SUB-ARRAY DE TAMAÑO: " + tamano);
            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
                fusionar(array, izquierda, medio, derecha, 1);
            }
            System.out.println("Estado tras operación:" + tamano + ": " + Arrays.toString(array));
        }
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, int nivel) {
        String indent = "  ".repeat(nivel);
        System.out.println(indent + "┌── Fusionando: " + izquierda + " hasta " + derecha);

        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;
        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }

        System.out.println(indent + "│   Izquierda: " + Arrays.toString(mitadIzquierda) + " | Derecha: " + Arrays.toString(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;
        while (i < tamanoIzquierda && j < tamanoDerecha) {

            System.out.print(indent + "│   ¿" + mitadIzquierda[i] + " <= " + mitadDerecha[j] + "? ");
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println("Si. Tomo " + mitadIzquierda[i]);
                array[k] = mitadIzquierda[i];
                i++;
            } else {
                System.out.println("No. Tomo " + mitadDerecha[j]);
                array[k] = mitadDerecha[j];
                j++;
            }
            k++;
        }
        while (i < tamanoIzquierda) {
            System.out.println(indent + "│   Copiando restante izquierda: " + mitadIzquierda[i]);
            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }
        while (j < tamanoDerecha) {
            System.out.println(indent + "│   Copiando restante derecha: " + mitadDerecha[j]);
            array[k] = mitadDerecha[j];
            j++;
            k++;
        }
        System.out.println(indent + "└── Resultado Fusión: " + Arrays.toString(Arrays.copyOfRange(array, izquierda, derecha + 1)));
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        int[] array2 = {5, 2, 8, 1, 9, 3};
        
        System.out.println("Array desordenado: " + Arrays.toString(array));
        MergeSort.ordenar(array, 0 ,5, 1);
        System.out.println("Array ordenado: " + Arrays.toString(array));

        System.out.println("Array desordenado: " + Arrays.toString(array2));
        MergeSort.ordenarIterativo(array2);
        System.out.println("Array ordenado: " + Arrays.toString(array2));
    }

}

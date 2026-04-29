import java.util.Arrays;

public class RetoRecuperacionTrazasSimple {

    public static void main(String[] args) {

        int[] base = {5, 2, 8, 1, 9, 3};

        System.out.println("====================================");
        System.out.println("INSERTION SORT ITERATIVO");
        System.out.println("====================================");
        int[] a1 = Arrays.copyOf(base, base.length);
        insertionIterativo(a1);

        System.out.println("\n====================================");
        System.out.println("INSERTION SORT RECURSIVO");
        System.out.println("====================================");
        int[] a2 = Arrays.copyOf(base, base.length);
        System.out.println("Inicial: " + mostrar(a2));
        insertionRecursivo(a2, a2.length, 0);
        System.out.println("Final:   " + mostrar(a2));

        System.out.println("\n====================================");
        System.out.println("MERGE SORT RECURSIVO");
        System.out.println("====================================");
        int[] a3 = Arrays.copyOf(base, base.length);
        System.out.println("Inicial: " + mostrar(a3));
        mergeRecursivo(a3, 0, a3.length - 1, 0);
        System.out.println("Final:   " + mostrar(a3));

        System.out.println("\n====================================");
        System.out.println("MERGE SORT ITERATIVO");
        System.out.println("====================================");
        int[] a4 = Arrays.copyOf(base, base.length);
        mergeIterativo(a4);

        System.out.println("\n====================================");
        System.out.println("QUICK SORT");
        System.out.println("====================================");
        int[] a5 = Arrays.copyOf(base, base.length);
        System.out.println("Inicial: " + mostrar(a5));
        quickSort(a5, 0, a5.length - 1, 0);
        System.out.println("Final:   " + mostrar(a5));
    }

    private static String mostrar(int[] array) {
        return Arrays.toString(array);
    }

    private static String subarray(int[] array, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return "[]";
        }

        return Arrays.toString(Arrays.copyOfRange(array, izquierda, derecha + 1));
    }

    private static String tab(int nivel) {
        String texto = "";

        for (int i = 0; i < nivel; i++) {
            texto += "  ";
        }

        return texto;
    }

    public static void insertionIterativo(int[] array) {

        System.out.println("Inicial: " + mostrar(array));

        for (int i = 1; i < array.length; i++) {

            int actual = array[i];
            int j = i - 1;

            System.out.println("\ni = " + i + ", actual = " + actual);

            while (j >= 0 && array[j] > actual) {

                System.out.println("Comparo: " + array[j] + " > " + actual + " -> verdadero");
                System.out.println("Desplazo " + array[j] + " de posicion " + j + " a posicion " + (j + 1));

                array[j + 1] = array[j];

                System.out.println("Array: " + mostrar(array));

                j--;
            }

            if (j >= 0) {
                System.out.println("Comparo: " + array[j] + " > " + actual + " -> falso");
            } else {
                System.out.println("Fin del while: j < 0");
            }

            array[j + 1] = actual;

            System.out.println("Inserto " + actual + " en posicion " + (j + 1));
            System.out.println("Array: " + mostrar(array));
        }

        System.out.println("\nFinal:   " + mostrar(array));
    }

    public static void insertionRecursivo(int[] array, int n, int nivel) {

        String t = tab(nivel);

        System.out.println(t + "Llamada insertionRecursivo(n = " + n + ")");

        if (n <= 1) {
            System.out.println(t + "Caso base: n <= 1");
            return;
        }

        insertionRecursivo(array, n - 1, nivel + 1);

        int ultimo = array[n - 1];
        int j = n - 2;

        System.out.println(t + "Insertar ultimo = " + ultimo + " dentro de los primeros " + n + " elementos");

        while (j >= 0 && array[j] > ultimo) {

            System.out.println(t + "Comparo: " + array[j] + " > " + ultimo + " -> verdadero");
            System.out.println(t + "Desplazo " + array[j] + " de posicion " + j + " a posicion " + (j + 1));

            array[j + 1] = array[j];

            System.out.println(t + "Array: " + mostrar(array));

            j--;
        }

        if (j >= 0) {
            System.out.println(t + "Comparo: " + array[j] + " > " + ultimo + " -> falso");
        } else {
            System.out.println(t + "Fin del while: j < 0");
        }

        array[j + 1] = ultimo;

        System.out.println(t + "Inserto " + ultimo + " en posicion " + (j + 1));
        System.out.println(t + "Array: " + mostrar(array));
    }

    public static void mergeRecursivo(int[] array, int izquierda, int derecha, int nivel) {

        String t = tab(nivel);

        System.out.println(t + "Llamada mergeRecursivo(" + izquierda + ", " + derecha + ") "
                + subarray(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(t + "Caso base: izquierda >= derecha");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(t + "Divido en [" + izquierda + ", " + medio + "] y ["
                + (medio + 1) + ", " + derecha + "]");

        mergeRecursivo(array, izquierda, medio, nivel + 1);
        mergeRecursivo(array, medio + 1, derecha, nivel + 1);

        System.out.println(t + "Fusiono [" + izquierda + ", " + medio + "] con ["
                + (medio + 1) + ", " + derecha + "]");

        fusionar(array, izquierda, medio, derecha, nivel);

        System.out.println(t + "Resultado fusion: " + subarray(array, izquierda, derecha));
    }

    public static void mergeIterativo(int[] array) {

        int n = array.length;

        System.out.println("Inicial: " + mostrar(array));

        for (int tamano = 1; tamano < n; tamano *= 2) {

            System.out.println("\nTamano de bloque = " + tamano);

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {

                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Fusiono [" + izquierda + ", " + medio + "] con ["
                        + (medio + 1) + ", " + derecha + "]");

                fusionar(array, izquierda, medio, derecha, 1);

                System.out.println("Array tras fusion: " + mostrar(array));
            }
        }

        System.out.println("\nFinal:   " + mostrar(array));
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha, int nivel) {

        String t = tab(nivel);

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

        System.out.println(t + "Izquierda: " + mostrar(mitadIzquierda));
        System.out.println(t + "Derecha:   " + mostrar(mitadDerecha));

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {

            System.out.print(t + "Comparo: " + mitadIzquierda[i] + " <= " + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {

                System.out.println(" -> verdadero");
                array[k] = mitadIzquierda[i];

                System.out.println(t + "Copio " + mitadIzquierda[i] + " en posicion " + k);
                i++;

            } else {

                System.out.println(" -> falso");
                array[k] = mitadDerecha[j];

                System.out.println(t + "Copio " + mitadDerecha[j] + " en posicion " + k);
                j++;
            }

            System.out.println(t + "Array: " + mostrar(array));

            k++;
        }

        while (i < tamanoIzquierda) {

            System.out.println(t + "Sobra izquierda: copio " + mitadIzquierda[i] + " en posicion " + k);

            array[k] = mitadIzquierda[i];

            System.out.println(t + "Array: " + mostrar(array));

            i++;
            k++;
        }

        while (j < tamanoDerecha) {

            System.out.println(t + "Sobra derecha: copio " + mitadDerecha[j] + " en posicion " + k);

            array[k] = mitadDerecha[j];

            System.out.println(t + "Array: " + mostrar(array));

            j++;
            k++;
        }
    }

    public static void quickSort(int[] array, int izquierda, int derecha, int nivel) {

        String t = tab(nivel);

        System.out.println(t + "Llamada quickSort(" + izquierda + ", " + derecha + ") "
                + subarray(array, izquierda, derecha));

        if (izquierda >= derecha) {
            System.out.println(t + "Caso base: izquierda >= derecha");
            return;
        }

        int indicePivote = particionar(array, izquierda, derecha, nivel);

        System.out.println(t + "Pivote queda en posicion " + indicePivote);
        System.out.println(t + "Array: " + mostrar(array));

        quickSort(array, izquierda, indicePivote - 1, nivel + 1);
        quickSort(array, indicePivote + 1, derecha, nivel + 1);
    }

    private static int particionar(int[] array, int izquierda, int derecha, int nivel) {

        String t = tab(nivel);

        int pivote = array[derecha];
        int i = izquierda - 1;

        System.out.println(t + "Pivote = " + pivote + " en posicion " + derecha);

        for (int j = izquierda; j < derecha; j++) {

            System.out.print(t + "Comparo: array[" + j + "] = " + array[j] + " <= pivote " + pivote);

            if (array[j] <= pivote) {

                System.out.println(" -> verdadero");

                i++;

                System.out.println(t + "Intercambio posiciones " + i + " y " + j);

                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;

                System.out.println(t + "Array: " + mostrar(array));

            } else {

                System.out.println(" -> falso");
                System.out.println(t + "No se intercambia");
            }
        }

        System.out.println(t + "Coloco pivote en su posicion final");
        System.out.println(t + "Intercambio posiciones " + (i + 1) + " y " + derecha);

        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        System.out.println(t + "Array: " + mostrar(array));

        return i + 1;
    }
}
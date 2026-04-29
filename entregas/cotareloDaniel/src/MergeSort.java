public class MergeSort {

    private static int nivel;

    public static void ordenar(int[] array, int izquierda, int derecha) {
        if (izquierda == 0 && derecha == array.length - 1) {
            nivel = 0;
        }

        System.out.println(Formato.sangria(nivel) + "Llamada ordenar(array, izquierda = " + izquierda + ", derecha = " + derecha + ")");

        if (izquierda >= derecha) {
            System.out.println(Formato.sangria(nivel) + "Caso base alcanzado: izquierda >= derecha, porque el tramo tiene un solo elemento o ninguno");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        System.out.println(Formato.sangria(nivel) + "Decision: dividir con medio = " + medio);

        nivel++;
        ordenar(array, izquierda, medio);
        nivel--;

        nivel++;
        ordenar(array, medio + 1, derecha);
        nivel--;

        fusionar(array, izquierda, medio, derecha);
    }

    public static void ordenarIterativo(int[] array) {
        nivel = 0;

        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("Decision: tamano = " + tamano + " < n = " + n + " -> verdadero");

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("Decision: fusionar izquierda = " + izquierda + ", medio = " + medio + ", derecha = " + derecha);

                fusionar(array, izquierda, medio, derecha);
            }
        }

        System.out.println("Decision: tamano >= n -> termina Merge Sort iterativo");
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        System.out.println(Formato.sangria(nivel) + "Fusionar [" + izquierda + ", " + medio + "] con [" + (medio + 1) + ", " + derecha + "]");

        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;

        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];

            System.out.println(Formato.sangria(nivel) + "Modificacion: mitadIzquierda[" + i + "] recibe array[" + (izquierda + i) + "] = " + mitadIzquierda[i]);
        }

        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];

            System.out.println(Formato.sangria(nivel) + "Modificacion: mitadDerecha[" + i + "] recibe array[" + (medio + 1 + i) + "] = " + mitadDerecha[i]);
        }

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.println(Formato.sangria(nivel) + "Comparacion: mitadIzquierda[" + i + "] = " + mitadIzquierda[i] + " <= mitadDerecha[" + j + "] = " + mitadDerecha[j]);

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                System.out.println(Formato.sangria(nivel) + "Resultado: verdadero");

                array[k] = mitadIzquierda[i];

                System.out.println(Formato.sangria(nivel) + "Modificacion: array[" + k + "] recibe mitadIzquierda[" + i + "] = " + array[k]);
                System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));

                i++;
            } else {
                System.out.println(Formato.sangria(nivel) + "Resultado: falso");

                array[k] = mitadDerecha[j];

                System.out.println(Formato.sangria(nivel) + "Modificacion: array[" + k + "] recibe mitadDerecha[" + j + "] = " + array[k]);
                System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));

                j++;
            }

            k++;
        }

        while (i < tamanoIzquierda) {
            System.out.println(Formato.sangria(nivel) + "Decision: i < tamanoIzquierda -> quedan elementos en mitadIzquierda");

            array[k] = mitadIzquierda[i];

            System.out.println(Formato.sangria(nivel) + "Modificacion: array[" + k + "] recibe mitadIzquierda[" + i + "] = " + array[k]);
            System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));

            i++;
            k++;
        }

        while (j < tamanoDerecha) {
            System.out.println(Formato.sangria(nivel) + "Decision: j < tamanoDerecha -> quedan elementos en mitadDerecha");

            array[k] = mitadDerecha[j];

            System.out.println(Formato.sangria(nivel) + "Modificacion: array[" + k + "] recibe mitadDerecha[" + j + "] = " + array[k]);
            System.out.println(Formato.sangria(nivel) + "Array: " + Formato.formatear(array));

            j++;
            k++;
        }
    }
}
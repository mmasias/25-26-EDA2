public class MergeSort {
  private static int nivel = 0;

  public static void main(String[] args) {
    int[] arrayPrueba = { 5, 2, 8, 1, 9, 3 };

    System.out.println("EJECUCIÓN MERGE SORT (RECURSIVO)");
    int[] arrayRec = arrayPrueba.clone();
    imprimirEstado(arrayRec, "Estado inicial", 0);
    ordenar(arrayRec, 0, arrayRec.length - 1);
    imprimirEstado(arrayRec, "Estado final", 0);

    System.out.println();
    System.out.println("EJECUCIÓN MERGE SORT (ITERATIVO)");
    ordenarIterativo(arrayPrueba.clone());
  }

  public static void ordenar(int[] array, int izquierda, int derecha) {
    String indent = "  ".repeat(nivel);
    if (izquierda >= derecha) {
      System.out
          .println(indent + "Caso base: [" + izquierda + "] contiene un solo elemento (" + array[izquierda] + ").");
      return;
    }

    int medio = izquierda + (derecha - izquierda) / 2;
    System.out
        .println(indent + "Dividir: Izq [" + izquierda + "," + medio + "] y Der [" + (medio + 1) + "," + derecha + "]");

    nivel++;
    ordenar(array, izquierda, medio);
    ordenar(array, medio + 1, derecha);
    nivel--;

    fusionar(array, izquierda, medio, derecha);
  }

  public static void ordenarIterativo(int[] array) {
    int n = array.length;
    imprimirEstado(array, "Estado inicial iterativo", 0);
    for (int tamano = 1; tamano < n; tamano *= 2) {
      System.out.println("Procesando bloques de tamaño: " + tamano);
      for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
        int medio = izquierda + tamano - 1;
        int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
        fusionar(array, izquierda, medio, derecha);
      }
    }
    imprimirEstado(array, "Estado final iterativo", 0);
  }

  private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
    String indent = "  ".repeat(nivel);
    int tamanoIzquierda = medio - izquierda + 1;
    int tamanoDerecha = derecha - medio;
    int[] mitadIzquierda = new int[tamanoIzquierda];
    int[] mitadDerecha = new int[tamanoDerecha];

    for (int i = 0; i < tamanoIzquierda; i++)
      mitadIzquierda[i] = array[izquierda + i];
    for (int i = 0; i < tamanoDerecha; i++)
      mitadDerecha[i] = array[medio + 1 + i];

    System.out.println(indent + "Fusionando: " + java.util.Arrays.toString(mitadIzquierda) + " con "
        + java.util.Arrays.toString(mitadDerecha));

    int i = 0, j = 0, k = izquierda;
    while (i < tamanoIzquierda && j < tamanoDerecha) {
      System.out.print(indent + "  Comparar " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + ": ");
      if (mitadIzquierda[i] <= mitadDerecha[j]) {
        System.out.println("Elegir de la izquierda");
        array[k] = mitadIzquierda[i];
        i++;
      } else {
        System.out.println("Elegir de la derecha");
        array[k] = mitadDerecha[j];
        j++;
      }
      k++;
    }

    while (i < tamanoIzquierda) {
      array[k] = mitadIzquierda[i];
      i++;
      k++;
    }
    while (j < tamanoDerecha) {
      array[k] = mitadDerecha[j];
      j++;
      k++;
    }
    imprimirEstado(array, indent + "Resultado fusión [" + izquierda + "..." + derecha + "]", 0);
  }

  private static void imprimirEstado(int[] array, String mensaje, int profundidad) {
    String indent = "  ".repeat(profundidad);
    System.out.println(mensaje);
    System.out.print(indent);
    for (int val : array) {
      System.out.print("[" + val + "]");
    }
    System.out.println();
  }
}

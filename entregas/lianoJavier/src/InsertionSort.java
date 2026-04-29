public class InsertionSort {
  private static int nivel = 0;

  public static void main(String[] args) {
    int[] arrayPrueba = { 5, 2, 8, 1, 9, 3 };

    System.out.println("EJECUCIÓN INSERTION SORT (ITERATIVO)");
    ordenar(arrayPrueba.clone());

    System.out.println();
    System.out.println("EJECUCIÓN INSERTION SORT (RECURSIVO)");
    int[] arrayRec = arrayPrueba.clone();
    imprimirEstado(arrayRec, "Estado inicial", null, 0);
    ordenar(arrayRec, arrayRec.length);
    imprimirEstado(arrayRec, "Estado final", null, 0);
  }

  public static void ordenar(int[] array) {
    imprimirEstado(array, "Inicio del algoritmo iterativo", null, 0);
    for (int i = 1; i < array.length; i++) {
      int actual = array[i];
      int j = i - 1;
      imprimirEstado(array, "Seleccionado elemento " + actual + " en índice " + i, new int[] { i }, 0);

      while (j >= 0 && array[j] > actual) {
        System.out.println("  Comparación: " + array[j] + " > " + actual + " (es mayor, desplazamos)");
        array[j + 1] = array[j];
        j--;
      }
      System.out.println("  Posición encontrada: " + (j + 1));
      array[j + 1] = actual;
      imprimirEstado(array, "Array tras insertar " + actual, new int[] { j + 1 }, 0);
    }
  }

  public static void ordenar(int[] array, int n) {
    String indent = "  ".repeat(nivel);
    if (n <= 1) {
      System.out.println(indent + "Caso base alcanzado (n=" + n + "): El array de tamaño 1 ya está ordenado.");
      return;
    }

    System.out.println(indent + "Dividiendo: ordenar sub-array de tamaño " + (n - 1));
    nivel++;
    ordenar(array, n - 1);
    nivel--;

    int ultimo = array[n - 1];
    int j = n - 2;

    imprimirEstado(array, indent + "Insertando " + ultimo + " (último elemento actual)", new int[] { n - 1 }, 0);

    while (j >= 0 && array[j] > ultimo) {
      System.out.println(indent + "  Comparando " + array[j] + " > " + ultimo + " (desplazar)");
      array[j + 1] = array[j];
      j--;
    }
    array[j + 1] = ultimo;
    imprimirEstado(array, indent + "Estado tras inserción recursiva", new int[] { j + 1 }, 0);
  }

  private static void imprimirEstado(int[] array, String mensaje, int[] seleccion, int profundidad) {
    String indent = "  ".repeat(profundidad);
    System.out.println(mensaje);
    System.out.print(indent);
    for (int val : array) {
      System.out.print("[" + val + "]");
    }
    System.out.println();
    if (seleccion != null) {
      System.out.print(indent);
      for (int k = 0; k < array.length; k++) {
        boolean esSeleccionado = false;
        for (int s : seleccion)
          if (k == s)
            esSeleccionado = true;
        System.out.print(esSeleccionado ? " ^ " : "   ");
      }
      System.out.println();
    }
  }
}

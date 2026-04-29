public class QuickSort {
  private static int nivel = 0;

  public static void main(String[] args) {
    int[] arrayPrueba = { 5, 2, 8, 1, 9, 3 };

    System.out.println("EJECUCIÓN QUICK SORT");
    imprimirEstado(arrayPrueba, "Estado inicial", null, 0);
    ordenar(arrayPrueba, 0, arrayPrueba.length - 1);
    imprimirEstado(arrayPrueba, "Estado final", null, 0);
  }

  public static void ordenar(int[] array, int izquierda, int derecha) {
    String indent = "  ".repeat(nivel);
    if (izquierda >= derecha) {
      System.out.println(indent + "Caso base: Rango [" + izquierda + "," + derecha + "] es indivisible.");
      return;
    }

    System.out.println(indent + "Particionando rango [" + izquierda + "," + derecha + "]");
    int indicePivote = particionar(array, izquierda, derecha);

    System.out.println(indent + "Pivote final en posición " + indicePivote);

    nivel++;
    System.out.println(indent + "Llamada recursiva izquierda:");
    ordenar(array, izquierda, indicePivote - 1);

    System.out.println(indent + "Llamada recursiva derecha:");
    ordenar(array, indicePivote + 1, derecha);
    nivel--;
  }

  private static int particionar(int[] array, int izquierda, int derecha) {
    String indent = "  ".repeat(nivel);
    int pivote = array[derecha];
    System.out.println(indent + "  Pivote elegido: " + pivote + " (en índice " + derecha + ")");
    int i = izquierda - 1;

    for (int j = izquierda; j < derecha; j++) {
      System.out.print(indent + "    ¿" + array[j] + " <= " + pivote + "? ");
      if (array[j] <= pivote) {
        i++;
        System.out.println("Sí. Intercambio de pos " + i + " (" + array[i] + ") con pos " + j + " (" + array[j] + ")");
        int temporal = array[i];
        array[i] = array[j];
        array[j] = temporal;
      } else {
        System.out.println("No.");
      }
    }

    System.out.println(indent + "  Colocando pivote: Intercambio " + array[i + 1] + " con " + array[derecha]);
    int temporal = array[i + 1];
    array[i + 1] = array[derecha];
    array[derecha] = temporal;

    imprimirEstado(array, indent + "  Estado tras particionar:", new int[] { i + 1 }, 0);
    return i + 1;
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

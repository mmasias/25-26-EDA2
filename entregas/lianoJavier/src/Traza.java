
public class Traza {
  private static final String FLECHA_PARA_ARRIBA = "^";
  private static final String ESPACIO = " ";
  private int[] array;
  private int[] itemsSeleccionados;
  private String mensajeCabecera;

  public Traza seleccionarArray(int[] array) {
    this.array = array;
    return this;
  }

  public Traza seleccionarItem(int[] itemsSeleccionados) {
    this.itemsSeleccionados = itemsSeleccionados;
    return this;
  }

  public Traza mensajeLog(String mensaje) {
    this.mensajeCabecera = mensaje;
    return this;
  }

  public void imprimir() {
    System.out.println(mensajeCabecera);
    imprimirArray();
    if (itemsSeleccionados != null) {
      imprimirSeleccionados();
    }
    System.out.println();
  }

  private void imprimirArray() {
    for (int i = 0; i < array.length; i++) {
      System.out.print("[" + array[i] + "]");
    }
    System.out.println();
  }

  private void imprimirSeleccionados() {
    boolean hePuestoValor;
    for (int i = 0; i < array.length; i++) {
      hePuestoValor = false;
      for (int j = 0; j < itemsSeleccionados.length; j++) {
        if (i == itemsSeleccionados[j]) {
          System.out.print(ESPACIO + FLECHA_PARA_ARRIBA + ESPACIO);
          hePuestoValor = true;
        }
      }
      if (!hePuestoValor) {
        System.out.print(ESPACIO + ESPACIO + ESPACIO);
      }
    }
    System.out.println();
    for (int i = 0; i < array.length; i++) {
      hePuestoValor = false;
      for (int j = 0; j < itemsSeleccionados.length; j++) {
        if (i == itemsSeleccionados[j]) {
          System.out.print(ESPACIO + (j + 1) + ESPACIO);
          hePuestoValor = true;
        }
      }
      if (!hePuestoValor) {
        System.out.print(ESPACIO + ESPACIO + ESPACIO);
      }
    }
    System.out.println();
  }

}

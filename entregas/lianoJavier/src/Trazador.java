public class Trazador {

  private static final String COLOR_ROJO = "\u001B[31m";
  private static final String RESTAURAR_COLOR = "\u001B[0m";
  private static final String ESPACIO_IDENTACION = "  ";

  private boolean activo = false;
  private int profundidadActual = 0;
  private int contadorComparaciones = 0;

  public void activar() {
    this.activo = true;
  }

  public void incrementarProfundidad() {
    profundidadActual++;
  }

  public void decrementarProfundidad() {
    if (profundidadActual > 0) {
      profundidadActual--;
    }
  }

  public void registrarComparacion() {
    if (activo) {
      contadorComparaciones++;
    }
  }

  private void imprimirPrefijo() {
    for (int contador = 0; contador < profundidadActual; contador++) {
      System.out.print(ESPACIO_IDENTACION);
    }
  }

  public void registrarLlegada(ContextoBusqueda contexto, Posicion actual) {
    if (!activo)
      return;

    imprimirPrefijo();
    System.out.println(
        "Visitando valor " + contexto.obtenerValor(actual) + " (Buscando: " + contexto.obtenerObjetivo() + ")");
    imprimirMatriz(contexto, actual);
  }

  public void registrarDescarteMenores(ContextoBusqueda contexto, Posicion actual) {
    if (!activo)
      return;

    imprimirPrefijo();
    System.out.println("Menor que objetivo. Descartando cuadrante superior-izquierdo.");
  }

  public void registrarDescarteMayores(ContextoBusqueda contexto, Posicion actual) {
    if (!activo)
      return;

    imprimirPrefijo();
    System.out.println("Mayor que objetivo. Descartando cuadrante inferior-derecho.");
  }

  public void registrarExito(ContextoBusqueda contexto, Posicion actual) {
    if (!activo)
      return;

    imprimirPrefijo();
    System.out.println("Exito: Objetivo encontrado.");
    System.out.println("Comparaciones totales realizadas: " + contadorComparaciones);
    System.out.println("--------------------------------------------------\n");
    contadorComparaciones = 0;
  }

  public void registrarRetroceso() {
    if (!activo)
      return;

    imprimirPrefijo();
    System.out.println("Retrocediendo (Backtracking)...");
  }

  public void registrarFinSinExito() {
    if (!activo)
      return;
    System.out.println("Busqueda finalizada sin exito.");
    System.out.println("Comparaciones totales realizadas: " + contadorComparaciones);
    System.out.println("--------------------------------------------------\n");
    contadorComparaciones = 0;
  }

  private void imprimirMatriz(ContextoBusqueda contexto, Posicion actual) {
    for (int filaActual = 0; filaActual < contexto.obtenerFilas(); filaActual++) {
      imprimirPrefijo();
      for (int columnaActual = 0; columnaActual < contexto.obtenerColumnas(); columnaActual++) {
        System.out.print(formatearCasilla(contexto, filaActual, columnaActual, actual));
      }
      System.out.println();
    }
    System.out.println();
  }

  private String formatearCasilla(ContextoBusqueda contexto, int fila, int columna, Posicion actual) {
    Posicion posicionEvaluada = new Posicion(fila, columna);
    int valorNumerico = contexto.obtenerValor(posicionEvaluada);
    String textoBase = String.format("%2d", valorNumerico);

    boolean esPosicionActual = (fila == actual.getFila() && columna == actual.getColumna());
    boolean estaDescartada = contexto.estaDescartada(posicionEvaluada);

    if (esPosicionActual) {
      return (estaDescartada ? COLOR_ROJO : "") + "(" + textoBase + ")" + RESTAURAR_COLOR + " ";
    } else if (estaDescartada) {
      return COLOR_ROJO + " " + textoBase + " " + RESTAURAR_COLOR + " ";
    } else {
      return " " + textoBase + "  ";
    }
  }
}

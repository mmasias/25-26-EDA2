public class ContextoBusqueda {
  private final int[][] matriz;
  private final boolean[][] descartados;
  private final int objetivo;
  private final int filas;
  private final int columnas;

  public ContextoBusqueda(int[][] matriz, int objetivo) {
    this.matriz = matriz;
    this.objetivo = objetivo;
    this.filas = matriz.length;
    this.columnas = matriz[0].length;
    this.descartados = new boolean[filas][columnas];
  }

  public int obtenerFilas() {
    return filas;
  }

  public int obtenerColumnas() {
    return columnas;
  }

  public int obtenerObjetivo() {
    return objetivo;
  }

  public int obtenerValor(Posicion posicion) {
    return matriz[posicion.getFila()][posicion.getColumna()];
  }

  public boolean estaDescartada(Posicion posicion) {
    return descartados[posicion.getFila()][posicion.getColumna()];
  }

  public boolean esObjetivo(Posicion posicion) {
    return matriz[posicion.getFila()][posicion.getColumna()] == objetivo;
  }

  public boolean esMenorQueObjetivo(Posicion posicion) {
    return matriz[posicion.getFila()][posicion.getColumna()] < objetivo;
  }

  public void descartarMenores(Posicion posicion) {
    for (int filaActual = 0; filaActual <= posicion.getFila(); filaActual++) {
      for (int columnaActual = 0; columnaActual <= posicion.getColumna(); columnaActual++) {
        descartados[filaActual][columnaActual] = true;
      }
    }
  }

  public void descartarMayores(Posicion posicion) {
    for (int filaActual = posicion.getFila(); filaActual < filas; filaActual++) {
      for (int columnaActual = posicion.getColumna(); columnaActual < columnas; columnaActual++) {
        descartados[filaActual][columnaActual] = true;
      }
    }
  }

  public boolean sePuedeIr(Posicion posicion) {
    int filaActual = posicion.getFila();
    int columnaActual = posicion.getColumna();

    if (filaActual < 0 || filaActual >= filas || columnaActual < 0 || columnaActual >= columnas) {
      return false;
    }

    return !descartados[filaActual][columnaActual];
  }
}

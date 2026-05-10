public class Posicion {
  private final int fila;
  private final int columna;

  public Posicion(int fila, int columna) {
    this.fila = fila;
    this.columna = columna;
  }

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public Posicion diagonalInferior() {
    return new Posicion(fila + 1, columna + 1);
  }

  public Posicion derecha() {
    return new Posicion(fila, columna + 1);
  }

  public Posicion abajo() {
    return new Posicion(fila + 1, columna);
  }

  public Posicion diagonalSuperior() {
    return new Posicion(fila - 1, columna - 1);
  }

  public Posicion izquierda() {
    return new Posicion(fila, columna - 1);
  }

  public Posicion arriba() {
    return new Posicion(fila - 1, columna);
  }

  public boolean esIgualA(Posicion otra) {
    return this.fila == otra.getFila() && this.columna == otra.getColumna();
  }
}

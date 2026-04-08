public class Letra {
  private int valor;
  private char caracter;
  private boolean puedeSerCero;

  public Letra(char caracter) {
    this.caracter = caracter;
    this.valor = 0;
    this.puedeSerCero = true;
  }

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public char getCaracter() {
    return caracter;
  }

  public boolean noPuedeSerCero() {
    return !puedeSerCero;
  }

  public void prohibirCero() {
    this.puedeSerCero = false;
  }
}

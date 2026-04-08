public class NodoLetra {
  private NodoLetra hijoIzquierdo;
  private NodoLetra hijoDerecho;
  private Letra contenida;

  public NodoLetra(Letra letra) {
    this.contenida = letra;
  }

  public void insertar(Letra nueva) {
    if (esMenor(nueva)) {
      insertarIzquierda(nueva);
    } else {
      insertarDerecha(nueva);
    }
  }

  private boolean esMenor(Letra otra) {
    return otra.getCaracter() < contenida.getCaracter();
  }

  private void insertarIzquierda(Letra nueva) {
    if (hijoIzquierdo == null) {
      hijoIzquierdo = new NodoLetra(nueva);
    } else {
      hijoIzquierdo.insertar(nueva);
    }
  }

  private void insertarDerecha(Letra nueva) {
    if (hijoDerecho == null) {
      hijoDerecho = new NodoLetra(nueva);
    } else {
      hijoDerecho.insertar(nueva);
    }
  }

  public Letra buscar(char caracterBuscado) {
    if (esCoincidencia(caracterBuscado)) return contenida;
    if (debeBuscarIzquierda(caracterBuscado)) return buscarEnIzquierda(caracterBuscado);
    if (debeBuscarDerecha(caracterBuscado)) return buscarEnDerecha(caracterBuscado);
    return null;
  }

  private boolean esCoincidencia(char caracter) {
      return contenida.getCaracter() == caracter;
  }

  private boolean debeBuscarIzquierda(char caracter) {
      return hijoIzquierdo != null && caracter < contenida.getCaracter();
  }

  private boolean debeBuscarDerecha(char caracter) {
      return hijoDerecho != null && caracter > contenida.getCaracter();
  }

  private Letra buscarEnIzquierda(char caracter) {
      return hijoIzquierdo.buscar(caracter);
  }

  private Letra buscarEnDerecha(char caracter) {
      return hijoDerecho.buscar(caracter);
  }
}

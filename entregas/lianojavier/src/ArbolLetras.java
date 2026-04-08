public class ArbolLetras {
  private NodoLetra raiz;

  public void insertar(Letra letra) {
    if (raiz == null) {
      raiz = new NodoLetra(letra);
    } else {
      raiz.insertar(letra);
    }
  }

  public Letra buscar(char caracter) {
    if (raiz == null) return null;
    return raiz.buscar(caracter);
  }
}

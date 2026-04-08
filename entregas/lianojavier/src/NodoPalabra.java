public class NodoPalabra {
  private NodoPalabra siguiente;
  private Palabra palabra;

  public NodoPalabra(Palabra palabra) {
    this.palabra = palabra;
  }

  public void insertarAlFinal(Palabra nuevaPalabra) {
    if (siguiente == null) {
      siguiente = new NodoPalabra(nuevaPalabra);
    } else {
      siguiente.insertarAlFinal(nuevaPalabra);
    }
  }

  public Palabra getPalabra() {
      return palabra;
  }

  public NodoPalabra getSiguiente() {
      return siguiente;
  }
}

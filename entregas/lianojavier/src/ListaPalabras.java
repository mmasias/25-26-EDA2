public class ListaPalabras {
  private NodoPalabra nodoRaiz;

  public void insertar(Palabra palabra) {
    if (nodoRaiz == null) {
      nodoRaiz = new NodoPalabra(palabra);
    } else {
      nodoRaiz.insertarAlFinal(palabra);
    }
  }

  public int calcularSumaTotal() {
    int suma = 0;
    NodoPalabra actual = nodoRaiz;
    while (actual != null) {
        suma += actual.getPalabra().calcularValor();
        actual = actual.getSiguiente();
    }
    return suma;
  }
}

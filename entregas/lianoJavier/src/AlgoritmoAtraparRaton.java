public class AlgoritmoAtraparRaton {

  private static final int DIVISOR_MITAD = 2;
  private final Trazador trazador = new Trazador();

  public AlgoritmoAtraparRaton verbose() {
    trazador.activar();
    return this;
  }

  public boolean buscar(int[][] matriz, int objetivo) {
    assert matriz != null && matriz.length > 0 && matriz[0].length > 0;

    ContextoBusqueda contexto = new ContextoBusqueda(matriz, objetivo);
    Posicion inicio = new Posicion(matriz.length / DIVISOR_MITAD, matriz[0].length / DIVISOR_MITAD);

    assert contexto.sePuedeIr(inicio);

    boolean resultado = buscarRecursivo(contexto, inicio);

    if (!resultado) {
      trazador.registrarFinSinExito();
    }

    return resultado;
  }

  private boolean buscarRecursivo(ContextoBusqueda contexto, Posicion actual) {
    trazador.registrarLlegada(contexto, actual);

    int valorActual = contexto.obtenerValor(actual);
    int objetivo = contexto.obtenerObjetivo();

    trazador.registrarComparacion();

    if (valorActual == objetivo) {
      trazador.registrarExito(contexto, actual);
      return true;
    }

    boolean encontrado = false;

    trazador.registrarComparacion();

    if (valorActual < objetivo) {
      contexto.descartarMenores(actual);
      trazador.registrarDescarteMenores(contexto, actual);

      trazador.incrementarProfundidad();
      if (contexto.sePuedeIr(actual.diagonalInferior())) {
        encontrado = buscarRecursivo(contexto, actual.diagonalInferior());
      }
      if (!encontrado && contexto.sePuedeIr(actual.derecha())) {
        encontrado = buscarRecursivo(contexto, actual.derecha());
      }
      if (!encontrado && contexto.sePuedeIr(actual.abajo())) {
        encontrado = buscarRecursivo(contexto, actual.abajo());
      }
      trazador.decrementarProfundidad();

    } else {
      contexto.descartarMayores(actual);
      trazador.registrarDescarteMayores(contexto, actual);

      trazador.incrementarProfundidad();
      if (contexto.sePuedeIr(actual.diagonalSuperior())) {
        encontrado = buscarRecursivo(contexto, actual.diagonalSuperior());
      }
      if (!encontrado && contexto.sePuedeIr(actual.izquierda())) {
        encontrado = buscarRecursivo(contexto, actual.izquierda());
      }
      if (!encontrado && contexto.sePuedeIr(actual.arriba())) {
        encontrado = buscarRecursivo(contexto, actual.arriba());
      }
      trazador.decrementarProfundidad();
    }

    if (!encontrado) {
      trazador.registrarRetroceso();
    }

    return encontrado;
  }
}

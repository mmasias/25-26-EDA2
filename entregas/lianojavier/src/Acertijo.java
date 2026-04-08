public class Acertijo {
  public static void main(String[] args) {
    Algoritmo algoritmo = new Algoritmo();

    algoritmo.registrarSumando("SEND");
    algoritmo.registrarSumando("MORE");
    algoritmo.establecerResolucion("MONEY");

    if (algoritmo.resolver()) {
      mostrarResultado(algoritmo.getLetras());
    }
  }

  private static void mostrarResultado(Letra[] letras) {
    System.out.println("Solucion encontrada? true");
    for (Letra letra : letras) {
      System.out.println(letra.getCaracter() + ":" + letra.getValor());
    }
  }
}

class Algoritmo {
  private IndiceLetras letrasUnicas = new IndiceLetras();
  private ListaPalabras sumandos = new ListaPalabras();
  private Palabra resolucion;

  public void registrarSumando(String string) {
    Palabra palabra = new Palabra(string, letrasUnicas);
    sumandos.insertar(palabra);
  }

  public void establecerResolucion(String palabra) {
    resolucion = new Palabra(palabra, letrasUnicas);
  }

  public Letra[] getLetras() {
    return letrasUnicas.listarTodas();
  }

  private final int LETRAS_ALFABETO = 10;

  public boolean resolver() {
    boolean[] digitosUsados = new boolean[LETRAS_ALFABETO];
    return buscarAsignacionRecursiva(0, digitosUsados);
  }

  private final int[] NUMEROS_DECIMALES = { 0, 9 };

  private boolean buscarAsignacionRecursiva(int indiceActual, boolean[] usados) {
    if (hemosAsignadoTodas(indiceActual)) {
      return esEcuacionCorrecta();
    }

    Letra letraActual = getLetras()[indiceActual];

    for (int digito = NUMEROS_DECIMALES[0]; digito <= NUMEROS_DECIMALES[1]; digito++) {
      if (esDigitoValidoParaLetra(digito, letraActual, usados)) {
        asignarDigito(letraActual, digito, usados);

        if (buscarAsignacionRecursiva(indiceActual + 1, usados)) {
          return true;
        }

        deshacerAsignacion(letraActual, digito, usados);
      }
    }

    return false;
  }

  private boolean hemosAsignadoTodas(int indiceActual) {
    return indiceActual == getLetras().length;
  }

  private boolean esEcuacionCorrecta() {
    return sumandos.calcularSumaTotal() == resolucion.calcularValor();
  }

  private boolean esDigitoValidoParaLetra(int digito, Letra letra, boolean[] usados) {
    if (usados[digito]) {
      return false;
    }

    if (digito == 0 && letra.noPuedeSerCero()) {
      return false;
    }

    return true;
  }

  private void asignarDigito(Letra letra, int digito, boolean[] usados) {
    letra.setValor(digito);
    usados[digito] = true;
  }

  private void deshacerAsignacion(Letra letra, int digito, boolean[] usados) {
    letra.setValor(0);
    usados[digito] = false;
  }
}

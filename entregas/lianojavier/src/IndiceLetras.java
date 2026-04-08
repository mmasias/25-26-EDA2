public class IndiceLetras {
  private ArbolLetras arbol = new ArbolLetras();
  private Letra[] listaLetras = new Letra[10];
  private int cantidadLetras = 0;

  public void añadir(String palabra) {
    char[] caracteres = palabra.toCharArray();
    for (int i = 0; i < caracteres.length; i++) {
      procesarCaracter(caracteres[i], i == 0);
    }
  }

  private void procesarCaracter(char caracter, boolean esPrimeraLetra) {
    Letra letra = registrarSiFalta(caracter);
    if (esPrimeraLetra) {
      letra.prohibirCero();
    }
  }

  private Letra registrarSiFalta(char caracter) {
    Letra letra = arbol.buscar(caracter);
    if (letra == null) {
      letra = crearYAñadir(caracter);
    }
    return letra;
  }

  private Letra crearYAñadir(char caracter) {
    Letra nuevaLetra = new Letra(caracter);
    arbol.insertar(nuevaLetra);
    almacenarEnArray(nuevaLetra);
    return nuevaLetra;
  }

  private void almacenarEnArray(Letra letra) {
    listaLetras[cantidadLetras] = letra;
    cantidadLetras++;
  }

  public Letra conseguir(char caracter) {
      return arbol.buscar(caracter);
  }

  public Letra[] listarTodas() {
    Letra[] obtenidas = new Letra[cantidadLetras];
    for (int i = 0; i < cantidadLetras; i++) {
        obtenidas[i] = listaLetras[i];
    }
    return obtenidas;
  }
}

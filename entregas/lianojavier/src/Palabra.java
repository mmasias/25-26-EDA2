public class Palabra {
  private String palabraOriginal;
  private Letra[] letras; 

  public Palabra(String palabra, IndiceLetras indice) {
    this.palabraOriginal = palabra;
    indexarLetras(indice);
  }

  private void indexarLetras(IndiceLetras indice) {
    indice.añadir(palabraOriginal);
    recuperarReferencias(indice);
  }

  private void recuperarReferencias(IndiceLetras indice) {
    char[] caracteres = palabraOriginal.toCharArray();
    this.letras = new Letra[caracteres.length];
    for (int i = 0; i < caracteres.length; i++) {
        this.letras[i] = indice.conseguir(caracteres[i]);
    }
  }

  public int calcularValor() {
    int valorAcumulado = 0;
    for (Letra letra : letras) {
        valorAcumulado = valorAcumulado * 10 + letra.getValor();
    }
    return valorAcumulado;
  }
}

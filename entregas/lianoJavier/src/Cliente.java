public class Cliente {

  public static void main(String[] args) {
    int[][] matriz = {
        { 2, 5, 9, 14, 21 },
        { 4, 7, 11, 17, 25 },
        { 8, 12, 15, 20, 30 },
        { 13, 18, 22, 27, 35 },
        { 19, 24, 28, 33, 40 }
    };

    AlgoritmoAtraparRaton buscador = new AlgoritmoAtraparRaton().verbose();

    System.out.println(buscador.buscar(matriz, 22));
    System.out.println(buscador.buscar(matriz, 21));
    System.out.println(buscador.buscar(matriz, 16));
  }
}

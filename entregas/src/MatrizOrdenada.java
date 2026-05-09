public class MatrizOrdenada { 
    private final int[][] cuadricula; 
    private final int totalFilas; 
    private final int totalColumnas; 

    public MatrizOrdenada(int[][] matrizEntrada) { 
        
        this.cuadricula = matrizEntrada; 
        this.totalFilas = matrizEntrada.length; 
        if (matrizEntrada.length > 0) {
            this.totalColumnas = matrizEntrada[0].length;
        } else {
            this.totalColumnas = 0;
        }
    } 

    public int getFilas() { 
        return totalFilas; 
    } 

    public int getColumnas() { 
        return totalColumnas; 
    } 

    public int obtenerValor(int f, int c) { 
        return cuadricula[f][c]; 
    } 

    public void mostrarMatriz() { 

        for (int i = 0; i < totalFilas; i++) { 
            for (int j = 0; j < totalColumnas; j++) { 
                System.out.printf("%5d", cuadricula[i][j]); 
            } 
            System.out.println(); 
        } 
    } 
}
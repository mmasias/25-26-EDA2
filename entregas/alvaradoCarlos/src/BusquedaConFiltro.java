public class BusquedaConFiltro {

    public static boolean buscar(int[][] matriz, int k) {

        if (matriz == null || matriz.length == 0) {
            return false;
        }

        int columnas = matriz[0].length;

        for (int i = 0; i < matriz.length; i++) {
            int primero = matriz[i][0];
            int ultimo = matriz[i][columnas - 1];

            if (k == primero || k == ultimo) {
                return true;
            }

            if (k < primero || k > ultimo) {
                continue;
            }

            int izq = 0;
            int der = columnas - 1;

            while (izq <= der) {
                int medio = izq + (der - izq) / 2;
                
                if (matriz[i][medio] == k) {
                    return true;
                }
                
                if (matriz[i][medio] < k) {
                    izq = medio + 1;
                } else {
                    der = medio - 1;
                }
            }
        }
        
        return false;
    }
}
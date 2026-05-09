public class BusquedaPorEliminacion { 

    // Renombramos la clase interna y sus atributos
    public static class Informe { 
        public final boolean exito; 
        public final int posFila; 
        public final int posColumna; 
        public final int pasosTotales; 

        public Informe(boolean exito, int posFila, int posColumna, int pasosTotales) { 
            this.exito = exito; 
            this.posFila = posFila; 
            this.posColumna = posColumna; 
            this.pasosTotales = pasosTotales; 
        } 

        @Override 
        public String toString() { 
            if (exito) { 
                return "HALLADO en la coordenada [" + posFila + "][" + posColumna + "] tras " + pasosTotales + " iteraciones."; 
            } 
            return "NO HALLADO. Total de comparaciones realizadas: " + pasosTotales; 
        } 
    } 

    // Renombramos el método y cambiamos la forma de mostrar la traza
    public static Informe ejecutarBusqueda(MatrizOrdenada mat, int objetivo) { 
        int f = 0; 
        int c = mat.getColumnas() - 1; 
        int contador = 0; 

        System.out.println("\n>> Iniciando búsqueda del valor: " + objetivo); 

        while (f < mat.getFilas() && c >= 0) { 
            int valorActual = mat.obtenerValor(f, c); 
            contador++; 

            if (valorActual == objetivo) { 
                System.out.printf("  Intento %d: Evalúa (F%d, C%d) = %d -> ¡Coincidencia!%n", 
                        contador, f, c, valorActual); 
                return new Informe(true, f, c, contador); 
            } else if (valorActual < objetivo) { 
                System.out.printf("  Intento %d: Evalúa (F%d, C%d) = %d -> %d es menor que %d, descartamos fila.%n", 
                        contador, f, c, valorActual, valorActual, objetivo); 
                f++; 
            } else { 
                System.out.printf("  Intento %d: Evalúa (F%d, C%d) = %d -> %d es mayor que %d, descartamos columna.%n", 
                        contador, f, c, valorActual, valorActual, objetivo); 
                c--; 
            } 
        } 

        System.out.println("  [Búsqueda finalizada sin éxito: límites excedidos]"); 
        return new Informe(false, -1, -1, contador); 
    } 

    public static int calcularMejorCaso() { 
        return 1; 
    } 

    public static int calcularPeorCaso(int filas, int columnas) { 
        return filas + columnas - 1; 
    } 
}
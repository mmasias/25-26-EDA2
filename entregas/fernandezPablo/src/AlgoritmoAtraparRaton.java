public class AlgoritmoAtraparRaton {

    private final Rastreador rastreador = new Rastreador();

    public AlgoritmoAtraparRaton verbose() {
        rastreador.activar();
        return this;
    }

    public boolean buscar(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        EstadoBusqueda estado = new EstadoBusqueda(matriz, objetivo);
        Posicion inicio = new Posicion(matriz.length / 2, matriz[0].length / 2);

        rastreador.log("=== INICIANDO BÚSQUEDA DEL RATÓN (" + objetivo + ") ===");
        
        boolean resultado = cazarRecursivo(estado, inicio.getFila(), inicio.getColumna());

        if (resultado) {
            rastreador.log("¡ÉXITO! Ratón " + objetivo + " atrapado.");
        } else {
            rastreador.log("El ratón no está en la matriz.");
        }
        rastreador.log("Comparaciones totales: " + estado.getComparaciones() + "\n");

        return resultado;
    }

    private boolean cazarRecursivo(EstadoBusqueda estado, int f, int c) {
        if (estado.esInvalidaOVisitada(f, c)) {
            return false;
        }

        estado.marcarComoVisitada(f, c);
        int valorActual = estado.getValor(f, c);
        
        rastreador.log("Visitando valor " + valorActual);

        estado.contarComparacion();
        if (valorActual == estado.getObjetivo()) {
            return true;
        }

        boolean encontrado = false;
        estado.contarComparacion();
        rastreador.profundizar();

        if (valorActual < estado.getObjetivo()) {
            rastreador.log("Menor que objetivo. Descartando zona superior-izquierda.");
            estado.descartarMenores(f, c);

            encontrado = cazarRecursivo(estado, f + 1, c + 1) || 
                         cazarRecursivo(estado, f, c + 1) || 
                         cazarRecursivo(estado, f + 1, c);
        } else {
            rastreador.log("Mayor que objetivo. Descartando zona inferior-derecha.");
            estado.descartarMayores(f, c);

            encontrado = cazarRecursivo(estado, f - 1, c - 1) || 
                         cazarRecursivo(estado, f, c - 1) || 
                         cazarRecursivo(estado, f - 1, c);
        }

        rastreador.retroceder();

        if (!encontrado) {
            rastreador.log("Camino sin salida. Backtracking...");
        }

        return encontrado;
    }
}
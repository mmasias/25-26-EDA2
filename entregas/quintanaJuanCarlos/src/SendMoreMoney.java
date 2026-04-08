public class SendMoreMoney {

    private static final int S = 0;
    private static final int E = 1;
    private static final int N = 2;
    private static final int D = 3;
    private static final int M = 4;
    private static final int O = 5;
    private static final int R = 6;
    private static final int Y = 7;

    private static final char[] NOMBRES = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};

    private final int[] asignacion = new int[8];
    private final boolean[] usado = new boolean[10];

    public SendMoreMoney() {
        for (int i = 0; i < asignacion.length; i++) {
            asignacion[i] = -1;
        }

        asignacion[M] = 1;
        usado[1] = true;
    }

    public boolean resolver() {
        return resolverColumna(0, 0);
    }

    private boolean resolverColumna(int columna, int acarreo) {
        if (columna == 0) {
            return resolverUnidades(acarreo);
        }
        if (columna == 1) {
            return resolverDecenas(acarreo);
        }
        if (columna == 2) {
            return resolverCentenas(acarreo);
        }
        if (columna == 3) {
            return resolverMillares(acarreo);
        }
        return resolverAcarreoFinal(acarreo);
    }

    private boolean resolverUnidades(int acarreo) {
        for (int d = 0; d <= 9; d++) {
            if (!asignar(D, d)) {
                continue;
            }

            for (int e = 0; e <= 9; e++) {
                if (!asignar(E, e)) {
                    continue;
                }

                int suma = asignacion[D] + asignacion[E] + acarreo;
                int y = suma % 10;
                int nuevoAcarreo = suma / 10;

                if (asignar(Y, y)) {
                    if (resolverColumna(1, nuevoAcarreo)) {
                        return true;
                    }
                    desasignar(Y, y);
                }

                desasignar(E, e);
            }

            desasignar(D, d);
        }
        return false;
    }

    private boolean resolverDecenas(int acarreo) {
        for (int n = 0; n <= 9; n++) {
            if (!asignar(N, n)) {
                continue;
            }

            for (int r = 0; r <= 9; r++) {
                if (!asignar(R, r)) {
                    continue;
                }

                int suma = asignacion[N] + asignacion[R] + acarreo;
                int resultado = suma % 10;
                int nuevoAcarreo = suma / 10;

                if (asignacion[E] == resultado) {
                    if (resolverColumna(2, nuevoAcarreo)) {
                        return true;
                    }
                }

                desasignar(R, r);
            }

            desasignar(N, n);
        }
        return false;
    }

    private boolean resolverCentenas(int acarreo) {
        for (int o = 0; o <= 9; o++) {
            if (!asignar(O, o)) {
                continue;
            }

            int suma = asignacion[E] + asignacion[O] + acarreo;
            int resultado = suma % 10;
            int nuevoAcarreo = suma / 10;

            if (asignacion[N] == resultado) {
                if (resolverColumna(3, nuevoAcarreo)) {
                    return true;
                }
            }

            desasignar(O, o);
        }
        return false;
    }

    private boolean resolverMillares(int acarreo) {
        for (int s = 1; s <= 9; s++) {
            if (!asignar(S, s)) {
                continue;
            }

            int suma = asignacion[S] + asignacion[M] + acarreo;
            int resultado = suma % 10;
            int nuevoAcarreo = suma / 10;

            if (asignacion[O] == resultado) {
                if (resolverColumna(4, nuevoAcarreo)) {
                    return true;
                }
            }

            desasignar(S, s);
        }
        return false;
    }

    private boolean resolverAcarreoFinal(int acarreo) {
        if (acarreo == asignacion[M]) {
            mostrarSolucion();
            return true;
        }
        return false;
    }

    private boolean asignar(int letra, int digito) {
        if ((letra == S || letra == M) && digito == 0) {
            return false;
        }

        if (asignacion[letra] != -1) {
            return asignacion[letra] == digito;
        }

        if (usado[digito]) {
            return false;
        }

        asignacion[letra] = digito;
        usado[digito] = true;
        return true;
    }

    private void desasignar(int letra, int digito) {
        if (letra == M) {
            return;
        }

        if (asignacion[letra] == digito) {
            asignacion[letra] = -1;
            usado[digito] = false;
        }
    }

    private int construirSEND() {
        return asignacion[S] * 1000
                + asignacion[E] * 100
                + asignacion[N] * 10
                + asignacion[D];
    }

    private int construirMORE() {
        return asignacion[M] * 1000
                + asignacion[O] * 100
                + asignacion[R] * 10
                + asignacion[E];
    }

    private int construirMONEY() {
        return asignacion[M] * 10000
                + asignacion[O] * 1000
                + asignacion[N] * 100
                + asignacion[E] * 10
                + asignacion[Y];
    }

    private void mostrarSolucion() {
        System.out.println("Solución encontrada:");
        for (int i = 0; i < asignacion.length; i++) {
            System.out.println(NOMBRES[i] + " = " + asignacion[i]);
        }

        System.out.println();
        System.out.println(construirSEND() + " + " + construirMORE() + " = " + construirMONEY());
    }

    public static void main(String[] args) {
        SendMoreMoney problema = new SendMoreMoney();
        if (!problema.resolver()) {
            System.out.println("No se encontró solución.");
        }
    }
}
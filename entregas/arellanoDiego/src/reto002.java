public class reto002 {

    // Arreglo para guardar el dígito asignado a cada letra.
    // Índices: 0=S, 1=E, 2=N, 3=D, 4=M, 5=O, 6=R, 7=Y
    private static int[] valoresAsignados = new int[8];
    
    // Arreglo para marcar qué dígitos del 0 al 9 ya están en uso
    private static boolean[] digitosUsados = new boolean[10];

    public static void main(String[] args) {
        System.out.println("Buscando solución para SEND + MORE = MONEY...\n");
        
        // Empezamos buscando asignar un valor a la primera letra (índice 0, que es la 'S')
        if (resolver(0)) {
            System.out.println("¡Solución encontrada!");
            imprimirResultado();
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    // Función recursiva de backtracking
    // El argumento 'indiceLetra' nos dice qué letra (del 0 al 7) estamos evaluando
    private static boolean resolver(int indiceLetra) {
        
        // Caso Base: Ya asignamos un dígito a las 8 letras (índices del 0 al 7)
        if (indiceLetra == 8) {
            return ecuacionCorrecta();
        }

        // Probamos todos los dígitos del 0 al 9 para la letra actual
        for (int digito = 0; digito <= 9; digito++) {
            
            // Verificamos si este dígito está libre
            if (!digitosUsados[digito]) {
                
                // Regla: Las letras 'S' (índice 0) y 'M' (índice 4) no pueden ser cero
                if (digito == 0 && (indiceLetra == 0 || indiceLetra == 4)) {
                    continue; // Saltamos a la siguiente iteración
                }

                // 1. Asignamos el valor y lo marcamos como usado
                valoresAsignados[indiceLetra] = digito;
                digitosUsados[digito] = true;

                // 2. Llamada recursiva para la siguiente letra
                if (resolver(indiceLetra + 1)) {
                    return true; // Si el camino funciona, propagamos el éxito hacia arriba
                }

                // 3. Backtracking: Deshacemos la jugada porque el camino falló
                digitosUsados[digito] = false;
                // No es estrictamente necesario borrar el valor de valoresAsignados
                // porque se sobrescribirá en la siguiente iteración válida.
            }
        }

        // Si probamos los 10 números y ninguno sirvió, este camino no es válido
        return false;
    }

    // Función auxiliar para comprobar matemáticamente la suma
    private static boolean ecuacionCorrecta() {
        // Obtenemos los valores individuales de las letras
        int S = valoresAsignados[0];
        int E = valoresAsignados[1];
        int N = valoresAsignados[2];
        int D = valoresAsignados[3];
        int M = valoresAsignados[4];
        int O = valoresAsignados[5];
        int R = valoresAsignados[6];
        int Y = valoresAsignados[7];

        // Construimos los números completos
        int send  = (S * 1000) + (E * 100) + (N * 10) + D;
        int more  = (M * 1000) + (O * 100) + (R * 10) + E;
        int money = (M * 10000) + (O * 1000) + (N * 100) + (E * 10) + Y;

        // Validamos la ecuación
        return (send + more == money);
    }

    // Imprime la suma en formato visual
    private static void imprimirResultado() {
        int S = valoresAsignados[0];
        int E = valoresAsignados[1];
        int N = valoresAsignados[2];
        int D = valoresAsignados[3];
        int M = valoresAsignados[4];
        int O = valoresAsignados[5];
        int R = valoresAsignados[6];
        int Y = valoresAsignados[7];

        int send  = (S * 1000) + (E * 100) + (N * 10) + D;
        int more  = (M * 1000) + (O * 100) + (R * 10) + E;
        int money = (M * 10000) + (O * 1000) + (N * 100) + (E * 10) + Y;

        System.out.printf("   %d\n", send);
        System.out.printf(" + %d\n", more);
        System.out.println("  ---------");
        System.out.printf("  %d\n\n", money);

        System.out.println("Valores:");
        System.out.println("S = " + S + ", E = " + E + ", N = " + N + ", D = " + D);
        System.out.println("M = " + M + ", O = " + O + ", R = " + R + ", Y = " + Y);
    }
}
public class reto002 {

    
    private static int[] valoresAsignados = new int[8];
    
    private static boolean[] digitosUsados = new boolean[10];

    public static void main(String[] args) {
        System.out.println("Buscando solución para SEND + MORE = MONEY...\n");
        
        if (resolver(0)) {
            System.out.println("¡Solución encontrada!");
            imprimirResultado();
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    private static boolean resolver(int indiceLetra) {
        
        if (indiceLetra == 8) {
            return ecuacionCorrecta();
        }

        for (int digito = 0; digito <= 9; digito++) {
            
            if (!digitosUsados[digito]) {
                
                if (digito == 0 && (indiceLetra == 0 || indiceLetra == 4)) {
                    continue;
                }

                valoresAsignados[indiceLetra] = digito;
                digitosUsados[digito] = true;

                if (resolver(indiceLetra + 1)) {
                    return true; 
                }

                digitosUsados[digito] = false;
            }
        }

        return false;
    }

    private static boolean ecuacionCorrecta() {
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

        return (send + more == money);
    }

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
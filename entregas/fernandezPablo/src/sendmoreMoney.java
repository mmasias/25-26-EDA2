public class sendmoreMoney {

    static int[] valores = new int[8];
    static boolean[] usados = new boolean[10];

    public static void main(String[] args) {
        System.out.println("Buscando solución para SEND + MORE = MONEY...\n");
        if (!resolver(0)) {
            System.out.println("No se encontró solución.");
        }
    }

    static boolean resolver(int indiceLetra) {
        if (indiceLetra == 8) {
            return comprobarSuma();
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (!usados[digito]) {
                
                valores[indiceLetra] = digito;
                usados[digito] = true;

                if (resolver(indiceLetra + 1)) {
                    return true;
                }

                usados[digito] = false;
            }
        }
        
        return false;
    }

    static boolean comprobarSuma() {
        int S = valores[0];
        int E = valores[1];
        int N = valores[2];
        int D = valores[3];
        int M = valores[4];
        int O = valores[5];
        int R = valores[6];
        int Y = valores[7];

        if (S == 0 || M == 0) {
            return false;
        }

        int send =  S * 1000 + E * 100 + N * 10 + D;
        int more =  M * 1000 + O * 100 + R * 10 + E;
        int money = M * 10000 + O * 1000 + N * 100 + E * 10 + Y;

        if (send + more == money) {
            System.out.println("¡Solución encontrada!");
            System.out.println("  " + send + " (SEND)");
            System.out.println("+ " + more + " (MORE)");
            System.out.println("-------");
            System.out.println(" " + money + " (MONEY)");
            return true;
        }

        return false;
    }
}
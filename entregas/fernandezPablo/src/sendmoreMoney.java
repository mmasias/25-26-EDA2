public class sendmoreMoney {

    static int S, E, N, D, M, O, R, Y;
    
    static boolean[] usado = new boolean[10];

    public static void main(String[] args) {
        System.out.println("Buscando solución...\n");
        resolver(0);
    }

    static boolean resolver(int paso) {
        
        if (paso == 8) {
            if (S == 0 || M == 0) return false;

            int send = S * 1000 + E * 100 + N * 10 + D;
            int more = M * 1000 + O * 100 + R * 10 + E;
            int money = M * 10000 + O * 1000 + N * 100 + E * 10 + Y;

            if (send + more == money) {
                System.out.println("  " + send);
                System.out.println("+ " + more);
                System.out.println("-------");
                System.out.println(" " + money);
                return true;
            }
            return false;
        }

        for (int digito = 0; digito <= 9; digito++) {
            if (!usado[digito]) {
                
                usado[digito] = true;
                
                if      (paso == 0) S = digito;
                else if (paso == 1) E = digito;
                else if (paso == 2) N = digito;
                else if (paso == 3) D = digito;
                else if (paso == 4) M = digito;
                else if (paso == 5) O = digito;
                else if (paso == 6) R = digito;
                else if (paso == 7) Y = digito;

                if (resolver(paso + 1)) {
                    return true; 
                }

                usado[digito] = false;
            }
        }
        
        return false;
    }
}
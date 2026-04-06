public class SendMoreMoney {

    
    static char[] letras = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
    
    static int[] valores = new int[8];
    
    static boolean[] usado = new boolean[10];

    public static void main(String[] args) {
        System.out.println("Buscando la solución...\n");
        
        resolver(0);
    }

   
    static boolean resolver(int indice) {
     
        if (indice == 8) {
            return comprobarSuma(); 
        }

        
        for (int digito = 0; digito <= 9; digito++) {
        
            if (!usado[digito]) {
                valores[indice] = digito; // Asignamos el dígito
                usado[digito] = true;     // Lo marcamos como "usado"

             
                if (resolver(indice + 1)) {
                    return true;
                }

           
                usado[digito] = false;
            }
        }
        
        
        return false;
    }

    
    static boolean comprobarSuma() {
        int s = valores[0];
        int e = valores[1];
        int n = valores[2];
        int d = valores[3];
        int m = valores[4];
        int o = valores[5];
        int r = valores[6];
        int y = valores[7];

        
        if (s == 0 || m == 0) {
            return false;
        }

        
        int send  = (s * 1000) + (e * 100) + (n * 10) + d;
        int more  = (m * 1000) + (o * 100) + (r * 10) + e;
        int money = (m * 10000) + (o * 1000) + (n * 100) + (e * 10) + y;

       
        if (send + more == money) {
            System.out.println("¡Solución encontrada!\n");
            System.out.println("  " + send);
            System.out.println("+ " + more);
            System.out.println("-------");
            System.out.println(" " + money);
            
            System.out.println("\nValores de cada letra:");
            for (int i = 0; i < 8; i++) {
                System.out.println(letras[i] + " = " + valores[i]);
            }
            return true;
        }
        
        return false;
    }
}
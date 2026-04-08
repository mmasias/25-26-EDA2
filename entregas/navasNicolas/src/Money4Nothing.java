public class Money4Nothing {
    
    static boolean[] used = new boolean[10];
    
    static int[] values = new int[256];

    public static final char[] LETTERS = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};

    public static void main(String[] args) {
        System.out.println("  SEND \n+ MORE \n------ \n MONEY\n");
        System.out.println("Iniciando la búsqueda con Poda (M = 1)...\n");

        values['M'] = 1;
        used[1] = true; 

        if (!resolver(0)) {
            System.out.println("No se encontró solución.");
        }
    }

    static boolean resolver(int indice) {
        if (indice == LETTERS.length) {
            return verificarSuma();
        }

        char caracterActual = LETTERS[indice];

        if (caracterActual == 'M') {
            return resolver(indice + 1);
        }

        for (int digit = 0; digit <= 9; digit++) {
            
            if (digit == 0 && caracterActual == 'S') {
                continue; 
            }

            if (!used[digit]) {
                
                used[digit] = true;
                values[caracterActual] = digit;

                if (resolver(indice + 1)) {
                    return true; 
                }

                used[digit] = false;
            }
        }

        return false; 
    }

    static boolean verificarSuma() {
        int send = values['S'] * 1000 + values['E'] * 100 + values['N'] * 10 + values['D'];
        int more = values['M'] * 1000 + values['O'] * 100 + values['R'] * 10 + values['E'];
        int money = values['M'] * 10000 + values['O'] * 1000 + values['N'] * 100 + values['E'] * 10 + values['Y'];

        if (send + more == money) {
            System.out.println("¡Solución Encontrada!");
            System.out.println("  " + send);
            System.out.println("+ " + more);
            System.out.println("-------");
            System.out.println(" " + money);
            return true;
        }
        return false;
    }
}

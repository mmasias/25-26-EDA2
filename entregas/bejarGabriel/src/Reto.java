public class Reto {
    static boolean[] used = new boolean[10];
    
    static int[] values = new int[256];

    public static final char[] LETTERS_1 = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
    
    static boolean resolve(char[] letters, int indice, int option) {
        if (indice == letters.length) {
            return verifySum(option);
        }

        char caracterActual = letters[indice];

        for (int digit = 0; digit <= 9; digit++) {
            boolean esCeroInvalido = (digit == 0) && ((option == 1 && (caracterActual == 'S' || caracterActual == 'M')));
        
            if (!esCeroInvalido && !used[digit]) {
                used[digit] = true;
                values[caracterActual] = digit;
            
                if (resolve(letters, indice + 1, option)) {
                    return true;
                }
            
                used[digit] = false;
            }
        }

        return false;
    }

    static boolean verifySum(int option) {
        if (option == 1) {
            int send = values['S'] * 1000 + values['E'] * 100 + values['N'] * 10 + values['D'];
            int more = values['M'] * 1000 + values['O'] * 100 + values['R'] * 10 + values['E'];
            int money = values['M'] * 10000 + values['O'] * 1000 + values['N'] * 100 + values['E'] * 10 + values['Y'];

            if (send + more == money) {
                System.out.println("Resultado: " + send + " + " + more + " = " + money);
                return true;
            }
        } 
        return false;
    }

    public static void main(String[] args) {
        
        System.out.println("Iniciando la búsqueda...\n");

        used = new boolean[10];
        if (!resolve(LETTERS_1, 0, 1)) System.out.println("No se encontró solución para el caso 1.");
    }

}
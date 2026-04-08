import java.util.Arrays;

public class RetoIterativo {
    static int[] values = new int[256];
    static boolean[] used = new boolean[10];

    public static final char[] LETTERS_1 = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};

    static void solveIterative(char[] letters, int puzzleOption) {
        int totalLetters = letters.length;
        int[] currentDigits = new int[totalLetters]; 
        Arrays.fill(currentDigits, -1);
        Arrays.fill(used, false);
        
        int currentIndex = 0; 
        
        while (currentIndex >= 0) {
            if (currentDigits[currentIndex] != -1) {
                used[currentDigits[currentIndex]] = false;
            }

            boolean isDigitFound = false;
            
            for (int candidateDigit = currentDigits[currentIndex] + 1; candidateDigit <= 9 && !isDigitFound; candidateDigit++) {
                if (!used[candidateDigit] && !isInvalidZero(letters[currentIndex], candidateDigit, puzzleOption)) {
                    currentDigits[currentIndex] = candidateDigit;
                    values[letters[currentIndex]] = candidateDigit;
                    used[candidateDigit] = true;
                    isDigitFound = true;
                }
            }

            if (isDigitFound) {
                if (currentIndex == totalLetters - 1) {
                    if (verifySum(puzzleOption)) return; 
                } else {
                    currentIndex++;
                    currentDigits[currentIndex] = -1;
                }
            } else {
                currentDigits[currentIndex] = -1;
                currentIndex--;
            }
        }
        System.out.println("No se encontró solución para el caso " + puzzleOption + ".");
    }

    static boolean isInvalidZero(char currentLetter, int candidateDigit, int puzzleOption) {
        if (candidateDigit != 0) return false;
        
        return switch (puzzleOption) {
            case 1 -> (currentLetter == 'S' || currentLetter == 'M');
            case 2 -> (currentLetter == 'F' || currentLetter == 'T' || currentLetter == 'S');
            case 3 -> (currentLetter == 'O' || currentLetter == 'E');
            default -> false;
        };
    }

    static boolean verifySum(int puzzleOption) {
        if (puzzleOption == 1) {
            int send = values['S'] * 1000 + values['E'] * 100 + values['N'] * 10 + values['D'];
            int more = values['M'] * 1000 + values['O'] * 100 + values['R'] * 10 + values['E'];
            int money = values['M'] * 10000 + values['O'] * 1000 + values['N'] * 100 + values['E'] * 10 + values['Y'];
            
            if (send + more == money) {
                System.out.println("Resolución: " + send + " + " + more + " = " + money);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Iniciando búsqueda iterativa...\n");
        solveIterative(LETTERS_1, 1);
    }
}
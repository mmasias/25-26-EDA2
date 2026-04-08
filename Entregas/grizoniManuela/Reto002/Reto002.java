import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reto002 {

    public static void main(String[] args) {
        System.out.println("=== Reto 002: Criptoaritmética ===\n");

        System.out.println("1) S E N D + M O R E = M O N E Y");
        solveCryptarithmetic(new String[] { "SEND", "MORE" }, "MONEY");

        System.out.println("\n2) F O R T Y + T E N + T E N = S I X T Y");
        solveCryptarithmetic(new String[] { "FORTY", "TEN", "TEN" }, "SIXTY");

        System.out.println("\n3) O D D + O D D = E V E N");
        solveCryptarithmetic(new String[] { "ODD", "ODD" }, "EVEN");
    }

    public static void solveCryptarithmetic(String[] operands, String result) {
        List<Character> uniqueLetters = new ArrayList<>();
        Map<Character, Integer> letterToDigit = new HashMap<>();

        for (String operand : operands) {
            for (char c : operand.toCharArray()) {
                if (!uniqueLetters.contains(c)) {
                    uniqueLetters.add(c);
                }
            }
        }

        for (char c : result.toCharArray()) {
            if (!uniqueLetters.contains(c)) {
                uniqueLetters.add(c);
            }
        }

        if (uniqueLetters.size() > 10) {
            System.out.println("Demasiadas letras únicas (máximo 10 permitidas por los 10 dígitos disponibles).");
            return;
        }

        boolean[] usedDigits = new boolean[10];
        boolean found = solveRecursive(uniqueLetters, 0, letterToDigit, usedDigits, operands, result);

        if (!found) {
            System.out.println("No se encontró solución válida para esta ecuación.");
        }
    }

    private static boolean solveRecursive(List<Character> letters, int index,
            Map<Character, Integer> assign,
            boolean[] used,
            String[] operands, String result) {
        if (index == letters.size()) {
            return isValid(assign, operands, result);
        }

        char currentLetter = letters.get(index);

        for (int digit = 0; digit <= 9; digit++) {
            if (!used[digit]) {
                assign.put(currentLetter, digit);
                used[digit] = true;

                if (solveRecursive(letters, index + 1, assign, used, operands, result)) {
                    return true;
                }

                used[digit] = false;
                assign.remove(currentLetter);
            }
        }

        return false;
    }

    private static boolean isValid(Map<Character, Integer> assign, String[] operands, String result) {
        for (String operand : operands) {
            if (operand.length() > 1 && assign.get(operand.charAt(0)) == 0) {
                return false;
            }
        }
        if (result.length() > 1 && assign.get(result.charAt(0)) == 0) {
            return false;
        }

        long sum = 0;
        for (String operand : operands) {
            sum += wordToNumber(operand, assign);
        }

        long resultNum = wordToNumber(result, assign);

        if (sum == resultNum) {
            printSolution(assign, operands, result);
            return true;
        }

        return false;
    }

    private static long wordToNumber(String word, Map<Character, Integer> assign) {
        long num = 0;
        for (char c : word.toCharArray()) {
            num = num * 10 + assign.get(c);
        }
        return num;
    }

    private static void printSolution(Map<Character, Integer> assign, String[] operands, String result) {
        System.out.println("Solución encontrada:");
        for (Map.Entry<Character, Integer> entry : assign.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + "  ");
        }
        System.out.println("\n");

        int maxLength = result.length();
        for (int i = 0; i < operands.length; i++) {
            String op = operands[i];
            long num = wordToNumber(op, assign);
            String prefix = (i == operands.length - 1) ? "+ " : "  ";
            System.out.printf("%s%" + maxLength + "d  (%s)\n", prefix, num, op);
        }

        System.out.print("  ");
        for (int i = 0; i < maxLength; i++)
            System.out.print("-");
        System.out.println();

        long resNum = wordToNumber(result, assign);
        System.out.printf("  %" + maxLength + "d  (%s)\n", resNum, result);
    }
}

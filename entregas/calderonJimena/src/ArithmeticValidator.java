import java.util.*;

public class ArithmeticValidator {

    public static long convertWordToNumber(String word, Map<Character, Integer> letterToDigitMapping) {
        long numericAccumulator = 0;
        for (char currentChar : word.toCharArray()) {
            if (!letterToDigitMapping.containsKey(currentChar)) return -1;
            numericAccumulator = numericAccumulator * 10 + letterToDigitMapping.get(currentChar);
        }
        return numericAccumulator;
    }

    public static boolean validateEquation(String[] leftSideWords, String rightSideWord, Map<Character, Integer> letterToDigitMapping) {
        long totalLeftSum = 0;
        for (String currentWord : leftSideWords) {
            long numericValue = convertWordToNumber(currentWord, letterToDigitMapping);
            if (numericValue == -1) return true;
            totalLeftSum += numericValue;
        }
        long rightSideNumericValue = convertWordToNumber(rightSideWord, letterToDigitMapping);
        return rightSideNumericValue == -1 || totalLeftSum == rightSideNumericValue;
    }

    public static boolean shouldPruneBranchEarly(String[] leftSideWords, String rightSideWord, Map<Character, Integer> letterToDigitMapping) {
        for (String currentWord : leftSideWords) {
            for (char currentChar : currentWord.toCharArray()) {
                if (!letterToDigitMapping.containsKey(currentChar)) return false;
            }
        }
        for (char currentChar : rightSideWord.toCharArray()) {
            if (!letterToDigitMapping.containsKey(currentChar)) return false;
        }
        return !validateEquation(leftSideWords, rightSideWord, letterToDigitMapping);
    }
}
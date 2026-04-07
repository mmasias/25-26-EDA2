import java.util.*;

public class BacktrackingEngine {

    private final char[] uniqueLetterSequence;
    private final int[] currentDigitAssignments;
    private final boolean[] isDigitOccupied;
    private final Map<Character, Integer> letterToDigitMapping;
    private final Set<Character> nonZeroLeadingLetters;
    private final String[] leftSideWords;
    private final String rightSideWord;

    public BacktrackingEngine(char[] uniqueLetterSequence, Set<Character> nonZeroLeadingLetters, 
                              String[] leftSideWords, String rightSideWord) {
        this.uniqueLetterSequence = uniqueLetterSequence;
        this.nonZeroLeadingLetters = nonZeroLeadingLetters;
        this.leftSideWords = leftSideWords;
        this.rightSideWord = rightSideWord;
        this.currentDigitAssignments = new int[uniqueLetterSequence.length];
        this.isDigitOccupied = new boolean[10];
        this.letterToDigitMapping = new HashMap<>();
    }

    public boolean executeBacktracking(int currentLetterIndex) {
        if (currentLetterIndex == uniqueLetterSequence.length) {
            return ArithmeticValidator.validateEquation(leftSideWords, rightSideWord, letterToDigitMapping);
        }

        for (int candidateDigit = 0; candidateDigit <= 9; candidateDigit++) {
            boolean isLeadingZeroViolation = (candidateDigit == 0 && nonZeroLeadingLetters.contains(uniqueLetterSequence[currentLetterIndex]));
            if (!isDigitOccupied[candidateDigit] && !isLeadingZeroViolation) {
                
                currentDigitAssignments[currentLetterIndex] = candidateDigit;
                isDigitOccupied[candidateDigit] = true;
                letterToDigitMapping.put(uniqueLetterSequence[currentLetterIndex], candidateDigit);

                if (!ArithmeticValidator.shouldPruneBranchEarly(leftSideWords, rightSideWord, letterToDigitMapping)) {
                    if (executeBacktracking(currentLetterIndex + 1)) {
                        return true;
                    }
                }

                isDigitOccupied[candidateDigit] = false;
                letterToDigitMapping.remove(uniqueLetterSequence[currentLetterIndex]);
            }
        }
        return false;
    }

    public Map<Character, Integer> getFinalMapping() {
        return new HashMap<>(letterToDigitMapping);
    }
}
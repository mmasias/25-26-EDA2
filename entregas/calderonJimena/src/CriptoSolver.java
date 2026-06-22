import java.util.*;

public class CriptoSolver {

    private String[] storedLeftSideWords;
    private String storedRightSideWord;

    public Map<Character, Integer> solve(String[] leftSideWords, String rightSideWord) {
        this.storedLeftSideWords = leftSideWords;
        this.storedRightSideWord = rightSideWord;

        List<Character> orderedLetterList = new ArrayList<>();
        Set<Character> processedLettersSet = new HashSet<>();
        Set<Character> nonZeroLeadingLetters = new HashSet<>();

        for (String currentWord : leftSideWords) {
            if (currentWord != null && !currentWord.isEmpty()) {
                nonZeroLeadingLetters.add(currentWord.charAt(0));
                for (char currentChar : currentWord.toCharArray()) {
                    if (processedLettersSet.add(currentChar)) {
                        orderedLetterList.add(currentChar);
                    }
                }
            }
        }
        if (rightSideWord != null && !rightSideWord.isEmpty()) {
            nonZeroLeadingLetters.add(rightSideWord.charAt(0));
            for (char currentChar : rightSideWord.toCharArray()) {
                if (processedLettersSet.add(currentChar)) {
                    orderedLetterList.add(currentChar);
                }
            }
        }

        if (orderedLetterList.size() > 10) return null;

        char[] uniqueLetterSequence = new char[orderedLetterList.size()];
        for (int positionIndex = 0; positionIndex < orderedLetterList.size(); positionIndex++) {
            uniqueLetterSequence[positionIndex] = orderedLetterList.get(positionIndex);
        }

        BacktrackingEngine engine = new BacktrackingEngine(uniqueLetterSequence, nonZeroLeadingLetters, leftSideWords, rightSideWord);
        boolean solved = engine.executeBacktracking(0);
        
        return solved ? engine.getFinalMapping() : null;
    }

    public void printSolution(Map<Character, Integer> finalMapping) {
        if (finalMapping == null) {
            System.out.println("No se encontró solución factible.");
            return;
        }
        System.out.println("\n=== SOLUCIÓN ===");
        long totalLeftSum = 0;
        for (String currentWord : storedLeftSideWords) {
            StringBuilder wordDigitsBuilder = new StringBuilder();
            for (char currentChar : currentWord.toCharArray()) {
                wordDigitsBuilder.append(finalMapping.get(currentChar));
            }
            String wordValueString = wordDigitsBuilder.toString();
            System.out.println("  " + currentWord + " = " + wordValueString);
            totalLeftSum += Long.parseLong(wordValueString);
        }

        StringBuilder rightSideDigitsBuilder = new StringBuilder();
        for (char currentChar : storedRightSideWord.toCharArray()) {
            rightSideDigitsBuilder.append(finalMapping.get(currentChar));
        }
        String rightSideValueString = rightSideDigitsBuilder.toString();

        int maxLength = storedRightSideWord.length();
        for (String currentWord : storedLeftSideWords) {
            if (currentWord.length() > maxLength) maxLength = currentWord.length();
        }
        StringBuilder separatorLine = new StringBuilder();
        for (int dashIndex = 0; dashIndex < maxLength; dashIndex++) separatorLine.append("-");
        System.out.println("  " + separatorLine);
        System.out.println("  " + storedRightSideWord + " = " + rightSideValueString);
        System.out.println("Verificación: " + totalLeftSum + " == " + rightSideValueString + " -> " + (totalLeftSum == Long.parseLong(rightSideValueString) ? "OK" : "FAIL"));

        System.out.print("\nMapeo: ");
        List<Character> sortedLetterKeys = new ArrayList<>(finalMapping.keySet());
        Collections.sort(sortedLetterKeys);
        for (char currentChar : sortedLetterKeys) {
            System.out.print(currentChar + "=" + finalMapping.get(currentChar) + " ");
        }
        System.out.println();
    }
}
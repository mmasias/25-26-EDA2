import java.util.*;

class SendMoreMoneySolver {

    public static void main(String[] args) {
        String[] words = {"SEND", "MORE"};
        String result = "MONEY";
        char[] letters = getUniqueLetters(words, result);
        int[] mapping = new int[256];
        boolean[] usedDigits = new boolean[10];

        if (solve(letters, 0, mapping, usedDigits, words, result)) {
            printMapping(letters, mapping, 0);
        }
    }

    private static boolean solve(char[] letters, int index, int[] mapping, boolean[] used, String[] words, String result) {
        int totalLetters = letters.length;
        int[] nextDigit = new int[totalLetters];
        int[] assignedDigit = new int[totalLetters];
        Arrays.fill(assignedDigit, -1);

        int level = index;
        while (level >= 0) {
            if (level == totalLetters) {
                if (isValid(words, result, mapping)) {
                    return true;
                }

                level--;
                if (level >= 0) {
                    releaseAssignment(level, used, assignedDigit);
                }
            } else {
                int chosenDigit = findNextValidDigit(
                        nextDigit[level], letters[level], used, words, result
                );

                if (chosenDigit == -1) {
                    nextDigit[level] = 0;
                    level--;
                    if (level >= 0) {
                        releaseAssignment(level, used, assignedDigit);
                    }
                } else {
                    nextDigit[level] = chosenDigit + 1;
                    mapping[letters[level]] = chosenDigit;
                    used[chosenDigit] = true;
                    assignedDigit[level] = chosenDigit;

                    level++;
                    if (level < totalLetters) {
                        nextDigit[level] = 0;
                    }
                }
            }
        }

        return false;
    }

    private static void releaseAssignment(int level, boolean[] used, int[] assignedDigit) {
        int previousDigit = assignedDigit[level];
        if (previousDigit != -1) {
            used[previousDigit] = false;
            assignedDigit[level] = -1;
        }
    }

    private static int findNextValidDigit(int startDigit, char character, boolean[] used, String[] words, String result) {
        int digit = startDigit;
        while (digit <= 9) {
            boolean isUnused = !used[digit];
            boolean respectsLeadingRule = !(digit == 0 && isLeading(character, words, result));
            if (isUnused && respectsLeadingRule) {
                return digit;
            }
            digit++;
        }
        return -1;
    }

    private static boolean isValid(String[] words, String result, int[] mapping) {
        long sumWords = sumWords(words, mapping, 0);
        return sumWords == toNumber(result, mapping);
    }

    private static long toNumber(String word, int[] mapping) {
        return toNumber(word, mapping, 0, 0);
    }

    private static boolean isLeading(char character, String[] words, String result) {
        if (result.charAt(0) == character) return true;
        return isLeadingInWords(character, words, 0);
    }

    private static char[] getUniqueLetters(String[] words, String result) {
        String all = words[0] + words[1] + result;
        String unique = collectUnique(all, 0, "");
        return unique.toCharArray();
    }

    private static void printMapping(char[] letters, int[] mapping, int index) {
        if (index == letters.length) {
            return;
        }

        System.out.println(letters[index] + ": " + mapping[letters[index]]);
        printMapping(letters, mapping, index + 1);
    }

    private static long sumWords(String[] words, int[] mapping, int index) {
        if (index == words.length) {
            return 0;
        }

        return toNumber(words[index], mapping) + sumWords(words, mapping, index + 1);
    }

    private static long toNumber(String word, int[] mapping, int index, long current) {
        if (index == word.length()) {
            return current;
        }

        long next = current * 10 + mapping[word.charAt(index)];
        return toNumber(word, mapping, index + 1, next);
    }

    private static boolean isLeadingInWords(char character, String[] words, int index) {
        if (index == words.length) {
            return false;
        }

        if (words[index].charAt(0) == character) {
            return true;
        }

        return isLeadingInWords(character, words, index + 1);
    }

    private static String collectUnique(String all, int index, String unique) {
        if (index == all.length()) {
            return unique;
        }

        char character = all.charAt(index);
        String nextUnique = unique.indexOf(character) == -1 ? unique + character : unique;
        return collectUnique(all, index + 1, nextUnique);
    }
}
public class FortyTen {

    public static void main(String[] args) {
        String[] words = {"FORTY", "TEN", "TEN"};
        String result = "SIXTY";
        char[] letters = getUniqueLetters(words, result);
        int[] mapping = new int[256];
        boolean[] usedDigits = new boolean[10];

        if (solve(letters, 0, mapping, usedDigits, words, result)) {
            printMappingRecursively(letters, mapping, 0);
        }
    }

    private static boolean solve(char[] letters, int index, int[] mapping, boolean[] used, String[] words, String result) {
        if (index == letters.length) {
            return isValid(words, result, mapping);
        }

        return tryDigits(letters, index, mapping, used, words, result, 0);
    }

    private static boolean tryDigits(char[] letters, int index, int[] mapping, boolean[] used, String[] words, String result, int digit) {
        if (digit > 9) {
            return false;
        }

        boolean found = false;
        char character = letters[index];

        if (!used[digit] && !(digit == 0 && isLeading(character, words, result))) {
            mapping[character] = digit;
            used[digit] = true;

            if (solve(letters, index + 1, mapping, used, words, result)) {
                found = true;
            } else {
                used[digit] = false;
                found = tryDigits(letters, index, mapping, used, words, result, digit + 1);
            }
        } else {
            found = tryDigits(letters, index, mapping, used, words, result, digit + 1);
        }

        return found;
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
        String all = words[0] + words[1] + words[2] + result;
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
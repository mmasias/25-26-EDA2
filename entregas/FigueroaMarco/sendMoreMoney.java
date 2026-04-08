import java.util.*;

public class SendMoreMoneySolver {

    public static void main(String[] args) {
        String[] words = {"SEND", "MORE"};
        String result = "MONEY";
        char[] letters = getUniqueLetters(words, result);
        int[] mapping = new int[256];
        boolean[] usedDigits = new boolean[10];

        if (solve(letters, 0, mapping, usedDigits, words, result)) {
            int i = 0;
            while (i < letters.length) {
                System.out.println(letters[i] + ": " + mapping[letters[i]]);
                i++;
            }
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
        long sumWords = 0;
        int i = 0;
        while (i < words.length) {
            sumWords += toNumber(words[i], mapping);
            i++;
        }
        return sumWords == toNumber(result, mapping);
    }

    private static long toNumber(String word, int[] mapping) {
        long residual = 0;
        int i = 0;
        while (i < word.length()) {
            residual = residual * 10 + mapping[word.charAt(i)];
            i++;
        }
        return res;
    }

    private static boolean isLeading(char character, String[] words, String result) {
        if (result.charAt(0) == character) return true;
        int i = 0;
        while (i < words.length) {
            if (words[i].charAt(0) == character) return true;
            i++;
        }
        return false;
    }

    private static char[] getUniqueLetters(String[] words, String result) {
        String all = words[0] + words[1] + result;
        String unique = "";
        int i = 0;
        while (i < all.length()) {
            char character = all.charAt(i);
            if (unique.indexOf(character) == -1) {
                unique += character;
            }
            i++;
        }
        return unique.toCharArray();
    }
}
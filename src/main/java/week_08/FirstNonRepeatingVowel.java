package main.java.week_08;

/**
 Given a string, write a method to find the index of first non-repeating vowel (a, e, i, o, u) in it and return
 it. If it doesn't exist, return -1. Assume that string is not empty, and all the characters of the String is
 lowercase.
 Follow-up Question: Can you solve it only with loops, the charAt() method, and the length() method,
 without using other string or collection methods?
 */
public class FirstNonRepeatingVowel {
    public static void main(String[] args) {
//        System.out.println("google = " + getFirstNonRepeatingVowel1("google"));
//        System.out.println("repeat = " + getFirstNonRepeatingVowel1("repeat"));
//        System.out.println("book = " + getFirstNonRepeatingVowel1("book"));
//        System.out.println("bcd = " + getFirstNonRepeatingVowel1("bcd"));

        String [] inputs = {"google", "repeat", "book", "bcd"};
        for (String input : inputs) {
            System.out.println(input + " = " + getFirstNonRepeatingVowel1(input));
        }
    }

    public static int getFirstNonRepeatingVowel1(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                int vowelCount = 0;
                for (int j = 0; j < input.length(); j++) {
                    if (ch == input.charAt(j)) {
                        vowelCount++;
                    }
                }
                if (vowelCount == 1) return i;
            }
        }
        return -1;
    }

    public static int getFirstNonRepeatingVowel2(String input) {
        String vowels = "aeiou";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                if (input.indexOf(ch) == input.lastIndexOf(ch)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getFirstNonRepeatingVowel3(String str) {
        int[] vowelArray = new int[5];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                continue;
            }
            switch (ch) {
                case 'a':
                    vowelArray[0]++;
                    break;
                case 'e':
                    vowelArray[1]++;
                    break;
                case 'i':
                    vowelArray[2]++;
                    break;
                case 'o':
                    vowelArray[3]++;
                    break;
                case 'u':
                    vowelArray[4]++;
                    break;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                continue;
            }
            if (ch == 'a' && vowelArray[0] == 1) {
                return i;
            } else if (ch == 'e' && vowelArray[1] == 1) {
                return i;
            } else if (ch == 'i' && vowelArray[2] == 1) {
                return i;
            } else if (ch == 'o' && vowelArray[3] == 1) {
                return i;
            } else if (ch == 'u' && vowelArray[4] == 1) {
                return i;
            }
        }
        return -1;
    }
}

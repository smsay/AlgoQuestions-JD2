package main.java.week_16;

import java.util.LinkedHashMap;
import java.util.Map;
/*
Given a string, write a method to find the first non-repeating vowel (a, e, i, o, u) in it and return its index.
If it doesn't exist, return -1.
Assume that all the characters of the String is lowercase.
Do not use String class functions other than charAt() and length()
You can also try to solve with Map data structure like using a Map<Character, Integer> variable.

Example
input: google
output: 5
explanation: only e is non-repeated vowel, and it’s index is 5

Example
input: mood
output: -1
explanation: o is repeated, no non-repeating vowel.

Example
input: responsible
output: 4
explanation: e is repeated, o and i are not repeated, o is the first non-repeating vowel
 */

public class Q2_FirstNonRepeatingVowel {
    public static void main(String[] args) {
        String word = "google";
        System.out.println(getFirstNonRepeatingVowel(word));
        System.out.println(getFirstNonRepeatingVowel("mood"));
        System.out.println(getFirstNonRepeatingVowel("responsible"));
        System.out.println("second : ");
        System.out.println(getFirstNonRepeatingVowel2(word));
        System.out.println(getFirstNonRepeatingVowel2("mood"));
        System.out.println(getFirstNonRepeatingVowel2("responsible"));
        System.out.println("third :");
        System.out.println(getFirstNonRepeatingVowel3("mood"));
        System.out.println(getFirstNonRepeatingVowel3(word));
        System.out.println("forth :");
        System.out.println(getFirstNonRepeatingVowel3(word));
        System.out.println(getFirstNonRepeatingVowel3("mood"));
    }

    public static int getFirstNonRepeatingVowel(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                int count = 0;
                for (int j = 0; j < input.length(); j++) {
                    if (ch == input.charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int getFirstNonRepeatingVowel2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (!map.containsKey(ch)) {
                    map.put(ch, i);
                } else {
                    map.put(ch, -1);
                }
            }
        }
        for (Integer value : map.values()) {
            if (value >= 0) {
                return value;
            }
        }
        return -1;
    }

    public static int getFirstNonRepeatingVowel3(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if ("aeiou".contains(currentChar + "")) {
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> each : map.entrySet()) {
            if (each.getValue() == 1) {
                return input.indexOf(each.getKey());
            }
        }
        return -1;
    }


    // not shared during mentor session
    public static int getFirstNonRepeatingVowel4(String input) {
        Map<Character, Integer[]> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                Integer[] value = map.getOrDefault(currentChar, new Integer[]{0, i});
                value[0] += 1;
                map.put(currentChar, value);
            }
        }
        for (Map.Entry<Character, Integer[]> each : map.entrySet()) {
            if (each.getValue()[0] == 1) {
                return each.getValue()[1];
            }
        }
        return -1;
    }

}

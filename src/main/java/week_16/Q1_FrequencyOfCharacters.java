package main.java.week_16;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q1_FrequencyOfCharacters {

/*    Write a method that returns the frequency of each character of a given String parameter.
    If the given String is null, then return null
    If the given String is empty return an empty map

Example
input: “”
output: empty map
explanation: input is empty

Example
input: null
output: null
explanation: input is null.

Example
input: responsible
output: {r=1, e=2, s=2, p=1, o=1, n=1, i=1, b=1, l=1}
explanation: characters are keys and occurrences are values
 */

    public static void main(String[] args) {
        System.out.println(solution1("I love Java Programming"));
        System.out.println(solution1(""));
        System.out.println(solution1(null));
        System.out.println(solution2("I love Java Programming"));
        System.out.println(solution2(""));
        System.out.println(solution2(null));
    }

    static Map<Character, Integer> solution1(String str) {
        if (str == null) return null;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    public static Map<Character, Integer> solution2(String str) {
        if (str == null) return null;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character each : str.toCharArray()) {
            if (map.containsKey(each)) {
                map.put(each, map.get(each) + 1);
            } else {
                map.put(each, 1);
            }
        }
        return map;
    }

}

package main.java.week_34_api;

import java.util.*;
import java.util.stream.Collectors;

/*
leetcode medium

151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Example: Let the input string be “i like this program very much”.
The function should change the string to “much very program this like i”
 */
public class ReverseWords {

    public static void main(String[] args) {
        //  String s = "i like this program very much ";
//        String s = "a good   example";
        String s = "the sky is blue";
        System.out.println(withStringJoin(s));
    }

    static String withStringBuilder(String s) {
        String[] strings = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    static String withStringJoin(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static String withStack(String s) {
        String[] words = s.trim().split("\\s+");
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
            if (!stack.isEmpty()) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }


    // other solutions
    static String withStream(String s) {
        return Arrays.stream(s.trim().split("\\s+"))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                }))
                .collect(Collectors.joining(" "));
    }

    static String withString(String input) {
        String[] strs = input.split(" ");
        String result = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!strs[i].isBlank()) {
                result += strs[i] + " ";
            }
        }
        return result.trim();
    }


}

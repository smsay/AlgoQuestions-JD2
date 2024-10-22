package main.java.week_19_sorting_methodReference_stream.algoQ;

/*
A string is said to be palindrome after converting all uppercase letters into lowercase letters and removing all spaces  it reads the same backward as forward.
For e.g. civic, radar, level, rotor, race car, are palindrome because if we try to read it from backward, it is same as forward.
Write a method that accepts a String as argument and return true
 if it is a palindrome, or false otherwise.
Assume string has only alphanumeric characters include letters
and numbers and spaces, ignore upper-lowercase characters.

Examples:
Radar → true
rotator → true
Summer→false
Was it a car or a cat I saw →true
"" → true
" " → true

 */
public class Q1_PalindromeString {

    public static boolean isPalindrome1(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        str = str.replace(" ", "").toLowerCase();
        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += "" + str.charAt(i);
        }
        return reverseStr.equals(str);
    }

    public static boolean isPalindrome2(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        str = str.toLowerCase();
        String filtered = "";
        String reverseStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                filtered = filtered + ch;
                reverseStr = ch + reverseStr;
            }
        }
//        for (int i = filtered.length() - 1; i >= 0; i--) {
//            reverseStr += "" + filtered.charAt(i);
//        }
        return reverseStr.equals(filtered);
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
//        String filtered = sb.toString();
//        String reversed = sb.reverse().toString();
//        return filtered.equals(reversed);
        return sb.compareTo(sb.reverse()) == 0;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("Radar"));
        System.out.println(isPalindrome("rotator"));
        System.out.println(!isPalindrome("Summer"));
        System.out.println(isPalindrome("Was it a car or a cat I saw"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(" "));


    }

}

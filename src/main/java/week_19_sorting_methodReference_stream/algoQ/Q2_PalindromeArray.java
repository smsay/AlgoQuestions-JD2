package main.java.week_19_sorting_methodReference_stream.algoQ;

import java.util.ArrayList;
import java.util.Arrays;

import static week_19_sorting_methodReference_stream.algoQ.Q1_PalindromeString.isPalindrome;

/*
Write a method that takes in a non-empty array of Strings that will return an ArrayList 
which consist of palindromic strings in given array. 
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Examples:
Input: String[] arr = {"abc", "car", "ada", "racecar", "cool"}
Output: ["ada", "racecar"]
Explanation: These two are the only palindrome strings in the given array
Input: String[] arr = {"def", "ab"}
Output:[]
 */
public class Q2_PalindromeArray {

    public static ArrayList<String> getPalindromes(String[] input) {

        ArrayList<String> result = new ArrayList<>();
        for (String str : input) {
            String s = str.replace(" ", "").toLowerCase();
            String reversed = new StringBuilder(s).reverse().toString();
            if (s.equals(reversed)){
                result.add(str);
            }
        }
        return result;
    }

    public static ArrayList<String> getPalindromes2(String[] array) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : array) {
            //call the method you have created for question-1
            if (isPalindrome(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static ArrayList<String> getPalindromes3(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        arrayList.removeIf(p -> !isPalindrome(p));
        return arrayList;
    }


    public static void main(String[] args) {
        String[] arr1 = {"abc", "car", "ada", "race car", "cool", "Was it a car or a cat I saw", " ", "abba"};
        String[] arr2 = {"def", "ab"};
        System.out.println(getPalindromes(arr1));
        System.out.println(getPalindromes(arr2));


    }


}

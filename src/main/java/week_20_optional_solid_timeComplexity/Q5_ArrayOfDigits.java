package main.java.week_20_optional_solid_timeComplexity;

import java.util.Arrays;

public class Q5_ArrayOfDigits {
    /*
    How to convert a positive int to an array of digits.
    Input: 490		Output: [4, 9, 0] (as int Array)
     */


    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(getDigits(490)));
            System.out.println(Arrays.toString(getDigits(0)));
        } catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static int[] getDigits(int number) {
        int length = String.valueOf(number).length();
        int[] ints = new int[length];
        for (int i = ints.length-1; i>=0; i--) {
            ints[i] = number % 10;
            number = number / 10;
        }
        return ints;
    }

    static int[] getDigits2(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }
        return ints;
    }

    static int[] getDigitsWithStream(int number) {
        return Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)    //  .map(c -> Character.getNumericValue(c)) //same
                .toArray();
    }

    static int[] getDigitsWithStream2(int number) {
        return Integer.toString(number)
                .chars()
                .map(c -> c - '0')
                .toArray();
    }


}

package main.java.week_18_generics_enum_lambda_lombok;

/*
Sum of Digits
Given a number, find the sum of its digits.

Examples :
Input: n = 687
Output: 21

Input: n = 12
Output: 3
 */
public class SumOfDigits {

    public static int findSumOfDigits(int number) {
        int sum = 0;

        // Ensure the number is non-negative
        number = Math.abs(number);

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int number1 = 687;
        System.out.println("Sum of digits for " + number1 + ": " + findSumOfDigits(number1));

        int number2 = 12;
        System.out.println("Sum of digits for " + number2 + ": " + findSumOfDigits(number2));
    }

}

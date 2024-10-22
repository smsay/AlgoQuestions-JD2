package main.java.week_37_aop_testing;

public class SumOfDigits {
    /*
    Sum of Digits / Digital Root

    Digital root is the recursive sum of all the digits in a number.

Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
Examples

    16  -->  1 + 6 = 7
   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
888888  -->  8 + 8 + 8 + 8 + 8 + 8 = 48  -->  4 + 8 = 12  -->  1 + 2 = 3

     */

    public static void main(String[] args) {
        System.out.println(digitalRoot(493193));
        System.out.println(withLoop(493193));
    }

    static int digitalRoot(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        if (sum < 10) {
            return sum;
        }
        return digitalRoot(sum);
    }

    static int withLoop(long n) {
        int sum;
        do {
            sum = 0;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            n = sum;
        } while (sum > 9);
        return sum;
    }

    // other solutions

    static int digitalRoot2(long n) {
        while (n > 9) {
            n = Long.toString(n).chars().map(i -> i - '0').sum();
        }
        return (int) n;
    }

    static int sum(int n) {
        int result = 0;
        if (n > 0) {
            result = n % 10 + sum(n / 10);
        }
        if (result > 9) {
            result = sum(result);
        }
        return result;
    }

    public static int digital_root(int n) {
        while (n > 9) {
            n = n / 10 + n % 10;
        }
        return n;
    }

}

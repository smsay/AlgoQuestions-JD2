package main.java.week_18_generics_enum_lambda_lombok;

public class SumOfDigitsUntilSingleDigit {

    public static void main(String[] args) {
        System.out.println("digitalRoot(129) = " + withLoop(129));
        System.out.println("digitalRoot(129) = " + withRecursion(129));

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

    public static int withRecursion(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        if (sum < 10) {
            return sum;
        }
        return withRecursion(sum);
    }


}

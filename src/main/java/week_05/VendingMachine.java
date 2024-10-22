package main.java.week_05;

import java.util.Scanner;

/**
You're developing software for a vending machine that dispenses items with given prices.
Write a program that takes in the item price and the amount paid by the customer and prints the remaining change to be
 dispensed in various denominations (e.g., dollars, quarters, dimes, nickels, pennies).
If any input is not greater than 0, it should print “Invalid input”

The vending machine operates with the following denominations:
Dollar bills: $1
Quarters: $0.25
Dimes: $0.10
Nickels: $0.05
Pennies: $0.01

Example-1
Input: item price is $3.50 and the customer pays $5.00
Output: 1 dollar bill, 2 quarters, 0 dimes, 0 nickels, 0 pennies

Example-2
Input: item price is $1.17 and the customer pays $2.00
Output: 2 dollar bill, 3 quarters, 0 dimes, 1 nickels, 3 pennies

Example-3
Input: item price is $-3.50 and the customer pays $5.00
Output: Invalid input
Explanation: any input must be greater than 0.

 */
public class VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write an item price: ");
        double itemPrice = scanner.nextDouble();
        System.out.print("Write the paid amount: ");
        double amountPaid = scanner.nextDouble();
        scanner.close();

        if (itemPrice > 0 && amountPaid > 0) {
            double change = amountPaid - itemPrice;
            int dollars = (int) change;
            System.out.println(change);
            System.out.println( (change-dollars)*100);
            int cents = (int) ((change - dollars) * 100); // if an item 0.78 cent and paid amount is $ 1, calculated penny amount is not valid due to double precision issue
//            int cents = (int) Math.round((change - dollars) * 100); // mitigation of imprecision of double
            int quarters = cents / 25;
            cents %= 25;
            int dimes = cents / 10;
            cents %= 10;
            int nickels = cents / 5;
            cents %= 5;
            System.out.println(dollars + " dollar bill, " + quarters + " quarters, " + dimes + " dimes, "
                    + nickels + " nickels, " + cents + " pennies");
        } else {
            System.out.println("Invalid input");
        }
    /*
    https://www.baeldung.com/java-double-precision-issue
    https://stackoverflow.com/questions/322749/retain-precision-with-double-in-java
    double precision issue:
    The imprecision of double arises due to how floating-point numbers are represented in memory.
    The double data type in Java uses a fixed amount of memory to represent a wide range of numbers, including fractions.
    However, this representation can't accurately capture every possible decimal value due to its binary nature.
    For instance, decimal values like 0.1 or 0.2 cannot be precisely represented in binary, resulting in small
    rounding errors when using double values.
    These rounding errors might accumulate over multiple calculations, causing unexpected behavior in some scenarios,
    especially in financial calculations where precision matters.
    To mitigate these issues, Java introduced the BigDecimal class, which allows accurate representation of decimal
    numbers with arbitrary precision by storing the digits and the scale separately. This class is commonly used for
    precise arithmetic operations where exact decimal representations are required, such as financial calculations.
     */

    }

}

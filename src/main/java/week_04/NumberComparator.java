package main.java.week_04;

public class NumberComparator {

    public static void main(String[] args) {
        /*
        If the number is greater than 90, I want to print only "Number is greater than 90"
        But it prints "Number is greater than 50" after "Number is greater than 90" for numbers greater than 90.
         */
        int number = 95;
        if (number > 90) {
            System.out.println(number + " is greater than 90");
        }
        if (number > 50) {
            System.out.println(number + " is greater than 50");
        }
    }
}

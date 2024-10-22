package main.java.week_04;

public class LeapYear {
    /**
      Leap Year
      Write a program that takes a year as input and checks if it is a leap year or not.
      A leap year is defined as a year that is divisible by 4, except for years that are divisible by 100.
      However, years that are divisible by 400 are considered leap years.
      <p>
      Example 1:
      input:
      year = 2024
      output:
      2024 is a leap year = true
      explanation: 2024 is divisible by 4, so it satisfies the basic requirement for a leap year.
      2024 is not divisible by 100, so it doesn't fall under the exception for non-leap years.
      Therefore, 2024 is a leap year.
      <p>
      Example 2:
      input:
      year = 1900
      output:
      1900 is a leap year = false
      explanation: the year 1900 is divisible by 4, but it is not a leap year because it is divisible by 100 and not divisible by 400.
     */

    public static void main(String[] args) {

//         option-1
        int year = 2024;

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        System.out.println(year + " is a leap year = " + isLeapYear);


//         option-2
//        int year = 2024;
//
//        boolean isLeapYear = false;
//
//        if (year % 4 == 0){
//            if (year % 100 == 0){
//                isLeapYear = year % 400 == 0;
//            } else {
//                isLeapYear = true;
//            }
//        }
//        System.out.println(year + " is a leap year = " + isLeapYear);

    }
}

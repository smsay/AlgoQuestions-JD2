package main.java.week_04;

public class SwitchCase {
      /*
        I want to print only
        "Excellent" if grade is 'A’,
        "Good" if grade is 'B’,
        "Can be improved!" if grade is 'C’,
        "No comment" for any other grades .
        But this code prints "Excellent", "Good", "Can be improved!" together for grade 'A'
         This Dirty Java Code needs to be fixed!
         */

    public static void main(String[] args) {
        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
            case 'B':
                System.out.println("Good");
            case 'C':
                System.out.println("Can be improved!");
            default:
                System.out.println("No comment");
        }
    }


    // Solution: Add "break;" after each case block
}

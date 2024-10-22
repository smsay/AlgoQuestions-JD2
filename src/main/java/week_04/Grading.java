package main.java.week_04;

public class Grading {

    /*
The coder tries to implement a logic for printing the right grade. Max grade is assumed to be 100.

If the grade is greater than or equals to 90 output excellent
If the grade is greater than or equals to 70 and smaller than 90 output good
If the grade is greater than or equals to 60 and smaller than 70 output pass
If the grade is smaller than 60 output fail

What is wrong here?
What could be improved?

Improve the code on screen & get ready to share and explain your code.
     */
    public static void main(String[] args) {
        int grade = 105;
        if (grade <= 100 && grade >= 90) {
            System.out.println("excellent");
        } else if (grade <= 90 && grade >= 70) {
            System.out.println("good");
        } else if (grade <= 70 && grade >= 60) {
            System.out.println("pass");
        } else if (grade <= 60 && grade >= 50) {
            System.out.println("fail");
        }

    }

    void solution() {
        int grade = 90;
        String result = "";
        if (grade <= 100 && grade >= 0) {
            if (grade >= 90) {
                result = "excellent";
            } else if (grade >= 70) {
                result = "good";
            } else if (grade >= 60) {
                result = "pass";
            } else {
                result = "fail";
            }
        } else {
            result = "invalid input";
        }
        System.out.println(result);

    }

}

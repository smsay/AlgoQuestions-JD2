package main.java.week_07;

import java.util.Random;
import java.util.Scanner;

/*
Write a program that creates two random numbers, asks user to find the sum of them takes the user input and
checks if it is true, if so prints “You got it”
if not, it prints “Try again”.
 */
public class GuessSum {
    public static void main(String[] args) {
        whileLoop();
        doWhile();
    }

    public static void whileLoop(){
        Random random = new Random();
        int number1 = random.nextInt(10) + 1;
        int number2 = random.nextInt(10) + 1;
//        int number1 = (int)(Math.random() * 10);

        Scanner input = new Scanner(System.in);

        System.out.print("What is " + number1 + " + " + number2 + "? ");

        int sum = number1 + number2;
        int userAnswer = input.nextInt();

        while (sum != userAnswer) {
            System.out.print("Try again.");
            userAnswer = input.nextInt();
        }

        System.out.println("You got it!");
    }


    static void doWhile() {
        Random random = new Random();
        int number1 = random.nextInt(10) + 1;
        int number2 = random.nextInt(10) + 1;
//        int number1 = (int) (Math.random() * 10);

        Scanner input = new Scanner(System.in);

        int sum = number1 + number2;
        int userAnswer;

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        do {
            userAnswer = input.nextInt();
            if (sum != userAnswer) {
                System.out.println("Try again !");
            }
        } while (sum != userAnswer);
        input.close();
        System.out.println("You got it!");

    }
}

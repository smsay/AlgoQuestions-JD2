package main.java.week_05;

import java.util.Scanner;

public class MaxSpeed {

    /*
    The coder wants to print out the answer of the question “is this a fast car?”
    If its max speed greater 200kph then it should print true and false otherwise.

    What could be improved in the coder's logic?
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSpeed = sc.nextInt();
        System.out.println("Enter the speed of car: ");
        if (maxSpeed >= 200) {
            System.out.println(true);
        } else if (maxSpeed < 200) {
            System.out.println(false);
        }
    }

    void solution() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the speed of car: ");
        int maxSpeed = sc.nextInt();
        sc.close();
        System.out.println(maxSpeed > 200);

    }
}

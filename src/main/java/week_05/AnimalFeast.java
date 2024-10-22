package main.java.week_05;

import java.util.Scanner;

/*
All the animals are having a feast! Each animal brings one dish. There is just one rule:
the dish must start and end with the same letters as the animal's name.
For example, the great blue heron is bringing garlic naan and the chickadee is bringing chocolate cake.
Write a program that takes the animal's name and dish prints “it is allowed” or “it is not allowed” to indicate whether the beast is allowed to bring the dish to the feast.
Each beast and dish must have at least two letters, if not, print “Beast & dish should not be less than two characters.”.
 */
public class AnimalFeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the animal's name: "); // "great blue heron"
        String animal = scanner.nextLine().trim().toLowerCase(); // "garlic naan"

        System.out.print("Enter the dish name: ");
        String dish = scanner.nextLine().trim().toLowerCase();
        scanner.close();

        if (animal.length() < 2 || dish.length() < 2) {
            System.out.println("Beast & dish should not be less than two characters.");
        } else if (animal.charAt(0) == dish.charAt(0) && animal.charAt(animal.length() - 1) == dish.charAt(dish.length() - 1)) {
            System.out.println("It is allowed.");
        } else {
            System.out.println("It is not allowed.");
        }

    }



}

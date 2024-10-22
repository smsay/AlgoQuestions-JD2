package main.java.week_07;

public class NestedLoopDemo {

    public static void main(String[] args) {
        drawSquare();
//        drawTriangle();
//        drawTriangleWithMissingFirstLine();
//        drawInvertedTriangle();

//        printNumberSquareWithI();
//        printNumberTriangleWithJ();
//        printReversedOrderedNumbersWithJ();
//        printReversedOrderedAndDecreasingNumbersWithJ();
//        combined2();
    }

    // i <= 5 and j <= 5
    public static void drawSquare() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawTriangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {  // change j <= 5 to j <= i
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawTriangleWithMissingFirstLine() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < i; j++) {  // change j <= i to j < i
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawInvertedTriangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 6 - i; j++) {  // change j <= i to j <= 6-i
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // -------------------------- NUMBERS --------------------------------------
    // i <= 5 and j <= 5
    public static void printNumberSquareWithI() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i + " "); // change * to i from "drawSquare()"
            }
            System.out.println();
        }
    }

    public static void printNumberTriangleWithJ() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) { // change j <= 5 to j <= i
                System.out.print(j + " "); // change i to J
            }
            System.out.println();
        }
    }

    public static void printReversedOrderedNumbersWithJ() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) { // change to j = 5; j >= i; j--
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printReversedOrderedAndDecreasingNumbersWithJ() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 6-i; j >= 1; j--) { // change initial value to j = 6-i and condition to j >= 1
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void combined() { // drawTriangleWithMissingFirstLine() and printReversedOrderedAndDecreasingNumbersWithJ
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("* ");
            }
            for (int j = 6-i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void combined2() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");  // remove * only from combined()
            }
            for (int j = 6-i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

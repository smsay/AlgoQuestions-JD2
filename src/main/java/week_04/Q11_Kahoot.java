package main.java.week_04;

public class Q11_Kahoot {
    public static void main(String[] args) {
        int x = 5;
        x = --x + -x++ + ++x - -x;
        System.out.println(x);

//        int x = 5;
//        x = --x     // 4 (x decremented to 4, then assigned to x)
//                + -x++  // -4 (x used as -4 in this step, but post-incremented to 5 after this step)
//                + ++x   // 6 (x pre-incremented to 6 before being used in this step)
//                - -x;   // 6 (the double negative cancels, leaving x as 7)
//        System.out.println(x); // Output: 12

    }
}

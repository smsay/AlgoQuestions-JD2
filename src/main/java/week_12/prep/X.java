package main.java.week_12.prep;

public class X {
    static void staticMethod() {
        System.out.println("Class X");
    }
}

class Y extends X {
    static void staticMethod() {
        System.out.println("Class Y");
    }
}

class MainClass3 {
    public static void main(String[] args) {
        Y.staticMethod();
    }
}

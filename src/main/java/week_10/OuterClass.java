package main.java.week_10;

public class OuterClass {

    static int data = 30;


    public static class InnerClass1 {
        // public static class
    }

    protected class InnerClass2 {
        // protected class
    }

    static class InnerClass3 {
        // default static class
        static void msg(){
            System.out.println("data is : " + data);
        }
    }

    private static class InnerClass4 {
       // private static class
       static void msg(){
           System.out.println("data is : " + data);
       }
    }
}

class TestOuterInner {
    public static void main(String[] args) {
        OuterClass.InnerClass3.msg();
//        OuterClass.InnerClass4.msg();
    }
}

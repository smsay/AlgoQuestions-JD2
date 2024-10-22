package main.java.week_12.prep;

public class SubClass extends ParentClass {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.a_method();
        subClass.b_method();
    }

    @Override
    protected void a_method() {
        System.out.println("This is abstract method");
    }
}

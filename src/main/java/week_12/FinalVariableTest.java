package main.java.week_12;

import java.util.ArrayList;

public class FinalVariableTest {

    public static void main(String[] args) {
//        num = 10;
        final int num = 5;

//        str = "";
        final String str = "Cydeo";

        final Car car = new Car("Toyota");
        car.year = 2020;
        System.out.println("car = " + car);
//        car = new Car("Ford"); compile error

        final ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(1);
        System.out.println("list = " + list);
//        list = new ArrayList<>();
    }


    void myMethod(final Car car) {
        car.year = 2023;
//        car = new Car("Ford");
    }

}

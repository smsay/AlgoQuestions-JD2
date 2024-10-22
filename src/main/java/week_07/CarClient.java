package main.java.week_07;

public class CarClient {
    public static void main(String[] args) {
        Car car = new Car();
        car.make = "Toyota";
        car.year = 2023;
        System.out.println("car.speed = " + car.speed);
        car.start();
        car.increaseSpeed();
        System.out.println("car.speed = " + car.speed);
        car.decreaseSpeed();
        System.out.println("car.speed = " + car.speed);
        car.stop();
    }
}

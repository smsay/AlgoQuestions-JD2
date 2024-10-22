package main.java.week_07;

public class Car {

    public String make;
    public String model;
    public int year;
    public double price;
    public int speed;

    public void start(){
        System.out.println("Starting car.");
    }

    public void increaseSpeed() {
        speed += 10;
    }

    public void decreaseSpeed() {
        speed -= 10;
    }

    public void stop(){
        System.out.println("Stopping car.");
    }
}
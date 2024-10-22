package main.java.week_13;

public class Rectangle extends House {

    private final int length;
    private final int width;

    public Rectangle(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

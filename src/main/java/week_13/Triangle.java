package main.java.week_13;

public class Triangle extends House {
    private final int base;
    private final int height;

    public Triangle(String name, int base, int height) {
        super(name);
        this.base = base;
        this.height = height;
    }


    @Override
    public double getArea() {
        return base * height / 2.0;
    }
}

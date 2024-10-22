package main.java.week_13;

public class Square extends House {
    private final int side;

    public Square(String name, int side) {
        super(name);
        this.side = side;
    }


    @Override
    public double getArea() {
        return side * side;
    }
}

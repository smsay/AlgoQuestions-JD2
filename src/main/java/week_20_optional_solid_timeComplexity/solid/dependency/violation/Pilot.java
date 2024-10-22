package main.java.week_20_optional_solid_timeComplexity.solid.dependency.violation;

public class Pilot {

    private RacingCar vehicle;

    public Pilot(){
        this.vehicle = new RacingCar(100);
    }

    public void increaseSpeed(){
        vehicle.accelerate();
    }
}

package main.java.week_20_optional_solid_timeComplexity.solid.liskov_substitution.solution;


public class Car extends Vehicle {

    @Override
    public void changeGear(Gear gear) {
        Gear actualGear = getGear();
        if (isMovingForwards(gear, actualGear)
                || isMovingBackwards(gear, actualGear)) {
            stop();
        }
        super.changeGear(gear);
    }

    private boolean isMovingBackwards(Gear gear, Gear actualGear) {
        return isMoving() && Gear.R.equals(actualGear) && Gear.D.equals(gear);
    }

    private boolean isMovingForwards(Gear gear, Gear actualGear) {
        return isMoving() && Gear.D.equals(actualGear) && Gear.R.equals(gear);
    }
}

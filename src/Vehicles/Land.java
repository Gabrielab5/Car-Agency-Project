package Vehicles;

public class Land extends Vehicle implements Landable{
    protected int wheels_num;
    protected String road;

    public Land(String model, int max_passengers, int max_speed, int wheels_num, String road) {
        super(model, max_passengers, max_speed);
        this.wheels_num = wheels_num;
        this.road = road;
    }

    public int getWheels_num() {
        return this.wheels_num;
    }

    public String getRoad() {
        return this.road;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "Number of wheels: " + this.getWheels_num() + "\nRoad can travel: " + this.getRoad();
    }
}


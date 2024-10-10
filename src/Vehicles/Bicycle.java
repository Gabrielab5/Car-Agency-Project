package Vehicles;

public class Bicycle extends Land implements Not_Motorized {
    public Bicycle(String model, int max_passengers, int max_speed, String road) {
        super(model, max_passengers, max_speed, 2, road);
    }

    public String getPower_Source() {
        return "Manual";
    }

    public char getEnergetic_Score() {
        return 'A';
    }

    public String toString() {
        return "Bicycle: " + super.toString() + ", Power Source: Manual, Energetic Score: A.";
    }
}

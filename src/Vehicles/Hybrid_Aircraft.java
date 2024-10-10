package Vehicles;
import java.util.Objects;

public class Hybrid_Aircraft extends Amphibian implements Airable {
    private String use;
    public Hybrid_Aircraft(String model, int max_passengers, int max_speed, int wheels_num, String flag, int engine_life, int gas_consumption) {
        super(model, max_passengers, max_speed, wheels_num, flag, engine_life, gas_consumption);
        this.use = "military";
    }
    @Override
    public String Use() {
        return this.use;
    }

    @Override
    public void Set_Use(String use){
        this.use = use;
    }

    @Override
    public String toString() {
        return "Hybrid Plane: " +super.toString() + ", Use: " + this.use;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Hybrid_Aircraft other))
            return false;
        return (Objects.equals(use, other.use));
    }

}

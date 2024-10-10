package Vehicles;

public class Cruise_Ship extends Water implements Waterable, Motorized, Commercial_Use_V {
    int gas_consumption;
    int engine_life;

    public Cruise_Ship(String model, int max_passengers, int max_speed, String flag, int gas_consumption, int engine_life) {
        super(model, max_passengers, max_speed, true, flag);
        this.gas_consumption = gas_consumption;
        this.engine_life = engine_life;
    }

    public String get_License_Type() {
        return "Unlimited";
    }

    public int getGas_Consumption() {
        return this.gas_consumption;
    }

    public void setGas_consumption(int gas_consumption) {
        this.gas_consumption = gas_consumption;
    }

    public int getExpected_Life() {
        return this.engine_life;
    }

    public void setExpected_Life(int engine_life) {
        this.engine_life = engine_life;
    }

    public String toString() {
        return "Cruise_Ship: " + super.toString() + ", Gas Consumption: " + this.gas_consumption + " L, Engine Life: "
                + this.engine_life + " Years, License Type: " + this.get_License_Type() +", With wind direction: "+this.with_wind_dir ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (obj instanceof Cruise_Ship) {
            Cruise_Ship other = (Cruise_Ship)obj;
            if (this.engine_life != other.engine_life) {
                return false;
            } else {
                return this.gas_consumption == other.gas_consumption;
            }
        } else {
            return false;
        }
    }
}
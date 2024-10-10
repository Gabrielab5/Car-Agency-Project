
package Vehicles;

public class Frigate extends Water implements Motorized {
    private int gas_consumption = 500;
    private int engine_life = 4;

    public Frigate(String model, int max_passengers, int max_speed, boolean is_with_wind_dir) {
        super(model, max_passengers, max_speed, is_with_wind_dir, "Israel");
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
        String var10000 = super.toString();
        return "frigate->\n" + var10000 + "\nGas consumption: " + this.getGas_Consumption() + "L\nEngine average lifetime: " + this.getExpected_Life() + " years";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Frigate other = (Frigate)obj;
            if (this.getExpected_Life() != other.getExpected_Life()) {
                return false;
            } else {
                return this.getGas_Consumption() == other.getGas_Consumption();
            }
        }
    }
}

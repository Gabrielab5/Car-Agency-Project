package Vehicles;

public class Jeep extends Land implements Commercial_Use_V, Motorized {
    private int engine_life;
    private int gas_consumption;

    public Jeep(String model, int gas_consumption, int max_speed, int engine_life) {
        super(model, 5, max_speed, 4, "Dirt");
        this.engine_life = engine_life;
        this.gas_consumption = gas_consumption;
    }

    public String get_License_Type() {
        return "Mini";
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
        return "Jeep: " + super.toString() + ", Engine: " + this.getGas_Consumption() + "L ,Engine average Lifetime: " + this.engine_life + " years,\n License Type: " + this.get_License_Type();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Jeep other = (Jeep)obj;
            if (this.engine_life != other.engine_life) {
                return false;
            } else {
                return this.gas_consumption == other.gas_consumption;
            }
        }
    }
}

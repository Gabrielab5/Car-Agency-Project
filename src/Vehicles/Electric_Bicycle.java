package Vehicles;

public class Electric_Bicycle extends Land implements Motorized{
    private int gas_consumption;
    private int engine_life;
    public Electric_Bicycle(String model, int max_passengers, int max_speed, String road) {
        super(model, max_passengers, max_speed, 2, road);
        this.gas_consumption = 20;
    }

    @Override
    public int getGas_Consumption() {
        return this.gas_consumption;
    }

    @Override
    public void setGas_consumption(int gas_consumption) {
        this.gas_consumption = gas_consumption;
    }

    @Override
    public int getExpected_Life() {
        return this.engine_life;
    }

    @Override
    public void setExpected_Life(int engine_life) {
        this.engine_life = engine_life;
    }
    public String toString() {
        return "Electric Bicycle: " + super.toString() + " , Gas Consumption: " +
                getGas_Consumption() + "L, Lifetime of " + engine_life + " years .";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Electric_Bicycle other = (Electric_Bicycle) obj;
        if (engine_life != other.engine_life)
            return false;
        return gas_consumption == other.gas_consumption;
    }
}


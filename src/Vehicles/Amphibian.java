package Vehicles;

public class Amphibian extends Vehicle implements Landable, Waterable, Motorized {
    Water water_travel;
    Land land_travel;
    private int engine_life;
    private int gas_consumption;

    public Amphibian(String model, int max_passengers, int max_speed, int wheels_num, String flag, int engine_life, int gas_consumption) {
        super(model, max_passengers, max_speed);
        this.land_travel = new Land(model, max_passengers, max_speed, wheels_num, "Paved Road");
        this.water_travel = new Water(model, max_passengers, max_speed, true, flag);
        this.engine_life = engine_life;
        this.gas_consumption = gas_consumption;
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
        return "Amphibian:  \n" +this.water_travel.toString() + ", Number of Wheels: " + this.land_travel.getWheels_num() + ", Engine Life: " + this.engine_life + " Years, Gas Consumption: " + this.gas_consumption;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (obj instanceof Amphibian) {
            Amphibian other = (Amphibian)obj;
            if (this.engine_life != other.engine_life) {
                return false;
            } else if (this.gas_consumption != other.gas_consumption) {
                return false;
            } else {
                if (this.land_travel == null) {
                    if (other.land_travel != null) {
                        return false;
                    }
                } else if (!this.land_travel.equals(other.land_travel)) {
                    return false;
                }

                if (this.water_travel == null) {
                    return other.water_travel == null;
                } else {
                    return this.water_travel.equals(other.water_travel);
                }
            }
        } else {
            return false;
        }
    }

    public Boolean Is_With_Wind_Dir() {
        return this.water_travel.Is_With_Wind_Dir();
    }

    public void Set_With_Wind_Dir(Boolean with_wind_dir) {
        this.water_travel.Set_With_Wind_Dir(with_wind_dir);
    }

    public String get_Current_Country_Flag() {
        return this.water_travel.get_Current_Country_Flag();
    }

    public void set_Current_Country_Flag(String curr_country_flag) {
        this.water_travel.set_Current_Country_Flag(curr_country_flag);
    }

    @Override
    public int getWheels_num() {
        return this.land_travel.getWheels_num();
    }

    @Override
    public String getRoad() {
        return this.land_travel.getRoad();
    }
}

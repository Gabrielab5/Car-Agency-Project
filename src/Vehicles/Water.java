package Vehicles;

import java.util.Objects;

public class Water extends Vehicle implements Waterable {
    protected Boolean with_wind_dir;
    protected String flag;

    public Water(String model, int max_passengers, int max_speed, Boolean with_wind_dir, String flag) {
        super(model, max_passengers, max_speed);
        this.with_wind_dir = with_wind_dir;
        this.flag = flag;

    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (!super.equals(obj)) {
            return false;
        }
        else if (obj instanceof Water other)
        {
            if (this.flag == null)
            {
                if (other.flag != null) {
                    return false;
                }
            } else if (!this.flag.equals(other.flag))
                return false;
                else return Objects.equals(this.with_wind_dir, other.with_wind_dir);
        }
        return false;
    }

    public String toString() {
        return super.toString() + "\nFlag: " + this.flag + "\nWind direction: " + this.with_wind_dir;
    }

    public Boolean Is_With_Wind_Dir() {
        return this.with_wind_dir;
    }


    public void Set_With_Wind_Dir(Boolean with_wind_dir) {
        this.with_wind_dir = with_wind_dir;
    }

    public String get_Current_Country_Flag() {
        return this.flag;
    }

    public void set_Current_Country_Flag(String flag) {
        this.flag = flag;
    }
}


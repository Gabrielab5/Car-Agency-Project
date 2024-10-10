package Vehicles;

public class Air extends Vehicle {
    protected String type;

    public Air(String model, int max_passengers, int max_speed, String type) {
        super(model, max_passengers, max_speed);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (obj instanceof Air other) {
            if (this.type == null) {
                return other.type == null;
            } else {
                return this.type.equals(other.type);
            }
        } else {
            return false;
        }
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "\nType: " + this.type;
    }
}


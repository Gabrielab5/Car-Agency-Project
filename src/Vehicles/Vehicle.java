
package Vehicles;

import java.awt.*;


public abstract class Vehicle implements VehicleColor, VehicleStatus, Cloneable{
    public static final String testDrive = "Test Drive";
    public static final String inStock = "In Stock";
    public static final String purchase = "Purchase";
    private String model;
    private int total_dist;
    private int max_passengers;
    private int max_speed;
    private String img_src;
    private Color color;
    private String status;

    public Vehicle(String model, int max_passengers, int max_speed) {
        this.model = model;
        this.max_passengers = max_passengers;
        this.max_speed = max_speed;
        this.color = Color.white;
        this.status = inStock;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){ return status; }
    public void Travel_Distance(int distance) {
        this.total_dist += distance;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMax_passengers() {
        return this.max_passengers;
    }

    public void setMax_passengers(int max_passengers) {
        this.max_passengers = max_passengers;
    }

    public int getMax_speed() {
        return this.max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }
    public int getTotal_dist() {
        return this.total_dist;
    }

    public String toString() {
        return "Model: " + this.getModel() + ", Traveled: " + this.getTotal_dist() + ", Max speed: " + this.getMax_speed() +
                "Mph, Max people: " + this.getMax_passengers() + ", Status: " + this.getStatus();
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Vehicle other = (Vehicle)obj;
            if (this.max_passengers != other.max_passengers) {
                return false;
            } else if (this.max_speed != other.max_speed) {
                return false;
            } else if (this.model == null) {
                return other.model == null;
            } else {
                return this.model.equals(other.model);
            }
        }
    }

    public void resetDistanceTraveled() {
        this.total_dist = 0;
    }
    public void setImageSource(String img_src) {
        this.img_src = img_src;
    }
    public String getImageSource() {
        return this.img_src;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
       Object other = super.clone();
        ((Vehicle)other).color = new Color(this.color.getRGB());
        return other;
    }

}

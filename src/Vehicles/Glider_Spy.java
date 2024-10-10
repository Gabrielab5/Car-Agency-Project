
package Vehicles;

public class Glider_Spy extends Air implements Not_Motorized {
    private String power_source;
    private final char energetic_score = 'C';

    public Glider_Spy(String power_source) {
        super("Classified", 1, 50, "Military");
        this.power_source = power_source;
    }

    public String getPower_Source() {
        return this.power_source;
    }
    public void setPower_source(String power_source) {
        this.power_source = power_source;
    }

    public char getEnergetic_Score() {
        return this.energetic_score;
    }

    public String toString() {
        String var10000 = super.toString();
        return "Glider_Spy-> \n" + var10000 + ", Power source: " + this.power_source + ", Energetic Score: " + this.energetic_score + ".";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (obj instanceof Glider_Spy other) {
            if (this.energetic_score != other.getEnergetic_Score()) {
                return false;
            } else if (this.power_source == null && other.power_source != null) {
                return false;
            } else {
                assert this.power_source != null;

                return this.power_source.equals(other.getPower_Source());
            }
        } else {
            return false;
        }
    }
}

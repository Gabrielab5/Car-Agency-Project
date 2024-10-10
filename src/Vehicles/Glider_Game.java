

package Vehicles;

public class Glider_Game extends Air implements Not_Motorized {
    private final String power_source = "Manual";
    private String use;
    private final char energetic_score = 'A';

    public Glider_Game() {
        super("Toy", 0, 10, "Civilian");
    }

    public String getPower_Source() {
        return this.power_source;
    }

    public char getEnergetic_Score() {
        return this.energetic_score;
    }

    public String toString() {
        String var10000 = super.toString();
        return "Glider_Game->\n" + var10000 + "\nPower source: " + this.power_source + "\nEnergetic Score: " + this.energetic_score;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (obj instanceof Glider_Game) {
            Glider_Game other = (Glider_Game)obj;
            if (this.energetic_score != other.getEnergetic_Score()) {
                return false;
            } else if (this.power_source == null && other.getPower_Source() != null) {
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


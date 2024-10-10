package Vehicles;

public class AirFactory {

    public static Air createVehicle(String type,String power_source){
        if (type.equals(VehicleFactory.GliderGame)) return new Glider_Game();
        if (type.equals(VehicleFactory.GliderSpy)) return new Glider_Spy(power_source);
     return null;
    }

}

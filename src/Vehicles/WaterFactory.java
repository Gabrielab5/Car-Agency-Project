package Vehicles;

public class WaterFactory {
    public static Water createVehicle(String type, String model, int max_passengers, int max_speed, int gas_consumption, String flag,int engine, boolean windDir){
        if (type.equals(VehicleFactory.Frigate)) return new Frigate(model,max_passengers,max_speed,windDir);
        if (type.equals(VehicleFactory.CruiseShip)) return new Cruise_Ship(model,max_passengers,max_speed,flag,gas_consumption,engine);
        return null;
    }
}

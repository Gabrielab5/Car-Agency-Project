package Vehicles;

public class LandFactory {

    public static Vehicle createVehicle(String type, String model, int max_passengers, int max_speed, int engine_life, int wheels_num, String road, int gas_consumption, String flag){
        if (type.equals(VehicleFactory.Jeep)) return new Jeep(model,gas_consumption,max_speed,engine_life);
        if (type.equals(VehicleFactory.Bicycle)) return new Bicycle(model,max_passengers,max_speed,road);
        if (type.equals(VehicleFactory.ElectricBicycle)) return new Electric_Bicycle(model,max_passengers,max_speed,road);
        if (type.equals(VehicleFactory.Amphibian)) return new Amphibian(model,max_passengers,max_speed,wheels_num,flag,engine_life,gas_consumption);
        if (type.equals(VehicleFactory.HybridAircraft)) return new Hybrid_Aircraft(model,max_passengers,max_speed,wheels_num,flag,engine_life,gas_consumption);
        else return null;
    }
}

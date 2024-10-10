package Vehicles;

import javax.swing.*;

public class VehicleFactory {

    public static final String Jeep = "Jeep";
    public static final String Bicycle = "Bicycle";
    public static final String ElectricBicycle = "Electric Bicycle";
    public static final String CruiseShip = "Cruise ship";
    public static final String Frigate = "Frigate";
    public static final String Amphibian = "Amphibian";
    public static final String HybridAircraft = "Hybrid Aircraft";
    public static final String GliderSpy = "Glider Spy";
    public static final String GliderGame = "Glider Game";
    public static final String LAND = "LAND";
    public static final String AIR = "AIR";
    public static final String WATER = "WATER";

    Vehicle createLand(String type, String model, int max_passengers, int max_speed, int engine_life, int wheels_num, String road, int gas_consumption, String flag){
        return LandFactory.createVehicle(type, model, max_passengers, max_speed, engine_life, wheels_num, road, gas_consumption,flag);
    }
    Vehicle createWater(String type, String model, int max_passengers, int max_speed, int gas_consumption, String flag,int engine, boolean windDir){
        return WaterFactory.createVehicle(type, model, max_passengers, max_speed, gas_consumption, flag, engine, windDir);
    }
    Vehicle createAir(String type,String power_source){
        return AirFactory.createVehicle(type, power_source);
    }

}

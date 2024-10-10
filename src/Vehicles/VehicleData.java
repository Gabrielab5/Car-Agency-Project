package Vehicles;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleData implements Iterable<Vehicle> {
    private static final VehicleData [] memento = new VehicleData[3];
    private static int index = 0; // version index
    private final ArrayList<Vehicle> vehicles;
    private final ArrayList<Updateable> updateables;
    private static VehicleData instance = new VehicleData();
    private final ReentrantLock vehicleLock = new ReentrantLock(true);
    private long totalDistance;
    private VehicleData(){
        vehicles = new ArrayList<Vehicle>();
        updateables = new ArrayList<Updateable>();
    }
    private VehicleData(VehicleData other){
        vehicles = new ArrayList<Vehicle>();
        updateables = other.updateables;
        for (Vehicle v : other.vehicles) {
            try {
                vehicles.add((Vehicle) v.clone());
            }catch(CloneNotSupportedException ex){
                System.out.println(ex);
            }
        }
        this.totalDistance = other.totalDistance;
    }
    public int size(){
        return vehicles.size();
    }
    public static VehicleData getInstance(){
        return instance;
    }
    public synchronized void updateDistance(long distance){
        totalDistance+=distance;
    }
    public synchronized long getTotalDistance(){ return totalDistance;}
    public synchronized void add(Vehicle vehicle){
        vehicles.add(vehicle);
        notifyListeners();
    }
    public void addlistener(Updateable updateable) {
        if (!updateables.contains(updateable))
            updateables.add(updateable);
    }

    public void notifyListeners(){
        for (Updateable u : updateables) {
            u.updateHandler();
        }
    }
    @Override
    public Iterator<Vehicle> iterator() {
        return vehicles.iterator();
    }
    public Vehicle get(int index){
        return vehicles.get(index);
    }
    public synchronized boolean remove(int index){
        Vehicle v = vehicles.get(index);
        if(Objects.equals(v.getStatus(), Vehicle.testDrive))
            return false;
        vehicles.remove(index);
        notifyListeners();
        return true;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof VehicleData other))
            return false;
        return vehicles.equals(other.vehicles) && (totalDistance == other.totalDistance) && (updateables.equals(other.updateables));
    }
    public static void save(){
        if (instance.vehicleLock.isLocked()){
            return;
        }
        if (index == 0){
            memento[index] = new VehicleData(instance);
            index++;
            JOptionPane.showMessageDialog(null, "Saved successfully! It's your first save!", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(index < memento.length){
            if(!instance.equals(memento[index-1])){
                memento[index] = new VehicleData(instance);
                index++;
                JOptionPane.showMessageDialog(null, "Saved successfully!", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            if(!instance.equals(memento[index-1])){
                memento[0] = memento[1];
                memento[1] = memento[2];
                memento[2] = new VehicleData(instance);
                JOptionPane.showMessageDialog(null, "Saved successfully! Your oldest version deleted!", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public static void load(int choise){
        if (instance.vehicleLock.isLocked()){   // loop over the vehicles and check none is in test
            JOptionPane.showMessageDialog(null, "Wait until all test drives are done", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (choise >= index || memento[choise] == null)
        {
            JOptionPane.showMessageDialog(null, "No such version", "Vehicle System", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        instance = new VehicleData(memento[choise]);
        instance.notifyListeners();
        if (choise == 0) {
            memento[0] = memento[1];
            memento[1] = memento[2];
            memento[2] = null;
        }
        else if ( choise == 1) {
            memento[1] = memento[2];
            memento[2] = null;
        }
        else
            memento[2] = null;
        index--;
    }
}

package com.adomlogistics.service;

import com.adomlogistics.datastructures.MyList;
import com.adomlogistics.model.Vehicle;
import com.adomlogistics.util.FileManager;
import java.util.List;

public class VehicleService {
    private MyList<Vehicle> vehicles = new MyList<>();

    public VehicleService() {
        List<Vehicle> loaded = FileManager.loadVehicles();
        for (Vehicle v : loaded) {
            vehicles.add(v);
        }
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        FileManager.saveVehicles(vehicles.toList());
    }

    public boolean removeVehicle(String regNum) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getRegistrationNumber().equals(regNum)) {
                vehicles.remove(i);
                FileManager.saveVehicles(vehicles.toList());
                return true;
            }
        }
        return false;
    }

    public Vehicle searchVehicle(String regNum) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getRegistrationNumber().equals(regNum)) {
                return vehicles.get(i);
            }
        }
        return null;
    }

    public List<Vehicle> listVehicles() {
        return vehicles.toList();
    }
}

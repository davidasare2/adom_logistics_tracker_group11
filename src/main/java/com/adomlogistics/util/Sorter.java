package com.adomlogistics.util;

import com.adomlogistics.model.Vehicle;
import java.util.List;

public class Sorter {
    // Insertion sort by fuel usage (ascending)
    public static void sortByFuelUsage(List<Vehicle> vehicles) {
        for (int i = 1; i < vehicles.size(); i++) {
            Vehicle key = vehicles.get(i);
            int j = i - 1;
            while (j >= 0 && vehicles.get(j).getFuelUsage() > key.getFuelUsage()) {
                vehicles.set(j + 1, vehicles.get(j));
                j--;
            }
            vehicles.set(j + 1, key);
        }
    }
}

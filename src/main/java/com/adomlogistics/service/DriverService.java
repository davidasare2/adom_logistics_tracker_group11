package com.adomlogistics.service;

import com.adomlogistics.datastructures.MyQueue;
import com.adomlogistics.model.Driver;
import com.adomlogistics.util.FileManager;
import java.util.List;

public class DriverService {
    private MyQueue<Driver> availableDrivers = new MyQueue<>();

    public DriverService() {
        List<Driver> loaded = FileManager.loadDrivers();
        for (Driver d : loaded) {
            availableDrivers.enqueue(d);
        }
    }

    public void addDriver(Driver d) {
        availableDrivers.enqueue(d);
        FileManager.saveDrivers(availableDrivers.toList());
    }

    public Driver assignDriver() {
        if (!availableDrivers.isEmpty()) {
            Driver d = availableDrivers.dequeue();
            FileManager.saveDrivers(availableDrivers.toList());
            return d;
        }
        return null;
    }

    public List<Driver> listAvailableDrivers() {
        return availableDrivers.toList();
    }
}

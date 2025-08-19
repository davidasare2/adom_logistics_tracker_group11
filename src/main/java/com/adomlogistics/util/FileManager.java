package com.adomlogistics.util;

import com.adomlogistics.model.Driver;
import com.adomlogistics.model.MaintenanceRecord;
import com.adomlogistics.model.Vehicle;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileManager {
    private static final String MAINTENANCE_FILE = "maintenance.txt";

    public static List<MaintenanceRecord> loadMaintenanceRecords() {
        List<MaintenanceRecord> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MAINTENANCE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    MaintenanceRecord r = new MaintenanceRecord(parts[0], parts[1], Double.parseDouble(parts[2]));
                    records.add(r);
                }
            }
        } catch (IOException e) {
            // File may not exist yet; that's OK
        }
        return records;
    }

    public static void saveMaintenanceRecords(List<MaintenanceRecord> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(MAINTENANCE_FILE))) {
            for (MaintenanceRecord r : records) {
                bw.write(r.getDate() + "," + r.getPartsReplaced() + "," + r.getCost());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving maintenance records: " + e.getMessage());
        }
    }
    private static final String VEHICLE_FILE = "vehicles.txt";
    private static final String DRIVER_FILE = "drivers.txt";
    private static final String DELIVERY_FILE = "deliveries.txt";
    public static List<com.adomlogistics.model.Delivery> loadDeliveries() {
        List<com.adomlogistics.model.Delivery> deliveries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DELIVERY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    com.adomlogistics.model.Delivery d = new com.adomlogistics.model.Delivery(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    deliveries.add(d);
                }
            }
        } catch (IOException e) {
            // File may not exist yet; that's OK
        }
        return deliveries;
    }

    public static void saveDeliveries(List<com.adomlogistics.model.Delivery> deliveries) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DELIVERY_FILE))) {
            for (com.adomlogistics.model.Delivery d : deliveries) {
                bw.write(d.getPackageId() + "," + d.getOrigin() + "," + d.getDestination() + "," + d.getAssignedVehicle() + "," + d.getAssignedDriver() + "," + d.getEta());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving deliveries: " + e.getMessage());
        }
    }

    public static List<Vehicle> loadVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(VEHICLE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    Vehicle v = new Vehicle(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]), parts[4]);
                    vehicles.add(v);
                }
            }
        } catch (IOException e) {
            // File may not exist yet; that's OK
        }
        return vehicles;
    }

    public static void saveVehicles(List<Vehicle> vehicles) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(VEHICLE_FILE))) {
            for (Vehicle v : vehicles) {
                bw.write(v.getRegistrationNumber() + "," + v.getType() + "," + v.getMileage() + "," + v.getFuelUsage() + "," + v.getDriverId());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving vehicles: " + e.getMessage());
        }
    }

    public static List<Driver> loadDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DRIVER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    Driver d = new Driver(parts[0], parts[1], Integer.parseInt(parts[2]));
                    drivers.add(d);
                }
            }
        } catch (IOException e) {
            // File may not exist yet; that's OK
        }
        return drivers;
    }

    public static void saveDrivers(List<Driver> drivers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DRIVER_FILE))) {
            for (Driver d : drivers) {
                bw.write(d.getId() + "," + d.getName() + "," + d.getExperience());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving drivers: " + e.getMessage());
        }
    }
}

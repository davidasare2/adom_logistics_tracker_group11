
package com.adomlogistics;

import com.adomlogistics.cli.Menu;
import com.adomlogistics.model.Delivery;
import com.adomlogistics.model.Driver;
import com.adomlogistics.model.MaintenanceRecord;
import com.adomlogistics.model.Vehicle;
import com.adomlogistics.service.DeliveryService;
import com.adomlogistics.service.DriverService;
import com.adomlogistics.service.MaintenanceService;
import com.adomlogistics.service.VehicleService;
import com.adomlogistics.util.Sorter;
import java.util.Scanner;

public class FleetManagementSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu();
            boolean running = true;
            System.out.println("Welcome to Adom Logistics Fleet Management System");
            while (running) {
                menu.displayMainMenu();
                System.out.print("Select an option: ");
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> vehicleMenuLoop(menu, scanner);
                    case "2" -> driverMenuLoop(menu, scanner);
                    case "3" -> deliveryMenuLoop(menu, scanner);
                    case "4" -> maintenanceMenuLoop(menu, scanner);
                    case "5" -> fuelMenuLoop(menu, scanner);
                    case "6" -> {
                        System.out.println("Exiting. Thank you for your service!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.\n");
                }
            }
        }
    }

    // ...existing code from App.java (all methods and logic)...

        private static void vehicleMenuLoop(Menu menu, Scanner scanner) {
            VehicleService vehicleService = new VehicleService();
            boolean back = false;
            while (!back) {
                menu.vehicleMenu(scanner);
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        System.out.print("Enter registration number: ");
                        String reg = scanner.nextLine();
                        System.out.print("Enter type (truck/van): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter mileage: ");
                        int mileage = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter fuel usage: ");
                        double fuel = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter driver ID: ");
                        String driverId = scanner.nextLine();
                        Vehicle v = new Vehicle(reg, type, mileage, fuel, driverId);
                        vehicleService.addVehicle(v);
                        System.out.println("Vehicle added successfully.");
                    }
                    case "2" -> {
                        System.out.print("Enter registration number to remove: ");
                        String reg = scanner.nextLine();
                        boolean removed = vehicleService.removeVehicle(reg);
                        if (removed) System.out.println("Vehicle removed.");
                        else System.out.println("Vehicle not found.");
                    }
                    case "3" -> {
                        System.out.print("Enter registration number to search: ");
                        String reg = scanner.nextLine();
                        Vehicle v = vehicleService.searchVehicle(reg);
                        if (v != null) {
                            System.out.println("Found: " + v.getRegistrationNumber() + ", Type: " + v.getType() + ", Mileage: " + v.getMileage() + ", Fuel: " + v.getFuelUsage() + ", Driver: " + v.getDriverId());
                        } else {
                            System.out.println("Vehicle not found.");
                        }
                    }
                    case "4" -> {
                        var list = vehicleService.listVehicles();
                        if (list.isEmpty()) {
                            System.out.println("No vehicles found.");
                        } else {
                            for (Vehicle v : list) {
                                System.out.println(v.getRegistrationNumber() + ", Type: " + v.getType() + ", Mileage: " + v.getMileage() + ", Fuel: " + v.getFuelUsage() + ", Driver: " + v.getDriverId());
                            }
                        }
                    }
                    case "5" -> back = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void driverMenuLoop(Menu menu, Scanner scanner) {
            DriverService driverService = new DriverService();
            boolean back = false;
            while (!back) {
                menu.driverMenu(scanner);
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        System.out.print("Enter driver ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter driver name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter experience (years): ");
                        int exp = Integer.parseInt(scanner.nextLine());
                        Driver d = new Driver(id, name, exp);
                        driverService.addDriver(d);
                        System.out.println("Driver added successfully.");
                    }
                    case "2" -> {
                        Driver d = driverService.assignDriver();
                        if (d != null) {
                            System.out.println("Assigned driver: " + d.getId() + " - " + d.getName());
                        } else {
                            System.out.println("No available drivers to assign.");
                        }
                    }
                    case "3" -> {
                        var list = driverService.listAvailableDrivers();
                        if (list.isEmpty()) {
                            System.out.println("No available drivers.");
                        } else {
                            for (Driver d : list) {
                                System.out.println(d.getId() + ", Name: " + d.getName() + ", Experience: " + d.getExperience() + " years");
                            }
                        }
                    }
                    case "4" -> back = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void deliveryMenuLoop(Menu menu, Scanner scanner) {
            DeliveryService deliveryService = new DeliveryService();
            boolean back = false;
            while (!back) {
                menu.deliveryMenu(scanner);
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        System.out.print("Enter package ID: ");
                        String packageId = scanner.nextLine();
                        System.out.print("Enter origin: ");
                        String origin = scanner.nextLine();
                        System.out.print("Enter destination: ");
                        String destination = scanner.nextLine();
                        System.out.print("Enter assigned vehicle: ");
                        String assignedVehicle = scanner.nextLine();
                        System.out.print("Enter assigned driver: ");
                        String assignedDriver = scanner.nextLine();
                        System.out.print("Enter ETA: ");
                        String eta = scanner.nextLine();
                        Delivery d = new Delivery(packageId, origin, destination, assignedVehicle, assignedDriver, eta);
                        deliveryService.addDelivery(d);
                        System.out.println("Delivery added successfully.");
                    }
                    case "2" -> {
                        System.out.print("Enter package ID to update: ");
                        String packageId = scanner.nextLine();
                        System.out.print("Enter new ETA: ");
                        String newEta = scanner.nextLine();
                        boolean updated = deliveryService.updateDeliveryStatus(packageId, newEta);
                        if (updated) System.out.println("Delivery status updated.");
                        else System.out.println("Delivery not found.");
                    }
                    case "3" -> {
                        var list = deliveryService.listDeliveries();
                        if (list.isEmpty()) {
                            System.out.println("No deliveries found.");
                        } else {
                            for (Delivery d : list) {
                                System.out.println(d.getPackageId() + ", From: " + d.getOrigin() + ", To: " + d.getDestination() + ", Vehicle: " + d.getAssignedVehicle() + ", Driver: " + d.getAssignedDriver() + ", ETA: " + d.getEta());
                            }
                        }
                    }
                    case "4" -> back = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void maintenanceMenuLoop(Menu menu, Scanner scanner) {
            MaintenanceService maintenanceService = new MaintenanceService();
            boolean back = false;
            while (!back) {
                menu.maintenanceMenu(scanner);
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter parts replaced: ");
                        String parts = scanner.nextLine();
                        System.out.print("Enter cost: ");
                        double cost = Double.parseDouble(scanner.nextLine());
                        MaintenanceRecord r = new MaintenanceRecord(date, parts, cost);
                        maintenanceService.addRecord(r);
                        System.out.println("Maintenance record added.");
                    }
                    case "2" -> {
                        var list = maintenanceService.listRecords();
                        if (list.isEmpty()) {
                            System.out.println("No maintenance records found.");
                        } else {
                            for (MaintenanceRecord r : list) {
                                System.out.println(r.getDate() + ", Parts: " + r.getPartsReplaced() + ", Cost: " + r.getCost());
                            }
                        }
                    }
                    case "3" -> back = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void fuelMenuLoop(Menu menu, Scanner scanner) {
            VehicleService vehicleService = new VehicleService();
            boolean back = false;
            while (!back) {
                menu.fuelMenu(scanner);
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                        var list = vehicleService.listVehicles();
                        if (list.isEmpty()) {
                            System.out.println("No vehicles found.");
                            break;
                        }
                        double totalFuel = 0;
                        for (var v : list) totalFuel += v.getFuelUsage();
                        double avgFuel = totalFuel / list.size();
                        System.out.printf("Average fuel usage: %.2f\n", avgFuel);
                        System.out.println("Flagged outliers (fuel usage > 120%% of average):");
                        boolean foundOutlier = false;
                        for (var v : list) {
                            if (v.getFuelUsage() > 1.2 * avgFuel) {
                                System.out.println(v.getRegistrationNumber() + ", Fuel: " + v.getFuelUsage());
                                foundOutlier = true;
                            }
                        }
                        if (!foundOutlier) System.out.println("None.");
                        System.out.println("\nVehicles sorted by fuel usage (ascending):");
                        Sorter.sortByFuelUsage(list);
                        for (var v : list) {
                            System.out.println(v.getRegistrationNumber() + ", Fuel: " + v.getFuelUsage());
                        }
                    }
                    case "2" -> back = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
}

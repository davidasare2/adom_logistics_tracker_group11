package com.adomlogistics.model;

public class Delivery {
    private String packageId;
    private String origin;
    private String destination;
    private String assignedVehicle;
    private String assignedDriver;
    private String eta;

    public Delivery(String packageId, String origin, String destination, String assignedVehicle, String assignedDriver, String eta) {
        this.packageId = packageId;
        this.origin = origin;
        this.destination = destination;
        this.assignedVehicle = assignedVehicle;
        this.assignedDriver = assignedDriver;
        this.eta = eta;
    }

    public String getPackageId() { return packageId; }
    public void setPackageId(String packageId) { this.packageId = packageId; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getAssignedVehicle() { return assignedVehicle; }
    public void setAssignedVehicle(String assignedVehicle) { this.assignedVehicle = assignedVehicle; }
    public String getAssignedDriver() { return assignedDriver; }
    public void setAssignedDriver(String assignedDriver) { this.assignedDriver = assignedDriver; }
    public String getEta() { return eta; }
    public void setEta(String eta) { this.eta = eta; }
}

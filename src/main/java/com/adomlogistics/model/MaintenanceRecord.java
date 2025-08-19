package com.adomlogistics.model;

public class MaintenanceRecord {
    private String date;
    private String partsReplaced;
    private double cost;

    public MaintenanceRecord(String date, String partsReplaced, double cost) {
        this.date = date;
        this.partsReplaced = partsReplaced;
        this.cost = cost;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getPartsReplaced() { return partsReplaced; }
    public void setPartsReplaced(String partsReplaced) { this.partsReplaced = partsReplaced; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}

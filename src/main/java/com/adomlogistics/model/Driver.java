package com.adomlogistics.model;

public class Driver {
    private String id;
    private String name;
    private int experience;
    private String assignedRoute;
    private int recentDelays;
    private int infractions;

    public Driver(String id, String name, int experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.assignedRoute = "";
        this.recentDelays = 0;
        this.infractions = 0;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public String getAssignedRoute() { return assignedRoute; }
    public void setAssignedRoute(String assignedRoute) { this.assignedRoute = assignedRoute; }
    public int getRecentDelays() { return recentDelays; }
    public void setRecentDelays(int recentDelays) { this.recentDelays = recentDelays; }
    public int getInfractions() { return infractions; }
    public void setInfractions(int infractions) { this.infractions = infractions; }
}

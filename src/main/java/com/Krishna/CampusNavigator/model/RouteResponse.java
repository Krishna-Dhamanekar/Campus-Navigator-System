package com.Krishna.CampusNavigator.model;

import java.util.List;

public class RouteResponse {

    private double totalWeight;    // composite cost
    private int    totalDistance;  // metres
    private int    totalTime;      // minutes
    private int    totalTraffic;   // sum of traffic scores
    private List<String> path;

    public RouteResponse(double totalWeight,
                         int totalDistance,
                         int totalTime,
                         int totalTraffic,
                         List<String> path) {
        this.totalWeight   = totalWeight;
        this.totalDistance = totalDistance;
        this.totalTime     = totalTime;
        this.totalTraffic  = totalTraffic;
        this.path          = path;
    }

    public double       getTotalWeight()   { return totalWeight; }
    public int          getTotalDistance() { return totalDistance; }
    public int          getTotalTime()     { return totalTime; }
    public int          getTotalTraffic()  { return totalTraffic; }
    public List<String> getPath()          { return path; }

    @Override
    public String toString() {
        return "RouteResponse{weight=" + totalWeight +
                ", distance=" + totalDistance +
                ", time=" + totalTime +
                ", traffic=" + totalTraffic +
                ", path=" + path + "}";
    }
}
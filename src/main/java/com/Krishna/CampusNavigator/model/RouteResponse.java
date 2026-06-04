package com.Krishna.CampusNavigator.model;

import java.util.List;

public class RouteResponse {

    private int totalDistance;
    private List<String> path;

    public RouteResponse(int totalDistance, List<String> path) {
        this.totalDistance = totalDistance;
        this.path = path;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public List<String> getPath() {
        return path;
    }
    @Override
    public String toString() {
        return "RouteResponse{" +
                "totalDistance=" + totalDistance +
                ", path=" + path +
                '}';
    }
}
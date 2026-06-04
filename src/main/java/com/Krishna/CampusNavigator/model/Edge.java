package com.Krishna.CampusNavigator.model;

public class Edge {

    private int destination;
    private int distance;

    public Edge(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public int getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", distance=" + distance +
                '}';
    }
}
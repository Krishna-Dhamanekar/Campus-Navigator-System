package com.Krishna.CampusNavigator.model;

public class Edge {

    private int destination;
    private int distance;   // in metres
    private int time;       // in minutes
    private int traffic;    // 1–10 scale

    public Edge(int destination, int distance, int time, int traffic) {
        this.destination = destination;
        this.distance    = distance;
        this.time        = time;
        this.traffic     = traffic;
    }

    public int getDestination() { return destination; }
    public int getDistance()    { return distance; }
    public int getTime()        { return time; }
    public int getTraffic()     { return traffic; }

    /**
     * Composite Weight = α × distance + β × time + γ × traffic
     * α = 1.0  (distance weight)
     * β = 0.5  (time weight)
     * γ = 2.0  (traffic weight — penalised most)
     */
    public double getWeight() {
        double alpha = 1.0;
        double beta  = 0.5;
        double gamma = 2.0;
        return alpha * distance + beta * time + gamma * traffic;
    }

    @Override
    public String toString() {
        return "Edge{dest=" + destination +
                ", dist=" + distance +
                ", time=" + time +
                ", traffic=" + traffic +
                ", weight=" + getWeight() + "}";
    }
}
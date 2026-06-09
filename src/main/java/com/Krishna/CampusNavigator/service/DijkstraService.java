package com.Krishna.CampusNavigator.service;

import com.Krishna.CampusNavigator.graph.CampusGraph;
import com.Krishna.CampusNavigator.graph.NodeNames;
import com.Krishna.CampusNavigator.model.Edge;
import com.Krishna.CampusNavigator.model.RouteResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DijkstraService {

    private final CampusGraph campusGraph;

    public DijkstraService(CampusGraph campusGraph) {
        this.campusGraph = campusGraph;
    }

    public RouteResponse findShortestPath(int source, int destination) {

        Map<Integer, List<Edge>> graph = campusGraph.getGraph();
        int n = 16;

        double[] weight   = new double[n];
        int[]    distance = new int[n];
        int[]    time     = new int[n];
        int[]    traffic  = new int[n];
        int[]    parent   = new int[n];

        Arrays.fill(weight,   Double.MAX_VALUE);
        Arrays.fill(distance, 0);
        Arrays.fill(time,     0);
        Arrays.fill(traffic,  0);
        Arrays.fill(parent,   -1);

        weight[source] = 0;

        // Priority queue ordered by composite weight
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Comparator.comparingDouble(a -> weight[a]));
        pq.add(source);

        while (!pq.isEmpty()) {

            int current = pq.poll();

            for (Edge edge : graph.getOrDefault(current, Collections.emptyList())) {

                int    nbr       = edge.getDestination();
                double newWeight = weight[current] + edge.getWeight();

                if (newWeight < weight[nbr]) {
                    weight[nbr]   = newWeight;
                    distance[nbr] = distance[current] + edge.getDistance();
                    time[nbr]     = time[current]     + edge.getTime();
                    traffic[nbr]  = traffic[current]  + edge.getTraffic();
                    parent[nbr]   = current;
                    pq.add(nbr);
                }
            }
        }

        if (weight[destination] == Double.MAX_VALUE) {
            return new RouteResponse(-1, -1, -1, -1, List.of("No Path Found"));
        }

        List<String> path = buildPath(parent, destination);

        return new RouteResponse(
                Math.round(weight[destination] * 100.0) / 100.0,
                distance[destination],
                time[destination],
                traffic[destination],
                path
        );
    }

    private List<String> buildPath(int[] parent, int destination) {
        List<String> path = new ArrayList<>();
        while (destination != -1) {
            path.add(NodeNames.NODES.get(destination));
            destination = parent[destination];
        }
        Collections.reverse(path);
        return path;
    }
}
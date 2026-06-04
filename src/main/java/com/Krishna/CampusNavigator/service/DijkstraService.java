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

        int[] distance = new int[n];
        int[] parent = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[source] = 0;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> distance[a]));

        pq.add(source);

        while (!pq.isEmpty()) {

            int current = pq.poll();

            for (Edge edge : graph.getOrDefault(current, Collections.emptyList())) {

                int neighbour = edge.getDestination();
                int newDistance = distance[current] + edge.getDistance();

                if (newDistance < distance[neighbour]) {

                    distance[neighbour] = newDistance;
                    parent[neighbour] = current;

                    pq.add(neighbour);
                }
            }
        }

        // No path exists
        if (distance[destination] == Integer.MAX_VALUE) {
            return new RouteResponse(
                    -1,
                    List.of("No Path Found")
            );
        }

        List<String> path = buildPath(parent, destination);

        return new RouteResponse(distance[destination], path);
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
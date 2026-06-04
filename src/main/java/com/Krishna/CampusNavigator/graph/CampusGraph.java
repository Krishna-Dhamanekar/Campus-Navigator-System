package com.Krishna.CampusNavigator.graph;

import com.Krishna.CampusNavigator.model.Edge;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CampusGraph {

    private final Map<Integer, List<Edge>> graph = new HashMap<>();

    public CampusGraph() {

        // TOP ROW
        addEdge(0,1,60);
        addEdge(1,2,50);
        addEdge(2,3,60);

// SECOND ROW
        addEdge(4,5,60);
        addEdge(5,6,50);
        addEdge(6,7,60);
        addEdge(7,8,60);

// THIRD ROW
        addEdge(9,10,50);
        addEdge(10,11,40);
        addEdge(11,12,50);
        addEdge(12,13,60);

// BOTTOM ROW
        addEdge(14,15,80);

// LEFT COLUMN
        addEdge(0,4,40);
        addEdge(4,9,50);
        addEdge(9,14,50);

// CENTER COLUMN
        addEdge(1,5,40);
        addEdge(5,10,50);

        addEdge(6,11,40);
        addEdge(11,15,40);

// RIGHT COLUMN
        addEdge(2,7,40);
        addEdge(3,8,50);

        addEdge(8,13,60);

// ALTERNATIVE PATHS (DASHED)
        addEdge(0,5,70);
        addEdge(9,5,70);

        addEdge(1,7,70);

        addEdge(3,7,80);

        addEdge(7,13,70);

        addEdge(12,13,70);

        addEdge(12,15,70);// Open Amphitheatre -> 3D Galactic Area
    }

    private void addEdge(int source, int destination, int distance) {

        graph.computeIfAbsent(source, k -> new ArrayList<>())
                .add(new Edge(destination, distance));

        graph.computeIfAbsent(destination, k -> new ArrayList<>())
                .add(new Edge(source, distance));
    }

    public Map<Integer, List<Edge>> getGraph() {
        return graph;
    }
}
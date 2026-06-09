package com.Krishna.CampusNavigator.graph;

import com.Krishna.CampusNavigator.model.Edge;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CampusGraph {

    private final Map<Integer, List<Edge>> graph = new HashMap<>();

    public CampusGraph() {

        // addEdge(src, dst, distanceMetres, timeMinutes, traffic1to10)

        // TOP ROW
        addEdge(0, 1,  60, 1, 2);
        addEdge(1, 2,  50, 1, 1);
        addEdge(2, 3,  60, 1, 2);

        // SECOND ROW
        addEdge(4, 5,  60, 1, 3);
        addEdge(5, 6,  50, 1, 5);
        addEdge(6, 7,  60, 1, 3);
        addEdge(7, 8,  60, 1, 2);

        // THIRD ROW
        addEdge(9,  10, 50, 1, 2);
        addEdge(10, 11, 40, 1, 1);
        addEdge(11, 12, 50, 1, 3);
        addEdge(12, 13, 60, 1, 2);

        // BOTTOM ROW
        addEdge(14, 15, 80, 2, 4);

        // LEFT COLUMN
        addEdge(0, 4,  40, 1, 1);
        addEdge(4, 9,  50, 1, 2);
        addEdge(9, 14, 50, 1, 1);

        // CENTER COLUMN
        addEdge(1,  5,  40, 1, 3);
        addEdge(5,  10, 50, 1, 4);
        addEdge(6,  11, 40, 1, 2);
        addEdge(11, 15, 40, 1, 1);

        // RIGHT COLUMN
        addEdge(2, 7,  40, 1, 2);
        addEdge(3, 8,  50, 1, 3);
        addEdge(8, 13, 60, 1, 2);

        // ALTERNATIVE PATHS
        addEdge(0,  5,  70, 2, 6);
        addEdge(9,  5,  70, 2, 5);
        addEdge(1,  7,  70, 2, 4);
        addEdge(3,  7,  80, 2, 5);
        addEdge(7,  13, 70, 2, 3);
        addEdge(12, 13, 70, 2, 4);
        addEdge(12, 15, 70, 2, 3);
    }

    private void addEdge(int source, int destination,
                         int distance, int time, int traffic) {

        graph.computeIfAbsent(source,      k -> new ArrayList<>())
                .add(new Edge(destination, distance, time, traffic));

        graph.computeIfAbsent(destination, k -> new ArrayList<>())
                .add(new Edge(source, distance, time, traffic));
    }

    public Map<Integer, List<Edge>> getGraph() {
        return graph;
    }
}
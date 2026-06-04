package com.Krishna.CampusNavigator.controller;

import com.Krishna.CampusNavigator.model.RouteResponse;
import com.Krishna.CampusNavigator.service.DijkstraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    private final DijkstraService dijkstraService;

    public RouteController(DijkstraService dijkstraService) {
        this.dijkstraService = dijkstraService;
    }

    @GetMapping("/api/route")
    public RouteResponse getRoute(
            @RequestParam int source,
            @RequestParam int destination
    ) {
        return dijkstraService.findShortestPath(source, destination);
    }
}
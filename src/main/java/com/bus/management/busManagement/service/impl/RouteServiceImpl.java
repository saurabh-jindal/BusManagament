package com.bus.management.busManagement.service.impl;

import com.bus.management.busManagement.model.Route;
import com.bus.management.busManagement.repository.RouteRepository;
import com.bus.management.busManagement.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }
}

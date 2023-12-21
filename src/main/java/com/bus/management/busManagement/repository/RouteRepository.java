package com.bus.management.busManagement.repository;

import com.bus.management.busManagement.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}

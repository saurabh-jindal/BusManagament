package com.bus.management.busManagement.repository;

import com.bus.management.busManagement.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BusRepository extends MongoRepository<Bus, String> {

    @Query(value = "{'route.id': ?0}")
    List<Bus> findByRouteId(String routeId);
}

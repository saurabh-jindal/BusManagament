package com.bus.management.busManagement.service.impl;

import com.bus.management.busManagement.model.Bus;
import com.bus.management.busManagement.model.Route;
import com.bus.management.busManagement.repository.BusRepository;
import com.bus.management.busManagement.repository.RouteRepository;
import com.bus.management.busManagement.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBusById(String busId) {
        return busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + busId));
    }

    @Override
    public Bus updateBus(String busId, Bus bus) {
        Bus existingBus = getBusById(busId);
        // Update existing bus fields
        existingBus.setBusNumber(bus.getBusNumber());
        existingBus.setStartLocation(bus.getStartLocation());
        existingBus.setEndLocation(bus.getEndLocation());
        // Add more fields as needed

        return busRepository.save(existingBus);
    }

    @Override
    public void deleteBus(String busId) {
        busRepository.deleteById(busId);
    }

    public Bus mapBusToRoute(String busId, String routeId, LocalTime tripStartTime, LocalTime tripEndTime) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + busId));

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + routeId));

        checkForScheduleOverlap(route, tripStartTime, tripEndTime);

        bus.setRoute(route);
        bus.setTripStartTime(tripStartTime);
        bus.setTripEndTime(tripEndTime);

        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getBusesByRouteId(String routeId) {
        return busRepository.findByRouteId(routeId);
    }

    private void checkForScheduleOverlap(Route route, LocalTime newStartTime, LocalTime newEndTime) {
        List<Bus> busesOnRoute = busRepository.findByRouteId(route.getId());

        for (Bus existingBus : busesOnRoute) {
            // Check if the new schedule overlaps with any existing schedules
            if (doSchedulesOverlap(existingBus.getTripStartTime(), existingBus.getTripEndTime(),
                    newStartTime, newEndTime)) {
                throw new RuntimeException("Schedule overlap detected for route " + route.getId());
            }
        }
    }

    private boolean doSchedulesOverlap(LocalTime startTime1, LocalTime endTime1,
                                       LocalTime startTime2, LocalTime endTime2) {
        return !(endTime1.isBefore(startTime2) || startTime1.isAfter(endTime2));
    }
}

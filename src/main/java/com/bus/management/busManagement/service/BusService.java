package com.bus.management.busManagement.service;

import com.bus.management.busManagement.model.Bus;

import java.time.LocalTime;
import java.util.List;

public interface BusService {
    Bus saveBus(Bus bus);
    List<Bus> getAllBuses();
    Bus getBusById(String busId);
    Bus updateBus(String busId, Bus bus);
    void deleteBus(String busId);

    Bus mapBusToRoute(String busId, String routeId, LocalTime tripStartTime, LocalTime tripEndTime);

    List<Bus> getBusesByRouteId(String routeId);
}

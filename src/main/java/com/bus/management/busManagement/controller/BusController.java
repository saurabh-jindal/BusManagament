package com.bus.management.busManagement.controller;

import com.bus.management.busManagement.model.Bus;
import com.bus.management.busManagement.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus savedBus = busService.saveBus(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }

    @PutMapping("/{busId}")
    public ResponseEntity<Bus> updateBus(@PathVariable String busId, @RequestBody Bus bus) {
        Bus updatedBus = busService.updateBus(busId, bus);
        return new ResponseEntity<>(updatedBus, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable String busId) {
        Bus bus = busService.getBusById(busId);
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<Void> deleteBus(@PathVariable String busId) {
        busService.deleteBus(busId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/map")
    public ResponseEntity<Bus> mapBusToRoute(@RequestParam String busId, @RequestParam String routeId,
                                             @RequestParam LocalTime tripStartTime, @RequestParam LocalTime tripEndTime) {
        Bus mappedBus = busService.mapBusToRoute(busId, routeId, tripStartTime, tripEndTime);
        return new ResponseEntity<>(mappedBus, HttpStatus.OK);
    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<Bus>> getBusesByRouteId(@PathVariable String routeId) {
        List<Bus> buses = busService.getBusesByRouteId(routeId);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
}

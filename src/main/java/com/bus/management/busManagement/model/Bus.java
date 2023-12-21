package com.bus.management.busManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document(collection = "buses")
public class Bus {
    @Id
    private String id;

    private String busNumber;
    private String startLocation;
    private String endLocation;
    private LocalTime startTime;
    private LocalTime endTime;

    private LocalTime tripStartTime;

    private LocalTime tripEndTime;

    private String busType;




    @DBRef
    private Route route;

    public Bus(String id, String busNumber, String startLocation, String endLocation, LocalTime startTime, LocalTime endTime, LocalTime tripStartTime, LocalTime tripEndTime, String busType, Route route) {
        this.id = id;
        this.busNumber = busNumber;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripStartTime = tripStartTime;
        this.tripEndTime = tripEndTime;
        this.busType = busType;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(LocalTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public LocalTime getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(LocalTime tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    // Constructors, getters, setters
}

package com.bus.management.busManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routes")
public class Route {
    @Id
    private String id;

    private String routeName;

    public Route(String id, String routeName) {
        this.id = id;
        this.routeName = routeName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    // Constructors, getters, setters
}

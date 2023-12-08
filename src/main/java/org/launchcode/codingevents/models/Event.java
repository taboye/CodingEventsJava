package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;
    private String name;
    private String description;
    private String country;

    //Add Constructor
    public Event(String name, String description, String country) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.id = nextId;
        nextId++;
    }

    //Add getter and setter method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

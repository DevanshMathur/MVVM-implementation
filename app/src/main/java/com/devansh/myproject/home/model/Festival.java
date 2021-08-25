package com.devansh.myproject.home.model;

import java.io.Serializable;

public class Festival implements Serializable {
    String uri;
    String name;
    String place;
    String description;

    public Festival(String uri, String name, String place, String description) {
        this.uri = uri;
        this.name = name;
        this.place = place;
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

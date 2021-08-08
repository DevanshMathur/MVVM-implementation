package com.devansh.myproject.model;

import android.net.Uri;

public class Festival {
    String uri;
    String name;
    String description;

    public Festival(String uri, String name, String description) {
        this.uri = uri;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

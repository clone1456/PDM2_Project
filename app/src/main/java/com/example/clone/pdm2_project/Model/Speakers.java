package com.example.clone.pdm2_project.Model;

/**
 * Created by clone on 17-01-2018.
 */

public class Speakers {
    private String name;
    private String description;

    public Speakers(String name, String description) {
        this.name = name;
        this.description = description;

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


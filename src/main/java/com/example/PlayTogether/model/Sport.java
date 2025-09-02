package com.example.PlayTogether.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Sport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sportId;
    private String name;
    private String description;
    private int numberOfPlayers ;
    private String imageName ; // Assuming this is an integer ID for an image resource


    public Sport() {}
    public Sport(String name, String description, int numberOfPlayers) {
        this.name = name;
        this.description = description;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public Long getId() {
        return sportId;
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
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

}

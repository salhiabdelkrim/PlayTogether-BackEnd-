package com.example.PlayTogether.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Encounter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long encounterId;
    @ManyToOne
    @JoinColumn(name = "sportId", nullable = false)
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false)
    private Member createdBy;

    @ManyToOne
    @JoinColumn(name = "locationId", nullable = false)
    private Location location;
    private String dateTime;
    private double price;

    public Encounter() {}

    public Encounter(Long encounterId, Sport sport, Location location, String dateTime, double price) {
        this.encounterId = encounterId;
        this.sport = sport;
        this.location = location;
        this.dateTime = dateTime;
        this.price = price;

    }

    public Long getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(Long encounterId) {
        this.encounterId = encounterId;
    }

    public Sport getSport() {
        return sport;
    }       
    public void setSport(Sport sport) {
        this.sport = sport;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Member getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Member createdBy) {
        this.createdBy = createdBy;
    }
}

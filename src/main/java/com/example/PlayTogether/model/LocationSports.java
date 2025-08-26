package com.example.PlayTogether.model;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LocationSports implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationSportsId;

    @ManyToOne
    @JoinColumn(name = "locationId", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "sportId", nullable = false)
    private Sport sport;

    public LocationSports() {}

    public LocationSports(Long locationSportsId, Location location, Sport sport) {
        this.locationSportsId = locationSportsId;
        this.location = location;
        this.sport = sport;
    }

    public Long getLocationSportsId() {
        return locationSportsId;
    }

    public void setLocationSportsId(Long locationSportsId) {
        this.locationSportsId = locationSportsId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

}

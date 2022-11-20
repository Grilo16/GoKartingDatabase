package com.E60.GoKartingDatabase.race;

import com.E60.GoKartingDatabase.driver.Driver;
import com.E60.GoKartingDatabase.raceDrivers.RaceDriver;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_seq")
    @SequenceGenerator(name = "race_seq")
    @Column(name = "id", nullable = false)
    private Long id;




    @Column(name = "race_date", nullable = false)
    private LocalDateTime raceDate;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "name")
    private String name;


    @JsonBackReference("race_drivers")
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private Set<RaceDriver> raceDrivers = new LinkedHashSet<>();

    @Column(name = "finished")
    private Boolean finished = false;


    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Set<RaceDriver> getRaceDrivers() {
        return raceDrivers;
    }

    public void setRaceDrivers(Set<RaceDriver> raceDrivers) {
        this.raceDrivers = raceDrivers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(LocalDateTime raceDate) {
        this.raceDate = raceDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
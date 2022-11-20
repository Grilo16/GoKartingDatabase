package com.E60.GoKartingDatabase.raceDrivers;

import com.E60.GoKartingDatabase.driver.Driver;
import com.E60.GoKartingDatabase.race.Race;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "race_drivers", uniqueConstraints = {
        @UniqueConstraint(name = "uc_racedriver_finish_position", columnNames = {"finish_position", "race_id"}),
        @UniqueConstraint(name = "uc_racedriver_start_position", columnNames = {"start_position", "race_id"})
})
public class RaceDriver {
    @EmbeddedId
    private RaceDriverId id;

    @MapsId("raceId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @MapsId("driversId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drivers_id", nullable = false)
    private Driver drivers;


    @Column(name = "start_position")
    private Integer startPosition;

    @Column(name = "finish_position")
    private Integer finishPosition;

    public RaceDriver() {
    }

    public RaceDriver(Race race, Driver drivers, Integer startPosition, Integer finishPosition) {
        this.race = race;
        this.drivers = drivers;
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;
    }

    public RaceDriver(RaceDriverId id, Race race, Driver drivers, Integer startPosition, Integer finishPosition) {
        this.id = id;
        this.race = race;
        this.drivers = drivers;
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;
    }

    public Integer getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(Integer finishPosition) {
        this.finishPosition = finishPosition;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public RaceDriverId getId() {
        return id;
    }

    public void setId(RaceDriverId id) {
        this.id = id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver drivers) {
        this.drivers = drivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RaceDriver that = (RaceDriver) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
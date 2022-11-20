package com.E60.GoKartingDatabase.raceDrivers;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RaceDriverId implements Serializable {
    private static final long serialVersionUID = -6041202975393398735L;
    @Column(name = "race_id", nullable = false)
    private Long raceId;

    @Column(name = "drivers_id", nullable = false)
    private Long driversId;

    public RaceDriverId() {
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getDriversId() {
        return driversId;
    }

    public void setDriversId(Long driversId) {
        this.driversId = driversId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RaceDriverId entity = (RaceDriverId) o;
        return Objects.equals(this.raceId, entity.raceId) &&
                Objects.equals(this.driversId, entity.driversId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId, driversId);
    }

}
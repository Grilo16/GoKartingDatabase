package com.E60.GoKartingDatabase.driver;

import com.E60.GoKartingDatabase.race.Race;
import com.E60.GoKartingDatabase.raceDrivers.RaceDriver;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
    @SequenceGenerator(name = "driver_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonBackReference("race_drivers")
    @OneToMany(mappedBy = "drivers", cascade = CascadeType.ALL)
    private Set<RaceDriver> raceDrivers = new LinkedHashSet<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Driver driver = (Driver) o;
        return id != null && Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
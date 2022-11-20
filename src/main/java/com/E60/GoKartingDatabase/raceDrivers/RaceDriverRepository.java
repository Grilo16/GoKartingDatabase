package com.E60.GoKartingDatabase.raceDrivers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RaceDriverRepository extends JpaRepository<RaceDriver, RaceDriverId> {
    List<RaceDriver> findByDrivers_Id(Long id);

    List<RaceDriver> findById_RaceIdOrderByFinishPositionAsc(Long raceId);


}
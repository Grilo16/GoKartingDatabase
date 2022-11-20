package com.E60.GoKartingDatabase.raceDrivers;

import com.E60.GoKartingDatabase.driver.Driver;
import com.E60.GoKartingDatabase.driver.DriverRepository;
import com.E60.GoKartingDatabase.race.Race;
import com.E60.GoKartingDatabase.race.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceDriverService {

    private RaceDriverRepository raceDriverRepository;
    private RaceRepository raceRepository;
    private DriverRepository driverRepository;

    @Autowired
    public RaceDriverService(RaceDriverRepository raceDriverRepository, RaceRepository raceRepository, DriverRepository driverRepository) {
        this.raceDriverRepository = raceDriverRepository;
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }

    public RaceDriver addDriverToRace(Long driverId, Long raceId) {
        RaceDriverId raceDriverId = new RaceDriverId();
        raceDriverId.setDriversId(driverId);
        raceDriverId.setRaceId(raceId);
        RaceDriver raceDriver = new RaceDriver();
        Driver driver = driverRepository.findById(driverId).get();
        Race race = raceRepository.findById(raceId).get();
        raceDriver.setId(raceDriverId);
        raceDriver.setRace(race);
        raceDriver.setDrivers(driver);
        System.out.println(raceDriver.getId());
        return raceDriverRepository.save(raceDriver);

    }

    public List<RaceDriver> getAllRaceDrivers() {
        return raceDriverRepository.findAll();
    }

    public List<RaceDriver> getAllRaceDriversByDriversId(Long driverId) {
        return raceDriverRepository.findByDrivers_Id(driverId);
    }

    public RaceDriver setPositions(RaceDriver raceDriverObj) {
        RaceDriver raceDriver = raceDriverRepository.findById(raceDriverObj.getId()).get();
        raceDriver.setStartPosition(raceDriverObj.getStartPosition());
        raceDriver.setFinishPosition(raceDriverObj.getFinishPosition());
        return raceDriverRepository.save(raceDriver);
    }

    public List<RaceDriver> getRaceResultsByRaceId(Long raceId) {
        return raceDriverRepository.findById_RaceIdOrderByFinishPositionAsc(raceId);
    }
}

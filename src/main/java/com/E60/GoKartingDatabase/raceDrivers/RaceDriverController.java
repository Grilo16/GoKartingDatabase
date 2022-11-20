package com.E60.GoKartingDatabase.raceDrivers;

import com.E60.GoKartingDatabase.race.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "race_drivers")
@CrossOrigin(origins = {"http://localhost:3000/", "https://grilo16.github.io/"})
public class RaceDriverController {

    private RaceDriverService raceDriverService;

    @Autowired
    public RaceDriverController(RaceDriverService raceDriverService) {
        this.raceDriverService = raceDriverService;
    }

    @GetMapping(path = "all")
    public List<RaceDriver> getAllRaceDrivers(){
        return raceDriverService.getAllRaceDrivers();
    }

    @GetMapping(path = "{driverId}")
    public List<RaceDriver> getAllRaceDriversByDriverId(@PathVariable Long driverId){
        return raceDriverService.getAllRaceDriversByDriversId(driverId);
    }

    @GetMapping(path = "/result/{raceId}")
    public List<RaceDriver> getRaceResultsByRaceId(@PathVariable Long raceId){
        return raceDriverService.getRaceResultsByRaceId(raceId);
    }

    @PostMapping(path = "{driverId}/race/{raceId}")
    public RaceDriver addDriverToRace(@PathVariable Long driverId, @PathVariable Long raceId){
        return raceDriverService.addDriverToRace(driverId, raceId);
    }

    @PatchMapping(path = "/setPositions")
    public RaceDriver setPositions(@RequestBody RaceDriver raceDriver){
        return raceDriverService.setPositions(raceDriver);
    }
}

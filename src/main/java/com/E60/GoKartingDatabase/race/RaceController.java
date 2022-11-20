package com.E60.GoKartingDatabase.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "races")
@CrossOrigin("http://localhost:3000/")
public class RaceController {

    private RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/all")
    public List<Race> getAllRaces(){
        return raceService.getAllRaces();
    }

    @PostMapping("/new")
    public Race addNewRace(@RequestBody Race race){
        return raceService.addNewRace(race);
    }

}

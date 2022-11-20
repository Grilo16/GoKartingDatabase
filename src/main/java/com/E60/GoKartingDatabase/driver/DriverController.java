package com.E60.GoKartingDatabase.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drivers")
@CrossOrigin(origins = {"http://localhost:3000/", "https://grilo16.github.io/"})
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(path = "/all")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping(path = "/{driverId}")
    public Driver getDriverById(@PathVariable Long driverId){
        return driverService.getDriverById(driverId);
    }

    @PostMapping(path = "/new")
    public Driver addNewDriver(@RequestBody Driver driver){
        return driverService.addNewDriver(driver);
    }
}

package pl.com.carfleetmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.carfleetmanagementsystem.errorhandler.exception.LocationNotFound;
import pl.com.carfleetmanagementsystem.models.Location;
import pl.com.carfleetmanagementsystem.repository.LocationRepository;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @DeleteMapping("/location/{id}")
    public HttpStatus deleteLocationById(@PathVariable("id") Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new LocationNotFound(id));
        locationRepository.delete(location);
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> findAllCarLogs(){
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok().body(locations);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<Location> findById(@PathVariable("id") Long id){
        Location location = locationRepository.findById(id).orElseThrow(() -> new LocationNotFound(id));
        return ResponseEntity.ok().body(location);

    }

    @PostMapping("/location")
    public ResponseEntity<Location> createCarLogs(@Valid @RequestBody Location location){
        return ResponseEntity.ok().body(locationRepository.save(location));
    }

}

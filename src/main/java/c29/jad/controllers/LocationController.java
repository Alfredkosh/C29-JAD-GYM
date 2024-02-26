package c29.jad.controllers;


import c29.jad.models.GymRoomModel;
import c29.jad.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/gymlocation", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllLocation () {
        List<GymRoomModel> gymLocation = locationService.getAllLocations();
        return new ResponseEntity<>(Map.of("message", "Successful", "data", gymLocation), HttpStatus.OK);
    }


}

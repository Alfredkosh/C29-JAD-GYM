package c29.jad.controllers;



import c29.jad.models.GymRoomModel;
import c29.jad.services.GymRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "gym")
public class GymRoomController {

    @Autowired
    GymRoomService gymRoomService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
        public ResponseEntity<Map<String, Object>> getAllGym () {
            List<GymRoomModel> GymData = gymRoomService.getAllGym();
            return new ResponseEntity<>(Map.of("message", "Successful", "data", GymData), HttpStatus.OK);
    }


}
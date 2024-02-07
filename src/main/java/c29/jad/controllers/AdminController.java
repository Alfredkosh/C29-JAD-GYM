package c29.jad.controllers;

import c29.jad.forms.CheckInRecordForm;
import c29.jad.models.CheckInRecordModel;
import c29.jad.services.CheckInRecordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    CheckInRecordService checkInRecordService;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin(Model model){
        model.addAttribute("message","Welcome Admin");
        return "admin";
    }

    @RequestMapping(value = "/visitor", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> visitor (HttpServletRequest request){
//        Integer gymRoomId = new CheckInRecordForm().getGymRoomId();
//
        int numberOfPeople = checkInRecordService.getAllRecords();
//        int usersNumber = checkInRecords.size();
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("Users number", usersNumber);
//        response.put("Check-In Records", checkInRecords);

        return new ResponseEntity<>(Map.of("Number of people", numberOfPeople), HttpStatus.OK);
    }

}

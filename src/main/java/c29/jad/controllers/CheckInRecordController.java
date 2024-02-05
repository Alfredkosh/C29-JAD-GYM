package c29.jad.controllers;

import c29.jad.forms.CheckInRecordForm;
import c29.jad.models.CheckInRecordModel;
import c29.jad.repositories.CheckInRecordRepository;
import c29.jad.services.CheckInRecordService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "record")
public class CheckInRecordController {

    @Autowired
    CheckInRecordRepository checkInRecordRepository;

    @Autowired
    CheckInRecordService checkInRecordService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
        public ResponseEntity<List<CheckInRecordModel>> getData(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<CheckInRecordModel> data = checkInRecordRepository.findByUserId(userId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> checked(@RequestBody CheckInRecordForm checkInRecordForm){
        try {
            CheckInRecordModel checkIn = checkInRecordService.checkIn(checkInRecordForm);
            return new ResponseEntity<>(Map.of("message", "Check In Successful"), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}

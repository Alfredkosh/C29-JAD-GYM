package c29.jad.controllers;

import c29.jad.models.CheckInRecordModel;
import c29.jad.repositories.CheckInRecordRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "record")
public class CheckInRecordController {

    @Autowired
    CheckInRecordRepository checkInRecordRepository;
    @RequestMapping(value = "/data", method = RequestMethod.GET)
        public ResponseEntity<List<CheckInRecordModel>> getData(HttpSession httpSession) {
        Integer userId = (Integer) httpSession.getAttribute("userId");

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<CheckInRecordModel> data = checkInRecordRepository.findByUserId(userId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}

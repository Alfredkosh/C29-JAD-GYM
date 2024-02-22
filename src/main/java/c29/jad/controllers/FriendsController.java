package c29.jad.controllers;


import c29.jad.forms.FriendsForm;
import c29.jad.models.FriendsModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import c29.jad.services.FriendsListService;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "friends")
public class FriendsController {

    @Autowired
    FriendsListService FriendsListService;



    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity<List<FriendsModel>> getData(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<FriendsModel> data = FriendsListService.getProfileById(userId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}

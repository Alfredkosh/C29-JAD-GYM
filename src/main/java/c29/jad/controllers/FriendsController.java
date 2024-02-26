package c29.jad.controllers;

import c29.jad.forms.CheckInRecordForm;
import c29.jad.forms.FriendsForm;
import c29.jad.mappers.FriendMapper;
import c29.jad.models.FriendsModel;
import c29.jad.services.FriendsListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;



@Controller
@RestController
@RequestMapping(value = "friends")
public class FriendsController {
    @Autowired
    FriendsListService friendsListService;

    @RequestMapping(value = "/friend", method = RequestMethod.POST)
    public ResponseEntity<String> addFriend(HttpServletRequest request, @RequestBody FriendsForm friendsForm) {
        Integer userId = (Integer) request.getAttribute("userId");
        Integer targetUserId = friendsForm.getUserId();
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        friendsListService.addFriend(userId, targetUserId);
        return new ResponseEntity<>("Add friend successful", HttpStatus.OK);
    }


    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    public ResponseEntity<Object> getFriends(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<FriendsModel> friends = friendsListService.getFriends(userId);
        var friendDto = FriendMapper.INSTANCE.mapToFriendDtoList(friends);
        return new ResponseEntity<>(friendDto, HttpStatus.OK);
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


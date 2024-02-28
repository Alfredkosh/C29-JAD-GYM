package c29.jad.controllers;

import c29.jad.forms.CheckInRecordForm;
import c29.jad.forms.FriendsForm;
import c29.jad.mappers.FriendMapper;
import c29.jad.models.FriendsModel;
import c29.jad.repositories.FriendsListRepository;
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
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;



@Controller
@RestController
@RequestMapping(value = "friends")
public class FriendsController {
    @Autowired
    FriendsListService friendsListService;

    @Autowired
    FriendsListRepository friendsListRepository;

    @RequestMapping(value = "/friend", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addFriend(HttpServletRequest request, @RequestBody FriendsForm friendsForm) {
        try {
            Integer userId = (Integer) request.getAttribute("userId");
            Integer targetUserId = friendsForm.getUserId();
            if (userId == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            friendsListService.addFriend(userId, targetUserId);
            return new ResponseEntity<>(Map.of("data", "Add friend successful"), HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<>(Map.of("data", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
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

    @RequestMapping(value = "/friend", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> removeFriend(@RequestBody FriendsForm friendsForm) {
        try {
            var userId = friendsForm.getUserId();
            friendsListRepository.deleteById(userId);
            // Perform necessary operations with the userId, such as removing the friend

            return new ResponseEntity<>(Map.of("message", userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


//    @RequestMapping(value = "/friend", method = RequestMethod.DELETE)
//        public ResponseEntity<Map<String, Object>> removeFriend(HttpServletRequest request, @RequestBody FriendsForm friendsForm) {
//            try {
//                var friendTableId = friendsForm.getUserId();
////                Integer userId = (Integer) request.getAttribute("userId");
//                if (friendTableId == null) {
//                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//                }
//                friendsListRepository.deleteById(friendTableId);
//                return new ResponseEntity<>(Map.of("data", "Remove friend successful"), HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(Map.of("data", e.getMessage()), HttpStatus.BAD_REQUEST);
//            }
//        }




    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


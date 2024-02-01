package c29.jad.controllers;

import c29.jad.forms.UserForm;
import c29.jad.models.UserModel;
import c29.jad.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.Map;

@RestController
@RequestMapping(value = "auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> logout(HttpSession httpSession){
        httpSession.removeAttribute("userId");
        return new ResponseEntity<>(Map.of("message", "Logout Successful"), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> login(HttpSession httpSession, @RequestBody UserForm userForm){
        try{
            Integer userId = userService.login(userForm.getUsername(), userForm.getPassword());
            httpSession.setAttribute("userId", userId);
            return new ResponseEntity<>(Map.of("message", "Login Successful", "userId", userId.toString()), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserForm userForm){
        try {
            UserModel user = userService.register(userForm);
            return new ResponseEntity<>(Map.of("message", "Register Successful"), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

}

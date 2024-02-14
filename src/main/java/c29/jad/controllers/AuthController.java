package c29.jad.controllers;

import c29.jad.forms.AdminForm;
import c29.jad.forms.CheckInRecordForm;
import c29.jad.forms.UserForm;
import c29.jad.models.CheckInRecordModel;
import c29.jad.models.UserModel;
import c29.jad.services.AdminService;
import c29.jad.services.CheckInRecordService;
import c29.jad.services.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "auth")
public class AuthController {
    @Autowired
    Environment env;
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CheckInRecordService checkInRecordService;


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> logout(HttpSession httpSession){
        httpSession.removeAttribute("userId");
        return new ResponseEntity<>(Map.of("message", "Logout Successful"), HttpStatus.OK);
    }

//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    public ResponseEntity<Map<String, String>> getUsername(HttpServletRequest request){
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("username") != null) {
//            String username = (String) session.getAttribute("username");
//            return ResponseEntity.ok().body(Map.of("message", "get username success", "data", username));
//        } else {
//            return ResponseEntity.badRequest().body(Map.of("message", "you are not logged in"));
//        }
//      }
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> login(@RequestBody UserForm userForm){
        try{
            Integer userId = userService.login(userForm.getUsername(), userForm.getPassword());
//            httpSession.setAttribute("userId", userId);
            String jwt = JWT.create()
                    .withIssuer("c29JADPJ")
                    .withClaim("userId", userId)
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(env.getProperty("jwt.secret")));

            return new ResponseEntity<>(Map.of("message", "Login Successful", "token", jwt), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }


    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> adminLogin(@RequestBody AdminForm adminForm){
        try{
            Integer isAdmin = adminService.adminLogin(adminForm.getUsername(), adminForm.getPassword());

            String jwt = JWT.create()
                    .withIssuer("c29JADPJ")
                    .withClaim("isAdmin", isAdmin)
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(env.getProperty("jwt.secret")));

            return new ResponseEntity<>(Map.of("message", "Login Successful", "token", jwt), HttpStatus.OK);
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

    @PostMapping("/checkUser")
    public ResponseEntity<String> checkUser(@RequestBody UserRequest userRequest) {
        System.out.println("input: " + userRequest.getUsername());

        // Perform the database query to check if the username exists
        boolean usernameExists = performDatabaseQuery(userRequest.getUsername());

        if (usernameExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exists");
        } else {
            return ResponseEntity.ok("available");
        }
    }

    private boolean performDatabaseQuery(String username) {
        // Implement your database query logic here
        // Example code:
        // Connect to the database and execute the query
        // If the username exists, return true; otherwise, return false
        return false; // Placeholder value, replace with your actual logic
    }

    // Define a class to represent the user request body
    public static class UserRequest {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }


}

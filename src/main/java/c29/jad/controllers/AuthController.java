package c29.jad.controllers;

import c29.jad.forms.AdminForm;
import c29.jad.forms.CheckInRecordForm;
import c29.jad.forms.UserForm;
import c29.jad.models.CheckInRecordModel;
import c29.jad.models.UserModel;
import c29.jad.responses.ApiResponse;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> login(@RequestBody UserForm userForm){
        try{
            Map<String, Object> user = userService.login(userForm.getUsername(), userForm.getPassword());
            boolean isAdmin = (boolean) user.get("isAdmin");
            Integer userId = (Integer) user.get("userId");
            String jwt = JWT.create()
                    .withIssuer("c29JADPJ")
                    .withClaim("isAdmin", isAdmin)
                    .withClaim("userId", userId)
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(env.getProperty("jwt.secret")));

            return new ResponseEntity<>(Map.of("message", "Login Successful", "token", jwt), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/username")
    public ResponseEntity<ApiResponse> getUsername(HttpServletRequest request) {
        var userId = request.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("you are not logged in", null));
        }
        Integer intUserId = (Integer) userId;
        String username = userService.getUsernameById(intUserId);

        if (username != null) {
            return ResponseEntity.ok().body(new ApiResponse("get username success", username));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("you are not logged in", null));
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> getProfile(HttpServletRequest request) {
        var userId = request.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("you are not logged in", null));
        }
        Integer intUserId = (Integer) userId;
        Optional<UserModel> user = userService.getProfileById(intUserId);

        return user.map(userModel -> ResponseEntity.ok().body(new ApiResponse("get username success", userModel))).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("you are not logged in", null)));
    }

    @RequestMapping(value = "/ownrecord", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> OwnCheckInRecord (HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("userId");

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<CheckInRecordModel> ownRecord = checkInRecordService.getOwnRecord(userId);

        return new ResponseEntity<>(Map.of("Total Check-in times", ownRecord), HttpStatus.OK);
    }
//    @RequestMapping(value = "/admin", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, String>> adminLogin(@RequestBody AdminForm adminForm){
//        try{
//            Integer isAdmin = adminService.adminLogin(adminForm.getUsername(), adminForm.getPassword());
//
//            String jwt = JWT.create()
//                    .withIssuer("c29JADPJ")
//                    .withClaim("isAdmin", isAdmin)
//                    .withIssuedAt(new Date())
//                    .sign(Algorithm.HMAC256(env.getProperty("jwt.secret")));
//
//            return new ResponseEntity<>(Map.of("message", "Login Successful", "token", jwt), HttpStatus.OK);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
//        }
//
//    }

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
    public ResponseEntity<String> checkUser(@RequestBody UserForm userForm) {
        boolean usernameExists = userService.checkIfUsernameExists(userForm.getUsername());
        if (usernameExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exists");
        } else {
            return ResponseEntity.ok("available");
        }
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestBody UserForm userForm) {
        boolean emailExists = userService.checkIfEmailExists(userForm.getEmail());
        if (emailExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exists");
        } else {
            return ResponseEntity.ok("available");
        }
    }


}

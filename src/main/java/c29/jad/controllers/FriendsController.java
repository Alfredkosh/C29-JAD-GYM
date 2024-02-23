package c29.jad.controllers;

import c29.jad.services.FriendsListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping(value = "friends")
public class FriendsController {

    // PostgreSQL database configuration
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/c29_gympj";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    @Autowired
    FriendsListService friendsListService;

<<<<<<< HEAD
=======





>>>>>>> 0d8d5292b64fee83a82452da926299e4b1889349
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity<String> getData(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
<<<<<<< HEAD

        String data = friendsListService.getUsernameById(userId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
=======
        String data = FriendsListService.getUsernameById(userId);
        return new ResponseEntity<>(data, HttpStatus.OK);
        }

>>>>>>> 0d8d5292b64fee83a82452da926299e4b1889349

    @GetMapping("/getUserDetails")
    public ResponseEntity<Map<String, Object>> getUserDetails(@RequestParam("friendName") String friendName) {
        if (!isNumber(friendName)) {
            return ResponseEntity.badRequest().body(null);
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT username FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(friendName));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");

                Map<String, Object> response = new HashMap<>();
                response.put("userId", friendName);
                response.put("username", username);

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
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

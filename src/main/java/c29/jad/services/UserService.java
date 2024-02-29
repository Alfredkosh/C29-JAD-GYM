package c29.jad.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import c29.jad.forms.UserForm;
import c29.jad.models.UserModel;
import c29.jad.repositories.AdminRepository;
import c29.jad.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public UserModel register(UserForm userForm) throws AuthenticationException{
        String username = userForm.getUsername();
        var users = userRepository.findByUsername(username);
        if (users.size() >= 1) {
            throw new AuthenticationException("Account alerady existed");
        }

        var newUser = new UserModel();
        if(userForm.getFullname() != null){
            newUser.setFullname((userForm.getFullname()));
        }
        if(userForm.getUsername() != null){
            newUser.setUsername((userForm.getUsername()));
        }
        if(userForm.getPassword() != null){
            var hashPassword = BCrypt.withDefaults().hashToString(10,userForm.getPassword().toCharArray());
            newUser.setPassword(hashPassword);
        }
        if(userForm.getAge() != null){
            newUser.setAge((userForm.getAge()));
        }
        if(userForm.getMobile_number() != null){
            newUser.setMobileNumber((userForm.getMobile_number()));
        }
        if(userForm.getEmail() != null){
            newUser.setEmail((userForm.getEmail()));
        }
        if(userForm.getGender() != null){
            newUser.setGender((userForm.getGender()));
        }

        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

//        // Get the current date
//        Date currentDate = calendar.getTime();

        // Add one year to the current date
        calendar.add(Calendar.YEAR, 1);
        Date nextYearDate = calendar.getTime();

        newUser.setExpiredDate(nextYearDate);


        newUser.setStatus(true);
        return userRepository.saveAndFlush(newUser);
    }

    public Map<String, Object> login(String username, String password) throws AuthenticationException {
        var users = userRepository.findByUsername(username);
        if (users.size() == 1) {
            var user = users.get(0);
            var result = BCrypt.verifyer().verify(password.getBytes(),
                    user.getPassword().getBytes());

            if(!result.verified){
                throw new AuthenticationException("Incorrect username/password");
            }
            return Map.of("userId", user.getId(), "isAdmin", user.isAdmin());
        }
        throw new AuthenticationException("Account does not find");
    }

    public boolean checkIfUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean checkIfEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public String getUsernameById(Integer userId) {
        UserModel result =  userRepository.findUsernameById(userId);

        return result.getUsername();
    }
    public Optional<UserModel> getProfileById(Integer userId) {
        return  userRepository.findById(userId);
    }

}

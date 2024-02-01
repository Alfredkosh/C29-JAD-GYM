package c29.jad.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import c29.jad.forms.UserForm;
import c29.jad.models.UserModel;
import c29.jad.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;

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
        if(userForm.getEmail() != null){
            newUser.setEmail((userForm.getEmail()));
        }
        if(userForm.getIcon() != null){
            newUser.setIcon((userForm.getIcon()));
        }
        if(userForm.getMobile_number() != null){
            newUser.setMobileNumber((userForm.getMobile_number()));
        }

        newUser.setStatus(true);
        return userRepository.saveAndFlush(newUser);
    }

    public Integer login(String username, String password) throws AuthenticationException {
        var users = userRepository.findByUsername(username);
        if (users.size() == 1) {
            var user = users.get(0);
            var result = BCrypt.verifyer().verify(password.getBytes(),
                    user.getPassword().getBytes());

            if(!result.verified){
                throw new AuthenticationException("Incorrect username/password");
            }
            return user.getId();
        }
        throw new AuthenticationException("Account does not find");
    }
}

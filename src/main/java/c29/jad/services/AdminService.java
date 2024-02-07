package c29.jad.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import c29.jad.models.AdminModel;
import c29.jad.models.CheckInRecordModel;
import c29.jad.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;


    public Integer adminLogin(String username, String password) throws AuthenticationException {
        var users = adminRepository.findByUsername(username);
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

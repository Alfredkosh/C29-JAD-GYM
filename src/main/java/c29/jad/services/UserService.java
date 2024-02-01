package c29.jad.services;

import c29.jad.models.UserModel;
import c29.jad.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean login(String username, String password) {
        List<UserModel> users = userRepository.login(username, password);
        if (users.size() == 1) {
            return true;
        }
        return false;
    }
}

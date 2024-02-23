package c29.jad.services;


import c29.jad.models.GymRoomModel;
import c29.jad.repositories.GymRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
@Service
public class GymRoomService {

    @Autowired
    GymRoomRepository gymRoomRepository;

    public List<GymRoomModel> getAllGym() {
        return gymRoomRepository.findAll();
    }

}

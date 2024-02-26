package c29.jad.services;

import c29.jad.models.GymRoomModel;
import c29.jad.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<GymRoomModel> getAllLocations() {
        return locationRepository.findAll();
    }
}

package c29.jad.repositories;

import c29.jad.models.GymRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<GymRoomModel, Integer> {
}

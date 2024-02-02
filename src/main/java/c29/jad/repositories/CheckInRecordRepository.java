package c29.jad.repositories;

import c29.jad.models.CheckInRecordModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CheckInRecordRepository extends JpaRepository<CheckInRecordModel, Long> {
    List<CheckInRecordModel> findByUserId(int userId);
}

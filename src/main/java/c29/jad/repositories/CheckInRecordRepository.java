package c29.jad.repositories;

import c29.jad.models.CheckInRecordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CheckInRecordRepository extends JpaRepository<CheckInRecordModel, Integer> {
    List<CheckInRecordModel> findByUserId(int userId);

    @Query(value = """
            SELECT * from check_in_records WHERE check_out_at BETWEEN '2024-02-01 00:00:00' AND '2024-02-29 23:59:59'
            """, nativeQuery = true)
    List<CheckInRecordModel> getVisitor ();
}

package c29.jad.repositories;

import c29.jad.models.CheckInRecordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CheckInRecordRepository extends JpaRepository<CheckInRecordModel, Integer> {
    List<CheckInRecordModel> findByUserId(int userId);

    @Query(value = """
            SELECT * from user where check_out_at >= : 
            """)
    List<CheckInRecordModel> getVisitor (@Param("gymRoomId") Integer gymRoomId);
}

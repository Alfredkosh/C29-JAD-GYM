package c29.jad.repositories;

import c29.jad.models.CheckInRecordModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CheckInRecordRepository extends JpaRepository<CheckInRecordModel, Integer> {
    List<CheckInRecordModel> findByUserId(int userId);

    @Query(value = """
            SELECT * from check_in_records WHERE check_out_at BETWEEN '2024-02-01 00:00:00' AND '2024-02-29 23:59:59'
            """, nativeQuery = true)
    List<CheckInRecordModel> getVisitor ();

    @Transactional
    @Modifying
    @Query(value = """
            UPDATE check_in_records SET check_out_at = current_timestamp WHERE user_id = :userId AND gym_room_id = :gymRoomId \s
            AND check_in_at = (
                        SELECT MAX(check_in_at)\s
                        FROM check_in_records\s
                        WHERE user_id = :userId\s
                        AND gym_room_id = :gymRoomId
                    )
            """, nativeQuery = true)
    void updateCheckOutTime (@Param("userId") Integer userId, @Param("gymRoomId") Integer gymRoomId);

//    List<CheckInRecordModel> findByGymRoomId(int gymRoomId);

    @Query(value = """
            SELECT * from check_in_records
            """, nativeQuery = true)
    List<CheckInRecordModel> getAllFlows ();


    @Query(value = """
            SELECT * from check_in_records WHERE user_id = :id
            """, nativeQuery = true)
    List<CheckInRecordModel> getCheckInTime (@Param("id") Integer id);

    @Query(value = """
            SELECT check_in_records.check_in_date from check_in_records WHERE user_id = :id
            """, nativeQuery = true)
    List<String> getLastCheckIn (@Param("id") Integer id);


}

package c29.jad.repositories;

import c29.jad.models.CourseListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseListRepository extends JpaRepository<CourseListModel, Integer> {
    @Query(value = """
            SELECT MIN(gym_room_id) FROM course_lists where gym_room_id > 0
            """, nativeQuery = true)
    Optional<Integer> findNextAvailableGymRoomId();
}


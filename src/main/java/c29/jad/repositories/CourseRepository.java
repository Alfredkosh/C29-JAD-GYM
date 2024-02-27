package c29.jad.repositories;

import c29.jad.models.CourseListModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseListModel, Integer> {
    List<CourseListModel> findAllByOrderByOpenDatetimeAsc();
}

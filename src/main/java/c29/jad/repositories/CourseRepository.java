package c29.jad.repositories;

import c29.jad.models.CourseListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseListModel, Integer> {

}

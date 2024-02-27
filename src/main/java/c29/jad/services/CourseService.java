package c29.jad.services;

import c29.jad.models.CourseListModel;
import c29.jad.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseListModel> getAllCourses() {
        return courseRepository.findAllByOrderByOpenDatetimeAsc();
    }

    public CourseListModel getCourseById(Integer id) {
        // Assuming you have a course repository or DAO to fetch the course by ID
        Optional<CourseListModel> optionalCourse = courseRepository.findById(id);

        // Or you can throw a custom exception indicating course not found
        return optionalCourse.orElse(null);
    }

}

package c29.jad.services;

import c29.jad.models.CourseListModel;
import c29.jad.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseListModel> getAllCourses() {
        return courseRepository.findAll();
    }
}

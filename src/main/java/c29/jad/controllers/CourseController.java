package c29.jad.controllers;

import c29.jad.dtos.CourseDto;
import c29.jad.mappers.CourseMapper;
import c29.jad.models.CheckInRecordModel;
import c29.jad.models.CourseListModel;
import c29.jad.services.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllCourses() {
        List<CourseListModel> data = courseService.getAllCourses();
        List<CourseDto> coursesDto = CourseMapper.INSTANCE.toCoursesDto(data);
        return new ResponseEntity<>(Map.of("message", "Successful", "data", coursesDto), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getCourseById(@PathVariable("id") Integer id) {
        CourseListModel course = courseService.getCourseById(id);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        CourseDto courseDto = CourseMapper.INSTANCE.toCourseDto(course);
        return new ResponseEntity<>(Map.of("message", "Successful", "data", courseDto), HttpStatus.OK);

    }

}

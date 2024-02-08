package c29.jad.services;

import c29.jad.forms.CourseListForm;
import c29.jad.models.CourseListModel;
import c29.jad.repositories.CourseListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class CourseListService {

    @Autowired
    CourseListRepository courseListRepository;

    public CourseListModel newCourse(CourseListForm courseListForm) throws AuthenticationException{
        var newCourseList = new CourseListModel();
        if(courseListForm.getGymRoomId() != null){
            newCourseList.setGymRoomId(courseListForm.getGymRoomId());
        }
        if(courseListForm.getName() != null){
            newCourseList.setName(courseListForm.getName());
        }
        if(courseListForm.getTutor() != null){
            newCourseList.setTutor(courseListForm.getTutor());
        }
        if(courseListForm.getTutorIcon() != null){
            newCourseList.setTutorIcon(courseListForm.getTutorIcon());
        }
        if(courseListForm.getMaxPeopleLimit() != null){
            newCourseList.setMaxPeopleLimit(courseListForm.getMaxPeopleLimit());
        }
        if(courseListForm.getOpenDatetime() != null){
            newCourseList.setOpenDatetime(courseListForm.getOpenDatetime());
        }
        if(courseListForm.getEndDatetime() != null){
            newCourseList.setEndDatetime(courseListForm.getEndDatetime());
        }
        return courseListRepository.saveAndFlush(newCourseList);
    }

}

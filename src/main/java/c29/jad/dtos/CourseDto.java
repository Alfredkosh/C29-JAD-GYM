package c29.jad.dtos;

import java.time.LocalDateTime;
import java.util.Date;

public class CourseDto {
    private int id;
    private int gymRoomId;
    private String name;
    private String tutor;
    private String tutorIcon;
    private Integer maxPeopleLimit;
    private Date openDatetime;
    private Date endDatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGymRoomId() {
        return gymRoomId;
    }

    public void setGymRoomId(int gymRoomId) {
        this.gymRoomId = gymRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTutorIcon() {
        return tutorIcon;
    }

    public void setTutorIcon(String tutorIcon) {
        this.tutorIcon = tutorIcon;
    }

    public Integer getMaxPeopleLimit() {
        return maxPeopleLimit;
    }

    public void setMaxPeopleLimit(Integer maxPeopleLimit) {
        this.maxPeopleLimit = maxPeopleLimit;
    }

    public Date getOpenDatetime() {
        return openDatetime;
    }

    public void setOpenDatetime(Date openDatetime) {
        this.openDatetime = openDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }
}

package c29.jad.forms;

import java.time.LocalDateTime;
import java.util.Date;

public class CourseListForm {
    private Integer gymRoomId;
    private String name;
    private String tutor;
    private String tutorIcon;
    private Integer maxPeopleLimit;
    private Date openDatetime;
    private Date endDatetime;

    @Override
    public String toString() {
        return "CourseListForm{" +
                "gymRoomId=" + gymRoomId +
                ", name='" + name + '\'' +
                ", tutor='" + tutor + '\'' +
                ", tutorIcon='" + tutorIcon + '\'' +
                ", maxPeopleLimit=" + maxPeopleLimit +
                ", openDatetime=" + openDatetime +
                ", endDatetime=" + endDatetime +
                '}';
    }

    public Integer getGymRoomId() {
        return gymRoomId;
    }

    public void setGymRoomId(Integer gymRoomId) {
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



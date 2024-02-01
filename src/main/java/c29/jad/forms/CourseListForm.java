package c29.jad.forms;

import jakarta.persistence.Column;

public class CourseListForm {
    private int gymRoomId;
    private String name;
    private String tutor;
    private String tutor_icon;
    private String date;
    private String time;

    @Override
    public String toString() {
        return "CourseListForm{" +
                "gymRoomId=" + gymRoomId +
                ", name='" + name + '\'' +
                ", tutor='" + tutor + '\'' +
                ", tutor_icon='" + tutor_icon + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
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

    public String getTutor_icon() {
        return tutor_icon;
    }

    public void setTutor_icon(String tutor_icon) {
        this.tutor_icon = tutor_icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

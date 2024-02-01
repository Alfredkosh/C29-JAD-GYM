package c29.jad.forms;

import jakarta.persistence.Column;

public class ClassReservationForm {
    private int userId;
    private int courseId;
    private String registerEmail;
    private String confirmMsg;

    @Override
    public String toString() {
        return "ClassReservationForm{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", registerEmail='" + registerEmail + '\'' +
                ", confirmMsg='" + confirmMsg + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getConfirmMsg() {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg) {
        this.confirmMsg = confirmMsg;
    }
}

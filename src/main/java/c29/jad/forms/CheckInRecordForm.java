package c29.jad.forms;

import jakarta.persistence.Column;

import java.util.Date;

public class CheckInRecordForm {
    private Integer userId;
    private Integer gymRoomId;
    private String checkInDate;
    private String checkInAt;
    private String checkOutAt;

    @Override
    public String toString() {
        return "CheckInRecordForm{" +
                "userId=" + userId +
                ", gymRoomId=" + gymRoomId +
                ", checkInDate='" + checkInDate + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGymRoomId() {
        return gymRoomId;
    }

    public void setGymRoomId(Integer gymRoomId) {
        this.gymRoomId = gymRoomId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckInAt() {
        return checkInAt;
    }

    public void setCheckInAt(String checkInAt) {
        this.checkInAt = checkInAt;
    }

    public String getCheckOutAt() {
        return checkOutAt;
    }

    public void setCheckOutAt(String checkOutAt) {
        this.checkOutAt = checkOutAt;
    }
}

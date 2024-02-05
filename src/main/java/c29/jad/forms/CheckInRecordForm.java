package c29.jad.forms;

import jakarta.persistence.Column;

import java.util.Date;

public class CheckInRecordForm {
    private Integer userId;
    private Integer gymRoomId;
    private String checkInDate;
    private Date checkInAt;
    private Date checkOutAt;

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

    public Date getCheckInAt() {
        return checkInAt;
    }

    public void setCheckInAt(Date checkInAt) {
        this.checkInAt = checkInAt;
    }

    public Date getCheckOutAt() {
        return checkOutAt;
    }

    public void setCheckOutAt(Date checkOutAt) {
        this.checkOutAt = checkOutAt;
    }
}

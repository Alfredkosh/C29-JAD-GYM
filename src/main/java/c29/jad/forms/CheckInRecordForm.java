package c29.jad.forms;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CheckInRecordForm {
    private Integer userId;
    private Integer gymRoomId;
    private LocalDate checkInDate;
    private LocalDateTime checkInAt;
    private LocalDateTime checkOutAt;

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

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckInAt() {
        return checkInAt;
    }

    public void setCheckInAt(LocalDateTime checkInAt) {
        this.checkInAt = checkInAt;
    }

    public LocalDateTime getCheckOutAt() {
        return checkOutAt;
    }

    public void setCheckOutAt(LocalDateTime checkOutAt) {
        this.checkOutAt = checkOutAt;
    }
}

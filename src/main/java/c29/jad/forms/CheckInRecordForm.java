package c29.jad.forms;

import jakarta.persistence.Column;

public class CheckInRecordForm {
    private int userId;
    private int gymRoomId;
    private String checkInDate;

    @Override
    public String toString() {
        return "CheckInRecordForm{" +
                "userId=" + userId +
                ", gymRoomId=" + gymRoomId +
                ", checkInDate='" + checkInDate + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGymRoomId() {
        return gymRoomId;
    }

    public void setGymRoomId(int gymRoomId) {
        this.gymRoomId = gymRoomId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
}

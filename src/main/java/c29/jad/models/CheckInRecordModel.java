package c29.jad.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name="check_in_records")
public class CheckInRecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="gym_room_id")
    private Integer gymRoomId;
    @Column(name="check_in_date")
    private Date checkInDate;
    @Column(name="check_in_at")
    private Date checkInAt;
    @Column(name="check_out_at")
    private Date checkOutAt;
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCheckInDate() {String fromTimeZone = "GMT+8";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date checkInDate = new Date();
        format.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
        String chinaDate = format.format(checkInDate);
        return chinaDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckInAt() {
        String fromTimeZone = "GMT+8";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date checkInAt = new Date();
        format.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
        String chinaDate = format.format(checkInAt);
        return chinaDate;
    }

    public void setCheckInAt(Date checkInAt) {this.checkInAt = checkInAt;}

    public String getCheckOutAt() {
        if (checkInAt == null) {
            return null; // Or any other appropriate value when the date is null
        }

        String fromTimeZone = "GMT+8";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date checkOutAt = new Date();
        format.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
        String chinaDate = format.format(checkOutAt);
        return chinaDate;

    }

    public void setCheckOutAt(Date checkOutAt) {
        this.checkOutAt = checkOutAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

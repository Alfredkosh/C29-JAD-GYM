package c29.jad.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="check_in_records")
public class CheckInRecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="user_id ")
    private Integer userId;
    @Column(name="gym_room_id")
    private Integer gymRoomId;
    @Column(name="check_in_date")
    private String checkInDate;
    @Column(name="check_in_at")
    private String checkInAt;
    @Column(name="check_out_at")
    private String checkOutAt;

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

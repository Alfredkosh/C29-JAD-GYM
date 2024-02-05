package c29.jad.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDate checkInDate;
    @Column(name="check_in_at")
    private LocalDateTime checkInAt;
    @Column(name="check_out_at")
    private LocalDateTime checkOutAt;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;


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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

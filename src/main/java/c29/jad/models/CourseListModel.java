package c29.jad.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="course_lists")
public class CourseListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="gym_room_id")
    private int gymRoomId;
    @Column(name="name")
    private String name;
    @Column(name="tutor")
    private String tutor;
    @Column(name="tutor_icon")
    private String tutorIcon;
    @Column(name="max_people_limit")
    private Integer maxPeopleLimit;
    @Column(name="open_datetime")
    private Date openDatetime;
    @Column(name="end_datetime")
    private Date endDatetime;
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="gym_room_id", updatable = false, insertable = false)
    private GymRoomModel gymRoom;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

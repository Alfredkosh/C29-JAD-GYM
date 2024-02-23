package c29.jad.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="gym_rooms")
public class GymRoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="map")
    private String map;
    @Column(name="location_name")
    private String locationName;
    @Column(name="location_address")
    private String locationAddress;
    @Column(name="location_contact")
    private String locationContact;
    @Column(name="location_email")
    private String locationEmail;
    @Column(name="location_max_people")
    private Integer locationMaxPeople;
    @Column(name="latitude")
    private String latitude;
    @Column(name="longitude")
    private String longitude;

    @OneToMany(mappedBy = "gymRoom")
    private List<CourseListModel> courseLists;

    public List<CourseListModel> getCourseLists() {
        return courseLists;
    }

    public void setCourseLists(List<CourseListModel> courseLists) {
        this.courseLists = courseLists;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationContact() {
        return locationContact;
    }

    public void setLocationContact(String locationContact) {
        this.locationContact = locationContact;
    }

    public String getLocationEmail() {
        return locationEmail;
    }

    public void setLocationEmail(String locationEmail) {
        this.locationEmail = locationEmail;
    }

    public Integer getLocationMaxPeople() {
        return locationMaxPeople;
    }

    public void setLocationMaxPeople(Integer locationMaxPeople) {
        this.locationMaxPeople = locationMaxPeople;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

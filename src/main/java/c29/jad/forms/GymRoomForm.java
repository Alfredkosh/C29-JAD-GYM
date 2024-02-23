package c29.jad.forms;

import jakarta.persistence.Column;

public class GymRoomForm {
    private String map;
    private String locationName;
    private String locationAddress;
    private String locationContact;
    private String locationEmail;
    private Integer locationMaxPeople;

    @Override
    public String toString() {
        return "GymRoomForm{" +
                "map='" + map + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationAddress='" + locationAddress + '\'' +
                ", locationContact='" + locationContact + '\'' +
                ", locationMaxPeople=" + locationMaxPeople +
                '}';
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
}

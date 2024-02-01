package c29.jad.forms;

import jakarta.persistence.Column;

public class GymRoomForm {
    private String map;
    private String locationName;
    private String locationAddress;
    private String locationContact;
    private int locationMaxPeople;

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

    public int getLocationMaxPeople() {
        return locationMaxPeople;
    }

    public void setLocationMaxPeople(int locationMaxPeople) {
        this.locationMaxPeople = locationMaxPeople;
    }
}

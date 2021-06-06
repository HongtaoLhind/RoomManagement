package de.dlh.lhind.exercise.roommgmt.model;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Building building;

    @Basic(optional = false)
    private String roomNumber;

    @Basic(optional = false)
    private Integer seats;

    @Basic(optional = false)
    private Boolean projectorPresent;

    public Room(){

    }

    public Room(Long id, Building building, String roomNumber, Integer seats, Boolean projectorPresent){
        this.id = id;
        this.building = building;
        this.roomNumber = roomNumber;
        this.seats = seats;
        this.projectorPresent = projectorPresent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Boolean getProjectorPresent() {
        return projectorPresent;
    }

    public void setProjectorPresent(Boolean projectorPresent) {
        this.projectorPresent = projectorPresent;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", building='" + building +
                ", room number=" + roomNumber +
                ", seats=" + seats +
                ", projection present" + projectorPresent +
                '}';
    }
}

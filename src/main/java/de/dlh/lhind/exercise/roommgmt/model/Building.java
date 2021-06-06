package de.dlh.lhind.exercise.roommgmt.model;

import javax.persistence.*;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    @Column(unique = true, name = "BUILDING_NUMBER")
    private String buildingNumber;

    @Basic
    @Column
    private String description;

    @Basic(optional = false)
    private Boolean publicAccess;

    public Building(){
    }

    public Building(Long id, String buildingNumber, String description, Boolean publicAccess){
        this.id = id;
        this.buildingNumber = buildingNumber;
        this.description = description;
        this.publicAccess = publicAccess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(Boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", building number='" + buildingNumber +
                ", description=" + description +
                ", public access=" + publicAccess +
                '}';
    }
}

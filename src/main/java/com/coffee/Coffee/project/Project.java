package com.coffee.Coffee.project;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private Long id;
    private String projectName;
    private String type;
    private String status;
    private String geography;
    private LocalDate startDate;
    private LocalDate endDate;
    private String ownerOrg;


    public Project(){

    }


    public Project(Long id, String projectName, String type, String status, String geography, LocalDate startDate, LocalDate endDate, String ownerOrg) {
        this.id = id;
        this.projectName = projectName;
        this.type = type;
        this.status = status;
        this.geography = geography;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ownerOrg = ownerOrg;
    }

    public Project(String projectName, String type, String status, String geography, LocalDate startDate, LocalDate endDate, String ownerOrg) {
        this.projectName = projectName;
        this.type = type;
        this.status = status;
        this.geography = geography;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ownerOrg = ownerOrg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography  ;
    }

    public LocalDate getStartDate() {
        return LocalDate.now();
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return LocalDate.of(2025,12,31);
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getOwnerOrg() {
        return ownerOrg;
    }

    public void setOwnerOrg(String ownerOrg) {
        this.ownerOrg = ownerOrg;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", geography='" + geography + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", ownerOrg='" + ownerOrg + '\'' +
                '}';
    }
}

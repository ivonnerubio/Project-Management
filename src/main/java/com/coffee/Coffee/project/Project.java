package com.coffee.Coffee.project;

import java.time.LocalDateTime;

public class Project {

    private Integer id;
    private String projectName;
    private String type;
    private String status;
    private String geography;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String ownerOrg;


    public Project(){

    }

    public Project(Integer id, String projectName, String type, String status, String geography, LocalDateTime startDate, LocalDateTime endDate, String ownerOrg) {
        this.id = id;
        this.projectName = projectName;
        this.type = type;
        this.status = status;
        this.geography = geography;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ownerOrg = ownerOrg;
    }

    public Project(String projectName, String type, String status, String geography, LocalDateTime startDate, LocalDateTime endDate, String ownerOrg) {
        this.projectName = projectName;
        this.type = type;
        this.status = status;
        this.geography = geography;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ownerOrg = ownerOrg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        this.geography = geography;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
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

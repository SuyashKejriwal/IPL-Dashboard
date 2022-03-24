package com.example.ipldashboard.dto;

public class TeamNameDto {

    private int id;

    private String teamName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TeamNameDto() {
    }

    @Override
    public String toString() {
        return "TeamNameDto{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}

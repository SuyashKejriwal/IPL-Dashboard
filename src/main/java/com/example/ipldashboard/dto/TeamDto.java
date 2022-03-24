package com.example.ipldashboard.dto;

import java.util.List;

public class TeamDto {

    private long id;

    private String teamName;

    private long totalMatches;

    private long totalWins;

    private List<MatchDto> latestMatches;

    public List<MatchDto> getLatestMatches() {
        return latestMatches;
    }

    public void setLatestMatches(List<MatchDto> latestMatches) {
        this.latestMatches = latestMatches;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", totalWins=" + totalWins +
                ", latestMatches=" + latestMatches +
                '}';
    }
}

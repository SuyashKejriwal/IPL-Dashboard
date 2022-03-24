package com.example.ipldashboard.controller;

import com.example.ipldashboard.dto.MatchDto;
import com.example.ipldashboard.dto.TeamDto;
import com.example.ipldashboard.dto.TeamNameDto;
import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/team")
    public ResponseEntity<List<TeamNameDto>> getAllTeams(){
        List<TeamNameDto> teamList=teamService.getAllTeams();
        return ResponseEntity.ok(teamList);
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable String teamName){
        TeamDto teamDto=teamService.getTeam(teamName);
        return ResponseEntity.ok(teamDto);
    }

    @GetMapping("/team/{teamName}/matches")
    public ResponseEntity<List<MatchDto>> getMatchesByTeam(@PathVariable String teamName,
                                                           @RequestParam int year){

        List<MatchDto> matchesList=teamService.getMatchesForTeamAndYear(teamName,year);
        return ResponseEntity.ok(matchesList);
    }
}

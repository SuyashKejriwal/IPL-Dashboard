package com.example.ipldashboard.service;

import com.example.ipldashboard.dto.MatchDto;
import com.example.ipldashboard.dto.TeamDto;
import com.example.ipldashboard.dto.TeamNameDto;
import com.example.ipldashboard.exception.TeamNotFoundException;
import com.example.ipldashboard.mapper.MatchMapper;
import com.example.ipldashboard.mapper.TeamMapper;
import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.repository.MatchRepository;
import com.example.ipldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    public TeamDto getTeam(String teamName) {
        Team team=teamRepository.findByTeamName(teamName)
                .orElseThrow(()-> new TeamNotFoundException(teamName));

        List<Match> teamLatestMatchesList=matchRepository.findLatestMatchesByTeam(teamName,4);

        List<MatchDto> teamLatestMatchesDtoList=teamLatestMatchesList.stream()
                        .map(matchMapper::MatchToDto)
                                .collect(Collectors.toList());

        TeamDto teamDto=teamMapper.TeamToDto(team,teamLatestMatchesDtoList);

        return teamDto;
    }

    public List<TeamNameDto> getAllTeams() {
        List<Team> teams=teamRepository.findAll();
        List<TeamNameDto> teamsList=new ArrayList<>();
        for(Team team:teams){
            TeamNameDto teamDto=new TeamNameDto();
            teamDto.setId((int) team.getId());
            teamDto.setTeamName(team.getTeamName());
            teamsList.add(teamDto);
        }

        return teamsList;
    }

    public List<MatchDto> getMatchesForTeamAndYear(String teamName, int year) {
        LocalDate startDate=LocalDate.of(year,1,1);
        LocalDate endDate=LocalDate.of(year+1,1,1);

        List<Match> matchList=matchRepository.getMatchesByTeamBetweenDates(
                teamName,startDate,endDate
        );

        List<MatchDto> matchDtoList=matchList.stream()
                .map(matchMapper::MatchToDto)
                .collect(Collectors.toList());

        return matchDtoList;
    }
}

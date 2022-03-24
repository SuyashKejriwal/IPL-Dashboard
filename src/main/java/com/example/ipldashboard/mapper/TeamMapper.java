package com.example.ipldashboard.mapper;

import com.example.ipldashboard.dto.MatchDto;
import com.example.ipldashboard.dto.TeamDto;
import com.example.ipldashboard.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public abstract class TeamMapper {

    @Mapping(target = "latestMatches",source = "latestMatches")
    public abstract TeamDto TeamToDto(Team team,List<MatchDto> latestMatches);

    public abstract Team DtoToTeam(TeamDto teamDto);



}


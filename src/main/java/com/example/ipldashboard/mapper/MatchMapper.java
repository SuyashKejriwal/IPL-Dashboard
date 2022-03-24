package com.example.ipldashboard.mapper;


import com.example.ipldashboard.dto.MatchDto;
import com.example.ipldashboard.model.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MatchMapper {

    public abstract MatchDto MatchToDto(Match match);

    public abstract Match DtoToMatch(MatchDto matchDto);
}

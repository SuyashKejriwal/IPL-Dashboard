package com.example.ipldashboard.mapper;

import com.example.ipldashboard.data.MatchInput;
import com.example.ipldashboard.model.Match;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.crypto.spec.PSource;

@Mapper(componentModel="spring")
public abstract class MatchCSVMapper {

    @Mapping(target = "playerOfMatch", source="player_of_match")
    @Mapping(target = "tossWinner",source = "toss_winner")
    @Mapping(target="matchWinner",source = "winner")
    @Mapping(target = "tossDecision",source = "toss_decision")
    @Mapping(target = "resultMargin",source = "result_margin")
    @Mapping(target="neutralVenue",source = "neutral_venue")
    @Mapping(target="team1",source = "matchInput",qualifiedByName = "getFirstInningsTeam")
    @Mapping(target="team2",source="matchInput",qualifiedByName = "getSecondInningsTeam")
    public abstract Match InputToMatch(MatchInput matchInput);


    @Named("getFirstInningsTeam")
    public String getFirstInningsTeam(MatchInput matchInput){
        if("bat".equals(matchInput.getToss_decision())){
            return matchInput.getToss_winner();
        }else{
            return matchInput.getToss_winner().equals(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }
    }

    @Named("getSecondInningsTeam")
    public String getSecondInningsTeam(MatchInput matchInput){
        if("bat".equals(matchInput.getToss_decision())){
            return matchInput.getToss_winner().equals(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }else{
            return matchInput.getToss_winner();
        }
    }
}

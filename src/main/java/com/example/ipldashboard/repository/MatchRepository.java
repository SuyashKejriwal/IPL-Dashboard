package com.example.ipldashboard.repository;

import com.example.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {

    public List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    @Query("select m from Match m where (m.team1=:teamName or m.team2=:teamName) and m.date between :dateStart and :dateEnd order by date desc")
   public List<Match> getMatchesByTeamBetweenDates(@Param("teamName") String teamName,
                                                   @Param("dateStart") LocalDate dateStart,
                                                   @Param("dateEnd") LocalDate dateEnd);

    @Query(
            value = "select m from Match m where (m.team1=:teamName or m.team2=:teamName) and m.date between :dateStart" +
                    " and :dateEnd order by date desc limit 4",
    nativeQuery = true)
    public List<Match> getPlayOffMatchesByTeamBetweenDates(@Param("teamName") String teamName,
                                                    @Param("dateStart") LocalDate dateStart,
                                                    @Param("dateEnd") LocalDate dateEnd);

    default List<Match> findLatestMatchesByTeam(String teamName,int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName, PageRequest.of(0,count));
    }
}

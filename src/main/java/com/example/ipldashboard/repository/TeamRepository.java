package com.example.ipldashboard.repository;

import com.example.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    public Optional<Team> findByTeamName(String teamName);


}

package com.example.ipldashboard.data;

import com.example.ipldashboard.mapper.MatchCSVMapper;
import com.example.ipldashboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MatchDataProcessing implements  ItemProcessor<MatchInput, Match>{

    @Autowired
    private MatchCSVMapper matchCSVMapper;
    private static final Logger log = LoggerFactory.getLogger(ItemProcessor.class);

    @Override
    public Match process(MatchInput matchInput) throws Exception {
    Match match=matchCSVMapper.InputToMatch(matchInput);
        return match;
    }
}

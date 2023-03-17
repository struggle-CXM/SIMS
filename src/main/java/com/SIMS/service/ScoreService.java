package com.SIMS.service;

import com.SIMS.entity.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface ScoreService {
    double GetAvgByEid(String eid);

    List<Score> GetScoreBySid(String sid);

    int AddScore(Score s);

    List<Score> GetAllScore();
}

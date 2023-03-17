package com.SIMS.dao;

import com.SIMS.entity.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ScoreDao {
    int AddScore(Connection conn, Score s) throws SQLException;
    int DelScore(Connection conn, Score s) throws SQLException;
    ResultSet FindScoreByEidAndSid(Connection conn,Score s) throws SQLException;

    ResultSet GetAvgByEid(Connection conn, String eid) throws SQLException;

    ResultSet GetScoreBySid(Connection conn,String sid) throws  SQLException;

    ResultSet GetAllScore(Connection conn)throws SQLException;


}

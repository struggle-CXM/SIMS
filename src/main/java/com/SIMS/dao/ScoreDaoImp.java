package com.SIMS.dao;

import com.SIMS.entity.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDaoImp extends BaseDao implements ScoreDao{

    /**
     * @param conn
     * @param s
     * @return
     * @throws SQLException
     */
    public int AddScore(Connection conn, Score s) throws SQLException {
        String sql = "insert into score value (?,?,?,?,?)";
        return super.updateDate(conn,sql,s.getEid() + s.getSid(),s.getEid(),s.getSid(),s.getScore(),s.getSc_time());
    }

    /**
     * @param conn
     * @param s
     * @return
     * @throws SQLException
     */
    public int DelScore(Connection conn, Score s) throws SQLException {
        String sql = "delete from score where eid = ? and sid = ?";
        return super.updateDate(conn , sql , s.getEid() ,s.getSid());
    }

    /**
     * @param conn
     * @param s
     * @return
     * @throws SQLException
     */
    public ResultSet FindScoreByEidAndSid(Connection conn, Score s) throws SQLException {
        String sql = "select * from score where eid = ? and sid = ?";
        return super.selectDate(conn , sql , s.getEid(),s.getSid());
    }

    /**
     * @param conn
     * @param eid
     * @return
     * @throws SQLException
     */
    public ResultSet GetAvgByEid(Connection conn, String eid) throws SQLException {
        String sql = "SELECT AVG(score) as avg from score WHERE eid = ?";
        return super.selectDate(conn,sql,eid);
    }

    /**
     * @param conn
     * @param sid
     * @return
     * @throws SQLException
     */
    public ResultSet GetScoreBySid(Connection conn, String sid) throws SQLException {
       String sql = "select * from score where sid = ?";
       return super.selectDate(conn,sql,sid);
    }

    /**
     * @param conn
     * @return
     * @throws SQLException
     */
    public ResultSet GetAllScore(Connection conn) throws SQLException {
        String sql ="select * from score";
        return super.selectDate(conn,sql);
    }
}

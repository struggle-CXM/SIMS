package com.SIMS.service;

import com.SIMS.dao.ScoreDaoImp;
import com.SIMS.entity.Score;
import com.SIMS.util.DBHelper;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreServiceImp implements ScoreService {
    private ScoreDaoImp sd;
    public ScoreServiceImp(){
        sd = new ScoreDaoImp();
    }



    /**
     * @param eid
     * @return
     */
    public double GetAvgByEid(String eid) {
        Connection conn = DBHelper.getConnection();
        ResultSet set;
        try{
            set = sd.GetAvgByEid(conn,eid);
            while (set.next()){
                double avg = set.getDouble("avg");

                String str = String.format("%.2f",avg);
                double AVG = Double.parseDouble(str);
                return AVG;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }
        return 0;
    }

    /**
     * @param sid
     * @return
     */
    public List<Score> GetScoreBySid(String sid) {
        Connection c = DBHelper.getConnection();
        ResultSet set;
        ArrayList<Score> s = new ArrayList<Score>();
        try{
            set = sd.GetScoreBySid(c,sid);
            while (set.next()){
                String scid = set.getString("scid");
                String eid = set.getString("eid");
                String sid1 = set.getString("sid");
                int score = set.getInt("score");
                String sctime = set.getString("sc_time");
                s.add(new Score(scid,eid,sid1,score,sctime));
            }
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * @param s
     * @return
     */
    public int AddScore(Score s) {
        Connection c= DBHelper.getConnection();
        int i;
        try{
             i = sd.AddScore(c,s);
             return i;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }

    }

    /**
     * @return
     */
    public List<Score> GetAllScore() {
        Connection c = DBHelper.getConnection();
        ResultSet set = null;
        ArrayList<Score> s = new ArrayList<Score>();
        try{
            set = sd.GetAllScore(c);
            while (set.next()){
                String scid = set.getString("scid");
                String eid = set.getString("eid");
                String sid1 = set.getString("sid");
                int score = set.getInt("score");
                String sctime = set.getString("sc_time");
                s.add(new Score(scid,eid,sid1,score,sctime));
            }
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }

    }
}

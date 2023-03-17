package com.SIMS.service;

import com.SIMS.dao.ExamDaoImp;
import com.SIMS.entity.Exam;
import com.SIMS.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamServiceImp implements ExamService{
    private ExamDaoImp ed;
    public ExamServiceImp(){
        ed = new ExamDaoImp();
    }
    /**
     * @param e
     * @return
     */
    public int AddExam(Exam e) {
        Connection conn =null;
        try{
            conn = DBHelper.getConnection();
            ed.AddExam(conn,e);
        } catch (SQLException s) {
            s.printStackTrace();
            return 0;

        }finally {
            ed.closeALL();
        }
        return 1;
    }

    /**
     * @param e
     * @return
     */
    public int DelExamByEid(Exam e) {
        Connection conn =null;
        try{
            conn = DBHelper.getConnection();
            ed.DelExamByEid(conn,e);
        } catch (SQLException s) {
            s.printStackTrace();
            return 0;

        }finally {
            ed.closeALL();
        }
        return 1;
    }

    /**
     * @param sub
     * @return
     */
    public List<Exam> FindExamBySub(String sub) {
        Connection conn = DBHelper.getConnection();
        ArrayList<Exam> e = new ArrayList<Exam>();
        ResultSet set;
        try{
            set = ed.FindExamBySub(conn,sub);
            while (set.next()){
                e.add(new Exam(set.getString("eid"),set.getString("sub"),set.getString("etime"),set.getString("location")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }finally {
            ed.closeALL();
        }
        return e;
    }

    /**
     * @param year
     * @param month
     * @param day
     * @return
     */
    public List<Exam> FindExamByDate(String year, String month, String day) {
        Connection conn = DBHelper.getConnection();
        ArrayList<Exam> e = new ArrayList<Exam>();
        ResultSet set;
        try{
            set = ed.FindExamByDate(conn,year,month,day);
            while (set.next()){
                e.add(new Exam(set.getString("eid"),set.getString("sub"),set.getString("etime"),set.getString("location")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }finally {
            ed.closeALL();
        }
        return e;
    }

    /**
     * @param sub
     * @param etime
     * @param loc
     * @return
     */
    public Exam GetEidBySub(String sub, String etime, String loc) {
        Connection conn = DBHelper.getConnection();

        ResultSet set;
        try{
            set = ed.GetEidBySub(conn,sub,etime,loc);
            while (set.next()){
                String eid = set.getString("eid");
                return new Exam(eid,null,null,null);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }finally {
            ed.closeALL();
        }
        return null;
    }

    /**
     * @param eid
     * @return
     */
    public Exam GetExamByEid(String eid) {
        Connection c = DBHelper.getConnection();
        ResultSet set = null;
        try{
            set = ed.GetExamByEid(c,eid);
            while (set.next()){
                String sub = set.getString("sub");
                String etime = set.getString("etime");
                String location = set.getString("location");
                return new Exam(eid,sub,etime,location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            ed.closeALL();
        }
        return null;
    }
}

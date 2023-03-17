package com.SIMS.dao;

import com.SIMS.entity.Exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDaoImp extends BaseDao implements ExamDao {

    /**
     * @param conn
     * @param e
     * @return
     * @throws SQLException
     */
    public int AddExam(Connection conn, Exam e) throws SQLException {
        String sql = "insert into exam value (?,?,?,?)";
        return super.updateDate(conn,sql,e.getEid(),e.getSub(),e.getEtime(),e.getLoc());
    }

    /**
     * @param conn
     * @param e
     * @return
     * @throws SQLException
     */
    public int DelExamByEid(Connection conn, Exam e) throws SQLException {
        String sql = "delete from exam where eid = ? ";
        return super.updateDate(conn,sql,e.getEid());
    }



    /**
     * @param conn
     * @param sub
     * @return
     * @throws SQLException
     */
    public ResultSet FindExamBySub(Connection conn, String sub) throws SQLException {
        String sql = "select * from exam where sub = ?";
        return super.selectDate(conn,sql,sub);
    }

    /**
     * @param conn
     * @param year
     * @param month
     * @param day
     * @return
     * @throws SQLException
     */
    public ResultSet FindExamByDate(Connection conn, String year, String month, String day) throws SQLException {
        String sql = "select * from exam where etime like ?";
        String Date = year + "-" + month + "-" + day;
        return super.selectDate(conn,sql,Date + "%");
    }

    /**
     * @param conn
     * @param sub
     * @param etime
     * @param loc
     * @return
     * @throws SQLException
     */
    public ResultSet GetEidBySub(Connection conn, String sub, String etime, String loc) throws SQLException {
        String sql = "select eid from exam where sub = ? and etime = ? and loc = ?";
        return super.selectDate(conn,sql,sub,etime,loc);
    }

    /**
     * @param conn
     * @param eid
     * @return
     * @throws SQLException
     */
    public ResultSet GetExamByEid(Connection conn, String eid) throws SQLException {
        String sql = "select * from exam where eid = ?";
        return super.selectDate(conn,sql,eid);
    }


}

package com.SIMS.dao;

import com.SIMS.entity.Exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExamDao {
    int AddExam(Connection conn, Exam e) throws SQLException;
    int DelExamByEid(Connection conn, Exam e) throws SQLException;
    ResultSet FindExamBySub(Connection conn,String sub) throws SQLException;
    ResultSet FindExamByDate(Connection conn,String year,String month,String day) throws SQLException;

    ResultSet GetEidBySub(Connection conn,String sub,String etime,String loc) throws SQLException;

    ResultSet GetExamByEid(Connection conn,String eid)throws SQLException;

}

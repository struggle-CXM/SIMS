package com.SIMS.dao;

import com.SIMS.entity.Student;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface StudentDao {
    int AddStudent(Connection conn, Student s)throws SQLException;
    int DelStudent(Connection conn, Student s)throws SQLException;

    ResultSet StudentLogin(Connection conn, Student s)throws SQLException;

    ResultSet FindStuByClass(Connection conn,String grade,String classNum)throws SQLException;

    ResultSet FindStuBySid(Connection conn,String sid)throws  SQLException;

    int ChangePassword(Connection conn,String sid,String password) throws SQLException;

    ResultSet GetAllStu(Connection conn)throws SQLException;



}

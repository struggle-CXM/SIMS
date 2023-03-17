package com.SIMS.dao;


import com.SIMS.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TeacherDao {
    int AddTeacher(Connection conn, Teacher t)throws SQLException;
    int DelTeacher(Connection conn, Teacher t)throws SQLException;

    ResultSet TeacherLogin(Connection conn, Teacher t) throws SQLException;

    int ChangePassword(Connection c,String tid,String password)throws  SQLException;

    ResultSet FindTeaByName(Connection c,Teacher t)throws SQLException;

    ResultSet GetAllTeacher(Connection c)throws SQLException;
}

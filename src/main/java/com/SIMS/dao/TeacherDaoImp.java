package com.SIMS.dao;

import com.SIMS.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImp extends BaseDao implements TeacherDao{
    /**
     * @param conn
     * @param t
     * @return
     * @throws SQLException
     */
    public int AddTeacher(Connection conn, Teacher t) throws SQLException {
        String sql = "insert into teacher value (?,?,?,?,?,?)";
        return super.updateDate(conn, sql,t.getTid(),t.getPassword(),t.getName(),t.getTel(),t.getAge(),t.getT_time());
    }

    /**
     * @param conn
     * @param t
     * @return
     * @throws SQLException
     */
    public int DelTeacher(Connection conn, Teacher t) throws SQLException {
        String sql = "delete from teacher where tid = ? ";
        return super.updateDate(conn, sql,t.getTid());
    }

    /**
     * @param conn
     * @param t
     * @return
     * @throws SQLException
     */
    public ResultSet TeacherLogin(Connection conn, Teacher t) throws SQLException {
        String sql = "select * from teacher where tid = ? and password = ?";
        return super.selectDate(conn, sql, t.getTid(),t.getPassword());
    }

    /**
     * @param c
     * @param tid
     * @param password
     * @return
     * @throws SQLException
     */
    public int ChangePassword(Connection c, String tid, String password) throws SQLException {
        String sql = "UPDATE teacher set password = ? where tid = ?";
        return super.updateDate(c,sql,password,tid);
    }

    /**
     * @param c
     * @param t
     * @return
     * @throws SQLException
     */
    public ResultSet FindTeaByName(Connection c, Teacher t) throws SQLException {
        String sql = "select * from teacher where name = ?";
        return super.selectDate(c,sql,t.getName());
    }

    /**
     * @param c
     * @return
     * @throws SQLException
     */
    public ResultSet GetAllTeacher(Connection c) throws SQLException {
        String sql = "select * from teacher";
        return super.selectDate(c,sql);
    }
}

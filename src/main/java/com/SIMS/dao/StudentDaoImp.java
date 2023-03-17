package com.SIMS.dao;

import com.SIMS.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImp extends BaseDao implements StudentDao{
    /**
     * @param conn
     * @param s
     * @return
     * @throws SQLException
     */
    public int AddStudent(Connection conn, Student s) throws SQLException {
        String sql = "insert into student value (?,?,?,?,?,?,?,?,?)";
        return super.updateDate(conn, sql,s.getSid(),s.getPassword(),s.getName(),s.getTel(),s.getGrade(),s.getClassNum(),s.getBirth(),s.getId(),s.getStime());
    }

    /**
     * @param conn
     * @param s
     * @return
     * @throws SQLException
     */
    public int DelStudent(Connection conn, Student s) throws SQLException {
        String sql = "delete from student where sid = ? ";
        return super.updateDate(conn, sql,s.getSid());
    }

    /**
     * @param conn
     * @param s
     * @return
     * @throws SQLException
     */
    public ResultSet StudentLogin(Connection conn, Student s) throws SQLException {
        String sql = "select * from student where sid = ? and password = ?";
        return super.selectDate(conn, sql, s.getSid(),s.getPassword());
    }

    /**
     * @param conn
     * @param grade
     * @param classNum
     * @return
     * @throws SQLException
     */
    public ResultSet FindStuByClass(Connection conn, String grade, String classNum) throws SQLException {
        String sql = "select * from student where grade = ? and classNum = ?";
        return super.selectDate(conn, sql,grade,classNum);
    }

    /**
     * @param conn
     * @param sid
     * @return
     * @throws SQLException
     */
    public ResultSet FindStuBySid(Connection conn, String sid) throws SQLException {
        String sql = "select * from student where sid = ?";
        return super.selectDate(conn, sql,sid);
    }

    /**
     * @param conn
     * @param sid
     * @param password
     * @return
     */
    public int ChangePassword(Connection conn, String sid, String password) throws SQLException {
        String sql = "UPDATE student set password = ? where sid = ?";
        return super.updateDate(conn,sql,password,sid);
    }

    /**
     * @param conn
     * @return
     * @throws SQLException
     */
    public ResultSet GetAllStu(Connection conn) throws SQLException {
        String sql = "select * from student";
        return super.selectDate(conn,sql);
    }
}

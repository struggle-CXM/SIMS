package com.SIMS.dao;

import com.SIMS.entity.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImp extends BaseDao implements AdminDao{
    /**
     * @param conn
     * @param a
     * @return
     * @throws SQLException
     */
    public ResultSet AdminLogin(Connection conn, Admin a) throws SQLException {
        String sql = "select * from admin where aid = ? and password = ?";
        return super.selectDate(conn, sql, a.getAid(),a.getPassword());
    }

    /**
     * @param conn
     * @param a
     * @return
     * @throws SQLException
     */
    public int ChangePassword(Connection conn, Admin a) throws SQLException {
        String sql = "UPDATE admin set password = ? where aid = ?";
        return super.updateDate(conn,sql,a.getPassword(),a.getAid());
    }
}

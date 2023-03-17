package com.SIMS.dao;

import com.SIMS.entity.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminDao {
    ResultSet AdminLogin(Connection conn, Admin a) throws SQLException;

    int ChangePassword(Connection conn,Admin a)throws SQLException;
}

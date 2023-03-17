package com.SIMS.service;

import com.SIMS.dao.AdminDao;
import com.SIMS.dao.AdminDaoImp;
import com.SIMS.entity.Admin;
import com.SIMS.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImp implements AdminService{
    private AdminDaoImp ad;
    public AdminServiceImp(){
        ad = new AdminDaoImp();

    }
    /**
     * @param a
     * @return
     */
    public Admin AdminLogin(Admin a) {
        Connection conn = DBHelper.getConnection();
        try{
            ResultSet set = ad.AdminLogin(conn,a);
            if (set.next()) {
                String aid = set.getString("aid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                String position = set.getString("position");
                return new Admin(aid, password,name,tel,position);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * @param a
     * @return
     */
    public int ChangePassword(Admin a) {
        Connection c = DBHelper.getConnection();

        try{
            ad.ChangePassword(c,a);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            ad.closeALL();
        }
        return 1;
    }
}

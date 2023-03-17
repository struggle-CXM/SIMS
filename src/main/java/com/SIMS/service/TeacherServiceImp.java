package com.SIMS.service;

import com.SIMS.dao.BaseDao;
import com.SIMS.dao.TeacherDao;
import com.SIMS.dao.TeacherDaoImp;
import com.SIMS.entity.Admin;
import com.SIMS.entity.Teacher;
import com.SIMS.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImp implements TeacherService{
    private TeacherDaoImp td;
    public TeacherServiceImp(){
        td = new TeacherDaoImp();
    }

    /**
     * @param t
     * @return
     */
    public int AddTeacher(Teacher t) {
        Connection conn =null;
        try{
            conn = DBHelper.getConnection();
            System.out.println(td.AddTeacher(conn,t));

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            td.closeALL();
        }
        return 1;
    }

    /**
     * @param t
     * @return
     */
    public int DelTeacher(Teacher t) {
        Connection conn =null;
        try{
            conn = DBHelper.getConnection();
            td.DelTeacher(conn,t);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            td.closeALL();
        }
        return 1;
    }

    /**
     * @param t
     * @return
     */
    public Teacher TeacherLogin(Teacher t) {
        Connection conn = DBHelper.getConnection();
        try{
            ResultSet set = td.TeacherLogin(conn,t);
            if (set.next()) {
                String tid = set.getString("tid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                int age = set.getInt("age");
                String t_time = set.getString("t_time");
                return new Teacher(tid, password,name,tel,age,t_time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * @param tid
     * @param password
     * @return
     */
    public int ChangePassword(String tid, String password) {
        Connection c= DBHelper.getConnection();
        try{
            td.ChangePassword(c,tid,password);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            td.closeALL();
        }
        return 1;
    }

    /**
     * @param t
     * @return
     */
    public List<Teacher> FindTeaByName(Teacher t) {
        Connection c = DBHelper.getConnection();
        ArrayList<Teacher> ts = new ArrayList<Teacher>();
        ResultSet set;
        try{
            set = td.FindTeaByName(c,t);
            while(set.next()){
                String tid = set.getString("tid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                int age = set.getInt("age");
                String t_time = set.getString("t_time");
                ts.add(new Teacher(tid,password,name,tel,age,t_time));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ts;
    }

    /**
     * @return
     */
    public List<Teacher> GetAllTeacher() {
        Connection c = DBHelper.getConnection();
        ArrayList<Teacher> ts = new ArrayList<Teacher>();
        ResultSet set;
        try{
            set = td.GetAllTeacher(c);
            while(set.next()){
                String tid = set.getString("tid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                int age = set.getInt("age");
                String t_time = set.getString("t_time");
                ts.add(new Teacher(tid,password,name,tel,age,t_time));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ts;
    }
}

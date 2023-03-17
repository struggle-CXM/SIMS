package com.SIMS.service;

import com.SIMS.dao.StudentDaoImp;
import com.SIMS.entity.Student;
import com.SIMS.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImp implements StudentService{
    private StudentDaoImp sd;
    public StudentServiceImp(){
        sd = new StudentDaoImp();
    }
    /**
     * @param s
     * @return
     */
    public int AddStudent(Student s) {
        Connection conn =null;
        try{
            conn = DBHelper.getConnection();
            sd.AddStudent(conn,s);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            sd.closeALL();
        }
        return 1;
    }

    /**
     * @param s
     * @return
     */
    public int DelStudent(Student s) {
        Connection conn =null;
        try{
            conn = DBHelper.getConnection();
            sd.DelStudent(conn,s);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            sd.closeALL();
        }
        return 1;
    }

    /**
     * @param s
     * @return
     */
    public Student StudentLogin(Student s) {
        Connection conn = DBHelper.getConnection();
        try{
            ResultSet set = sd.StudentLogin(conn,s);
            if (set.next()){
                String sid = set.getString("sid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                String grade = set.getString("grade");
                String classNum = set.getString("classNum");
                String birth= set.getString("birth");
                String id = set.getString("id");
                String stime = set.getString("stime");
                return new Student(sid,password,name,tel,grade,classNum,birth,id,stime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }
        return null;
    }

    /**
     * @param grade
     * @param classNum
     * @return
     */
    public List<Student> FindStuByClass(String grade, String classNum) {
        Connection conn = DBHelper.getConnection();
        ArrayList<Student> s = new ArrayList<Student>();
        ResultSet set;
        try{
            set = sd.FindStuByClass(conn,grade,classNum);
            while(set.next()){
                String sid = set.getString("sid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                String grade_tmp = set.getString("grade");
                String classNum_tmp = set.getString("classNum");
                String birth = set.getString("birth");
                String id = set.getString("id");
                String stime = set.getString("stime");
                s.add(new Student(sid,password,name,tel,grade_tmp,classNum_tmp,birth,id,stime));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }
        return s;
    }

    /**
     * @param sid
     * @return
     */
    public Student FindStuBySid(String sid) {
        Connection c = DBHelper.getConnection();
        try{
            ResultSet set = sd.FindStuBySid(c,sid);
            while (set.next()){
                return new Student(set.getString("sid"),set.getString("password"),set.getString("name"),set.getString("grade"),set.getString("classNum"),set.getString("birth"),set.getString("id"),set.getString("stime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }
        return null;
    }

    /**
     * @return
     */
    public List<Student> GetAllStu() {
        Connection c=  DBHelper.getConnection();
        ArrayList<Student> s = new ArrayList<Student>();
        ResultSet set;
        try{
            set = sd.GetAllStu(c);
            while (set.next()){
                String sid = set.getString("sid");
                String password = set.getString("password");
                String name = set.getString("name");
                String tel = set.getString("tel");
                String grade = set.getString("grade");
                String classNum = set.getString("classNum");
                String birth = set.getString("birth");
                String id = set.getString("id");
                String stime = set.getString("stime");
                s.add(new Student(sid,password,name,tel,grade,classNum,birth,id,stime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sd.closeALL();
        }
        return s;
    }

    /**
     * @param sid
     * @param password
     * @return
     */
    public int ChangePassword(String sid, String password) {
        Connection c= DBHelper.getConnection();
        try{
            sd.ChangePassword(c,sid,password);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            sd.closeALL();
        }
        return 1;
    }
}

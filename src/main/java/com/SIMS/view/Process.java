package com.SIMS.view;

import com.SIMS.entity.Admin;
import com.SIMS.entity.Score;
import com.SIMS.entity.Student;
import com.SIMS.entity.Teacher;
import com.SIMS.service.AdminServiceImp;
import com.SIMS.service.ScoreServiceImp;
import com.SIMS.service.StudentServiceImp;
import com.SIMS.service.TeacherServiceImp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Process {
    Scanner sc = new Scanner(System.in);
    AdminServiceImp as;
    TeacherServiceImp ts;
    StudentServiceImp ss;
    ScoreServiceImp scs;

    public Process() {
        as = new AdminServiceImp();
        ts = new TeacherServiceImp();
        ss = new StudentServiceImp();
        scs = new ScoreServiceImp();
    }

    public String input() {
        byte[] buf = new byte[50];
        try {
            System.in.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buf).trim();
    }

    public void process() {
        System.out.println("欢迎\n1.管理员登录\n2.教师登录\n3.学生登录");
        String op = input();
        if (op.equals("1")) {

            System.out.println("请输入管理员ID：");
            String aid = sc.nextLine();

            System.out.println("请输入管理员ID：");
            String password = sc.nextLine();
            Admin a = as.AdminLogin(new Admin(aid, password));
            if (a != null) {
                System.out.println("登录成功");
//管理员功能列表
                while (true) {
                    System.out.println("选择操作:\n1.添加教师\n2.删除教师\n3.添加学生\n4.删除学生\n5.Eid查平均成绩\n6.根据班级查询学生信息" +
                            "\n7.根据学号查询成绩");
                    String op1 = input();

//                    添加教师
                    if (op1.equals("1")) {
                        String tid = sc.nextLine();
                        System.out.println(tid);

                        String password1 = sc.nextLine();
                        System.out.println(password1);

                        String name = sc.nextLine();
                        System.out.println(name);

                        int age = sc.nextInt();
                        System.out.println(age);

                        String year = sc.next();
                        String month = sc.next();
                        String day = sc.next();
                        String date = year + "-" + (month.length() < 2 ? "0" + month : month) + "-" + (day.length() < 2 ? "0" + day : day);

//                        Teacher t = new Teacher(tid,password1,name,age,date);
                        if (ts.AddTeacher(new Teacher(tid, password1, name, age, date)) == 1) {
                            System.out.println("添加成功");

                        } else {
                            System.out.println("fail");
                        }
//                        删除教师
                    } else if (op1.equals("2")) {
                        System.out.println("输入删除的教师ID");
                        String tid = sc.nextLine();
                        if (ts.DelTeacher(new Teacher(tid)) == 1) {
                            System.out.println("删除成功");
                        } else {
                            System.out.println("出错了");
                            System.out.println("  ");
                        }

                    } else if (op1.equals("3")) {
                        String sid = sc.next();
                        String password1 = sc.next();
                        String name = sc.next();
                        String grade = sc.next();
                        String classNum = sc.next();
                        String birth = "2001-04-02";
                        String id = sc.next();
                        String stime = "2001-04-02";
                        Student s = new Student(sid, password1, name, grade, classNum, birth, id, stime);
                        if (ss.AddStudent(s) == 1) {
                            System.out.println("success");
                        } else {
                            System.out.println("fail");
                        }


                    } else if (op1.equals("4")) {
                        String sid = sc.next();

                        Student s = new Student(sid);
                        if (ss.DelStudent(s) == 1) {
                            System.out.println("success");
                        } else {
                            System.out.println("fail");
                        }


                    } else if (op1.equals("5")) {
                        double avg = scs.GetAvgByEid("fw");
                        System.out.println(avg);
                    } else if (op1.equals("6")) {
//                        根据班级查询学生
                        List<Student> s = ss.FindStuByClass("2019", "3");
                        for (Student s1 : s) {
                            System.out.println(s1);

                        }
                    } else if (op1.equals("7")) {
//                        根据学号查询成绩
                        List<Score> s = scs.GetScoreBySid("grd");
                        for (Score s1 : s) {
                            System.out.println(s1);

                        }
                    }
                }

            } else {
                System.out.println("登录失败");
            }
        }
    }
}

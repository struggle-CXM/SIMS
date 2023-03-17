package com.SIMS.entity;

public class Student {
    private String sid;
    private String password;
    private String name;

    private String tel;
    private String grade;
    private String classNum;
    private String birth;
    private String id;
    private String stime;

    public Student(String sid) {
        this.sid = sid;
    }


    public Student(String sid, String password) {
        this.sid = sid;
        this.password = password;
    }

    public Student(String sid, String password, String name, String tel, String grade, String classNum, String birth, String id, String stime) {
        this.sid = sid;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.grade = grade;
        this.classNum = classNum;
        this.birth = birth;
        this.id = id;
        this.stime = stime;
    }

    public Student(String sid, String password, String name, String grade, String classNum, String birth, String id, String stime) {
        this.sid = sid;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.classNum = classNum;
        this.birth = birth;
        this.id = id;
        this.stime = stime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", grade='" + grade + '\'' +
                ", classNum='" + classNum + '\'' +
                ", birth='" + birth + '\'' +
                ", id='" + id + '\'' +
                ", stime='" + stime + '\'' +
                '}';
    }
}

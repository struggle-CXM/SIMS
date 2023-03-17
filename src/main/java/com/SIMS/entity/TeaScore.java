package com.SIMS.entity;

public class TeaScore {
    private String name;
    private String sid;

    private String grade;

    private String classNum;

    private String sub;
    private int score;
    private String eid;
    private String etime;
    private String sctime;

    public TeaScore(String name, String sid, String grade, String classNum, String sub, int score, String eid, String etime, String sctime) {
        this.name = name;
        this.sid = sid;
        this.grade = grade;
        this.classNum = classNum;
        this.sub = sub;
        this.score = score;
        this.eid = eid;
        this.etime = etime;
        this.sctime = sctime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getSctime() {
        return sctime;
    }

    public void setSctime(String sctime) {
        this.sctime = sctime;
    }

    @Override
    public String toString() {
        return "TeaScore{" +
                "name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                ", grade='" + grade + '\'' +
                ", classNum='" + classNum + '\'' +
                ", sub='" + sub + '\'' +
                ", score=" + score +
                ", eid='" + eid + '\'' +
                ", etime='" + etime + '\'' +
                ", sctime='" + sctime + '\'' +
                '}';
    }
}

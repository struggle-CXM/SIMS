package com.SIMS.entity;

public class StuScore {
    private String sub;
    private int score;
    private String etime;
    private String sctime;

    public StuScore(String sub, int score, String etime, String sctime) {
        this.sub = sub;
        this.score = score;
        this.etime = etime;
        this.sctime = sctime;
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
        return "StuScore{" +
                "sub='" + sub + '\'' +
                ", score='" + score + '\'' +
                ", etime='" + etime + '\'' +
                ", sctime='" + sctime + '\'' +
                '}';
    }
}

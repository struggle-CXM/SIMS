package com.SIMS.entity;

public class Score {
    private String scid;
    private String eid;
    private String sid;
    private int score;
    private String sc_time;

    public Score(String scid, String eid, String sid, int score, String sc_time) {
        this.scid = scid;
        this.eid = eid;
        this.sid = sid;
        this.score = score;
        this.sc_time = sc_time;
    }

    public Score(String eid, String sid) {
        this.eid = eid;
        this.sid = sid;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSc_time() {
        return sc_time;
    }

    public void setSc_time(String sc_time) {
        this.sc_time = sc_time;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scid='" + scid + '\'' +
                ", eid='" + eid + '\'' +
                ", sid='" + sid + '\'' +
                ", score=" + score +
                ", sc_time='" + sc_time + '\'' +
                '}';
    }
}

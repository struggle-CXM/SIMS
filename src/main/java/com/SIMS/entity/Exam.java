package com.SIMS.entity;

public class Exam {
    private String eid;
    private String sub;
    private String etime;
    private String loc;

    public Exam(String sub) {
        this.sub = sub;
    }

    public Exam(String eid, String sub, String etime, String loc) {
        this.eid = eid;
        this.sub = sub;
        this.etime = etime;
        this.loc = loc;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "eid='" + eid + '\'' +
                ", sub='" + sub + '\'' +
                ", etime='" + etime + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}

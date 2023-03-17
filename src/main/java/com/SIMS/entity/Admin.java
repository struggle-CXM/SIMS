package com.SIMS.entity;

public class Admin {
    private String aid;
    private String password;
    private String name;

    private String tel;
    private String position;

    public Admin(String aid, String password, String name, String tel, String position) {
        this.aid = aid;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.position = position;
    }

    public Admin(String aid, String password) {
        this.aid = aid;
        this.password = password;
    }

    public Admin(String aid, String password, String name, String position) {
        this.aid = aid;
        this.password = password;
        this.name = name;
        this.position = position;
    }

    public Admin(String aid, String name, String position) {
        this.aid = aid;
        this.name = name;
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Admin(String name) {
        this.name = name;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

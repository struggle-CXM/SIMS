package com.SIMS.entity;

public class Teacher {
    private String tid;
    private String password;
    private String name;

    private String tel;
    private int age;
    private String t_time;

    public Teacher(String tid, String password, String name, String tel, int age, String t_time) {
        this.tid = tid;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.age = age;
        this.t_time = t_time;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String tid, String password) {
        this.tid = tid;
        this.password = password;
    }

    public Teacher(String tid, String name, int age, String t_time) {
        this.tid = tid;
        this.name = name;
        this.age = age;
        this.t_time = t_time;
    }

    public Teacher(String tid, String password, String name, int age, String t_time) {
        this.tid = tid;
        this.password = password;
        this.name = name;
        this.age = age;
        this.t_time = t_time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", age=" + age +
                ", t_time='" + t_time + '\'' +
                '}';
    }
}

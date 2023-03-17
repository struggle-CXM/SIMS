package com.SIMS.service;

import com.SIMS.entity.Student;

import java.util.List;

public interface StudentService {
    int AddStudent(Student s);
    int DelStudent(Student s);

    Student StudentLogin(Student s);

    List<Student> FindStuByClass(String grade,String classNum);

    Student FindStuBySid(String sid);

    List<Student> GetAllStu();

    int ChangePassword(String sid,String password);
}

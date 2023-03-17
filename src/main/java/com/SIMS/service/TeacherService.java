package com.SIMS.service;

import com.SIMS.entity.Teacher;

import java.util.List;

public interface TeacherService {
    int AddTeacher(Teacher t);
    int DelTeacher(Teacher t);

    Teacher TeacherLogin(Teacher t);

    int ChangePassword(String tid,String password);

    List<Teacher> FindTeaByName(Teacher t);

    List<Teacher> GetAllTeacher();
}

package com.SIMS.service;

import com.SIMS.entity.Exam;

import java.util.List;

public interface ExamService {
    int AddExam(Exam e);
    int DelExamByEid(Exam e);
    List<Exam> FindExamBySub(String sub);
    List<Exam> FindExamByDate(String year,String month,String day);
    Exam GetEidBySub(String sub,String etime,String loc);
    Exam GetExamByEid(String eid);
}

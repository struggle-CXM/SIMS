package com.SIMS.service;

import com.SIMS.entity.Student;
import org.junit.Test;

import java.util.Scanner;

public class StudentServiceTest {
    Scanner sc = new Scanner(System.in);
    @Test
    public void FindStuBySidTest(){
        System.out.println("findstubysid");


        StudentServiceImp ss = new StudentServiceImp();
        Student s = ss.FindStuBySid("190970141");
        if (s == null){
            System.out.println("fail");
        }else{
            System.out.println(s.getSid());

        }


    }
}

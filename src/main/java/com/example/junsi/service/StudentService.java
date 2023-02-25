package com.example.junsi.service;

import com.alibaba.excel.EasyExcel;
import com.example.junsi.pojo.Student;
import org.junit.Test;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public  static ArrayList<Student> students=new ArrayList<>();
    static {
        StudentJDBC studentJDBC=new StudentJDBC();
        try {
            students=studentJDBC.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Student> getStudents() {return students;}
    public ArrayList<Student> findStu(String key){
        ArrayList<Student> results=new ArrayList<>();
        for(Student student:students){
            if(student.getStuno().contains(key)||student.getName().contains(key)){
                results.add(student);
            }
        }
        return results;
    }

    public boolean delStudent(String stuno){
        Student student = findByStu(stuno);
        return students.remove(student);
    }
    public Student findByStu(String stuno) {
        for (Student student:students) {
            if(student.getStuno().equals(stuno)){
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updataStudent(String stuno, Student stu) {
        for (Student student:students) {
            if(student.getStuno().equals(stuno)){
               student.setStuno(stu.getStuno());
               student.setAge(stu.getAge());
               student.setName(stu.getName());
               student.setCoure(stu.getCoure());
               student.setSex(stu.getSex());
            }
        }
    }
}

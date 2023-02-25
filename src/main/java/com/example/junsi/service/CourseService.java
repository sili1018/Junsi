package com.example.junsi.service;

import com.example.junsi.pojo.Course;
import com.example.junsi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseService {
    public static ArrayList<Course> courses=new ArrayList<>();
    static {
        CourseJDBC courseJDBC=new CourseJDBC();
        try {
            courses =courseJDBC.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Course> getCourses() {return courses;}
    public ArrayList<Course> findStu(String key){
        ArrayList<Course> results=new ArrayList<>();
        for(Course course:courses){
            if(course.getCno().contains(key)||course.getCname().contains(key)){
                results.add(course);
            }
        }
        return results;
    }

    public boolean delCourse(String stuno){
        Course course = findByStu(stuno);
        return courses.remove(course);
    }
    public Course findByStu(String stuno) {
        for (Course course:courses) {
            if(course.getCno().equals(stuno)){
                return course;
            }
        }
        return null;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updataCourse(String cno, Course course) {
        for (Course course1:courses) {
            if(course1.getCno().equals(cno)){
                course1.setCno(course.getCno());
                course1.setCname(course.getCname());
                course1.setTname(course.getTname());
            }
        }
    }
}

package com.example.junsi.service;

import com.example.junsi.pojo.Student;
import com.example.junsi.pojo.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherService {
    private static ArrayList<Teacher> teachers=new ArrayList<>();
    static {
        TeacherJDBC teacherJDBC=new TeacherJDBC();
        try {
            teachers=teacherJDBC.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Teacher> getTeachers() {return teachers;}
    public ArrayList<Teacher> findStu(String key){
        ArrayList<Teacher> results=new ArrayList<>();
        for(Teacher teacher:teachers){
            if(teacher.getTno().contains(key)||teacher.getTname().contains(key)){
                results.add(teacher);
            }
        }
        return results;
    }

    public boolean delStudent(String stuno){
        Teacher teacher = findByStu(stuno);
        return teachers.remove(teacher);
    }
    public Teacher findByStu(String stuno) {
        for (Teacher teacher:teachers) {
            if(teacher.getTno().equals(stuno)){
                return teacher;
            }
        }
        return null;
    }

    public void addStudent(Teacher teacher) {teachers.add(teacher);
    }

    public void updataTeacher(String stuno, Teacher tea) {
        for (Teacher teacher:teachers) {
            if(teacher.getTno().equals(stuno)){
                teacher.setTno(tea.getTno());
                teacher.setAge(tea.getAge());
                teacher.setTname(tea.getTname());
                teacher.setCname(tea.getCname());
            }
        }
    }
}

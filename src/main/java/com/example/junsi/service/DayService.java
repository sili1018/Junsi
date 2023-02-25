package com.example.junsi.service;

import com.example.junsi.pojo.Day;
import com.example.junsi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class DayService {
    private static ArrayList<Day> days =new ArrayList<>();
    static {
        DayJDBC dayJDBC=new DayJDBC();
        try {
            days=dayJDBC.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Day> getStudents() {return days;}

    public void updataStudent(String stuno, Day d) {
        for (Day day:days) {
            if(day.getFirst().equals(stuno)){
                day.setFirst(d.getFirst());
                day.setSecond(d.getSecond());
                day.setThird(d.getThird());
                day.setFourth(d.getFourth());
            }
        }
    }
}
